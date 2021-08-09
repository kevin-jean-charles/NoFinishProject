import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { BookPayload } from '../model/book-payload';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  baseUrl = `${environment.baseUrl}`;
  constructor(private httpClient: HttpClient) { }

  createBook(bookPayload: BookPayload){
    return this.httpClient.post(`${this.baseUrl}`, bookPayload);
  }

  getAllBooks(): Observable<Array<BookPayload>>{
    return this.httpClient.get<Array<BookPayload>>(`${this.baseUrl}`);
  }

  getBookById(idBook: number){
    return this.httpClient.get<BookPayload>(`${this.baseUrl}/${idBook}`)
  }

  updateBook(book:BookPayload){
    return this.httpClient.put(`${this.baseUrl}/${book.id}`, book);
  }

  deleteBook(idBook: number): Observable<BookPayload> {
    return this.httpClient.delete<BookPayload>(`${this.baseUrl}/${idBook}`)

  }

}
