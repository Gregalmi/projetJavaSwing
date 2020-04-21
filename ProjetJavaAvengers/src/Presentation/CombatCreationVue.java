package Presentation;

import Entite.Combat;
import Entite.Organisation;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CombatCreationVue extends JPanel implements ActionListener {

	private Controleur controleur;
	private JLabel label;
	private JTextField lieu, nom, commentaire;
	private JButton btnAjout;

	public CombatCreationVue (Controleur controleur)
	{

		this.controleur = controleur;
		setLayout(new BorderLayout());
		setVisible(true);

		//Formulaire creation organisation

		JPanel combatFormulaire = new JPanel();
		combatFormulaire.setLayout(new GridLayout(5, 2, 20,20));


		combatFormulaire.add(new JLabel("Nom"));
		nom = new JTextField(20);
		combatFormulaire.add(nom);

		combatFormulaire.add(new JLabel("Lieu du Combat"));
		lieu = new JTextField(20);
		combatFormulaire.add(lieu);

		combatFormulaire.add(new JLabel("Commentaire"));
		commentaire = new JTextField(20);
		combatFormulaire.add(commentaire);


		btnAjout = new JButton("Ajouter");
		btnAjout.addActionListener(this);

		JPanel combatFormulaireEtBouton = new JPanel();
		Border border = BorderFactory.createTitledBorder("Créer un combat");
		combatFormulaireEtBouton.setBorder(border);
		combatFormulaireEtBouton.setLayout(new FlowLayout());
		combatFormulaireEtBouton.add(combatFormulaire);
		combatFormulaireEtBouton.add(btnAjout);
		add(combatFormulaireEtBouton, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAjout){
			System.out.println(" Action bouton creer");
			String nomCbt = nom.getText();
			String lieuCbt = lieu.getText();
			String commentairecbt = commentaire.getText();

			Combat combat = new Combat(nomCbt, lieuCbt, commentairecbt);

			if (nomCbt.isEmpty() || lieuCbt.isEmpty() || commentairecbt.isEmpty()) {
				JOptionPane jopNull = new JOptionPane();
				jopNull.showMessageDialog(null, "Veuillez renseigner tous les champs ! " , "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
			}else{
				List<Combat> combats = controleur.getCombats();
				int count = 0;
				for(int i=0; i<combats.size();i++) 	
					if (combats.get(i).getIntitule().contains(nomCbt)) {
						count++;
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, " Ce combat est déjà créé", "attention", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 

				if(count<1 ) {
					controleur.creerCombat(combat);
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, " Votre combat a bien été créé", "attention", JOptionPane.INFORMATION_MESSAGE);
					nom.setText("");
					lieu.setText("");
					commentaire.setText("");
				}	           
			}
		}
	}
}





