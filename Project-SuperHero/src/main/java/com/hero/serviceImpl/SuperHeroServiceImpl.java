package com.hero.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hero.entity.SuperHero;
import com.hero.repository.SuperHeroRepo;
import com.hero.service.SuperHeroService;

@Service
public class SuperHeroServiceImpl implements SuperHeroService{
	
@Autowired
private SuperHeroRepo superHeroRepo;

	@Override
	public String addSuperHero(SuperHero superHero) {
		superHeroRepo.save(superHero);
		return "Data save successfully";
	}

	@Override
	public List<SuperHero> getAllSuperHeros() {
		return superHeroRepo.findAll();
		
		}

	@Override
	public SuperHero getSuperHeroById(Long id) {
		return superHeroRepo.findById(id).orElse(null);
	}

	@Override
	public SuperHero updateSuperHeroById(Long id, String userName) {
		Optional<SuperHero> sh = superHeroRepo.findById(id);
		if(sh.isPresent()) {
			SuperHero s = sh.get();
			s.setName(userName);
			return s;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteSuperHeroById(Long id) {
		Optional<SuperHero>sh= superHeroRepo.findById(id);
		if(sh.isPresent()) {
			//SuperHero s = sh.get();
			superHeroRepo.deleteById(id);
		}
	}

	@Override
	public void deleteAllSuperHero(SuperHero superHero) {
		superHeroRepo.deleteAll();
	}
	

}
