package com.nofinish.ldvelh.controller;


import com.nofinish.ldvelh.model.Hero;
import com.nofinish.ldvelh.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books/{book_id}/hero")
public class HeroController {

    @Autowired
    private final HeroService heroService;



    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    //create hero
    @PostMapping("")
    public ResponseEntity<Hero> createHero(@PathVariable("book_id") Long book_id, @RequestBody Hero hero){
        Hero newHero = heroService.createHero(book_id, hero);
        return new ResponseEntity<>(newHero, HttpStatus.OK);
    }


    //getHero hero
    @GetMapping("{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Long id) {
        Hero hero = heroService.readHeroById(id);
        return new ResponseEntity<>(hero,HttpStatus.OK);
    }

    //update hero

    @PutMapping
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        Hero updateHero = heroService.updateHero(hero);
        return new ResponseEntity<>(updateHero,HttpStatus.OK);
    }

    //delete hero
    @DeleteMapping
    public ResponseEntity<Hero> deleteHeroById(@RequestBody Hero hero) {
        heroService.deleteHero(hero);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
