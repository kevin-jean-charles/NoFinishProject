package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Chapter;

import java.util.List;

public interface ChapterService {
    Chapter createOrUpdateChapter(Chapter chapter);

    List<Chapter> findAllChapters();

    void deleteChapter(Chapter chapter);

    Chapter findById(Long id);

    void deleteChapterById(Long id);
}
