import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookService } from '../service/book.service';
import { BookPayload } from './book-payload';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  addBookForm: FormGroup;
  bookPayload!: BookPayload;
  sub? : Subscription;

  constructor(private bookService: BookService, private router: Router) {
    this.addBookForm = new FormGroup({});

    this.bookPayload = {
      id : 0,
      title: '',
      resume: '',
      chapters: []
    }
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.addBookForm = new FormGroup({
      title: new FormControl(''),
      resume: new FormControl('')
    });
    console.log(this.addBookForm);
  }

  createBook():void {
      this.bookPayload.title = this.addBookForm.get('title')?.value;
      this.bookPayload.resume = this.addBookForm.get('resume')?.value;
      this.sub = this.bookService.createBook(this.bookPayload).subscribe(data => {
        this.router.navigateByUrl('/library-editor');
      }, error => {
        console.log('Failure Response');
      })
  }

}