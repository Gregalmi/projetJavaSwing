package Presentation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;
public class CombatParticipantsVue extends JPanel implements ActionListener {
	private Controleur controleur;
	private JComboBox<String> comboCombat, comboHeros, comboVilains;
	private JLabel labelCombat, labelHeros, labelVilains;
	private JButton btnCombat, btnHeros, btnVilains;
	private JTable tableCombat, tableSH, tableSV, tableSuperHeros, tableSuperVilains, tableSVil, tableSHer;
	private JPanel combatGestion, combatGestionEtBouton, listeCombattants;
	public CombatParticipantsVue(Controleur controleur, CombatModel combatModel, HeroModel heroModel, VilainModel vilainModel) {
		this.controleur = controleur;
		setLayout(new BorderLayout());
		setVisible(true);
		combatGestion = new JPanel();
		combatGestion.setLayout(new GridLayout(3, 3, 20,20));
		//ComboBox sélection Combats
		comboCombat = new JComboBox<String>();
		labelCombat = new JLabel("Liste des combats");
		comboCombat.setPreferredSize(new Dimension(100, 20));
		combatGestion.add(labelCombat);
		combatGestion.add(comboCombat);
		for (Combat c : controleur.getCombats()) {
			comboCombat.addItem(c.getIntitule());//no
		}
		btnCombat = new JButton("Sélectionner");
		btnCombat.addActionListener(this);
		combatGestion.add(btnCombat);
		//ComboBox Ajout des Héros
		comboHeros = new JComboBox<String>();
		labelHeros = new JLabel("Liste des heros");
		comboHeros.setPreferredSize(new Dimension(100, 20));
		combatGestion.add(labelHeros);
		combatGestion.add(comboHeros);
		for (Hero h : controleur.getHeros()) {
			comboHeros.addItem(h.getNom());//no
		}
		btnHeros= new JButton("Ajouter");
		btnHeros.addActionListener(this::AjoutHeros);
		combatGestion.add(btnHeros);
		// ComboBox ajout des Vilains
		comboVilains = new JComboBox<String>();
		labelVilains = new JLabel("Liste des Vilains");
		comboVilains.setPreferredSize(new Dimension(100, 20));
		combatGestion.add(labelVilains);
		combatGestion.add(comboVilains);
		for (Vilain v : controleur.getVilains()) {
			comboVilains.addItem(v.getNom());//no
		}
		btnVilains= new JButton("Ajouter");
		btnVilains.addActionListener(this::AjoutVilains);
		combatGestion.add(btnVilains);
		// Container of comboBoxes
		combatGestionEtBouton = new JPanel();
		Border border = BorderFactory.createTitledBorder("Gérer les combattants");
		combatGestionEtBouton.setBorder(border);
		combatGestionEtBouton.setLayout(new FlowLayout());
		combatGestionEtBouton.add(combatGestion);
		add(combatGestionEtBouton, BorderLayout.NORTH);
		listeCombattants = new JPanel();
		listeCombattants.setLayout(new GridLayout(1, 2));
		tableSH = new JTable(heroModel);
		listeCombattants.add(new JScrollPane(tableSH));
		tableSV = new JTable(vilainModel);
		listeCombattants.add(new JScrollPane(tableSV));
		this.add(listeCombattants, BorderLayout.SOUTH);
		//Tableau des groupes de combat
		tableCombat = new JTable(combatModel);
        add(new JScrollPane(tableCombat),BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCombat){
			this.removeAll();
			this.listeCombattants.removeAll();
			System.out.println(" Action bouton sélection combat");		
			String value = comboCombat.getSelectedItem().toString();
			List<Combat> combats = controleur.findCombatByName(value);
			int idCombat = combats.get(0).getId();
			CombatModel combatModel = new CombatModel(combats);
			//Ajout de la capsule de sélection
			List<Hero> heros = controleur.getHerosByCombat(idCombat);
            HeroModel heroModel = new HeroModel(heros);
            tableSH = new JTable(heroModel);
            listeCombattants.add(new JScrollPane(tableSH));
            
            
            List<Vilain> vilains = controleur.getVilainsByCombat(idCombat);
            VilainModel vilainModel = new VilainModel(vilains);
            tableSV = new JTable(vilainModel);
            listeCombattants.add(new JScrollPane(tableSV));
            //Table du combat sélectionné
			tableCombat = new JTable(combatModel);
	        this.add(new JScrollPane(tableCombat),BorderLayout.CENTER);
	        this.add(listeCombattants, BorderLayout.SOUTH);
	        this.add(combatGestionEtBouton,BorderLayout.NORTH);

	        repaint();
			revalidate();
		}
	}
	public void AjoutHeros(ActionEvent h) {
		if (h.getSource() == btnHeros){
			
			listeCombattants.removeAll();
			System.out.println(" Action bouton sélection Héros");
			String valueCombat = comboCombat.getSelectedItem().toString();
			System.out.println(valueCombat);
			List<Combat> combats = controleur.findCombatByName(valueCombat);
			int idcombat = combats.get(0).getId();
			String valueHero = comboHeros.getSelectedItem().toString();
			List<Hero> heros = controleur.findHeroByName(valueHero);
			int idheros = heros.get(0).getId();
			System.out.println(idcombat);
			controleur.participantHero(idheros, idcombat);
			List<Hero> superHeros = controleur.getHerosByCombat(idcombat);
	        HeroModel heroModel = new HeroModel(superHeros);
	        
	        List<Vilain> vilains = controleur.getVilainsByCombat(idcombat);
            VilainModel vilainModel = new VilainModel(vilains);
            tableSVil = new JTable(vilainModel);
            
	      //Affiche la nouvelle table de SH
	        tableSuperHeros = new JTable(heroModel);
	        listeCombattants.add(new JScrollPane(tableSuperHeros));
	        listeCombattants.add(new JScrollPane(tableSVil));
	        //listeCombattants.add(new JScrollPane(tableSV));
			repaint();
 	        revalidate();
		}
	}
	public void AjoutVilains(ActionEvent v) {
		if (v.getSource() == btnVilains){
			/* Affiche la tableSuperVilains en tps reel mais sans celle des SH...*/
			listeCombattants.removeAll();

			String valueCombat = comboCombat.getSelectedItem().toString();
			List<Combat> combats = controleur.findCombatByName(valueCombat);
			int idcombat = combats.get(0).getId();
			String valueVilain = comboVilains.getSelectedItem().toString();
			List<Vilain> vilains = controleur.findVilainByName(valueVilain);
			int idvilains = vilains.get(0).getId();
			//vilains.get(0).getId();
			List<Hero> heros = controleur.getHerosByCombat(idcombat);
            HeroModel heroModel = new HeroModel(heros);
            tableSHer = new JTable(heroModel);
            //listeCombattants.add(new JScrollPane(tableSHer));
			
			controleur.participantVilain(idvilains, idcombat);
			List<Vilain> superVilains = controleur.getVilainsByCombat(idcombat);
	        VilainModel vilainModel = new VilainModel(superVilains);
	        //Affiche la nouvelle table de SV
	        tableSuperVilains = new JTable(vilainModel);
	        listeCombattants.add(new JScrollPane(tableSHer));
	        listeCombattants.add(new JScrollPane(tableSuperVilains));
			//System.out.println(" Action bouton sélection vilain");
			repaint();
 	        revalidate();
		}
	}
}
