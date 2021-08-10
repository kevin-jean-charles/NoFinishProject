import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookPayload } from '../model/book-payload';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit {

  updateBookForm: FormGroup;
  book?: BookPayload;
  id?: number;
  bookSub?: Subscription;


  constructor(private bookService: BookService, private route: ActivatedRoute, private router: Router ) {
    this.updateBookForm = new FormGroup({});
  }

  ngOnInit(): void {
    this.initForm();
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      console.log(this.id);
      
      this.bookService.getBookById(this.id).subscribe(book => { 
        this.id = book.id;
        console.log(book);

        this.updateBookForm.setValue({
          title: book.title,
          resume: book.resume,
        })
      })
    })
  }

  initForm() {
    this.updateBookForm = new FormGroup({
      title: new FormControl(''),
      resume: new FormControl('')
    });
  }

  updateBook() {
    this.book = {
      id: this.id,
      title: this.updateBookForm.value.title,
      resume: this.updateBookForm.value.resume,
      chapters: []
} 
    
    this.bookService.updateBook(this.book).subscribe(
      resp => {
        this.router.navigate(['/library-editor']);
        console.log("modification effectuée")
        console.log(this.id)
      }
    )
  }
}

