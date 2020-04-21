package Presentation;

import Entite.Combat;
import Entite.Hero;
import Entite.Vilain;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CombatListeVue extends JPanel implements ActionListener {
    private Controleur controleur;
    private JComboBox<String> listeCbt, listehro, listevln;
    private JLabel label, labelhro, labelvln;
    private JButton btnCombat;
    private JTable tableCombat, tableSH, tableSV, tableHero, tableVilain;
    private JPanel listeCombat;

	public CombatListeVue (Controleur controleur, CombatModel combatModel, HeroModel heroModel, VilainModel vilainModel) {
            
        this.controleur = controleur;
        this.setLayout(null);

        listeCombat = new JPanel();

        Border border = BorderFactory.createTitledBorder("Liste des combats");
        listeCombat.setBorder(border);

        listeCombat.setLayout(new FlowLayout());
        listeCombat.setBounds(750, 50, 400, 100);

        //Liste des organisations
        listeCbt = new JComboBox<String>();
        label = new JLabel("Liste des combats");
        listeCbt.setPreferredSize(new Dimension(100, 20));
        listeCombat.add(label);
        listeCombat.add(listeCbt);
        for (Combat c : controleur.getCombats()) {
            listeCbt.addItem(c.getIntitule());//no
        }

            btnCombat = new JButton("Afficher un Combat");
            btnCombat.addActionListener(this);
            listeCombat.add(btnCombat);
            add(listeCombat);



            tableCombat = new JTable(combatModel);
            add(new JScrollPane(tableCombat)).setBounds(500, 200, 890, 400);
            
            JLabel icon = new JLabel(new ImageIcon("groupe.jpg"));
		    JPanel panIcon = new JPanel();
		    panIcon.add(icon);
		    add(panIcon);
		    panIcon.setBounds(50, 40, 400, 600);
		    
		    JLabel icon2 = new JLabel(new ImageIcon("thanos700.jpg"));
		    JPanel panIcon2 = new JPanel();
		    panIcon2.add(icon2);
		    add(panIcon2);
		    panIcon2.setBounds(1200, 40, 700, 700);
           
        }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCombat) {

            System.out.println(" Action bouton afficher l'organisation");
            this.removeAll();
            this.setLayout(null);

            String value = listeCbt.getSelectedItem().toString();
            
           
            add(listeCombat).setBounds(750, 50, 400, 100);
            

            List<Combat> combats = controleur.findCombatByName(value);
            int idcombat = combats.get(0).getId();
            
            List<Hero> heros = controleur.getHerosByCombat(idcombat);
            HeroModel heroModel = new HeroModel(heros);
            tableHero = new JTable(heroModel);
            add(new JScrollPane(tableHero)).setBounds(30, 230, 650, 400);
            
            
            List<Vilain> vilains = controleur.getVilainsByCombat(idcombat);
            VilainModel vilainModel = new VilainModel(vilains);
            tableVilain = new JTable(vilainModel);
            add(new JScrollPane(tableVilain)).setBounds(1220, 230, 650, 400);
            //List<Organisation> organisations = controleur.findOrganisationByName(value);

            CombatModel combatModel = new CombatModel(combats);
            //organisationModel.setOrganisations(organisations);
            tableCombat = new JTable(combatModel);
            
            add(new JScrollPane(tableCombat)).setBounds(700, 300, 500, 150);
            
            JLabel icon3 = new JLabel(new ImageIcon("logo.jpg"));
		    JPanel panIcon3 = new JPanel();
		    panIcon3.add(icon3);
		    add(panIcon3);
		    panIcon3.setBounds(750, 500, 400, 400);
            
            
            repaint();
            revalidate();
        }
    }
}
