/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import utilities.Pair;

public class MatrixGraph<V extends Vertex> implements Graph<V> {

	private List<V> vertices;
	
	private List<List<Integer>> matrix;	
	
	//------------------------------------------------------------------------------------
	
	public MatrixGraph() {
		vertices = new ArrayList<V>();
		matrix = new ArrayList<>();		
	}
	
	
	//------------------------------------------------------------------------------------
	
	@Override
	public boolean addVertex(V vertex) {
		vertices.add(vertex.getId(), vertex);
		
		if(matrix.get(vertex.getId()) != null) {
			return false;
		}
		else {
			matrix.add(vertex.getId(),new ArrayList<>());
			return true;
		}		
		
	}

	//------------------------------------------------------------------------------------
	
	@Override
	public boolean addEdge(V v1, V v2, int weight) {
		
		matrix.get(v1.getId()).add(v2.getId(), weight);
		
		return false;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean addEdge(V v1, V v2) {

		matrix.get(v1.getId()).add(v2.getId(), 1);
		
		return false;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean removeVertex(V vertex) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean removeEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<List<V>> getWeightMatrix() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public Hashtable<V,List<Pair<Integer,V>>> getAdjacencyList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<V> getEdgeList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<V> getEdgeList(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------------------------
	
	@Override
	public Hashtable<V,V> getVertexList() {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------------------------
	
	@Override
	public List<V> getAdjacentVertices(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------------------------
}
