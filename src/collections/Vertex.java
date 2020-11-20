/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

public class Vertex<E> {
	
	//------------------------------------------------------
	//Attributes
	
	private E element;
	
	private int id;
	
	//------------------------------------------------------
	//Constructor
	
	public Vertex(E element, int id) {
		
		this.element = element;		
		this.id = id;		
		
	}
	
	//------------------------------------------------------
	//Getters
	
	public E getElement() { return element; }
	public int getId() { return id; }
	
	//------------------------------------------------------
	//Setters
	
	public void setElement(E element) { this.element = element; }
	public void setId(int id) { this.id = id; }	
	
	//------------------------------------------------------	
	
}
