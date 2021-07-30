package com.nofinish.ldvelh.repo;

import com.nofinish.ldvelh.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChapterRepo extends JpaRepository<Chapter, Long> {

}
