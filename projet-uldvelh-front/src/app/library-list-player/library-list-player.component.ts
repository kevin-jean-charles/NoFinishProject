import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { BookPayload } from '../model/book-payload';
import { AuthService } from '../service/auth.service';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-library-list-player',
  templateUrl: './library-list-player.component.html',
  styleUrls: ['./library-list-player.component.scss']
})
export class LibraryListPlayerComponent implements OnInit {
  books?: BookPayload[];
  bookSub?: Subscription;
  constructor(private bookService: BookService, private authService: AuthService) { }

  ngOnInit(): void {
    this.bookService.getAllBooks().subscribe(resp => {
      this.books = resp;
      console.log(this.books);
    })
    this.bookSub = this.bookService.bookSubject.subscribe(resp => {
      this.books = resp;
    })
  }

}
