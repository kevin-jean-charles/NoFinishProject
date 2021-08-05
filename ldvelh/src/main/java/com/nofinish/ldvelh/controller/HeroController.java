package com.nofinish.ldvelh.controller;


import com.nofinish.ldvelh.model.Hero;
import com.nofinish.ldvelh.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book/{book_id}/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    //create hero
    @PostMapping("")
    public ResponseEntity<Hero> createHeroInBookByBookId(@PathVariable("book_id") Long book_id, @RequestBody Hero hero){
        Hero newHero = heroService.saveHero(book_id, hero);
        return new ResponseEntity<>(newHero, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable Long id) {
        Hero hero = heroService.findHeroById(id);
        return new ResponseEntity<>(hero,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        Hero updateHero = heroService.updateHero(hero);
        return new ResponseEntity<>(updateHero,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Hero> deleteHeroById(@RequestBody Hero hero) {
        heroService.deleteHero(hero);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
