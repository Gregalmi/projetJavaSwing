package Metier;
import java.util.ArrayList;
import java.util.List;

import Entite.Vilain;

public class GererVilains {
	static List<Vilain> vilains = new ArrayList<>();
	
	public GererVilains() {
		
	}
	
	public static void ajouterVilain(Vilain vilain) {
		vilains.add(vilain);
	}
	
	
	public static List<Vilain> getVilains() {
		return vilains;
	}

}
