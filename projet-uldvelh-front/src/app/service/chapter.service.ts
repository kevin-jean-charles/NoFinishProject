import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChapterPayload } from '../add-chapter/chapter-payload';

@Injectable({
  providedIn: 'root'
})
export class ChapterService {

  baseUrl= "http://localhost:8080/api/chapter";
  
  constructor(private httpClient: HttpClient) { }

  createChapter(chapterPayload: ChapterPayload){
    return this.httpClient.post(`${this.baseUrl}`, chapterPayload)
  }

  getAllChapters(): Observable<Array<ChapterPayload>>{
    return this.httpClient.get<Array<ChapterPayload>>(`${this.baseUrl}`);
  }

  getChapterById(idChapter: number){
    return this.httpClient.get<ChapterPayload>(`${this.baseUrl}/${idChapter}`)
  }

  updateChapter(chapter:ChapterPayload){
    return this.httpClient.put(`${this.baseUrl}/${chapter.id}`, chapter.id);
  }

  deleteChapter(idChapter: number): Observable<ChapterPayload> {
    return this.httpClient.delete<ChapterPayload>(`${this.baseUrl}/${idChapter}`)
  }

}
