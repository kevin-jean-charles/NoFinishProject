import { Component, OnInit } from '@angular/core';

import { Observable, Subscription } from 'rxjs';
import { BookPayload } from '../add-book/book-payload';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-library-list-editor',
  templateUrl: './library-list-editor.component.html',
  styleUrls: ['./library-list-editor.component.scss']
})
export class LibraryListEditorComponent implements OnInit {

  bookSub? : Subscription;
  book?: BookPayload;
  databooks?: BookPayload[];
  isDeleted: boolean = false;
  books?: BookPayload[];

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.bookSub= this.bookService.getAllBooks().subscribe(resp=>{
      this.books = resp;
      console.log(this.books);
    })
  }

  deleteBook(id: number){
    this.bookSub = this.bookService.deleteBook(id).subscribe(book =>{ console.log("ok")})
    this.databooks = this.books?.filter(book => book.id !== id);
    this.books = this.databooks
    this.isDeleted = true;
  }

  // updateBook(id: number){
  //   this.bookSub = this.bookService.getBookById(id).subscribe(book => {
  //     this.book = book;
  //     console.log(this.book);    
  //   })
  }
