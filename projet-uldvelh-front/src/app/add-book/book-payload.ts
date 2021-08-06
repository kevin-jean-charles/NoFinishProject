import { ChapterPayload } from "../add-chapter/chapter-payload";

export class BookPayload {
  constructor(public id: number,
    public title: string,
    public resume: string,
    public chapters: ChapterPayload[]
  ) {}

}