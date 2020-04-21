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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import Entite.Hero;
import Entite.Organisation;

public class HeroCreationVue extends JPanel implements ActionListener {
	private Controleur controleur;
	private JLabel labelOrganisation;
	private JTextField nom, idSecrete, commentaire, pouvoir;
	private JComboBox<String> comboOrganisation;
	private JButton btnAjout;
	public HeroCreationVue(Controleur controleur) {
		this.controleur = controleur;
		setLayout(new BorderLayout());
		setVisible(true);
		//Formulaire creation superhéros
		JPanel herosFormulaire = new JPanel();
		herosFormulaire.setLayout(new GridLayout(5, 2, 20,20));
		herosFormulaire.add(new JLabel("Nom"));
		nom = new JTextField(20);
		herosFormulaire.add(nom);
		herosFormulaire.add(new JLabel("Identité secrète"));
		idSecrete = new JTextField(20);
		herosFormulaire.add(idSecrete);
		herosFormulaire.add(new JLabel("Commentaire"));
		commentaire = new JTextField(20);
		herosFormulaire.add(commentaire);
		herosFormulaire.add(new JLabel("Pouvoir"));
		pouvoir = new JTextField(20);
		herosFormulaire.add(pouvoir);
		
		comboOrganisation = new JComboBox<String>();
		labelOrganisation = new JLabel("Liste des organisations");
		comboOrganisation.setPreferredSize(new Dimension(100, 20));
		herosFormulaire.add(labelOrganisation);
		herosFormulaire.add(comboOrganisation);
        for (Organisation o : controleur.getOrganisations()) {
        	comboOrganisation.addItem(o.getNom());//no
        }
        
		btnAjout = new JButton("Ajouter");
		btnAjout.addActionListener(this);
		JPanel herosFormulaireEtBouton = new JPanel();
		Border border = BorderFactory.createTitledBorder("Créer un SuperHéros");
		herosFormulaireEtBouton.setBorder(border);
		herosFormulaireEtBouton.setLayout(new FlowLayout());
		herosFormulaireEtBouton.add(herosFormulaire);
		herosFormulaireEtBouton.add(btnAjout);
		add(herosFormulaireEtBouton,BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAjout){
			System.out.println(" Action bouton creer");
			String nomHeros = nom.getText();
			String idSrecreteHeros = idSecrete.getText();
			String comHeros = commentaire.getText();
			String pvrHeros= pouvoir.getText();
			String orgaHeros = comboOrganisation.getSelectedItem().toString();
			int orgaId = controleur.findOrganisationByName(orgaHeros).get(0).getId();
			Hero hero = new Hero(nomHeros, idSrecreteHeros, comHeros, pvrHeros, orgaId);
			
			if (nomHeros.isEmpty() || idSrecreteHeros.isEmpty() || comHeros.isEmpty() || pvrHeros.isEmpty()) {
				JOptionPane jopNull = new JOptionPane();
				jopNull.showMessageDialog(null, "Veuillez renseigner tous les champs ! " , "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
			}
			else{
				List<Hero> heros = controleur.getHeros();
				int count = 0;
				for(int i=0; i<heros.size();i++) 	
					if (heros.get(i).getNom().contains(nomHeros)) {
						count++;
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, " Cet Héros est déjà créé", "attention", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 
				
				if(count<1 ) {
					controleur.creerHero(hero);
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, " Votre Héros a bien été créé", "attention", JOptionPane.INFORMATION_MESSAGE);
					nom.setText("");
					idSecrete.setText("");
					commentaire.setText("");
					pouvoir.setText("");
				}	
			
			}
			
		}
	}
}


