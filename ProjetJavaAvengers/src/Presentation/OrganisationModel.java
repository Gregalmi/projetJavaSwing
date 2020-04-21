package Presentation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entite.Organisation;





public class OrganisationModel extends AbstractTableModel{
	private String nomColonnes[] = new String[]{"NOM","SIEGE","DIRIGEANT","COMMENTAIRE","DATE"}; 
	private List<Organisation> organisations;
	private Organisation organisation;
	
	public OrganisationModel(List<Organisation>organisations) {
		this.organisations = organisations;
		System.out.println("test");
		System.out.println(organisations);
	}
	
	@Override
	public int getRowCount() {
		return organisations.size();
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
		Organisation organisation = organisations.get(ligne); 
		Object retour=null;
		switch (colonne) { 
		case 0:
			retour = organisation.getNom(); break;
		case 1:
			retour = organisation.getAdresse(); break;
		case 2:
			retour = organisation.getDirigeant(); break;
		case 3:
			retour = organisation.getCommentaire(); break;
		case 4:
			retour = organisation.getDateAjout(); break;
		default:
			break;
		}
		return retour;
	}
	

	public void setOrganisations(List<Organisation> organisations) {
		this.organisations = organisations;
		fireTableDataChanged();
	}
	
	
}

