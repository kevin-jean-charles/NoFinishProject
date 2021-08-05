package com.nofinish.ldvelh.service;

import com.nofinish.ldvelh.model.Hero;

public interface HeroService {
    Hero saveHero(Long id, Hero chapter);

    Hero findHeroById(Long id);

    Hero updateHero(Hero hero);

    void deleteHero(Hero hero);
}
