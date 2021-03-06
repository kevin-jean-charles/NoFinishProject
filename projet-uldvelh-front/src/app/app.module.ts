import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { FooterComponent } from './layout/footer/footer.component';
import { OhFourComponent } from './oh-four/oh-four.component';
import { LibraryListPlayerComponent } from './library/library-list-player/library-list-player.component';
import { BookCardComponent } from './library/book-card/book-card.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { EditorComponent } from './editor/editor.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { EditorDetailsComponent } from './editor/editor-details/editor-details.component';
import { LibraryListEditorComponent } from './library/library-list-editor/library-list-editor.component';
import { AddBookComponent } from './add-book/add-book.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LibraryListEditorItemComponent } from './library/library-list-editor/library-list-editor-item/library-list-editor-item.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { AddChapterComponent } from './add-chapter/add-chapter.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { AuthInterceptor } from './auth/interceptor/auth.interceptor';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    FooterComponent,
    OhFourComponent,
    LibraryListPlayerComponent,
    BookCardComponent,
    NavBarComponent,
    EditorComponent,
    EditorListComponent,
    EditorDetailsComponent,
    LibraryListEditorComponent,
    AddBookComponent,
    LibraryListEditorItemComponent,
    UpdateBookComponent,
    AddChapterComponent,
    SignUpComponent,
    SignInComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
],
  bootstrap: [AppComponent]
})
export class AppModule { }
