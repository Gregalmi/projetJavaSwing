package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import Entite.Hero;
import Entite.Organisation;
import Metier.FacadeMetier;



public class OrganisationListeVue extends JPanel implements ActionListener{
	private Controleur controleur;
	private JComboBox <String> listeOrga;
	private JLabel label;
	private JButton btnListeOrga;
	private JTable tableOrganisations, tableHeroOrga; 
	private JPanel listeOrganisations, panIcon, panIcon2;

	public OrganisationListeVue (Controleur controleur, OrganisationModel organisationModel) {
		this.controleur = controleur;
		
		//setLayout(new GridLayout(1,2));
		this.setLayout(null);
		
		listeOrganisations = new JPanel();
		listeOrganisations.setBounds(750, 50, 400, 100);
		Border border = BorderFactory.createTitledBorder("Liste des organisations");
		listeOrganisations.setBorder(border);		
		listeOrganisations.setLayout(new FlowLayout());		
		//Liste des organisations
		listeOrga = new JComboBox<String>();
		label = new JLabel("Liste des organisations");
		listeOrga.setPreferredSize(new Dimension(100,20));
		listeOrganisations.add(label);
		listeOrganisations.add(listeOrga); 
		for (Organisation o : controleur.getOrganisations()) {
			listeOrga.addItem(o.getNom());//non
		}

		btnListeOrga = new JButton("Afficher Organisation");
		btnListeOrga.addActionListener(this);
		listeOrganisations.add(btnListeOrga);
		//add(listeOrganisations, BorderLayout.NORTH);	

		add(listeOrganisations);


		tableOrganisations = new JTable(organisationModel);
		
		//add(new JScrollPane(tableOrganisations),BorderLayout.CENTER);
		//
		add(new JScrollPane(tableOrganisations)).setBounds(500, 200, 890, 400);
		
		JLabel icon = new JLabel(new ImageIcon("hulk.jpg"));
	    panIcon = new JPanel();
	    panIcon.add(icon);
	    add(panIcon);
	    panIcon.setBounds(20, 350, 450, 650);
	    
		JLabel icon2 = new JLabel(new ImageIcon("veuvenoire.jpg"));
	    panIcon2 = new JPanel();
	    panIcon2.add(icon2);
	    add(panIcon2);
	    panIcon2.setBounds(1400, 100, 350, 500);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnListeOrga){

			String value = listeOrga.getSelectedItem().toString();

			this.removeAll();
			this.setLayout(null);
			
			//add(listeOrganisations, BorderLayout.NORTH);
			add(listeOrganisations);
			listeOrganisations.setBounds(750, 50, 400, 100);
			
			List <Organisation> organisations = controleur.findOrganisationByName(value);
			int idorganisation = organisations.get(0).getId();


			List<Hero> heros = controleur.getHerosInOrganisation(idorganisation);
			HeroModel heroModel = new HeroModel(heros);
			tableHeroOrga = new JTable(heroModel);
			//add(new JScrollPane(tableHeroOrga), BorderLayout.SOUTH);
			
			
			OrganisationModel organisationModel = new OrganisationModel(organisations);

			tableOrganisations = new JTable(organisationModel);

			//add(new JScrollPane(tableOrganisations),BorderLayout.CENTER);
			add(new JScrollPane(tableOrganisations)).setBounds(500, 200, 890, 50);
			add(new JScrollPane(tableHeroOrga)).setBounds(500, 300, 890, 400);
			add(panIcon);
			add(panIcon2);
			repaint();
			revalidate();


		}
	}	
}
