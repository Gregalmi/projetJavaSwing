package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Entite.Hero;
import Entite.Organisation;

public class OrganisationCreationVue extends JPanel implements ActionListener {
	private Controleur controleur;


	private JLabel label;
	private JTextField nom, siege, dirigeant, commentaire, date ;
	private JButton btnAjout;


	public OrganisationCreationVue (Controleur controleur) {
		this.controleur = controleur;
		setLayout(new BorderLayout());
		setVisible(true);

		//Formulaire creation organisation


		JPanel organisationFormulaire = new JPanel();
		organisationFormulaire.setLayout(new GridLayout(5, 2, 20,20));


		organisationFormulaire.add(new JLabel("Nom"));
		nom = new JTextField(20);
		organisationFormulaire.add(nom);

		organisationFormulaire.add(new JLabel("Siège"));
		siege = new JTextField(20);
		organisationFormulaire.add(siege);

		organisationFormulaire.add(new JLabel("Dirigeant"));
		dirigeant = new JTextField(20);
		organisationFormulaire.add(dirigeant);

		organisationFormulaire.add(new JLabel("Commentaire"));
		commentaire = new JTextField(20);
		organisationFormulaire.add(commentaire);

		btnAjout = new JButton("Ajouter");
		btnAjout.addActionListener(this);

		JPanel organisationFormulaireEtBouton = new JPanel();
		Border border = BorderFactory.createTitledBorder("Créer une organisation");
		organisationFormulaireEtBouton.setBorder(border);
		organisationFormulaireEtBouton.setLayout(new FlowLayout());
		organisationFormulaireEtBouton.add(organisationFormulaire);
		organisationFormulaireEtBouton.add(btnAjout);
		add(organisationFormulaireEtBouton,BorderLayout.CENTER);



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAjout){

			System.out.println(" Action bouton creer");
			String nomOrg = nom.getText();
			String addressOrg = siege.getText();
			String dirOrg = dirigeant.getText();
			String comOrg = commentaire.getText();

			Organisation organisation = new Organisation(nomOrg, addressOrg, dirOrg,comOrg);

			// TESTS :
			if (nomOrg.isEmpty() || addressOrg.isEmpty() || dirOrg.isEmpty() || comOrg.isEmpty()) {
				JOptionPane jopNull = new JOptionPane();
				jopNull.showMessageDialog(null, "Veuillez renseigner tous les champs ! " , "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
			}
			else{
				List<Organisation> organisations = controleur.getOrganisations();
				int count = 0;
				for(int i=0; i<organisations.size();i++) 	
					if (organisations.get(i).getNom().contains(nomOrg)) {
						count++;
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, " Cette Organisation est déjà créée", "attention", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 


				if(count<1 ) {
					controleur.creerOrganisation(organisation);
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, " Votre Organisation a bien été créée", "attention", JOptionPane.INFORMATION_MESSAGE);
					nom.setText("");
					siege.setText("");
					dirigeant.setText("");
					commentaire.setText("");
				}	
			}
		}
	}	
}

