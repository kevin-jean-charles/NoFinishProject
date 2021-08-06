import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ChapterService } from '../service/chapter.service';
import { ChapterPayload } from './chapter-payload';

@Component({
  selector: 'app-add-chapter',
  templateUrl: './add-chapter.component.html',
  styleUrls: ['./add-chapter.component.scss']
})
export class AddChapterComponent implements OnInit {


  addChapterForm: FormGroup;
  chapterPayload!: ChapterPayload;
  sub? : Subscription;

  constructor(private chapterService: ChapterService, private router: Router) {
    this.addChapterForm = new FormGroup({});

    this.chapterPayload = {
      id : 0,
      number: 0,
      text: ''
    }
   }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.addChapterForm = new FormGroup({
      number: new FormControl(''),
      text: new FormControl('')
    });
    console.log(this.addChapterForm);
  }

  createChapter():void {
    this.chapterPayload.text = this.addChapterForm.get('text')?.value;
    this.chapterPayload.text = this.addChapterForm.get('number')?.value;
    this.sub = this.chapterService.createChapter(this.chapterPayload).subscribe(data => {
      this.router.navigateByUrl('/library-editor');
    }, error => {
      console.log('Failure Response');
    })
}

}
