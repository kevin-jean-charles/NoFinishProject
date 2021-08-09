import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { AddChapterComponent } from './add-chapter/add-chapter.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { AuthGuard } from './guards/auth.guard';
import { LayoutComponent } from './layout/layout.component';
import { LibraryListEditorItemComponent } from './library-list-editor/library-list-editor-item/library-list-editor-item.component';
import { LibraryListEditorComponent } from './library-list-editor/library-list-editor.component';
import { LibraryListPlayerComponent } from './library-list-player/library-list-player.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { UpdateBookComponent } from './update-book/update-book.component';
//import { OhFourComponent } from './oh-four/oh-four.component';

const routes: Routes = [
  {path: 'signup', component : SignUpComponent},
  {path: 'signin', component : SignInComponent},
  {path: '', canActivate: [AuthGuard], component: LayoutComponent, children : [ 

  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'library-player', component: LibraryListPlayerComponent },
  { path: 'library-editor/:id', component: LibraryListEditorItemComponent},
  { path: 'library-editor', component: LibraryListEditorComponent },
  { path: 'editor-list', component: EditorListComponent },
  { path: 'add-book', component: AddBookComponent },
  { path: 'update-book/:id', component: UpdateBookComponent },
  { path: 'add-chapter', component: AddChapterComponent}


  // { path: '**', redirectTo: '/not-found' },
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
