package Entite;
import java.util.Date;

public class Organisation {
	
	private int id;
	private String nom;
	private String adresse;
	private String dirigeant;
	private String commentaire;
	private Date dateAjout;
	
	public Organisation(int id, String nom, String adresse, String dirigeant, String commentaire, Date dateAjout) {

		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.dirigeant = dirigeant;
		this.commentaire = commentaire;
		this.dateAjout = dateAjout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDirigeant() {
		return dirigeant;
	}

	public void setDirigeant(String dirigeant) {
		this.dirigeant = dirigeant;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", dirigeant=" + dirigeant
				+ ", commentaire=" + commentaire + ", dateAjout=" + dateAjout + "]";
	}
	
	

}
