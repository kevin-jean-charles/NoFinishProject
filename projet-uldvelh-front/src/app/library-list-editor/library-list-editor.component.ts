import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { BookPayload } from '../add-book/book-payload';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-library-list-editor',
  templateUrl: './library-list-editor.component.html',
  styleUrls: ['./library-list-editor.component.scss']
})
export class LibraryListEditorComponent implements OnInit {

  books$!: Observable<Array<BookPayload>>;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.books$ = this.bookService.getAllBooks();
  }

}
