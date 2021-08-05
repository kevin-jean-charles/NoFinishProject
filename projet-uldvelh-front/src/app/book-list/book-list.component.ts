import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { BookPayload } from '../add-book/book-payload';
import { BookService } from '../service/book.service';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  books$!: Observable<Array<BookPayload>>;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.books$ = this.bookService.getAllBooks();

  }

}
