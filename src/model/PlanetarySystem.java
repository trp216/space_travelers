/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package model;

import java.time.LocalDate;
import java.util.ArrayList;

import utilities.Pair;

public class PlanetarySystem {
	
	//------------------------------------------------------------------------------------

	// Attributes of the PlanetarySystem class
	
	private String name;
	
	private LocalDate discoveryDate;
	
	private String coordinates;

	private ArrayList<Pair<String,Integer>> civilizations; //where the integer is its type and the string is its name

	private ArrayList<String> planets;
	
	private ArrayList<String> stars;
	
	//------------------------------------------------------------------------------------
	
	//Constructor of class PlanetarySystem

	public PlanetarySystem(String name, LocalDate discoveryDate, String coordinates) {
		this.name = name;
		this.discoveryDate = discoveryDate;
		this.coordinates = coordinates;
		
		civilizations = new ArrayList<Pair<String,Integer>>();
		planets = new ArrayList<String>();
		stars = new ArrayList<String>();
	}
	
	//------------------------------------------------------------------------------------
	
	//Getters of class PlanetarySystem

	public String getName() {
		return name;
	}
	
	public LocalDate getDiscoveryDate() {
		return discoveryDate;
	}

	public String getCoordinates() {
		return coordinates;
	}
	
	public ArrayList<Pair<String, Integer>> getCivilizations() {
		return civilizations;
	}
	
	public ArrayList<String> getPlanets() {
		return planets;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getStars() {
		return stars;
	}
	
	//------------------------------------------------------------------------------------
	
	//Setters of class PlanetarySystem
	
	public void setDiscoveryDate(LocalDate discoveryDate) {
		this.discoveryDate = discoveryDate;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public void setCivilizations(ArrayList<Pair<String, Integer>> civilizations) {
		this.civilizations = civilizations;
	}

	public void setPlanets(ArrayList<String> planets) {
		this.planets = planets;
	}

	public void setStars(ArrayList<String> stars) {
		this.stars = stars;
	}
		
	//------------------------------------------------------------------------------------
	
	

}
