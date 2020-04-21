package Donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Hero;
import Entite.Organisation;


public class HeroDAO {

	private static Connection connection;
	static Organisation organisation = new Organisation();
	
	public HeroDAO() {

		connection = MaConnection.getInstance();

	}

	public static void creerHero(Hero hero) {
		try {
			PreparedStatement prepare = HeroDAO.connection.prepareStatement(
					"INSERT INTO heros (her_nom,her_identite,her_commentaire, her_pouvoir, org_id) VALUES (?, ?, ?, ?, ?)"
					);
			prepare.setString(1, hero.getNom());
			prepare.setString(2, hero.getIdentiteSecrete());
			prepare.setString(3, hero.getCommentaire());
			prepare.setString(4, hero.getPouvoir());
			prepare.setInt(5, hero.getOrganisation() );
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Hero> getHeros() {
		List<Hero> heros = new ArrayList<>();
		Hero hero;
		ResultSet result;
		try {
			Statement st = HeroDAO.connection.createStatement();
			result = HeroDAO.connection.createStatement().executeQuery("SELECT * FROM heros");
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

	public static Hero findHeroById(int id) {
		Hero notreHero = new Hero();
		Hero hero;
		ResultSet result;
		try {
			Statement st = HeroDAO.connection.createStatement();
			result = HeroDAO.connection.createStatement().executeQuery("SELECT * FROM heros where her_id = " + id + ";");
			while (result.next()) {
				hero = new Hero();
				hero.setId(result.getInt("her_id"));
				hero.setNom(result.getString("her_nom"));
				hero.setIdentiteSecrete(result.getString("her_identite"));
				hero.setCommentaire(result.getString("her_commentaire"));
				hero.setPouvoir(result.getString("her_pouvoir"));
				notreHero = hero;
				
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notreHero;
	}
	
	public static List<Hero> findHeroByName(String name) {
		List<Hero> heros = new ArrayList<>();

		Hero hero;
		ResultSet result;
		try {
			Statement st = HeroDAO.connection.createStatement();
			result = HeroDAO.connection.createStatement()
					.executeQuery("SELECT * FROM heros where her_nom = '" + name + "';");
			if (result.first()) {
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
		//return notreOrganisation;
		return heros;
	}
}