package Presentation;

import Entite.Combat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CombatModel extends AbstractTableModel {

    private String nomColonnes[] = new String[]{"NOM","LIEU","COMMENTAIRE"};
    private List<Combat> combats;
    private Combat combat;

    public CombatModel(List<Combat> combats) {
        this.combats = combats;
        System.out.println("test");
        //System.out.println(organisations);
    }

    @Override
    public int getRowCount() {
        return combats.size();
    }

    @Override
    public int getColumnCount() {
        return nomColonnes.length;
    }

    @Override
    public String getColumnName(int index) {
        return nomColonnes[index];
    }

    @Override
    public Object getValueAt(int ligne, int colonne) {
        Combat combat = combats.get(ligne);
        Object retour=null;
        switch (colonne) {
            case 0:
                retour = combat.getIntitule(); break;
            case 1:
                retour = combat.getLieu(); break;
            case 2:
                retour = combat.getCommentaire(); break;
            default:
                break;
        }
        return retour;
    }

        public void setCombats(List<Combat> combats ) {
            this.combats = combats;
            fireTableDataChanged();
        }


    }


