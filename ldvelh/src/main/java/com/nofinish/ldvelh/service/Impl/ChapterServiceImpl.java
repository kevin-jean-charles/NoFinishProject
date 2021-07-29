package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Chapter;
import com.nofinish.ldvelh.repo.ChapterRepo;
import com.nofinish.ldvelh.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private  ChapterRepo chapterRepo;


    @Override
    public Chapter saveChapter(Chapter chapter) {
        return chapterRepo.save(chapter);
    }


//    @Override
//    public Chapter saveOptions(Chapter chapter) {
//        Chapter chapterOptions = chapterRepo.getById(chapter.getId());
//        HashMap<Integer, Chapter> chapterHashMap = new HashMap<>();
//
//        chapterHashMap.put(1, chapter);
//
//        return chapterRepo.save(chapter);
//    }

    @Override
    public List<Chapter> findAllChapters() {
        return  chapterRepo.findAll();
    }

    @Override
    public Chapter findByCaption(String caption) {
        return chapterRepo.findByCaption(caption);
    }

    @Override
    public Chapter updateChapter(Chapter chapter) {
        return chapterRepo.save(chapter);
    }

    @Override
    public void deleteChapter(Chapter chapter) {
        chapterRepo.delete(chapter);
    }


}
