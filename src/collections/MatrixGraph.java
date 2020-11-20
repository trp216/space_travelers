/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.io.InvalidObjectException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import javax.naming.directory.InvalidAttributesException;
import utilities.Pair;

public class MatrixGraph<E> implements Graph<E> {

	private Hashtable<Integer,Vertex<E>> vertices;	
	
	private Hashtable<Integer,Hashtable<Integer,Integer>> adjMatrix;
	
	private boolean isDirected;
	
	private boolean isWeighted;
	
	//------------------------------------------------------------------------------------
	
	public MatrixGraph(boolean isDirected, boolean isWeighted) {
		
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
				
		vertices = new Hashtable<>();		
		adjMatrix = new Hashtable<>();
				
	}	
	
	//------------------------------------------------------------------------------------
	
	@Override
	public boolean addVertex(E element, int vertexId) throws IllegalArgumentException{
		
		if(vertexId < 0) {
			throw new IllegalArgumentException("Id can not be negative");
		}
				
		if (vertices.get(vertexId) == null) {
			
			vertices.put(vertexId, new Vertex<E>(element,vertexId));
			
			if(adjMatrix.get(vertexId) == null) {
				adjMatrix.put(vertexId, new Hashtable<>());
			}	
			
			return true;
		}	
		
		return false;	
	}

	//------------------------------------------------------------------------------------
	
	@Override
	public boolean addEdge(int vertexId1, int vertexId2, int weight) throws InvalidAttributesException, IllegalArgumentException {
		if(weight < 0) {
			throw new IllegalArgumentException("Weight can not be negative");
		}
		
		if(!isWeighted && weight != 1) {
			throw new InvalidAttributesException("The operation is only valid on weighted MatrixGraph");
		}	
		
		if(vertices.get(vertexId1) == null || vertices.get(vertexId1) == null) {
			return false;
		}
			
		
		adjMatrix.get(vertexId1).put(vertexId2,weight);
		if(!isDirected) {
			adjMatrix.get(vertexId2).put(vertexId1,weight);
		}
		
		return true;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean addEdge(int vertexId1, int vertexId2) throws InvalidAttributesException, IllegalArgumentException {		
		return addEdge(vertexId1,vertexId2,1);
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean removeVertex(V vertex) {
		
		matrix.remove(vertex.getId());
		
		return true;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean removeEdge(V v1, V v2) {
		
		matrix.get(v1.getId()).remove(v2.getId());
		
		return false;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<List<Integer>> getWeightMatrix() {
		return matrix;
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
