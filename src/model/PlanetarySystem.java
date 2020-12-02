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

	// ATTRIBUTES OF THE CLASS PLANETARY SYSTEM
	
	private String name;
	
	private LocalDate discoveryDate;
	
	private String coordinates;
	
	private int id;
	
	// CIVILIZATIONS HAVE TWO ATTRIBUTES: STRING (NAME) AND INTEGER THE TYPE OF GALAXY

	private ArrayList<Pair<String,Integer>> civilizations; 

	private ArrayList<String> planets;
	
	private ArrayList<String> stars;
	
	//------------------------------------------------------------------------------------
	
	// CONSTRUCTOR METHOD OF THE CLASS PLANETARY SYSTEM

	public PlanetarySystem(String name, int id, LocalDate discoveryDate, String coordinates) {
		
		this.name = name;
		
		this.id = id;
		
		this.discoveryDate = discoveryDate;
		
		this.coordinates = coordinates;
		
		civilizations = new ArrayList<Pair<String,Integer>>();
		
		planets = new ArrayList<String>();
		
		stars = new ArrayList<String>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// GET'S METHOD OF THE CLASS PLANETARY SYSTEM

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
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
	
	// SET'S METHOD OF THE CLASS PLANETARY SYSTEM
	
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

	public void setId(int id) {
		this.id = id;
	}
		
	//------------------------------------------------------------------------------------
	
	// ADD METHOD IN THE ARRAYLIST OF CIVILIZATIONS
	
	public void addCivilization(String name, Integer number) {
		
		Pair<String, Integer> pair = new Pair<String, Integer>(name, number);
		
		civilizations.add(pair);
		
	}
	
	//------------------------------------------------------------------------------------
	
	// ADD METHOD IN THE ARRAYLIST OF PLANETS
	
	public void addplanet (String name) {
		
		planets.add(name);
		
	}
	
	//------------------------------------------------------------------------------------
	
	// ADD METHOD IN THE ARRAYLIST OF STARTS
	
	public void addStart(String name) {
		
		stars.add(name);
		
	}
	
	//------------------------------------------------------------------------------------
	
}
