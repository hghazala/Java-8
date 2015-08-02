package fr.houssam.java8.entity;

import java.util.List;

public class Person {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private List<String> activite;
	
	public Person(int id, String nom, String prenom, int age, List<String> activite){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.activite = activite;
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
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getActivite() {
		return activite;
	}
	public void setActivite(List<String> activite) {
		this.activite = activite;
	}
	
	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getId());
		stringBuilder.append("-"+this.getNom());
		stringBuilder.append("-"+this.getPrenom());
		stringBuilder.append("-"+this.getActivite());
		
		return stringBuilder.toString();
	}
}
