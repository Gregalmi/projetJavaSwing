package Entite;

public abstract class SuperGens {
	
	private int id;
	private String nom;
	private String identiteSecrete;
	private String commentaire;
	
	public SuperGens() {};
	
	public SuperGens(String nom, String commentaire) {
		this.nom = nom;
		this.commentaire = commentaire;
	}
	
	public SuperGens(String nom, String identiteSecrete, String commentaire) {
		this.nom = nom;
		this.identiteSecrete = identiteSecrete;
		this.commentaire = commentaire;
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

	public String getIdentiteSecrete() {
		return identiteSecrete;
	}

	public void setIdentiteSecrete(String identiteSecrete) {
		this.identiteSecrete = identiteSecrete;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "SuperGens [id=" + id + ", nom=" + nom + ", identiteSecrete=" + identiteSecrete + ", commentaire="
				+ commentaire + "]";
	}
	
	
	
	

}
