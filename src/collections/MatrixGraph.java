/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.naming.directory.InvalidAttributesException;
import utilities.Pair;

public class MatrixGraph<E> implements Graph<E> {
	
	//------------------------------------------------------------------------------------
	
	// Attributes

	private Hashtable<Integer,Vertex<E>> vertices;	
	
	private Hashtable<Integer,Hashtable<Integer,Integer>> adjMatrix;
	
	private boolean isDirected;
	
	private boolean isWeighted;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method
	
	public MatrixGraph(boolean isDirected, boolean isWeighted) {
		
		this.isDirected = isDirected;
		
		this.isWeighted = isWeighted;
				
		vertices = new Hashtable<>();	
		
		adjMatrix = new Hashtable<>();
				
	}	
	
	//------------------------------------------------------------------------------------
	
	// Add vertex method
	
	@Override
	public boolean addVertex(E element, int vertexId) throws IllegalArgumentException{
		
		if(vertexId < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}
				
		if (vertices.get(vertexId) == null) {
			
			vertices.put(vertexId, new Vertex<E>(element,vertexId));
			
			adjMatrix.put(vertexId, new Hashtable<>());
						
			return true;
			
		}	
		
		return false;
		
	}

	//------------------------------------------------------------------------------------
	
	// Add edge method
	
	@Override
	public boolean addEdge(int vertexId1, int vertexId2, int weight) throws InvalidAttributesException, IllegalArgumentException {
		
		if(vertexId1 < 0 || vertexId2 < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}	
		
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
	
	// Override add edge method

	@Override
	public boolean addEdge(int vertexId1, int vertexId2) throws InvalidAttributesException, IllegalArgumentException {		
		return addEdge(vertexId1,vertexId2,1);
	}
	
	//------------------------------------------------------------------------------------
	
	// Is empty method 

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
	//------------------------------------------------------------------------------------
	
	// Remove vertex method

	@Override
	public boolean removeVertex(int vertexId) {
		
		if(vertexId < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}
		
		Vertex<E> v =  vertices.get(vertexId);
		
		if(v == null) {
			
			return false;
			
		}
		
		if(adjMatrix.remove(vertexId) == null) {
			
			return false;
			
		}		
		
		Enumeration<Hashtable<Integer,Integer>> rows = adjMatrix.elements();
		
		while (rows.hasMoreElements()) {
			
			rows.nextElement().remove(vertexId);	
			
		}		
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Override remove edge method

	@Override
	public boolean removeEdge(int vertexId1, int vertexId2) {
		
		if(vertexId1 < 0 || vertexId2 < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}	
		
		if(vertices.get(vertexId1) == null || vertices.get(vertexId1) == null) {
			
			return false;
			
		}	
		
		if(adjMatrix.get(vertexId1).remove(vertexId2) == null) {
			
			return false;
			
		}
			
		//At this point it will remove it 100% of the times if the graph is not directed
		if(!isDirected) {
			
			adjMatrix.get(vertexId2).remove(vertexId1);
			
		}
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Override method of the HashTable

	@Override
	public Hashtable<Integer, Hashtable<Integer, Integer>> getWeightMatrix() {
		return adjMatrix;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get adjacency list method

	@Override
	public Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>> getAdjacencyList() {
		
		List<Pair<Integer,Vertex<E>>> adjacentVerticesList = new ArrayList<>() ;
		
		Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>> adjList = new Hashtable<>();
					
		Enumeration<Integer> ids1 = vertices.keys();
		
		while(ids1.hasMoreElements()) {
			
			int id1 = ids1.nextElement();
			
			Hashtable<Integer,Integer> row = adjMatrix.get(id1);
			
			Enumeration<Integer> ids2 = row.keys();
					
			
			while(ids2.hasMoreElements()) {
				
				int id2 = ids2.nextElement();
				
				Vertex<E> v2 = vertices.get(id2);
				
				int weight = row.get(id2);
				
				adjacentVerticesList.add(new Pair<Integer,Vertex<E>>(weight,v2));
				
			}			
			
		}
		
		return adjList;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get edge list method

	@Override
	public List<Edge<E>> getEdgeList() {
		
		List<Edge<E>> edgeList = new ArrayList<>();
		
		Enumeration<Integer> ids1 = vertices.keys();
		
		while(ids1.hasMoreElements()) {
			
			int id1 = ids1.nextElement();
			
			Hashtable<Integer,Integer> row = adjMatrix.get(id1);
			
			Enumeration<Integer> ids2 = row.keys();
					
			
			while(ids2.hasMoreElements()) {
				
				int id2 = ids2.nextElement();
				
				Vertex<E> v1 = vertices.get(id1);
				
				Vertex<E> v2 = vertices.get(id2);
				
				int weight = row.get(id2);
				
				edgeList.add(new Edge<E>(v1, v2, weight));
				
			}
			
		}
		
		return edgeList;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// get edge list override

	@Override
	public List<Edge<E>> getEdgeList(int vertexId) {
		
		Vertex<E> v1 = vertices.get(vertexId);
		
		if(vertexId < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}
		
		if(v1 == null) {
			
			return null;
			
		}		
		
		List<Edge<E>> edgeList = new ArrayList<>();
		
		Hashtable<Integer,Integer> row = adjMatrix.get(vertexId);
		
		Enumeration<Integer> ids2 = row.keys();
				
		while(ids2.hasMoreElements()) {
			
			int id2 = ids2.nextElement();
			
			Vertex<E> v2 = vertices.get(id2);
			
			int weight = row.get(id2);
			
			edgeList.add(new Edge<E>(v1,v2,weight));
			
		}	
		
		return edgeList;
		
	}

	//------------------------------------------------------------------------------------
	
	// Get vertices method
	
	@Override
	public Hashtable<Integer,Vertex<E>> getVertices()  {				
		return vertices;
	}	
	
	//------------------------------------------------------------------------------------
	
	// Get adjacent vertices method
	
	@Override
	public List<Vertex<E>> getAdjacentVertices(int vertexId) {
				
		if(vertexId < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}
					
		Vertex<E> v1 = vertices.get(vertexId);
		
		if(v1 == null) {
			
			return null;
			
		}
		
		List<Vertex<E>> verticesList = new ArrayList<>();
		
		Hashtable<Integer,Integer> row = adjMatrix.get(vertexId);
		
		Enumeration<Integer> ids2 = row.keys();
				
		while(ids2.hasMoreElements()) {
			
			int id2 = ids2.nextElement();
			
			Vertex<E> v2 = vertices.get(id2);
			
			verticesList.add(v2);
			
		}	
		
		return verticesList;
		
	}

	//------------------------------------------------------------------------------------
	
	// Is directed method
	
	@Override
	public boolean isDirected() {
		return isDirected;
	}
	
	//------------------------------------------------------------------------------------
	
	// Is weighted method

	@Override
	public boolean isWeighted() {
		return isWeighted;
	}

	//------------------------------------------------------------------------------------
	
}
