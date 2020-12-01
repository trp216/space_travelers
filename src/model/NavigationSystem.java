/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package model;

import java.time.LocalDate;
import java.util.Hashtable;

import collections.AdjacencyListGraph;
import collections.Graph;
import collections.GraphAlgorithms;
import collections.MatrixGraph;

public class NavigationSystem {

	//------------------------------------------------------------------------------------

	// Attributes of the NavigationSystem class

	private String name;

	//------------------------------------------------------------------------------------

	// Relations of the NavigationSystem class

	private PlanetarySystem currentSystem;
	
	private Graph systems;

	//------------------------------------------------------------------------------------

	// Constructor of the NavigationSystem class

	public NavigationSystem(String name) {
		this.name = name;
		
		ga = new GraphAlgorithms();
	}

	//------------------------------------------------------------------------------------

	//Operations of the NavigationSystem class

	public void generateSystems(int n) {

		Hashtable<Integer,Boolean> c = new Hashtable<Integer,Boolean>();

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
				
				double id = Math.random()*27001;
				
				PlanetarySystem nps = new PlanetarySystem(sname, (int)id, discoveryDate, coordinate);
				n--;
			}

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

	//------------------------------------------------------------------------------------

}
