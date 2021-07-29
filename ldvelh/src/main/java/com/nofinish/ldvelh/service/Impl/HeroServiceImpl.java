package com.nofinish.ldvelh.service.Impl;

import com.nofinish.ldvelh.model.Book;
import com.nofinish.ldvelh.model.Hero;
import com.nofinish.ldvelh.repo.BookRepo;
import com.nofinish.ldvelh.repo.HeroRepo;
import com.nofinish.ldvelh.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepo heroRepo;

    @Autowired
    private BookRepo bookRepo;


    @Override
    public Hero createHero(Long id, Hero hero) {
        Optional<Book> currentBook = bookRepo.findById(id);
        currentBook.get().setHero(hero);
        return heroRepo.save(hero);
    }

    @Override
    public Hero readHeroById(Long id) {
        Optional<Hero> heroOption = heroRepo.findById(id);
        if(heroOption.isPresent()) {
            return heroOption.get();
        }
        return null;
    }

    @Override
    public Hero updateHero(Hero hero) {
        return heroRepo.save(hero);
    }

    @Override
    public void deleteHero(Hero hero) {
        heroRepo.delete(hero);
    }
}
