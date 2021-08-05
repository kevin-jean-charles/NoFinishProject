import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  constructor(private httpClient: HttpClient) { }

  // public getAllBooks():Observable<Book[]>
}
