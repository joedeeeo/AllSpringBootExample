package com.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hero.entity.SuperHero;


@Repository
public interface SuperHeroRepo extends JpaRepository<SuperHero, Long>{
	

}
