package Metier;

import java.util.ArrayList;
import java.util.List;

import Donnees.FacadeDonnees;
import Entite.Combat;
import Entite.Hero;
import Entite.Vilain;

public class GererCombat {
	
	static List<Combat> combats = new ArrayList<>();
	private FacadeDonnees facadeDonnees;
	
	public GererCombat() {
		facadeDonnees = new FacadeDonnees();	
	}
	
	public void participantHero(int i, int j) {
		facadeDonnees.participantHero(i,j);	
	}

	public List<Hero> getHerosByCombat(int id) {
		return facadeDonnees.getHerosByCombat(id);
	}

	public void creerCombat(Combat combat) {
		facadeDonnees.creerCombat(combat);	
	}

	public List<Vilain> getVilainsByCombat(int id) {
		return facadeDonnees.getVilainsByCombat(id);
	}

	
	public void participantVilain(int i, int j) {
		facadeDonnees.participantVilain(i,j);
	}
	
	public List<Combat> getCombats() {
		return facadeDonnees.getCombats();
	}
	
	public List<Combat> findCombatByName(String name) {
		return facadeDonnees.findCombatByName(name);
	}

}
