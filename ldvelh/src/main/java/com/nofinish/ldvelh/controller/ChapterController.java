package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.service.BookService;
import com.nofinish.ldvelh.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
    @Autowired
    private BookService bookService;


    @PostMapping("")
    public ResponseEntity<Chapter> createChapter(@RequestBody Chapter chapter){
        Chapter newChapter = chapterService.createOrUpdateChapter(chapter);
        return new ResponseEntity<>(newChapter, HttpStatus.OK);
    }



    @GetMapping("")
    public ResponseEntity<List<Chapter>> getAllChapters(){
        List<Chapter> listChapters = chapterService.findAllChapters();
        return new ResponseEntity<>(listChapters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getById(@PathVariable Long id){
        Chapter chapter = chapterService.findById(id);
        return new ResponseEntity<>(chapter, HttpStatus.OK);
    }

//    @PostMapping("/{book_id}/chapter")
//    public ResponseEntity<Chapter> addChapterToBook(@PathVariable("book_id") Long bookId, @RequestBody Chapter chapter) {
//        Chapter updateChapter = chapterService.saveChapter(chapter);
//        return new ResponseEntity<>(updateChapter, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapter> updateChapter(@RequestBody Chapter chapter){
        Chapter updatedChapter = chapterService.createOrUpdateChapter(chapter);
        return new ResponseEntity<>(updatedChapter, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chapter> deleteChapter(@PathVariable Long id){
        chapterService.deleteChapterById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping()
    public ResponseEntity<Chapter> deleteChapters(@RequestBody Chapter chapter){
        chapterService.deleteChapter(chapter);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
