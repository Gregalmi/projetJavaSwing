package Metier;

import java.util.ArrayList;
import java.util.List;

import Donnees.FacadeDonnees;
import Entite.Hero;
import Entite.Organisation;

public class GererOrganisation {
	static List<Organisation> organisations = new ArrayList<>();
	private FacadeDonnees facadeDonnees;
	
	public GererOrganisation() {
		facadeDonnees = new FacadeDonnees();
	}
	
	public void creerOrganisation(Organisation organisation) {
		facadeDonnees.creerOrganisation(organisation);
	}
	
	public List<Organisation> getOrganisations() {
		return facadeDonnees.getOrganisations();
	}
	
	public void afficherOrganisation() {
		
	}
	
	public List<Organisation> findOrganisationByName(String name) {
		return facadeDonnees.findOrganisationByName(name);
	}
	
	public Organisation findOrganisationById(int id) {
		return facadeDonnees.findOrganisationById(id);
	}
	
	public List<Hero> getHerosInOrganisation(int id) {
		return facadeDonnees.getHerosInOrganisation(id);
	}
	
}
