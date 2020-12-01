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

import javax.naming.directory.InvalidAttributesException;

import collections.AdjacencyListGraph;
import collections.Graph;
import collections.GraphAlgorithms;
import collections.MatrixGraph;
import utilities.Pair;

public class NavigationSystem {

	//------------------------------------------------------------------------------------

	// Attributes of the NavigationSystem class

	private String name;

	//------------------------------------------------------------------------------------

	// Relations of the NavigationSystem class

	private PlanetarySystem currentSystem;
	
	private Graph systems;
	
	//private ArrayList<PlanetarySystem> arraySystems;

	//------------------------------------------------------------------------------------

	// Constructor of the NavigationSystem class

	public NavigationSystem(String name) {
		this.name = name;
		
		//arraySystems = new ArrayList<PlanetarySystem>();
	}

	//------------------------------------------------------------------------------------

	//Operations of the NavigationSystem class

	public void generateSystems(int n) {

		Hashtable<Integer,Boolean> c = new Hashtable<Integer,Boolean>();
		Hashtable<Integer,PlanetarySystem> ids = new Hashtable<Integer,PlanetarySystem>();
		//this is for generating names in the format char + number
		for(int i = 65;i<=90 && n>0;i++) {
			char x = (char) i;

			for(int j = 1;j<=1000 && n>0;j++) {
				String sname = x + "" + j + "";
				
				int coordinate = (int)Math.random()*Integer.MAX_VALUE;
				while(c.contains(coordinate)) {
					coordinate = (int)Math.random()*Integer.MAX_VALUE;
				}
				c.put(coordinate, true);
				
				int id = (int)Math.random()*27001;
				while(ids.contains(id)) {
					id = (int)Math.random()*27001;
				}
				
				
				PlanetarySystem nps = new PlanetarySystem(sname, (int)id, discoveryDate, (coordinate+""));
				ids.put(id, nps);
				n--;
			}

		}
		generateWeights(ids);
	}
	
	public void generateWeights(Hashtable<Integer,PlanetarySystem> ht) throws InvalidAttributesException, IllegalArgumentException {
		int weight = (int)Math.random()*100001;
		Random random = new Random();
		int s1 = random.nextInt(ht.size());
		int s2 = random.nextInt(ht.size());
		if(s1!=s2 || systems.getAdjacentVertices(s1).get(s2)!=null) {
			systems.addEdge(s1, s2, weight);
		}
		else {
			s1 = random.nextInt(ht.size());
			s2 = random.nextInt(ht.size());
		}
	}
	
	public void graphSelected(boolean adj) {

		if(adj==true) {
			systems = new AdjacencyListGraph<PlanetarySystem>(false,true);
		}
		else {
			systems = new MatrixGraph<PlanetarySystem>(false,true);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public PlanetarySystem search(int id) {
		return (PlanetarySystem) GraphAlgorithms.DFS(systems, id);
	}
	
	@SuppressWarnings("unchecked")
	public int calculateDistance(int idPS1, int idPS2) {
		return GraphAlgorithms.dijkstra(systems, search(idPS1).getId(), search(idPS2).getId());
	}
	
	@SuppressWarnings("unchecked")
	public void addPlanetarySystem(String n, LocalDate ld, int coordinates,ArrayList<Pair<String,Integer>> c, ArrayList<String> p,ArrayList<String> s) {
		
		int id = (int)Math.random()*(Integer.MAX_VALUE-27001) + 27001;
		
		PlanetarySystem nps = new PlanetarySystem(n, id, ld, (coordinates+""));
		
		nps.setCivilizations(c);
		nps.setPlanets(p);
		nps.setStars(s);
		
		systems.addVertex(nps, id);
	}
	
	public ArrayList<PlanetarySystem> closestSystems(int id) throws Exception{
		return (ArrayList<PlanetarySystem>) GraphAlgorithms.BFS(systems, id);
	}
	
	public boolean removePlanetarySystem(int id) {
		return systems.removeVertex(id);
	}

	//------------------------------------------------------------------------------------

}
