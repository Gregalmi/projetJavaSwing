package Metier;
import java.util.ArrayList;
import java.util.List;

import Donnees.CombatDAO;
import Donnees.HeroDAO;
import Donnees.OrganisationDAO;
import Donnees.VilainDAO;
import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public class FacadeMetier implements MetierItf {
	private GererOrganisation gererOrganisation;
	private GererCombat gererCombat;
	private GererHeros gererHeros;
	private GererVilains gererVilains;
	
	public FacadeMetier () {
		gererOrganisation = new GererOrganisation();
		gererCombat = new GererCombat();
		gererHeros = new GererHeros();
		gererVilains = new GererVilains();
	}

	public void creerHero(Hero hero) {
		gererHeros.creerHero(hero);
	}

	@Override
	public List<Hero> getHeros() {
		return gererHeros.getHeros();
	}

	@Override
	public Hero findHeroById(int id) {
		return gererHeros.findHeroById(id);
	}
	
	@Override
	public List<Hero> findHeroByName(String name) {
		return gererHeros.findHeroByName(name);
	}

	@Override
	public List<Vilain> getVilains() {
		return gererVilains.getVilains();
	}
	@Override
	public List<Vilain> findVilainByName(String name) {
		return gererVilains.findVilainByName(name);
	}
	@Override
	public Vilain findVilainById(int id) {
		return gererVilains.findVilainById(id);
	}
	
	@Override
	public void creerVilain(Vilain vilain) {
		gererVilains.creerVilain(vilain);
	}

	@Override
	public void creerOrganisation(Organisation organisation) {
		gererOrganisation.creerOrganisation(organisation);
		
	}

	@Override
	public List<Organisation> getOrganisations() {
		// TODO Auto-generated method stub
		return gererOrganisation.getOrganisations();
	}
	
	@Override
	public List<Hero> getHerosInOrganisation(int id) {
		return gererOrganisation.getHerosInOrganisation(id);
	}

	@Override
	public Organisation getOrganisationbyID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organisation> findOrganisationByName(String name) {
		return gererOrganisation.findOrganisationByName(name);
	}
	
	public Organisation findOrganisationById(int id) {
		return gererOrganisation.findOrganisationById(id);
	}

	@Override
	public void participantHero(int i, int j) {
		gererCombat.participantHero(i,j);
		
	}

	@Override
	public List<Hero> getHerosByCombat(int id) {
		return gererCombat.getHerosByCombat(id);
	}

	@Override
	public void creerCombat(Combat combat) {
		gererCombat.creerCombat(combat);
		
	}

	@Override
	public List<Vilain> getVilainsByCombat(int id) {
		return gererCombat.getVilainsByCombat(id);
	}

	@Override
	public void participantVilain(int i, int j) {
		gererCombat.participantVilain(i,j);
		
	}

	@Override
	public List<Combat> getCombats() {
		return gererCombat.getCombats();
	}

	@Override
	public List<Combat> findCombatByName(String name) {
		return gererCombat.findCombatByName(name);
	}
	
}
