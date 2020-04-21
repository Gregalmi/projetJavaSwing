package Entite;

public class Hero extends SuperGens {
	
	private String pouvoir;
	private String organisation;
	

	public Hero(String nom, String identiteSecrete, String commentaire, String pouvoir, String organisation) {
		super(nom, identiteSecrete, commentaire);
		this.pouvoir = pouvoir;
		this.organisation = organisation;
	}

	public String getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(String pouvoir) {
		this.pouvoir = pouvoir;
	}

	@Override
	public String toString() {
		return "Hero [pouvoir=" + pouvoir + ", toString()=" + super.toString() + "]";
	}
	
	
}
