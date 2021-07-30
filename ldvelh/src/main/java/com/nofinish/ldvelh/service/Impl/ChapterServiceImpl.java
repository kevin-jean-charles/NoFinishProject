package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.repo.BookRepo;
import com.nofinish.ldvelh.repo.ChapterRepo;
import com.nofinish.ldvelh.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private  ChapterRepo chapterRepo;


    @Override
    public Chapter createOrUpdateChapter(Chapter chapter) {
//        Optional<Book> currentBook = bookRepo.findById(id);
//        currentBook.get().setListChapters(currentBook.get().getListChapters());
        return chapterRepo.save(chapter);
    }

//    @Override
//    public Chapter saveOptions(Chapter chapter) {
//        Optional<Chapter> chapterOptions = chapterRepo.getById(chapter.getId());
//        Set<Option> options = new HashMap<>();
//
//        option.put(1, chapter);
//
//        return chapterRepo.save(chapter);
//    }

    @Override
    public List<Chapter> findAllChapters() {

        return chapterRepo.findAll();
    }



    @Override
    public void deleteChapter(Chapter chapter) {

        chapterRepo.delete(chapter);
    }

    @Override
    public Chapter findById(Long id) {
        Optional<Chapter> chapter = chapterRepo.findById(id);
        if (chapter.isPresent()) {
            return chapter.get();
        }
        return null;
    }

    @Override
    public void deleteChapterById(Long id) {
        chapterRepo.deleteById(id);
    }


}
