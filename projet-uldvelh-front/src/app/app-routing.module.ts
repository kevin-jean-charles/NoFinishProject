import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { AddChapterComponent } from './add-chapter/add-chapter.component';
import { EditorListComponent } from './editor/editor-list/editor-list.component';
import { AuthGuard } from './auth/guards/auth.guard';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LibraryListEditorItemComponent } from './library/library-list-editor/library-list-editor-item/library-list-editor-item.component';
import { LibraryListEditorComponent } from './library/library-list-editor/library-list-editor.component';
import { LibraryListPlayerComponent } from './library/library-list-player/library-list-player.component';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { UpdateBookComponent } from './update-book/update-book.component';
//import { OhFourComponent } from './oh-four/oh-four.component';

const routes: Routes = [

  {path: '', component: LayoutComponent, children : [ 
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'signup', component : SignUpComponent},
  {path: 'signin', component : SignInComponent},
  { path: 'home', component: HomeComponent},
  
  ]},
        
  {path: '', canActivate: [AuthGuard], component: LayoutComponent, children : [ 
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'library-player', component: LibraryListPlayerComponent },
  { path: 'library-editor/:id', component: LibraryListEditorItemComponent},
  { path: 'library-editor', component: LibraryListEditorComponent },
  { path: 'editor-list', component: EditorListComponent },
  { path: 'add-book', component: AddBookComponent },
  { path: 'update-book/:id', component: UpdateBookComponent },
  { path: 'add-chapter', component: AddChapterComponent},
 
  // { path: '**', redirectTo: '/not-found' },
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
