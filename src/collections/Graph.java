/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.Hashtable;
import java.util.List;

import utilities.Pair;

public interface Graph<V> {
		
	//------------------------------------------------------------------------------------
	
	public boolean addVertex(V vertex) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean addEdge(V v1, V v2, int weight) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean addEdge(V v1, V v2) ;
	
	//------------------------------------------------------------------------------------
		
	public boolean isEmpty() ;
	
	//------------------------------------------------------------------------------------
	
	public boolean removeVertex(V vertex) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean removeEdge(V v1, V v2) ;
	
	//------------------------------------------------------------------------------------

	public Hashtable<V,Hashtable<V,Integer>> getWeightMatrix() ;

	//------------------------------------------------------------------------------------

	public Hashtable<V,List<Pair<V,Integer>>> getAdjacencyList() ;
	
	//------------------------------------------------------------------------------------
	
	public List<V> getEdgeList() ;

	//------------------------------------------------------------------------------------
	
	public List<V> getEdgeList(V vertex) ;

	//------------------------------------------------------------------------------------
	
	public Hashtable<V,V> getVertexList() ;

	//------------------------------------------------------------------------------------
	
	public List<V> getAdjacentVertices(V vertex) ;

	//------------------------------------------------------------------------------------
	
}
