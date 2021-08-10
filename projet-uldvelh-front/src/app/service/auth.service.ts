import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators'
import { environment } from 'src/environments/environment';
import { LocalStorageService } from 'ngx-webstorage';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  dev = false;
  URL_DEV = 'http://locahost:3000/api';
  URL_TEST = `${environment.baseUrl}`;
  API_URL: string

  constructor(private http: HttpClient,
    private router: Router
  ) {
    this.API_URL = this.dev ? this.URL_DEV : this.URL_TEST;
  }

  signup(username: string, email: string, password: string) {
    const body = {
      username,
      email,
      password,
      
    }
    return this.http.post(`${this.API_URL}/auth/signup`, body)
  }

  login(username: string, password: string) {
    const body = {
      username,
      password
    }
    return this.http.post(`${this.API_URL}/auth/signin`, body)
      .pipe(
        map(
          (resp: any) => {
            localStorage.setItem('TOKEN_APPLI', resp.accessToken);
            localStorage.setItem('USER_ID', resp.id);
            console.log('Token Save');
            return resp;
          }
        )
      );
  }


  getUserId(): any {
    return localStorage.getItem('USER_ID') || 0;
  }

  logout() {
    localStorage.removeItem('TOKEN_APPLI');
    localStorage.removeItem('USER_ID');
    this.router.navigate(['/signin']);
  }

 isAuthenticated(): Boolean{
   console.log("ok auth")
    return localStorage.getItem('USER_ID') != null;

  }

}