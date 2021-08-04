import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookPayload } from '../add-book/book-payload';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  

  constructor(private httpClient: HttpClient) { }

  addBook(bookPayload: BookPayload){
    return this.httpClient.post('http://localhost:8082/api/posts/', bookPayload);
  }
}
