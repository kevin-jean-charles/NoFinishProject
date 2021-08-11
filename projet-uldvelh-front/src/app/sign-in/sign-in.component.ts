import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  constructor(private router: Router,
    private authService: AuthService) { }
  
    ngOnInit(): void {
    }
  
    onSubmit(form: NgForm) {
      console.log(form.value);
      this.authService.login(form.value.username, form.value.password)
        .subscribe(
          (resp: any) => {
            console.log("connection succeed", resp);
            this.router.navigate(['/library-editor']);
          },
          error => {
            console.log('error while');
            
          }
      )
    }
}
