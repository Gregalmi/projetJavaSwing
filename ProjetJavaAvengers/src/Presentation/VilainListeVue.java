package Presentation;

import Entite.Organisation;
import Entite.Vilain;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import Donnees.OrganisationDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class VilainListeVue extends JPanel implements ActionListener {
	private Controleur controleur;
	private JComboBox<String> comboVilain;
	private JLabel label;
	private JButton btnListeVilain;
	private JTable tableVilains;
	private VilainModel vilainModel;
	private JPanel listeAllVilains, panIcon, panIcon2  ;

	public VilainListeVue (Controleur controleur, VilainModel vilainModel) {
		this.controleur = controleur;

		//setLayout(new BorderLayout());

		this.setLayout(null);

		listeAllVilains = new JPanel();
		listeAllVilains.setBounds(750, 50, 400, 100);
		Border border = BorderFactory.createTitledBorder("Liste des vilains");
		listeAllVilains.setBorder(border);
		listeAllVilains.setLayout(new FlowLayout());

		//Liste des organisations
		comboVilain = new JComboBox<String>();
		label = new JLabel("Liste des organisations");
		comboVilain.setPreferredSize(new Dimension(100,20));
		listeAllVilains.add(label);
		listeAllVilains.add(comboVilain);
		for (Vilain v : controleur.getVilains()) {
			comboVilain.addItem(v.getNom());//non
		}

		btnListeVilain = new JButton("Afficher un vilain");
		btnListeVilain.addActionListener(this);
		listeAllVilains.add(btnListeVilain);
		add(listeAllVilains);

		tableVilains = new JTable(vilainModel);
		add(new JScrollPane(tableVilains)).setBounds(500, 200, 890, 400);
		
		JLabel icon = new JLabel(new ImageIcon("locky.jpg"));
	    panIcon = new JPanel();
	    panIcon.add(icon);
	    add(panIcon);
	    panIcon.setBounds(20, 350, 450, 450);
	    
		JLabel icon2 = new JLabel(new ImageIcon("mechantblack.jpg"));
	    panIcon2 = new JPanel();
	    panIcon2.add(icon2);
	    add(panIcon2);
	    panIcon2.setBounds(1400, 100, 450, 450);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListeVilain){
			System.out.println(" Action bouton afficher l'organisation");
			String value = comboVilain.getSelectedItem().toString();
			//JScrollPane js = new JScrollPane();
			this.removeAll();
			this.setLayout(null);

			List<Vilain> vilains = controleur.findVilainByName(value);
			VilainModel vilainModel = new VilainModel(vilains);

			tableVilains = new JTable(vilainModel);

			add(listeAllVilains);
			add(panIcon);
			add(panIcon2);
			
			add(new JScrollPane(tableVilains)).setBounds(500, 200, 890, 400);
			repaint();
			revalidate();

			System.out.println(controleur.findOrganisationByName(value));
			System.out.println("S�lection : " + value);

		}
	}
}
