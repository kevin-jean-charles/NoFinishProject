import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { BookPayload } from 'src/app/add-book/book-payload';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-library-list-editor-item',
  templateUrl: './library-list-editor-item.component.html',
  styleUrls: ['./library-list-editor-item.component.scss']
})
export class LibraryListEditorItemComponent implements OnInit {
  book! : BookPayload;
  id!: number;
  // @Output() updateBookById = new EventEmitter<any>();


  constructor(private bookService: BookService, private activatedRoute: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.id = +params['id'];
      this.bookService.getBookById(this.id).subscribe(resp => {
        this.book = resp
        console.log(resp);
      })
    })
  }

  updateBook(id: number){
    console.log(id);
    // this.updateBookById.emit(id);
    this.router.navigateByUrl('update-book/' + id)
  }

}
