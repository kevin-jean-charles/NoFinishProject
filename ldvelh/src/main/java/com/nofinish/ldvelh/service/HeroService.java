package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Hero;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HeroService {
    Hero createHero(Long id, Hero chapter);

    Hero readHeroById(Long id);

    Hero updateHero(Hero hero);

    void deleteHero(Hero hero);
}
