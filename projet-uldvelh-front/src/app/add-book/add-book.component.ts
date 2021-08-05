import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from '../service/book.service';
import { BookPayload } from './book-payload';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  addBookForm: FormGroup ;
  bookPayload: BookPayload ;
  title = new FormControl('');
  resume = new FormControl('');


  constructor(private bookService: BookService, private router: Router) {
    this.addBookForm = new FormGroup({
      title: this.title,
      resume: this.resume
    });
    this.bookPayload = {
      id: '',
      title: '',
      resume:''
    }
    
    
  }
  ngOnInit() {
  }

  addBook() {
    this.bookPayload.title = this.addBookForm.get('title')?.value;
    this.bookPayload.resume = this.addBookForm.get('resume')?.value;
    

    this.bookService.createBook(this.bookPayload).subscribe(data => {
      this.router.navigateByUrl('/library-editor');
      
    }, error => {
      console.log('Failure Response');
    })
 }

}
