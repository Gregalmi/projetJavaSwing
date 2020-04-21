package Presentation;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import Donnees.OrganisationDAO;
import Entite.Hero;
import Entite.Organisation;
import Metier.FacadeMetier;

public class HeroModel extends AbstractTableModel{
	private String nomColonnes[] = new String[]{"NOM","IDENTITE SECRETE","COMMENTAIRE","POUVOIR","ORGANISATION"};
	private List<Hero> heros;
	private Hero hero;
	//private HeroListeVue heroListeVue;
	
	
	public HeroModel(List<Hero>heros) {
		this.heros = heros;
		//controleur = new Controleur(new FacadeMetier());
		System.out.println("test");
		System.out.println(heros);
	}

	@Override
	public int getRowCount() {
		return heros.size();
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
		Hero hero = heros.get(ligne);

		
		Object retour=null;
		switch (colonne) {
		case 0:
			retour = hero.getNom(); break;
		case 1:
			retour = hero.getIdentiteSecrete(); break;
		case 2:
			retour = hero.getCommentaire(); break;
		case 3:
			retour = hero.getPouvoir(); break;
		case 4:
			int idorga = hero.getOrganisation();
			String nomorga = OrganisationDAO.findOrganisationById(idorga).getNom();
			retour = nomorga; break;
			//retour = hero.getOrganisation(); break;
		default:
			break;
		}
		return retour;
	}
	
	public void setHeros(List<Hero> heros) {
		this.heros = heros;
		fireTableDataChanged();
	}
	
}
