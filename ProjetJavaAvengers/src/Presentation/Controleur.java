package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Donnees.HeroDAO;
import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;
import Metier.FacadeMetier;




public class Controleur implements ActionListener {
	//connecter ici avec la facade metier
	
	private OrganisationListeVue organisationListeVue;
	private OrganisationCreationVue organisationCreationVue;
	private HeroListeVue heroListeVue;
	private HeroCreationVue heroCreationVue;
	
	// composants graphiques fenï¿½tre principale
	private JFrame fenPrincipale;
	private JMenuBar barreMenu;
	private JMenu organisation, superHeros, superVilains, combats;
	private JMenuItem listeOrga, creaOrga, listeHeros, creaHeros, listeVilains, creaVilain, listeCombats, creaCombat, gererCombat; 
	private Container conteneur;
		
	// composants MVC
	private OrganisationModel organisationModel;
	protected FacadeMetier facadeMetier;

	// Composant vue Combat
	private CombatCreationVue combatCreationVue;
	private CombatListeVue combatListeVue;
	private CombatParticipantsVue combatParticipantsVue;
	private CombatModel combatModel;
	private HeroModel heroModel;
	private VilainModel vilainModel;
	private VilainListeVue vilainListeVue;
	private VilainCreationVue vilainCreationVue;


	//private OrganisationVue organisationVue;
	
	public Controleur (FacadeMetier facadeMetier) {
		this.facadeMetier = facadeMetier; 
		fenPrincipale = new JFrame();
		fenPrincipale.setTitle ("Gestion Avengers") ;  
		fenPrincipale.setBounds (0, 0, 1980, 1080) ;
		conteneur = fenPrincipale.getContentPane();
		conteneur.setLayout(new BorderLayout());
		heroModel = new HeroModel(getHeros());
		vilainModel = new VilainModel(getVilains());
		organisationModel = new OrganisationModel(getOrganisations());
		organisationListeVue = new OrganisationListeVue(this, organisationModel);
		organisationCreationVue = new OrganisationCreationVue(this);
		heroListeVue = new HeroListeVue(this, heroModel);
		heroCreationVue = new HeroCreationVue(this);
		
		ImageIcon icon = new ImageIcon("avengers.jpg");
		
		vilainCreationVue = new VilainCreationVue(this);
		vilainListeVue = new VilainListeVue(this, vilainModel);

		combatModel = new CombatModel(getCombats()) ;
		combatCreationVue = new CombatCreationVue(this);
		combatListeVue = new CombatListeVue(this, combatModel, heroModel, vilainModel);
		combatParticipantsVue = new CombatParticipantsVue(this, combatModel, heroModel, vilainModel);
			
		// barre menu
		barreMenu = new JMenuBar();
		fenPrincipale.setJMenuBar(barreMenu);
		
		organisation= new JMenu("Organisation");
		barreMenu.add(organisation);
		listeOrga = new JMenuItem("Afficher");
		creaOrga = new JMenuItem("Créer");
		organisation.add(listeOrga);
		organisation.add(creaOrga);
		listeOrga.addActionListener(this);
		creaOrga.addActionListener(this);
		
		
		superHeros= new JMenu("Super Héros");
		barreMenu.add(superHeros);
		listeHeros = new JMenuItem("Afficher");
		creaHeros = new JMenuItem("Créer");
		superHeros.add(listeHeros);
		superHeros.add(creaHeros);
		listeHeros.addActionListener(this);
		creaHeros.addActionListener(this);
		
		superVilains= new JMenu("Super Vilains");
		barreMenu.add(superVilains);
		listeVilains = new JMenuItem("Afficher");
		creaVilain = new JMenuItem("Créer");
		superVilains.add(listeVilains);
		superVilains.add(creaVilain);
		listeVilains.addActionListener(this);
		creaVilain.addActionListener(this);
		
		combats= new JMenu("Combats");
		barreMenu.add(combats);
		listeCombats = new JMenuItem("Afficher");
		creaCombat = new JMenuItem("Créer");
		gererCombat = new JMenuItem("Gérer-Ajouter");
		combats.add(listeCombats);
		combats.add(creaCombat);
		combats.add(gererCombat);
		listeCombats.addActionListener(this);
		creaCombat.addActionListener(this);
		gererCombat.addActionListener(this);
		
		JLabel image = new JLabel(icon);
		fenPrincipale.add(image);
		
		
		
		fenPrincipale.setVisible(true) ;
	
		}



	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		conteneur.removeAll();
		if(source==listeOrga){
			organisationListeVue = new OrganisationListeVue(this,organisationModel); //(this,etudiantModel)
			conteneur.add(organisationListeVue);
			System.out.println("bouton page principale listeOrga");
		}else if(source==creaOrga){
			organisationCreationVue = new OrganisationCreationVue(this);//(this,organisationModel);
			conteneur.add(organisationCreationVue);
			System.out.println("bouton page principale creaOrga");
		}else if(source==listeHeros){
			heroListeVue = new HeroListeVue(this, heroModel);//(this,organisationModel);
			conteneur.add(heroListeVue);
			System.out.println("bouton page principale listeHeros");
		}else if(source==creaHeros){
			heroCreationVue = new HeroCreationVue(this);//(this,organisationModel);
			conteneur.add(heroCreationVue);
			System.out.println("bouton page principale listeHeros");
		}else if(source==listeVilains){
			vilainListeVue = new VilainListeVue(this, vilainModel);//(this,organisationModel);
			conteneur.add(vilainListeVue);
			System.out.println("bouton page principale listeHeros");
		}else if(source==creaVilain){
			vilainCreationVue = new VilainCreationVue(this);//(this,organisationModel);
			conteneur.add(vilainCreationVue);
			System.out.println("bouton page principale listeHeros");
		}else if(source==listeCombats){
			combatListeVue = new CombatListeVue(this, combatModel, heroModel, vilainModel);
			conteneur.add(combatListeVue);
			System.out.println("bouton page principale listeCombat");
		}else if(source== creaCombat) {
			combatCreationVue = new CombatCreationVue(this);
			conteneur.add(combatCreationVue);
			System.out.println("bouton page principale crea Combat");
		}else if(source== gererCombat) {
			combatParticipantsVue = new CombatParticipantsVue(this, combatModel, heroModel, vilainModel);
			conteneur.add(combatParticipantsVue);
			System.out.println("bouton page principale crea Combat");
		}

		conteneur.revalidate();
	}
		public List<Organisation> getOrganisations() {
			return facadeMetier.getOrganisations();
		}	
		
		public List<Organisation> findOrganisationByName(String name) {
			return facadeMetier.findOrganisationByName(name);
		}
		
		public Organisation findOrganisationById(int id) {
			return facadeMetier.findOrganisationById(id);
		}
		
		
		public void creerOrganisation(Organisation organisation) {
			facadeMetier.creerOrganisation(organisation);
			organisationModel.setOrganisations(this.getOrganisations());
		}
		
		public List<Hero> getHerosInOrganisation(int id) {
			return facadeMetier.getHerosInOrganisation(id);
		}
		
		public List<Hero> getHeros() {
			return facadeMetier.getHeros();
		}	
		
		public Hero findHeroById(int id) {
			return facadeMetier.findHeroById(id);
		}
		
		public void creerHero(Hero hero) {
			facadeMetier.creerHero(hero);
			heroModel.setHeros(this.getHeros());
		}
		
		public List<Hero> findHeroByName(String name) {
			return facadeMetier.findHeroByName(name);
		}
		
		
		public void participantHero(int i, int j) {
			facadeMetier.participantHero(i,j);
			
		}
		

		public List<Vilain> getVilains() {
			return facadeMetier.getVilains();
		}

		public List<Vilain> findVilainByName(String name) {
			return facadeMetier.findVilainByName(name);
		}

		public Vilain findVilainById(int id) {
			return facadeMetier.findVilainById(id);
		}
		
		public void creerVilain(Vilain vilain) {
			facadeMetier.creerVilain(vilain);
			vilainModel.setVilains(this.getVilains());
		}


		public List<Hero> getHerosByCombat(int id) {
			return facadeMetier.getHerosByCombat(id);
		}
		
		public void creerCombat(Combat combat) {
			facadeMetier.creerCombat(combat);
			combatModel.setCombats(this.getCombats());	
		}

		public List<Vilain> getVilainsByCombat(int id) {
			return facadeMetier.getVilainsByCombat(id);
		}

		public void participantVilain(int i, int j) {
			facadeMetier.participantVilain(i,j);
		}
		
		public List<Combat> getCombats() {
			return facadeMetier.getCombats();
		}
		
		public List<Combat> findCombatByName(String name) {
			return facadeMetier.findCombatByName(name);
		}
	

		
	
		
		
}
		
