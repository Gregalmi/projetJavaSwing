package Metier;
import java.util.ArrayList;
import java.util.List;

import Entite.Hero;

public class GererHeros {
	static List<Hero> heros = new ArrayList<>();

	
	public GererHeros() {
		
	}
	
	public static void ajouterHero(Hero hero) {
		heros.add(hero);
	}
	
	public static List<Hero> getHeros() {
		return heros;
	}
}
