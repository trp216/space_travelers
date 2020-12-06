/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import java.util.SplittableRandom;
import javax.naming.directory.InvalidAttributesException;
import collections.AdjacencyListGraph;
import collections.Graph;
import collections.GraphAlgorithms;
import collections.MatrixGraph;
import collections.Vertex;
import utilities.Pair;

public class NavigationSystem {

	public static int MAX_SYSTEMS_NUMBER = 27000;

	Hashtable<Integer,Integer> usedXCoordinates;

	Hashtable<Integer,Integer> usedYCoordinates;

	Hashtable<Integer,Integer> usedZCoordinates;

	Hashtable<Integer, Integer> usedIds;

	int systemCount;
	//------------------------------------------------------------------------------------

	// ATTRIBUTES AND RELATIONS OF THE CLASS NAVEGATION SYSTEM

	private PlanetarySystem currentLocationSystem;

	private PlanetarySystem currentSystem;

	private Graph<PlanetarySystem> systems;

	//------------------------------------------------------------------------------------

	// CONSTRUCTOR METHOD OF THE CLASS NAVEGATION SYSTEM

	public NavigationSystem() {

		usedXCoordinates = new Hashtable<>();
		usedYCoordinates = new Hashtable<>();
		usedZCoordinates = new Hashtable<>();		
		usedIds = new Hashtable<>();

		PlanetarySystem solarSystem = new PlanetarySystem("Solar System", 1, LocalDate.of(1543, 1, 1), 0, 0, 0);

		usedXCoordinates.put(0, 0);
		usedYCoordinates.put(0, 0);
		usedZCoordinates.put(0, 0);

		solarSystem.addPlanet("Earth");
		solarSystem.addStars("Sun");
		solarSystem.addCivilization("Human", 2);

		currentLocationSystem = solarSystem;		

		systemCount = 1;
	}

	//------------------------------------------------------------------------------------

	// GENERATE SYSTEMS

	public void generateSystems(int n) throws InvalidAttributesException, IllegalArgumentException {

		for(int i = 65 ; i <= 90 && n > 0 ; i ++) { //Generates the letter of the name

			char x = (char) i;

			for(int j = 1 ; j <= 1000 && n > 0 ; j++) { //Adds the number to the letter generated before

				String sName = x + "" + j;

				int coordX, coordY, coordZ;

				Random r = new Random();

				do {

					coordX = r.nextInt();
					coordY = r.nextInt();
					coordZ = r.nextInt();					

				} while(usedXCoordinates.containsKey(coordX)
						&& usedYCoordinates.containsKey(coordY)
						&& usedZCoordinates.containsKey(coordZ));

				usedXCoordinates.put(coordX, coordX);
				usedYCoordinates.put(coordY, coordY);
				usedZCoordinates.put(coordZ, coordZ);

				int id;

				do { // checks if the id is repeated

					id = r.nextInt();
					if(id < 0) id = -id;

				}while(usedIds.contains(id));

				usedIds.put(id, id);

				PlanetarySystem nps = new PlanetarySystem(sName, (int) id, generateDiscoveryDate(), coordX, coordY, coordZ);
				
				nps.setPlanets(generateSP());
				nps.setStars(generateSP());
				nps.setCivilizations(generateC());
				
				systems.addVertex(nps, id);

				//Updates edges, is a fully connected graph
				updateEdges(nps);				

				n -- ;

			}

		}

	}

	//------------------------------------------------------------------------------------

	public void updateEdges(PlanetarySystem newPlanetarySystem) {

		int newPSId = newPlanetarySystem.getId();

		Hashtable<Integer, Vertex<PlanetarySystem>> vertices = systems.getVertices();

		Set<Integer> ids = vertices.keySet();

		for(Integer id : ids) {
			if(id!= newPSId) {

				int distance = calculateDistance(newPlanetarySystem, vertices.get(id).getElement());

				try {
					systems.addEdge(newPSId,id,distance);
				}
				catch (InvalidAttributesException e) {
					e.printStackTrace();
				} 
				catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	//------------------------------------------------------------------------------------

	private int calculateDistance(PlanetarySystem ps1, PlanetarySystem ps2) {

		int x1,x2,y1,y2,z1,z2;
		x1 = ps1.getCoordX();
		y1 = ps1.getCoordY();
		z1 = ps1.getCoordZ();

		x2 = ps2.getCoordX();
		y2 = ps2.getCoordY();
		z2 = ps2.getCoordZ();	

		return (int)Math.sqrt(Math.pow(Math.pow(x2-x1,2) + Math.pow(y2-y1,2) + Math.pow(z2-z1,2),0.5));
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
	
	private String generateRandomString() {
		Random r = new Random();
		int low = 65;
		int high = 91;
		char x = (char) (r.nextInt(high-low) + low);
		String obj = x + ""+  r.nextInt() + "";
		return obj;
	}
	
	//------------------------------------------------------------------------------------

	private ArrayList<String> generateSP(){
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(generateRandomString());
		
		return ar;
		
	}

	//------------------------------------------------------------------------------------

	private ArrayList<Pair<String,Integer>> generateC(){
		
		Random r = new Random();
		int low = 1;
		int high = 4;
		int type = r.nextInt(high-low) + low;
		
		ArrayList<Pair<String,Integer>> ar = new ArrayList<Pair<String,Integer>>(); 
		ar.add(new Pair<String, Integer>(generateRandomString(),type));
		
		return ar;
	}

	//------------------------------------------------------------------------------------

	// GRAPH SELECTED METHOD

	public void graphSelected(boolean adj) {

		if(adj == true) {

			systems = new AdjacencyListGraph<PlanetarySystem>(false, true);

		} else {

			systems = new MatrixGraph<PlanetarySystem>(false, true);

		}

		systems.addVertex(currentLocationSystem, currentLocationSystem.getId());
	}

	//------------------------------------------------------------------------------------

	// METHOD PLANETARY SYSTEM SEARCH

	public PlanetarySystem search(int id) throws Exception {

		currentSystem = (PlanetarySystem) GraphAlgorithms.DFS(systems, currentLocationSystem.getId(),id);

		return currentSystem;

	}

	//------------------------------------------------------------------------------------

	// METHOD CALCULATE DISTANCE

	public int calculateDistance(int idPS1, int idPS2) throws Exception {

		return GraphAlgorithms.dijkstra(systems, search(idPS1).getId(), search(idPS2).getId());

	}

	//------------------------------------------------------------------------------------

	// METHOD ADD PLANETARY SYSTEM

	public int addPlanetarySystem(String n, LocalDate ld, int coordX, int coordY, int coordZ, ArrayList<Pair<String,Integer>> civilizations, ArrayList<String> planets, ArrayList<String> stars) throws Exception {

		Random r = new Random();

		int id;

		do { // checks if the id is repeated

			id = r.nextInt();

		} while(usedIds.contains(id) || id < 0);

		usedIds.put(id, id);

		if(usedXCoordinates.containsKey(coordX) && usedYCoordinates.containsKey(coordY) && usedZCoordinates.containsKey(coordZ)) {
			throw new Exception("Planetary system in the given coordinates already exists");
		}

		usedXCoordinates.put(coordX, coordX);
		usedYCoordinates.put(coordY, coordY);
		usedZCoordinates.put(coordZ, coordZ);

		PlanetarySystem nps = new PlanetarySystem(n, id, ld, coordX, coordY, coordZ);

		nps.setCivilizations(civilizations);

		nps.setPlanets(planets);

		nps.setStars(stars);

		systems.addVertex(nps, id);

		updateEdges(nps);

		return id;

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

	public void setCurrentPlanetarySystem(PlanetarySystem currentSystem) {
		this.currentSystem = currentSystem;
	}

	public void setCurrentLocationPlanetarySystem(PlanetarySystem currentLocationSystem) {
		this.currentLocationSystem = currentLocationSystem;
	}

	public PlanetarySystem getCurrentLocationSystem() {
		return currentLocationSystem;
	}

	public Collection<PlanetarySystem> getSystems() {

		Collection<Vertex<PlanetarySystem>> vertices = systems.getVertices().values();
		Collection<PlanetarySystem> systems = new ArrayList<>();

		for (Vertex<PlanetarySystem> vertex : vertices) {
			systems.add(vertex.getElement());
		}

		return systems;
	}

	//------------------------------------------------------------------------------------

}
