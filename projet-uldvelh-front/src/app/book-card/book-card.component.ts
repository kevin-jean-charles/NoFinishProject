import { EventEmitter, Input } from '@angular/core';
import { Component, OnInit, Output } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';

import { BookPayload } from '../model/book-payload';
import { BookService } from '../service/book.service';


@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss']
})
export class BookCardComponent implements OnInit {

  //interface
  @Input() book?: BookPayload;

  @Output() deleteBookById = new EventEmitter<any>();
  @Output() updateBookById = new EventEmitter<any>();


  constructor(private router: Router, private bookService: BookService) { }

  ngOnInit() {}

  deleteBook(id?: number){
    this.deleteBookById.emit(id)
  }

  updateBook(id?: number){
    this.updateBookById.emit(id);
    this.router.navigateByUrl('update-book/' + id)
  }

  // addChapter(id?: number){
  //   this.router.navigateByUrl('add-chapter/' + id)
  // }
  
}