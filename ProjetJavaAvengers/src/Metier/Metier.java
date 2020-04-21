package Metier;
import java.util.ArrayList;
import java.util.List;

import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public class Metier implements MetierItf {

	
	public Metier () {
		initialiser();
	}
	
	public void initialiser() {
		Hero spiderman = new Hero("Spider-Man", "Peter Parker", "C'est l'homme araignée", "super fort", "avenger");
		Hero batman = new Hero("Batman", "Bruce Wayne", "C'est l'homme chauve souris", "tres tres fort", "avenger");
		Vilain lechauve = new Vilain ("Le Chauve", "john malko", "pas de cheveu", "son crane", 5);
		ajouterHero(spiderman);
		ajouterHero(batman);
		ajouterVilain(lechauve);
		System.out.println(getHeros());
		System.out.println(getVilains());

	}
	
	public void ajouterHero(Hero hero) {
		GererHeros.ajouterHero(hero);
	}
	
	public void ajouterVilain(Vilain vilain) {
		GererVilains.ajouterVilain(vilain);
	}

	@Override
	public void creerHero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hero> getHeros() {
		return GererHeros.getHeros();
	}

	@Override
	public Hero getHerobyID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerVilain(Vilain vilain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vilain> getVilains() {
		return GererVilains.getVilains();
	}

	@Override
	public Vilain getVilainbyID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerOrganisation(Organisation organisation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Organisation> getOrganisations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organisation getOrganisationbyID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
