/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;
import java.util.Hashtable;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import utilities.Pair;

public interface Graph<E> {
		
	//------------------------------------------------------------------------------------
	
	// METHOD 1 (INTERFACE)
	
	public boolean addVertex(E element, int vertexId) throws IllegalArgumentException;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 2 (INTERFACE)
	
	public boolean addEdge(int vertexId1, int vertexId2, int weight) throws InvalidAttributesException,IllegalArgumentException ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 3 (INTERFACE)
	
	public boolean addEdge(int vertexId1, int vertexId2) throws InvalidAttributesException,IllegalArgumentException ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 4 (INTERFACE)
		
	public boolean isEmpty() ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 5 (INTERFACE)
	
	public boolean removeVertex(int vertexId);
	
	//------------------------------------------------------------------------------------
	
	// METHOD 6 (INTERFACE)
	
	public boolean removeEdge(int vertexId1, int vertexId2) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 7 (INTERFACE)

	public Hashtable<Integer, Hashtable<Integer, Integer>> getWeightMatrix() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 8 (INTERFACE)

	public Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>> getAdjacencyList() ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 9 (INTERFACE)
	
	public List<Edge<E>> getEdgeList() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 10 (INTERFACE)
	
	public List<Edge<E>> getEdgeList(int vertexId) ;

	//------------------------------------------------------------------------------------
	
	// METHOD 11 (INTERFACE)
	
	public Hashtable<Integer,Vertex<E>> getVertices() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 12 (INTERFACE)
	
	public List<Vertex<E>> getAdjacentVertices(int vertexId) ;

	//------------------------------------------------------------------------------------
	
	// METHOD 13 (INTERFACE)
	
	public boolean isDirected() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 14 (INTERFACE)
		
	public boolean isWeighted() ;

	//------------------------------------------------------------------------------------
		
}
