import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { BookPayload } from '../model/book-payload';
import { User } from '../model/user.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = `${environment.baseUrl}`;

  constructor(private http: HttpClient, private authService: AuthService) { }

  getAllUsers() {
    return this.http.get<User[]>(`${this.baseUrl}/users`).pipe(
      catchError(error => of([]))
    )
  }

  getUserById(id: number) {
    return this.http.get<User>(`${this.baseUrl}/users/${id}`).pipe(
      catchError(error => of([]))
    )
  }

  addUserInBook(id: number, book: BookPayload) {
    return this.http.post<User>(`${this.baseUrl}/users/${id}/book`, book);
  }


}
