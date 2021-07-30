import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { FooterComponent } from './layout/footer/footer.component';
import { AboutComponent } from './about/about.component';
import { OhFourComponent } from './oh-four/oh-four.component';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LibraryListPlayerComponent } from './library-list-player/library-list-player.component';
import { BookCardComponent } from './book-card/book-card.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookItemComponent } from './book-list/book-item/book-item.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { EditorComponent } from './editor/editor.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { EditorDetailsComponent } from './editor/editor-details/editor-details.component';
import { LibraryListEditorComponent } from './library-list-editor/library-list-editor.component';
import { AddBookComponent } from './add-book/add-book.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    FooterComponent,
    AboutComponent,
    OhFourComponent,
    LoginComponent,
    InscriptionComponent,
    LibraryListPlayerComponent,
    BookCardComponent,
    BookListComponent,
    BookItemComponent,
    NavBarComponent,
    EditorComponent,
    EditorListComponent,
    EditorDetailsComponent,
    LibraryListEditorComponent,
    AddBookComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
