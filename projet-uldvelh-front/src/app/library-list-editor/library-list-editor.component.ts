import { Component, OnChanges, OnDestroy, OnInit } from '@angular/core';

import { Observable, Subscription } from 'rxjs';
import { BookPayload } from '../model/book-payload';
import { AuthService } from '../service/auth.service';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-library-list-editor',
  templateUrl: './library-list-editor.component.html',
  styleUrls: ['./library-list-editor.component.scss']
})
export class LibraryListEditorComponent implements OnInit, OnDestroy {

  bookSub? : Subscription;
  book?: BookPayload;
  databooks?: BookPayload[];
  isDeleted: boolean = false;
  books?: BookPayload[];
  currentUserId?: number;

  constructor(private bookService: BookService, private authService: AuthService) { }

  ngOnInit(): void {
    this.currentUserId = parseInt(this.authService.getUserId());
    this.bookService.getBooksByUserId(this.currentUserId).subscribe(resp=>{
      this.books = resp;
      console.log(this.books);
    })
    this.bookSub = this.bookService.bookSubject.subscribe(resp => {
      this.books = resp;
})
  }


  deleteBook(id: number) {
    const currentUserId = this.currentUserId || 0;
    this.bookService.deleteBook(id, currentUserId).subscribe(book =>{ console.log("ok")})
    this.databooks = this.books?.filter(book => book.id !== id);
    this.books = this.databooks
    this.isDeleted = true;
  }

  // updateBook(id: number){
  //   this.bookSub = this.bookService.getBookById(id).subscribe(book => {
  //     this.book = book;
  //     console.log(this.book);    
  //   })

  ngOnDestroy() {
    this.bookSub?.unsubscribe();
}
  }
