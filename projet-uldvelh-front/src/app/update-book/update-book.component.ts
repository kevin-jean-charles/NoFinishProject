import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookPayload } from '../add-book/book-payload';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit {

  updateBookForm: FormGroup;
  //bookPayload: BookPayload;
  id!: number;
  bookSub?:Subscription;

  constructor(private bookService: BookService, private route: ActivatedRoute) {
    this.updateBookForm = new FormGroup({});
  }

  ngOnInit(): void {
    this.initForm();
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      console.log(this.id);
      
      this.bookService.getBookById(this.id).subscribe(book => { 
        this.id = book.id;
        console.log(book);

        this.updateBookForm.setValue({
          title: book.title,
          resume: book.resume,
          chapters: book.chapters
        })
      })
    })
  }

  initForm() {
    this.updateBookForm = new FormGroup({
      title: new FormControl(''),
      resume: new FormControl('')
    });
  }

  updateBook() {

    const formValues = {
      id:this.id,
      title: this.updateBookForm.value.title,
      resume: this.updateBookForm.value.resume,
      chapters: this.updateBookForm.value.chapters
    }
    console.log(formValues);
  
    
    this.bookService.updateBook(formValues).subscribe(
      resp => {
        console.log("modification effectuée")
        console.log(this.id)
      }
    )
  }
}

