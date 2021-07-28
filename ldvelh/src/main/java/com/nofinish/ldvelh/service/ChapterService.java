package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Chapter;

import java.util.List;

public interface ChapterService {
    Chapter saveChapter(Chapter chapter);

    List<Chapter> findAllChapters();

    Chapter findByCaption(String caption);

    Chapter updateChapter(Chapter chapter);

    void deleteChapter(Chapter chapter);
}
