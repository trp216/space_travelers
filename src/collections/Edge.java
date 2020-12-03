/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

public class Edge<E> {
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the class edge

	private Vertex<E> vertex1;
	
	private Vertex<E> vertex2;
	
	private int weight;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the class edge

	public Edge(Vertex<E> vertex1, Vertex<E> vertex2, int weight) {
		
		this.vertex1 = vertex1;
		
		this.vertex2 = vertex2;
		
		this.weight = weight;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get's method of the class edge

	public Vertex<E> getVertex1() {
		return vertex1;
	}

	public Vertex<E> getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;	
	}
	
	//------------------------------------------------------------------------------------
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object anotherEdge) {
		Edge<E> aEdge = (Edge<E>)anotherEdge;
		
		return vertex1.equals(aEdge.vertex1)
				&& vertex2.equals(aEdge.vertex2)
				&& weight == aEdge.weight;
	}
	
	public String toString() {
		return "{" + vertex1.toString() + ";" + vertex2.toString() + ";" + weight + "}";
	}
}
