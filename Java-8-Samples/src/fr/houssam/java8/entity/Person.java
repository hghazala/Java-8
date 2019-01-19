package fr.houssam.java8.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private List<String> activite;
}
