/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package model;

public class NavigationSystem {
	
	//------------------------------------------------------------------------------------

	// Attributes of the NavigationSystem class
	
	private String name;
	
	//------------------------------------------------------------------------------------

	// Relations of the NavigationSystem class
	
	private PlanetarySystem currentSystem;
	
	//------------------------------------------------------------------------------------

	// Constructor of the NavigationSystem class

	public NavigationSystem(String name) {
		this.name = name;
	}
	
	//------------------------------------------------------------------------------------
	
	//Operations of the NavigationSystem class
	
	public void generateSystems(int n) {
		
	//this is for generating names in the format char + number
			for(int i = 65;i<=90 && n>0;i++) {
				char x = (char) i;
				
				for(int j = 1;j<=10000 && n>0;j++) {
					String sname = x + "" + j + "";
					n--;
				}
				
			}
			
		
	}
	
	//------------------------------------------------------------------------------------
	
}
