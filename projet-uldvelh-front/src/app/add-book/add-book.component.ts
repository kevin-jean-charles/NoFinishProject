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


  constructor(private bookService: BookService, private router: Router) {
    this.addBookForm = new FormGroup({
      title: this.title
    });
    this.bookPayload = {
      id: '',
      title: ''
    }
    
    
  }
  ngOnInit(): void {
  }

  addBook() {
 
    this.bookPayload.title = this.addBookForm.get('title')?.value;
    
    this.bookService.addBook(this.bookPayload).subscribe(data => {
      this.router.navigateByUrl('/');
      
    }, error => {
      console.log('Failure Response');
    })
 }

}
