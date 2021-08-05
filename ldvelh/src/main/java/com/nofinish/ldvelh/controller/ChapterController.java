package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;


    @PostMapping("/add")
    public ResponseEntity<Chapter> createChapter(@RequestBody Chapter chapter){
        Chapter newChapter = chapterService.saveChapter(chapter);
        return new ResponseEntity<>(newChapter, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chapter>> getAllChapters(){
        List<Chapter> listChapters = chapterService.findAllChapters();
        return  new ResponseEntity<>(listChapters, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Chapter> getByCaption(@PathVariable String caption){
        Chapter chapter = chapterService.findByCaption(caption);
        return  new ResponseEntity<>(chapter, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Chapter> updateChapter(@RequestBody Chapter chapter){
        Chapter updatedChapter = chapterService.updateChapter(chapter);
        return new ResponseEntity<>(updatedChapter, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Chapter> deleteChapterById(@RequestBody Chapter chapter){
        chapterService.deleteChapter(chapter);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
