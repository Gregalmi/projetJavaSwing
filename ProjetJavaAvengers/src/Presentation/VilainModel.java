package Presentation;

import Entite.Organisation;
import Entite.Vilain;
import javax.swing.table.AbstractTableModel;
import java.util.List;
public class VilainModel extends AbstractTableModel {
    private String nomColonnes[] = new String[]{"NOM","IDENTITE","FAIBLESSE", "COMMENTAIRE","MALVEILLANCE"};
    private List<Vilain> vilains;
    private Vilain vilain;
    public VilainModel(List<Vilain> vilains) {
        this.vilains = vilains;
        System.out.println("test");
        System.out.println(vilains);
    }

    @Override
    public int getRowCount() {
        return vilains.size();
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
        Vilain vilain = vilains.get(ligne);
        Object retour=null;
        switch (colonne) {
            case 0:
                retour = vilain.getNom(); break;
            case 1:
                retour = vilain.getIdentiteSecrete(); break;
            case 2:
                retour = vilain.getFaiblesse(); break;
            case 3:
                retour = vilain.getCommentaire(); break;
            case 4:
                retour = vilain.getMalveillance(); break;
            default:
                break;
        }
        return retour;
    }
    public void setVilains(List<Vilain> vilains) {
        this.vilains = vilains;
        fireTableDataChanged();
    }
}