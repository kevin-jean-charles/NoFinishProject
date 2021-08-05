import { EventEmitter, Input } from '@angular/core';
import { Component, OnInit, Output } from '@angular/core';

import { BookPayload } from '../add-book/book-payload';


@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss']
})
export class BookCardComponent implements OnInit {

  

  //interface
  @Input() book?: BookPayload;

  @Output() deleteBookById = new EventEmitter<any>();

  constructor() { }

  ngOnInit() {}

  deleteBook(id?: number){
    this.deleteBookById.emit(id)
    
  }

}
