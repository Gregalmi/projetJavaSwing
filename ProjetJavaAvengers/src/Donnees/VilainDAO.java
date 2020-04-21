package Donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Hero;
import Entite.Vilain;

public class VilainDAO {

	private static Connection connection;
	//static Organisation organisation = new Organisation();
	public VilainDAO() {
		connection = MaConnection.getInstance();
	}

	public static void creerVilain(Vilain vilain) {
		try {
			PreparedStatement prepare = VilainDAO.connection.prepareStatement(
                      	"INSERT INTO vilains (vil_nom, vil_commentaire, vil_faiblesse, vil_malveillance) VALUES (?, ?, ?, ?)"
                      );
			prepare.setString(1, vilain.getNom());
			prepare.setString(2, vilain.getCommentaire());
			prepare.setString(3, vilain.getFaiblesse());
			prepare.setString(4, vilain.getMalveillance() );
			prepare.executeUpdate();
			prepare.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public static List<Vilain> getVilains() {
		List<Vilain> vilains = new ArrayList<>();
		Vilain vilain;
		ResultSet result;
		try {
			Statement st = VilainDAO.connection.createStatement();
			result = VilainDAO.connection.createStatement().executeQuery("SELECT * FROM vilains");
			while (result.next()) {
				vilain = new Vilain();
				vilain.setId(result.getInt("vil_id"));
				vilain.setNom(result.getString("vil_nom"));
				vilain.setIdentiteSecrete(result.getString("vil_identite"));
				vilain.setFaiblesse(result.getString("vil_faiblesse"));
				vilain.setCommentaire(result.getString("vil_commentaire"));
				vilain.setMalveillance(result.getString("vil_malveillance"));
				vilains.add(vilain);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vilains;
		}
		
		public static Vilain findVilainById(int id) {
			//List<Hero> heros = new ArrayList<>();
			Vilain notreVilain = new Vilain();
			Vilain vilain;
			ResultSet result;
			try {
				Statement st = VilainDAO.connection.createStatement();
				result = VilainDAO.connection.createStatement().executeQuery("SELECT * FROM vilains where vil_id = " + id);
				if (result.first()) {
					vilain = new Vilain();
				    vilain.setId(result.getInt("vil_id"));
					vilain.setNom(result.getString("vil_nom"));
					vilain.setIdentiteSecrete(result.getString("vil_identite"));
					vilain.setCommentaire(result.getString("vil_commentaire"));
					vilain.setFaiblesse(result.getString("vil_faiblesse"));
					vilain.setMalveillance(result.getString("vil_malveillance"));
					notreVilain = vilain;
				}
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return notreVilain;
		}
		
		public static List<Vilain> findVilainByName(String name) {
			List<Vilain> vilains = new ArrayList<>();
			//List<Hero> heros = new ArrayList<>();
			//Organisation notreOrganisation = new Organisation();
			Vilain vilain;
			ResultSet result;
			try {
				Statement st = VilainDAO.connection.createStatement();
				result = VilainDAO.connection.createStatement()
						.executeQuery("SELECT * FROM vilains where vil_nom = '" + name + "';");
				if (result.first()) {
					vilain = new Vilain();
					vilain.setId(result.getInt("vil_id"));					vilain.setNom(result.getString("vil_nom"));
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
			//return notreOrganisation;
			return vilains;
		}
		
		
}
