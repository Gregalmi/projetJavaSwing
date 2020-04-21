package Metier;
import java.util.List;

import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public interface MetierItf {
	
	void creerHero(Hero hero);
	void ajouterHero(Hero hero);
	public List<Hero> getHeros();
	public Hero getHerobyID();
	void creerVilain(Vilain vilain);
	void ajouterVilain(Vilain vilain);
	public List<Vilain> getVilains();
	public Vilain getVilainbyID();
	void creerOrganisation(Organisation organisation);
	public List<Organisation> getOrganisations();
	public Organisation getOrganisationbyID();
	//void creerCombat(Combat combat);
	//public List<Combat> getCombats();
	//public Combat combat getCombatbyID();

}
