import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookService } from '../service/book.service';
import { BookPayload } from '../model/book-payload';
import { AuthService } from '../service/auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  addBookForm: FormGroup;
  bookPayload!: BookPayload;
  sub?: Subscription;
  currentUser?: any;
  currentUserId?: any;
  bookList?: BookPayload[];
  newBook?: BookPayload;
  isCreated: boolean = false;

  constructor(private bookService: BookService, private router: Router, private authService: AuthService, private userService: UserService) {
    this.addBookForm = new FormGroup({});
  }

  ngOnInit() {
    this.initForm();
    this.currentUserId = parseInt(this.authService.getUserId());
    console.log(this.currentUserId);
    
  }

  initForm() {
    this.addBookForm = new FormGroup({
      title: new FormControl('', [Validators.required, Validators.minLength(1)]),
      resume: new FormControl('', [Validators.required, Validators.minLength(1)])
    });
    console.log(this.addBookForm);
  }

  get title() {
    return this.addBookForm.get("title")
  }
  get resume() {
    return this.addBookForm.get("resume")
  }

  createBook(): void {
    this.newBook = {
      title: this.addBookForm.value.title,
      resume: this.addBookForm.value.resume
    }
    this.bookService.createBook(this.newBook).subscribe(data => {
        console.log(data);
        this.userService.addUserInBook(this.currentUserId, data).subscribe(resp => {
          console.log('Histoire ajouté à la liste de l\'utilisateur');
          this.bookService.getBooksByUserId(this.currentUserId);

          this.isCreated = true

          setTimeout( ()=> {
            this.router.navigate(['/library-editor']);
          },2000 ) 
        })

      }, error => {
        console.log('Failure Response');
      })
  } 
  
}