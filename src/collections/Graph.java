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
	
	public boolean removeVertex(E vertex) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 6 (INTERFACE)
	
	public boolean removeEdge(E v1, E v2) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 7 (INTERFACE)

	public List<List<Integer>> getWeightMatrix() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 8 (INTERFACE)

	public Hashtable<E,List<Pair<Integer,E>>> getAdjacencyList() ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 9 (INTERFACE)
	
	public List<E> getEdgeList() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 10 (INTERFACE)
	
	public List<E> getEdgeList(E vertex) ;

	//------------------------------------------------------------------------------------
	
	// METHOD 11 (INTERFACE)
	
	public Hashtable<E,E> getVertexList() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 12 (INTERFACE)
	
	public List<E> getAdjacentVertices(E vertex) ;

	//------------------------------------------------------------------------------------
	
}
