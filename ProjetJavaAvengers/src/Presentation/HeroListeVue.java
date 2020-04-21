package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import Donnees.OrganisationDAO;
import Entite.Hero;

public class HeroListeVue  extends JPanel implements ActionListener{
	private Controleur controleur;
	private JComboBox <String> comboHeros;
	private JLabel label;
	private JButton btnComboHeros;
	private JTable tableHeros;
	private JPanel listeHeros, panIcon, panIcon2;


	public HeroListeVue(Controleur controleur, HeroModel heroModel) {
		this.controleur = controleur;
		//setLayout(new BorderLayout());
		
		this.setLayout(null);
		
		listeHeros = new JPanel();
		listeHeros.setBounds(750, 50, 400, 100);
		Border border = BorderFactory.createTitledBorder("Liste des Superhéros");
		listeHeros.setBorder(border);
		listeHeros.setLayout(new FlowLayout());
		
		//Liste des organisations
		comboHeros = new JComboBox<String>();
		label = new JLabel("Liste des Superhéros");
		comboHeros.setPreferredSize(new Dimension(100,20));
		listeHeros.add(label);
		listeHeros.add(comboHeros); 
		for (Hero h : controleur.getHeros()) {
			comboHeros.addItem(h.getNom());//non
		}
		btnComboHeros = new JButton("Afficher le Superhéros");
		btnComboHeros.addActionListener(this);
		listeHeros.add(btnComboHeros);
		add(listeHeros);	
		
		tableHeros = new JTable(heroModel);
		add(new JScrollPane(tableHeros)).setBounds(500, 200, 890, 400);
		
		JLabel icon = new JLabel(new ImageIcon("ironman.jpg"));
	    panIcon = new JPanel();
	    panIcon.add(icon);
	    add(panIcon);
	    panIcon.setBounds(20, 200, 350, 350);
	    
	    JLabel icon2 = new JLabel(new ImageIcon("thor.jpg"));
	    panIcon2 = new JPanel();
	    panIcon2.add(icon2);
	    add(panIcon2);
	    panIcon2.setBounds(1500, 40, 300, 300);
		//System.out.println(tableHeros);
		
}
	public HeroListeVue(Controleur controleur) {
		this.controleur = controleur;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComboHeros){
			System.out.println(" Action bouton afficher le superhéros");
			String value = comboHeros.getSelectedItem().toString();
			//JScrollPane js = new JScrollPane();
			this.removeAll();
			this.setLayout(null);
			
			List <Hero> heros = controleur.findHeroByName(value);
			HeroModel heroModel = new HeroModel(heros);
			
			tableHeros = new JTable(heroModel);
			
			add(listeHeros);
			add(panIcon);
			add(panIcon2);

			add(new JScrollPane(tableHeros)).setBounds(500, 200, 890, 400);
			repaint();
			revalidate();
			System.out.println(controleur.findHeroByName(value));	
			System.out.println("Sélection : " + value);
			}
		}

}
