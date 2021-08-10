import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
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

  constructor(private bookService: BookService, private router: Router, private authService: AuthService, private userService: UserService) {
    this.addBookForm = new FormGroup({});
  }

  ngOnInit() {
    this.initForm();
    //this.getUser();
    this.currentUserId = parseInt(this.authService.getUserId());
    console.log(this.currentUserId);
    
  }

  initForm() {
    this.addBookForm = new FormGroup({
      title: new FormControl(''),
      resume: new FormControl('')
    });
    console.log(this.addBookForm);
  }


  createBook(): void {
    this.newBook = {
      title: this.addBookForm.value.title,
      resume: this.addBookForm.value.resume
    }
    this.bookService.createBook(this.newBook).subscribe(data => {
        console.log(data);
        this.userService.addUserInBook(this.currentUserId, data).subscribe(resp => {

          console.log('Histoire ajoutée à la liste de l\'utilisateur');

        
          this.bookService.getAllBooks();

        })
        this.router.navigate(['/library-editor']);
      }, error => {
        console.log('Failure Response');
      })
  }
}