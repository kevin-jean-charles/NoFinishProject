import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LayoutComponent } from './layout/layout.component';
import { LibraryListEditorComponent } from './library-list-editor/library-list-editor.component';
import { LibraryListPlayerComponent } from './library-list-player/library-list-player.component';
import { LoginComponent } from './login/login.component';
import { OhFourComponent } from './oh-four/oh-four.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'library-player', component: LibraryListPlayerComponent },
  { path: 'library-editor', component: LibraryListEditorComponent },
  { path: 'editor-list', component: EditorListComponent },
  { path: 'book-list', component: BookListComponent },
  { path: '**', redirectTo: '/not-found' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
