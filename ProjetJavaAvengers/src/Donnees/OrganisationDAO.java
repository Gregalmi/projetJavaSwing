package Donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import Entite.Hero;
import Entite.Organisation;
import Entite.Vilain;

public class OrganisationDAO {
	
	private static Connection connection;

	public OrganisationDAO() {
		
		connection = MaConnection.getInstance();
		
	}
	
	public static void creerOrganisation(Organisation organisation) {
		try {
			
			PreparedStatement prepare = OrganisationDAO.connection.prepareStatement(
                      	"INSERT INTO organisation (org_nom, org_adresse, org_dirigeant,org_commentaires, org_date) VALUES (?, ?, ?, ?, NOW())"
                      );
			prepare.setString(1, organisation.getNom());
			prepare.setString(2, organisation.getAdresse());
			prepare.setString(3, organisation.getDirigeant());
			prepare.setString(4, organisation.getCommentaire());
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		public static List<Organisation> getOrganisations() {
		List<Organisation> organisations = new ArrayList<>();
		Organisation organisation;
		ResultSet result;
		try {
			Statement st = OrganisationDAO.connection.createStatement();
			result = OrganisationDAO.connection.createStatement().executeQuery("SELECT * FROM organisation");
			while (result.next()) {
				organisation = new Organisation();
				organisation.setId(result.getInt("org_id"));
				organisation.setNom(result.getString("org_nom"));
				organisation.setAdresse(result.getString("org_adresse"));
				organisation.setDirigeant(result.getString("org_dirigeant"));
				organisation.setCommentaire(result.getString("org_commentaires"));
				organisation.setDateAjout(result.getDate("org_date"));
				organisations.add(organisation);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organisations;
	}
		
		public static List<Organisation> findOrganisationByName(String name) {
			List<Organisation> organisations = new ArrayList<>();
			
			Organisation organisation;
			ResultSet result;
			try {
				Statement st = OrganisationDAO.connection.createStatement();
				result = OrganisationDAO.connection.createStatement()
						.executeQuery("SELECT * FROM organisation where org_nom = '" + name + "';");
				if (result.first()) {
					organisation = new Organisation();
					organisation.setId(result.getInt("org_id"));
					organisation.setNom(result.getString("org_nom"));
					organisation.setAdresse(result.getString("org_adresse"));
					organisation.setDirigeant(result.getString("org_dirigeant"));
				
					organisation.setCommentaire(result.getString("org_commentaires"));
					organisation.setDateAjout(result.getDate("org_date"));
					
					organisations.add(organisation);
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return organisations;
		}
		
		public static Organisation findOrganisationById(int id) {
			Organisation notreOrganisation = new Organisation();
			Organisation organisation;
			ResultSet result;
			try {
				Statement st = OrganisationDAO.connection.createStatement();
				result = OrganisationDAO.connection.createStatement().executeQuery("SELECT * FROM organisation where org_id = " + id + ";");
				while (result.next()) {
					organisation = new Organisation();
					organisation.setId(result.getInt("org_id"));
					organisation.setNom(result.getString("org_nom"));
					organisation.setAdresse(result.getString("org_adresse"));
					organisation.setDirigeant(result.getString("org_dirigeant"));

					organisation.setCommentaire(result.getString("org_commentaires"));
					organisation.setDateAjout(result.getDate("org_date"));
					notreOrganisation = organisation;
					
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return notreOrganisation;
		}
		
		public static List<Hero> getHerosInOrganisation(int id) {
			List<Hero> heros = new ArrayList<>();
			Organisation organisation;
			Hero hero;
			ResultSet result;
			try {
				Statement st = OrganisationDAO.connection.createStatement();
				result = OrganisationDAO.connection.createStatement()
						.executeQuery("SELECT her_id, her_nom, her_pouvoir, her_identite, her_commentaire, organisation.org_id, organisation.org_nom FROM heros, organisation WHERE heros.org_id = organisation.org_id  AND organisation.org_id =  "+ id +";");
				while (result.next()) {
					//organisation = new Organisation();
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

}
