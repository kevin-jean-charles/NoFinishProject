import { ChapterPayload } from "../add-chapter/chapter-payload";
import { User } from "./user.model";

export class BookPayload {
  constructor(
    public id: number,
    public title: string,
    public resume: string,
    public chapters: ChapterPayload[],
    public user: User
  ) {}

}