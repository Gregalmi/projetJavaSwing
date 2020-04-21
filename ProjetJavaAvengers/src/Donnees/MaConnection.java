package Donnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnection {
	private static String url = "jdbc:mysql://localhost/projetjavaavengers1";
	private static String user = "root";
	private static String passwd = "";
	private static Connection connect;
	public static Connection getInstance(){
		if(connect == null){
			try {
			      // Etape 1 - chargement du driver
			      Class.forName("com.mysql.jdbc.Driver"); /* va chercher le pilote adéquat */
			      // Etape 2 - récupérer la connexion 
			      connect = DriverManager.getConnection(url,user, passwd);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Connexion Impossible" + e.getMessage());
			}
		}       
		return connect; 
	}
}
