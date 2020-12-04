/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.SplittableRandom;

import javax.naming.directory.InvalidAttributesException;

import collections.AdjacencyListGraph;
import collections.Graph;
import collections.GraphAlgorithms;
import collections.MatrixGraph;
import utilities.Pair;

public class NavigationSystem {

	//------------------------------------------------------------------------------------

	// ATTRIBUTES AND RELATIONS OF THE CLASS NAVEGATION SYSTEM

	private String name;

	private PlanetarySystem currentSystem;

	private Graph systems;

	//------------------------------------------------------------------------------------

	// CONSTRUCTOR METHOD OF THE CLASS NAVEGATION SYSTEM

	public NavigationSystem(String name) {

		this.name = name;

	}

	//------------------------------------------------------------------------------------

	// GENERATE SYSTEMS

	public void generateSystems(int n) throws InvalidAttributesException, IllegalArgumentException {

		Hashtable<Integer,Boolean> c = new Hashtable<Integer,Boolean>(); //saves the coordinates to check later that they won't repeat

		Hashtable<Integer,PlanetarySystem> ids = new Hashtable<Integer,PlanetarySystem>(); //saves the ids

		for(int i = 65 ; i <= 90 && n > 0 ; i ++) { //Generates the letter of the name

			char x = (char) i;

			for(int j = 1 ; j <= 1000 && n > 0 ; j++) { //Adds the number to the letter generated before

				String sname = x + "" + j + "";

				int coordinate = (int)Math.random()*Integer.MAX_VALUE;

				while(c.contains(coordinate)) { //checks if the coordinate already exists

					coordinate = (int)Math.random()*Integer.MAX_VALUE;

				}

				c.put(coordinate, true);

				int id = (int) Math.random() * 27001;

				while(ids.contains(id)) { // checks if the id is repeated

					id = (int) Math.random() * 27001;

				}

				PlanetarySystem nps = new PlanetarySystem(sname, (int) id, generateDiscoveryDate(), (coordinate + ""));

				systems.addVertex(nps, id);

				ids.put(id, nps); // Saves the id. Also saves the object, just in case that we would like to use that hashtable later

				n -- ;

			}

		}

		generateWeights(ids); //generates

	}

	//------------------------------------------------------------------------------------

	public LocalDate generateDiscoveryDate() {

		SplittableRandom sr = new SplittableRandom();

		double random = sr.nextDouble();

		int minAge = - 1;

		int maxAge = 0;

		int age = (int) Math.round(sr.nextDouble()*(maxAge - minAge + 1) + minAge);

		LocalDate now = LocalDate.now();

		LocalDate discDate = now.minusYears(age);

		if(discDate.isLeapYear()) {

			discDate.minusDays((long)random);

		} else {

			discDate.minusDays((long)random);

		}

		return discDate;
		
	}

	//------------------------------------------------------------------------------------

	// GENERATE WEIGHTS

	public void generateWeights(Hashtable<Integer, PlanetarySystem> ht) throws InvalidAttributesException, IllegalArgumentException {

		Random random = new Random();

		int n = ht.size();

		while(n<0) {

			int weight = (int) Math.random() * 100001;

			int s1 = random.nextInt(ht.size());

			int s2 = random.nextInt(ht.size());

			if(s1!= s2 && systems.getAdjacentVertices(s1)!= null && systems.getAdjacentVertices(s1).get(s2) != null) {

				systems.addEdge(s1, s2, weight);
				
				n--;

			} else {

				s1 = random.nextInt(ht.size());

				s2 = random.nextInt(ht.size());

			}
			
		}

	}

	//------------------------------------------------------------------------------------

	// GRAPH SELECTED METHOD

	public void graphSelected(boolean adj) {

		if(adj == true) {

			systems = new AdjacencyListGraph<PlanetarySystem>(false, true);

		} else {

			systems = new MatrixGraph<PlanetarySystem>(false, true);

		}

	}

	//------------------------------------------------------------------------------------

	// METHOD PLANETARY SYSTEM SEARCH

	@SuppressWarnings("unchecked")
	public PlanetarySystem search(int id) {

		currentSystem = (PlanetarySystem) GraphAlgorithms.DFS(systems, id);

		return currentSystem;

	}

	//------------------------------------------------------------------------------------

	// METHOD CALCULATE DISTANCE

	@SuppressWarnings("unchecked")
	public int calculateDistance(int idPS1, int idPS2) {

		return GraphAlgorithms.dijkstra(systems, search(idPS1).getId(), search(idPS2).getId());

	}

	//------------------------------------------------------------------------------------

	// METHOD ADD PLANETARY SYSTEM

	@SuppressWarnings("unchecked")
	public void addPlanetarySystem(String n, LocalDate ld, int coordinates, ArrayList<Pair<String,Integer>> civilizations, ArrayList<String> planets, ArrayList<String> stars) {

		int id = (int)Math.random()*(Integer.MAX_VALUE-27001) + 27001;

		PlanetarySystem nps = new PlanetarySystem(n, id, ld, (coordinates + ""));

		nps.setCivilizations(civilizations);

		nps.setPlanets(planets);

		nps.setStars(stars);

		systems.addVertex(nps, id);

	}

	//------------------------------------------------------------------------------------

	// CLOSESTS SYSTEM METHOD

	public ArrayList<PlanetarySystem> closestSystems(int id) throws Exception{

		return (ArrayList<PlanetarySystem>) GraphAlgorithms.BFS(systems, id);

	}

	//------------------------------------------------------------------------------------

	// REMOVE PLANETARY SYSTEM METHOD

	public boolean removePlanetarySystem(int id) {

		return systems.removeVertex(id);

	}

	//------------------------------------------------------------------------------------
	
	// GET CURRENT SYSTEM

	public PlanetarySystem getCurrentSystem() {
		return currentSystem;
	}

	//------------------------------------------------------------------------------------
	
	// SET PLANETARY SYSTEM

	public void setPlanetarySystem(PlanetarySystem currentSystem) {
		this.currentSystem = currentSystem;
	}

	//------------------------------------------------------------------------------------

}
