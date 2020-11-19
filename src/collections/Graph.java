/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.Hashtable;
import java.util.List;

import utilities.Pair;

public interface Graph<V extends Vertex> {
		
	//------------------------------------------------------------------------------------
	
	// METHOD 1 (INTERFACE)
	
	public boolean addVertex(V vertex) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 2 (INTERFACE)
	
	public boolean addEdge(V v1, V v2, int weight) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 3 (INTERFACE)
	
	public boolean addEdge(V v1, V v2) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 4 (INTERFACE)
		
	public boolean isEmpty() ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 5 (INTERFACE)
	
	public boolean removeVertex(V vertex) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 6 (INTERFACE)
	
	public boolean removeEdge(V v1, V v2) ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 7 (INTERFACE)

	public List<List<V>> getWeightMatrix() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 8 (INTERFACE)

	public Hashtable<V,List<Pair<Integer,V>>> getAdjacencyList() ;
	
	//------------------------------------------------------------------------------------
	
	// METHOD 9 (INTERFACE)
	
	public List<V> getEdgeList() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 10 (INTERFACE)
	
	public List<V> getEdgeList(V vertex) ;

	//------------------------------------------------------------------------------------
	
	// METHOD 11 (INTERFACE)
	
	public Hashtable<V,V> getVertexList() ;

	//------------------------------------------------------------------------------------
	
	// METHOD 12 (INTERFACE)
	
	public List<V> getAdjacentVertices(V vertex) ;

	//------------------------------------------------------------------------------------
	
}
