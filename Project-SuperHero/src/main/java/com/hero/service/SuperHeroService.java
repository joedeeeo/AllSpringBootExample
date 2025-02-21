package com.hero.service;

import java.util.List;

import com.hero.entity.SuperHero;

public interface SuperHeroService {

	public String addSuperHero(SuperHero superHero);
	public List<SuperHero> getAllSuperHeros();
	public SuperHero getSuperHeroById(Long id);
	public SuperHero updateSuperHeroById(Long id,String userName);
	public void deleteSuperHeroById(Long id);
	public void deleteAllSuperHero(SuperHero superHero);
	
}
