package Donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;
import Metier.GererHeros;
import Metier.GererVilains;
import Donnees.MaConnection;

public class FacadeDonnees implements DonneesItf {
	
	List<Vilain> vilains = new ArrayList<>();
	private Connection connection;
	
	public FacadeDonnees () {
		
		connection = MaConnection.getInstance();
		OrganisationDAO organisationDAO = new OrganisationDAO();
		HeroDAO heroDAO = new HeroDAO();
		VilainDAO vilainDAO = new VilainDAO();
		CombatDAO combatDAO = new CombatDAO();
	}

	public void creerVilain(Vilain vilain) {
		VilainDAO.creerVilain(vilain);
	}
	
	public void creerHero(Hero hero) {
		HeroDAO.creerHero(hero);
	}
	
	public List<Hero> getHeros() {
		return HeroDAO.getHeros();
	}
	
	public List<Vilain> getVilains() {
		return VilainDAO.getVilains();
	}
	
	public List<Vilain> findVilainByName(String name) {
		return VilainDAO.findVilainByName(name);
	}


	@Override
	public Hero findHeroById(int id) {
		return HeroDAO.findHeroById(id);
	}
	
	@Override
	public List<Hero> findHeroByName(String name) {
		return HeroDAO.findHeroByName(name);
	}
	
	@Override
	public void afficherHero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherVilain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerOrganisation(Organisation organisation) {
		OrganisationDAO.creerOrganisation(organisation);
	}

	@Override
	public List<Organisation> getOrganisations() {
		return OrganisationDAO.getOrganisations();
	}

	@Override
	public Organisation getOrganisationByID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  List<Organisation> findOrganisationByName(String name) {
		return OrganisationDAO.findOrganisationByName(name);
	}
	
	public Organisation findOrganisationById(int id) {
		return OrganisationDAO.findOrganisationById(id);
	}

	@Override
	public void afficherOrganisation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Hero> getHerosInOrganisation(int id) {
		return OrganisationDAO.getHerosInOrganisation(id);
	}

	@Override
	public Vilain findVilainById(int id) {
		return VilainDAO.findVilainById(id);
	}
	
	@Override
	public void participantHero(int i, int j) {
		CombatDAO.participantHero(i, j);
	}
	@Override
	public List<Hero> getHerosByCombat(int id) {
		return CombatDAO.getHerosByCombat(id);
	}
	@Override
	public void creerCombat(Combat combat) {
		CombatDAO.creerCombat(combat);
	}

	@Override
	public List<Vilain> getVilainsByCombat(int id) {
		return CombatDAO.getVilainsByCombat(id);
	}

	@Override
	public void participantVilain(int i, int j) {
		CombatDAO.participantVilain(i, j);
	}

	@Override
	public List<Combat> getCombats() {
		return CombatDAO.getCombats();
	}

	@Override
	public List<Combat> findCombatByName(String name) {
		return CombatDAO.findCombatByName(name);
	}
	

}
