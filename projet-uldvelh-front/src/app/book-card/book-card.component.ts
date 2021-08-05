import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { BookPayload } from '../add-book/book-payload';
import { BookService } from '../service/book.service';


@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss']
})
export class BookCardComponent implements OnInit {

 
  permaLink: any;

  book!: BookPayload;

  constructor(private router: ActivatedRoute, private bookService: BookService) { }

  ngOnInit() {
    this.router.params.subscribe(params => {
      this.permaLink = params['id'];
    });

    this.bookService.getBook(this.permaLink).subscribe((data:BookPayload) => {
      this.book = data;
    },(err: any) => {
      console.log('Failure Response');
    })


}
