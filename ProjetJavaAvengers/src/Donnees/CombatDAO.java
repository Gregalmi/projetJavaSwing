package Donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entite.Combat;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public class CombatDAO {
	private static Connection connection;
	static Organisation organisation = new Organisation();
	public CombatDAO() {
		connection = MaConnection.getInstance();
	}
	public static void creerCombat(Combat combat) {
		try {
			PreparedStatement prepare = CombatDAO.connection.prepareStatement(
					"INSERT INTO `groupedecombat`(`cbt_intitule`,`cbt_lieu`,`cbt_commentaire`) " +
					"VALUES ( ? , ? , ? )" + ";");
			//prepare.setInt(1, combat.getId());
			prepare.setString(1, combat.getIntitule());
			prepare.setString(2, combat.getLieu());
			prepare.setString(3, combat.getCommentaire());
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Combat> findCombatByName(String name) {
		List<Combat> combats = new ArrayList<>();
		
		Combat combat;
		ResultSet result;
		try {
			Statement st = CombatDAO.connection.createStatement();
			result = CombatDAO.connection.createStatement()
					.executeQuery("SELECT * FROM groupedecombat where cbt_intitule = '" + name + "';");
			if (result.first()) {
				combat = new Combat();
				combat.setId(result.getInt("cbt_id"));
				combat.setIntitule(result.getString("cbt_intitule"));
				combat.setLieu(result.getString("cbt_lieu"));
				combat.setCommentaire(result.getString("cbt_commentaire"));
				//notreOrganisation = organisation;
				combats.add(combat);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return combats;
	}
	
	public static List<Combat> getCombats() {
	List<Combat> combats = new ArrayList<>();
	Combat combat;
	ResultSet result;
	try {
		Statement st = CombatDAO.connection.createStatement();
		result = CombatDAO.connection.createStatement().executeQuery("SELECT * FROM groupedecombat");
		while (result.next()) {
			combat = new Combat();
			combat.setId(result.getInt("cbt_id"));
			combat.setIntitule(result.getString("cbt_intitule"));
			combat.setLieu(result.getString("cbt_lieu"));
			combat.setCommentaire(result.getString("cbt_commentaire"));
			//combat.setDateCombat(result.getDate("cbt_date"));
			combats.add(combat);
		}
		st.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return combats;
}
	public static void participantHero(int i, int j) {
		try {
			PreparedStatement prepare = CombatDAO.connection.prepareStatement(
					"INSERT INTO `her_participe`(`her_par_id`, `cbt_id`) " +
					" SELECT heros.her_id, groupedecombat.cbt_id" +
					" FROM heros, groupedecombat" +
					" WHERE heros.her_id = ? AND groupedecombat.cbt_id = ?" + ";");
			prepare.setInt(1, i);
			prepare.setInt(2, j);
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, "Votre SuperHeros est déjà dans le combat", "Ajout Héros", JOptionPane.INFORMATION_MESSAGE);;
		}
	}
	public static List<Hero> getHerosByCombat(int id) {
		List<Hero> heros = new ArrayList<>();
		Hero hero;
		ResultSet result;
		try {
			Statement st = CombatDAO.connection.createStatement();
			result = CombatDAO.connection.createStatement()
					.executeQuery("SELECT heros.her_nom,heros.her_identite, heros.her_commentaire, heros.her_pouvoir, heros.her_id, heros.org_id" + 
					" FROM heros LEFT JOIN her_participe ON heros.her_id = her_participe.her_par_id" + 
					" INNER JOIN groupedecombat ON groupedecombat.cbt_id = her_participe.cbt_id" + 
					" AND groupedecombat.cbt_id = " + id + ";");
			while (result.next()) {
				hero = new Hero();
				hero.setId(result.getInt("her_id"));
				hero.setNom(result.getString("her_nom"));
				hero.setIdentiteSecrete(result.getString("her_identite"));
				hero.setCommentaire(result.getString("her_commentaire"));
				hero.setPouvoir(result.getString("her_pouvoir"));
				hero.setOrganisation(result.getInt("org_id"));
				heros.add(hero);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
	}
	public static void participantVilain(int i, int j) {
		try {
			PreparedStatement prepare = CombatDAO.connection.prepareStatement(
					"INSERT INTO `vil_participe`(`vil_par_id`, `cbt_id`) " +
					" SELECT vilains.vil_id, groupedecombat.cbt_id" +
					" FROM vilains, groupedecombat" +
					" WHERE vilains.vil_id = ? AND groupedecombat.cbt_id = ?" + ";");
			prepare.setInt(1, i);
			prepare.setInt(2, j);
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Votre SuperVilain est déjà dans le combat", "Ajout Vilains", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static List<Vilain> getVilainsByCombat(int id) {
		List<Vilain> vilains = new ArrayList<>();
		Vilain vilain;
		ResultSet result;
		try {
			Statement st = CombatDAO.connection.createStatement();
			result = CombatDAO.connection.createStatement()
					.executeQuery("SELECT vilains.vil_nom,vilains.vil_identite, vilains.vil_commentaire, vilains.vil_faiblesse, vilains.vil_id, vilains.vil_malveillance" + 
					" FROM vilains LEFT JOIN vil_participe ON vilains.vil_id = vil_participe.vil_par_id" + 
					" INNER JOIN groupedecombat ON groupedecombat.cbt_id = vil_participe.cbt_id" + 
					" AND groupedecombat.cbt_id = " + id + ";");
			while (result.next()) {
				vilain = new Vilain();
				vilain.setId(result.getInt("vil_id"));
				vilain.setNom(result.getString("vil_nom"));
				vilain.setIdentiteSecrete(result.getString("vil_identite"));
				vilain.setCommentaire(result.getString("vil_commentaire"));
				vilain.setFaiblesse(result.getString("vil_faiblesse"));
				vilain.setMalveillance(result.getString("vil_malveillance"));
				vilains.add(vilain);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vilains;
	}
	/*
	 * public static List<Hero> getHeros() { List<Hero> heros = new ArrayList<>();
	 * Hero hero; ResultSet result; try { Statement st =
	 * CombatDAO.connection.createStatement(); result =
	 * CombatDAO.connection.createStatement().executeQuery("SELECT * FROM heros");
	 * while (result.next()) { hero = new Hero();
	 * hero.setId(result.getInt("her_id"));
	 * hero.setNom(result.getString("her_nom"));
	 * hero.setIdentiteSecrete(result.getString("her_identite"));
	 * hero.setCommentaire(result.getString("her_commentaire"));
	 * hero.setPouvoir(result.getString("her_pouvoir")); heros.add(hero); }
	 * st.close(); } catch (SQLException e) { e.printStackTrace(); } return heros;
	 * 
	 * }
	 */
		/*public static List<Hero> findHeroById(int id) {
			List<Hero> heros = new ArrayList<>();
			Hero hero;
			ResultSet result;
			try {
				Statement st = CombatDAO.connection.createStatement();
				result = CombatDAO.connection.createStatement().executeQuery("SELECT * FROM heros where her_id = " + id);
				if (result.first()) {
					hero = new Hero();
					//hero.setId(result.getInt("her_id"));
					hero.setNom(result.getString("her_nom"));
					hero.setIdentiteSecrete(result.getString("her_identite"));
					hero.setCommentaire(result.getString("her_commentaire"));
					hero.setPouvoir(result.getString("her_pouvoir"));
					heros.add(hero);
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return heros;
		}*/
}


