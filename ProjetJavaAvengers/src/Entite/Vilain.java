package Entite;

public class Vilain extends SuperGens{
	
	private String faiblesse;
	private int malveillance;
	
	public Vilain(String nom, String identiteSecrete, String commentaire, String faiblesse, int malveillance) {
		super(nom, identiteSecrete, commentaire);
		this.faiblesse = faiblesse;
		this.malveillance = malveillance;
	}
	
	public Vilain(String nom, String commentaire, String faiblesse, int malveillance) {
		super(nom, commentaire);
		this.faiblesse = faiblesse;
		this.malveillance = malveillance;
	}
	
	
	public String getFaiblesse() {
		return faiblesse;
	}

	public void setFaiblesse(String faiblesse) {
		this.faiblesse = faiblesse;
	}

	public int getMalveillance() {
		return malveillance;
	}

	public void setMalveillance(int malveillance) {
		this.malveillance = malveillance;
	}

	@Override
	public String toString() {
		return "Vilain [faiblesse=" + faiblesse + ", malveillance=" + malveillance + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}
