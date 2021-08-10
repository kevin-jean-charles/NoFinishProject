import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';

import { BookPayload } from '../model/book-payload';

@Injectable({
  providedIn: 'root'
})
  
export class BookService {
  baseUrl = `${environment.baseUrl}`;
  bookSubject = new Subject<BookPayload[]>();
  constructor(private httpClient: HttpClient) { }

  createBook(bookPayload: BookPayload){
    return this.httpClient.post(`${this.baseUrl}/books`, bookPayload);
  }

  getBookList() {
    this.httpClient.get<BookPayload[]>(`${this.baseUrl}/books`).subscribe(resp => {
      this.bookSubject.next(resp);
    })
}

  getAllBooks(): Observable<Array<BookPayload>>{
    return this.httpClient.get<Array<BookPayload>>(`${this.baseUrl}/books`);
  }
  getBooksByUserId(idUser:number): Observable<Array<BookPayload>> {
    return this.httpClient.get<Array<BookPayload>>(`${this.baseUrl}/books/${idUser}/user`);
  }

  getBookById(idBook: number){
    return this.httpClient.get<BookPayload>(`${this.baseUrl}/books/${idBook}`)
  }

  updateBook(book:BookPayload){
    return this.httpClient.put(`${this.baseUrl}/books/${book.id}`, book);
  }

  deleteBook(idBook: number, userId: number): Observable<BookPayload> {
    return this.httpClient.delete<BookPayload>(`${this.baseUrl}/books/${idBook}/user/${userId}`)

  }

}
