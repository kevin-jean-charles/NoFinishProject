import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookPayload } from '../add-book/book-payload';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  

  constructor(private httpClient: HttpClient) { }

  createBook(bookPayload: BookPayload){
    return this.httpClient.post('http://localhost:8080/api/books', bookPayload);
  }

  getAllBooks(): Observable<Array<BookPayload>>{
    return this.httpClient.get<Array<BookPayload>>("http://localhost:8080/api/books");
  }

  getBook(permaLink: Number):Observable<BookPayload>{
    return this.httpClient.get<BookPayload>('http://localhoast/8080/api/books/' + permaLink)
  }
}
