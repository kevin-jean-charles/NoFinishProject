import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { BookPayload } from '../add-book/book-payload';

@Injectable({
  providedIn: 'root'
})

export class BookService {
  
  baseURL = 'http://localhost:8082/api/books'

  constructor(private httpClient: HttpClient) { }


  createBook(bookPayload: BookPayload){
    return this.httpClient.post(`${this.baseURL}`, bookPayload);
  }

  getAllBooks(): Observable<Array<BookPayload>>{
    return this.httpClient.get<Array<BookPayload>>(`${this.baseURL}`);
  }

  getBook(idBook: number):Observable<BookPayload>{
    return this.httpClient.get<BookPayload>(`${this.baseURL}/${idBook}`)
  }

  deleteBook(idBook: number): Observable<BookPayload> {
    return this.httpClient.delete<BookPayload>(`${this.baseURL}/${idBook}`)

  }
  
}
