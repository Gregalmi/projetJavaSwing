package Donnees;

import java.util.List;

import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public interface DonneesItf {
	void creerHero(Hero hero);
	public List<Hero> getHeros();
	void afficherHero();
	public Hero findHeroById(int id);
	public List<Hero> findHeroByName(String name);
	void creerVilain(Vilain vilain);
	void afficherVilain();
	public List<Vilain> getVilains();
	public Vilain findVilainById(int id);
	public List<Vilain> findVilainByName(String name);
	void creerOrganisation(Organisation organisation);
	public List<Organisation> getOrganisations();
	public Organisation getOrganisationByID();
	public List<Organisation> findOrganisationByName(String name);
	public Organisation findOrganisationById(int id);
	void afficherOrganisation();
	public List<Hero> getHerosInOrganisation(int id);
	public void participantHero(int i, int j);
	public List<Hero> getHerosByCombat(int id);
	public void creerCombat(Combat combat);
	public List<Vilain> getVilainsByCombat(int id);
	public void participantVilain(int i, int j);
	public List<Combat> getCombats();
	public List<Combat> findCombatByName(String name);

	
}
