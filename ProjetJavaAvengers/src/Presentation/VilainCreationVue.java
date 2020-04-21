package Presentation;

import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class VilainCreationVue extends JPanel implements ActionListener {
	private Controleur controleur;
	private JLabel label;
	private JTextField nom, faiblesse, identite, commentaire, malveillance ;
	private JButton btnAjout;
	public VilainCreationVue (Controleur controleur) {
		this.controleur = controleur;
		setLayout(new BorderLayout());
		setVisible(true);
		//Formulaire creation organisation
		JPanel vilainFormulaire = new JPanel();
		vilainFormulaire.setLayout(new GridLayout(5, 2, 20,20));
		vilainFormulaire.add(new JLabel("Nom"));
		nom = new JTextField(20);
		vilainFormulaire.add(nom);
		vilainFormulaire.add(new JLabel("Identite"));
		identite = new JTextField(20);
		vilainFormulaire.add(identite);
		vilainFormulaire.add(new JLabel("Faiblesse"));
		faiblesse = new JTextField(20);
		vilainFormulaire.add(faiblesse);
		vilainFormulaire.add(new JLabel("Commentaire"));
		commentaire = new JTextField(20);
		vilainFormulaire.add(commentaire);
		vilainFormulaire.add(new JLabel("Malveillance"));
		malveillance = new JTextField(20);
		vilainFormulaire.add(malveillance);
		add(vilainFormulaire);
		btnAjout = new JButton("Ajouter");
		btnAjout.addActionListener(this);
		JPanel vilainFormulaireEtBouton = new JPanel();
		Border border = BorderFactory.createTitledBorder("Créer un SuperVilain");
		vilainFormulaireEtBouton.setBorder(border);
		vilainFormulaireEtBouton.setLayout(new FlowLayout());
		vilainFormulaireEtBouton.add(vilainFormulaire);
		vilainFormulaireEtBouton.add(btnAjout);
		add(vilainFormulaireEtBouton,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAjout){
			System.out.println(" Action bouton creer");
			String nomVil = nom.getText();
			String identiteVil = identite.getText();
			String faiblesseVil = faiblesse.getText();
			String malveillanceVil = malveillance.getText();
			String commentaireVil = commentaire.getText();
			Vilain vilain = new Vilain(nomVil, identiteVil,commentaireVil, faiblesseVil, malveillanceVil);

			if (nomVil.isEmpty() || faiblesseVil.isEmpty() || malveillanceVil.isEmpty() ||  commentaireVil.isEmpty() ) {
				JOptionPane jopNull = new JOptionPane();
				jopNull.showMessageDialog(null, "Veuillez renseigner tous les champs sauf l'identité si vous ne voulez pas vous dévoiler  ! " , "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
			}
			else{
				List<Vilain> vilains = controleur.getVilains();
				int count = 0;
				for(int i=0; i<vilains.size();i++) 	
					if (vilains.get(i).getNom().contains(nomVil)) {
						count++;
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, " Ce Vilain est déjà créé", "attention", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 

				if(count<1 ) {
					controleur.creerVilain(vilain);
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, " Votre Vilain a bien été créé", "attention", JOptionPane.INFORMATION_MESSAGE);
					nom.setText("");
					commentaire.setText("");
					faiblesse.setText("");
					identite.setText("");
					malveillance.setText("");
				}	  
			}
		}
	}
}
