import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { HeaderComponent } from './layout/header/header.component';
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
import { Accueil1Component } from './accueil1/accueil1.component';
import { Accueil2Component } from './accueil2/accueil2.component';
import { EditorComponent } from './editor/editor.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { EditorDetailsComponent } from './editor/editor-details/editor-details.component';
import { LibraryListEditorComponent } from './library-list-editor/library-list-editor.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    HeaderComponent,
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
    Accueil1Component,
    Accueil2Component,
    EditorComponent,
    EditorListComponent,
    EditorDetailsComponent,
    LibraryListEditorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
