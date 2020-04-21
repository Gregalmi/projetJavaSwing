package Entite;

import java.util.ArrayList;

public class Combat {
	private int id;
	private String intitule;
	private String lieu;
	private String commentaire;

	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	private ArrayList<Hero> heros;
	private ArrayList<Vilain> vilains;

	public Combat() {
	}

	public Combat(String intitule, String lieu, String commentaire) {
		super();
		this.intitule = intitule;
		this.lieu = lieu;
		this.commentaire = commentaire;

	}
	public Combat(String intitule) {
		this.intitule = intitule;
		heros = new ArrayList<>();
		vilains = new ArrayList<>();
	}
	public String getIntitule() {
		return intitule;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public void ajouterHeros(Hero hero) {
		heros.add(hero);
	}
	public ArrayList<Hero> getHeros() {	
		return heros;
	}
	public void setHeros(ArrayList<Hero> heros) {
		this.heros = heros;
	}
	public void ajouterVilains(Vilain vilain) {
		vilains.add(vilain);
	}
	public ArrayList<Vilain> getVilains() {
		return vilains;
	}
	public void setVilains(ArrayList<Vilain> vilains) {
		this.vilains = vilains;
	}
	@Override
	public String toString() {
		return "Combat [id=" + id + ", intitule=" + intitule + ", heros=" + heros + ", vilains=" + vilains + ", getHeros()="
				+ getHeros() + ", getVilains()=" + getVilains() + "]";
	}
}
