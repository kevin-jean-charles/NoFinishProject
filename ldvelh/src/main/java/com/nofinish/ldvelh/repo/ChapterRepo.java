package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepo extends JpaRepository<Chapter, Integer> {
    Chapter findByCaption(String caption);


}
