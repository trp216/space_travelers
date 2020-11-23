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

public class AdjacencyListGraph<E> implements Graph<E>{
	
	//------------------------------------------------------------------------------------
	
	// Attributes of the class adjacency list graph
	
	private Hashtable<Integer,Vertex<E>> vertices;
	
	private Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>>  adjList;
	
	private boolean isDirected;
	
	private boolean isWeighted;
	
	//------------------------------------------------------------------------------------
	
	// Constructor method of the adjacency list graph class
	
	public AdjacencyListGraph(boolean isDirected, boolean isWeighted) {
		
		this.isDirected = isDirected;
		
		this.isWeighted = isWeighted;
		
		adjList = new Hashtable<>();
				
		vertices = new Hashtable<>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Add vertex method
	
	@Override
	public boolean addVertex(E element, int vertexId) throws IllegalArgumentException {
		
		if(vertexId < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
		}
		
		if (vertices.get(vertexId) == null) {
			
			Vertex<E> newVertex = new Vertex<>(element,vertexId);
			
			vertices.put(vertexId, newVertex);		
			
			adjList.put(newVertex,new ArrayList<>());
					
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
		
		Vertex<E> v1 =  vertices.get(vertexId1);
		
		Vertex<E> v2 =  vertices.get(vertexId2);
		
		if(v1 == null || v2 == null) {
			
			return false;
			
		}
		
		adjList.get(v1).add(new Pair<Integer,Vertex<E>>(weight,v2));
		
		if(!isDirected) {
			
			adjList.get(v2).add(new Pair<Integer,Vertex<E>>(weight,v1));
			
		}
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Add edge method Override

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
		
		if(adjList.remove(v) == null) {
			
			return false;
			
		}		
		
		Enumeration<List<Pair<Integer,Vertex<E>>>> lists = adjList.elements();
		
		while (lists.hasMoreElements()) {
			
			List<Pair<Integer,Vertex<E>>> list = lists.nextElement();
			
			boolean check = false;
			
			for (int i = 0; i < list.size() && !check; i++) {
				
				Pair<Integer,Vertex<E>> p = list.get(i);
				
				Vertex<E> v1 = p.getValue();
				
				if(v == v1) {
					
					list.remove(i);	
					
					check = true;
					
				}
				
			}			
			
		}	
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Remove edge method

	@Override
	public boolean removeEdge(int vertexId1, int vertexId2) {
		
		if(vertexId1 < 0 || vertexId2 < 0) {
			
			throw new IllegalArgumentException("Id can not be negative");
			
		}	
		
		if(vertices.get(vertexId1) == null || vertices.get(vertexId1) == null) {
			
			return false;
			
		}	
		
		Vertex<E> v1 =  vertices.get(vertexId1);
		
		Vertex<E> v2 =  vertices.get(vertexId2);
		
		List<Pair<Integer,Vertex<E>>> v1List = adjList.get(v1);
		
		boolean removed = false;
		
		for (int i = 0; i < v1List.size() && !removed ; i++) {
			
			if(v1List.get(i).getValue() == v2) {
				
				v1List.remove(i);
				
				removed = true;
				
			}			
			
		}		
			
		//At this point it will remove it 100% of the times if the graph is not directed
		if(!isDirected) {
			
			List<Pair<Integer,Vertex<E>>> v2List = adjList.get(v2);
			
			removed = false;
						
			for (int i = 0; i < v2List.size() && !removed ; i++) {
				
				if(v2List.get(i).getValue() == v1) {
					
					v2List.remove(i);
					
					removed = true;
					
				}			
				
			}
			
		}
		
		return true;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get weight matrix method

	@Override
	public Hashtable<Integer, Hashtable<Integer, Integer>> getWeightMatrix() {
		
		Hashtable<Integer,Hashtable<Integer,Integer>> adjMatrix = new Hashtable<>();
		
		Enumeration<Vertex<E>> allVertices = vertices.elements(); 
		
		while(allVertices.hasMoreElements()) {
			
			Vertex<E> v1 = allVertices.nextElement();
			
			List<Pair<Integer,Vertex<E>>> v1List = adjList.get(v1);
			
			adjMatrix.put(v1.getId(),new Hashtable<Integer,Integer>());
			
			for (Pair<Integer, Vertex<E>> p : v1List) {
				
				int v2Id = p.getValue().getId();
				
				int weight = p.getKey();
				
				adjMatrix.get(v1.getId()).put(v2Id, weight);				
				
			}
			
		}	
		
		return adjMatrix;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get adjacency list method

	@Override
	public Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> getAdjacencyList() {
		return adjList;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get edge list method

	@Override
	public List<Edge<E>> getEdgeList() {
		
		List<Edge<E>> edgeList = new ArrayList<>();
		
		Enumeration<Vertex<E>> vertices1 = vertices.elements();
		
		while(vertices1.hasMoreElements()) {
			
			Vertex<E> v1 = vertices1.nextElement();
			
			List<Pair<Integer,Vertex<E>>> v1List = adjList.get(v1);
			
			for(Pair<Integer,Vertex<E>> p : v1List) {
								
				Vertex<E> v2 = p.getValue();
				
				int weight = p.getKey();
				
				edgeList.add(new Edge<E>(v1, v2, weight));
				
			}
			
			
		}
		
		return edgeList;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get edge list method

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
		
		List<Pair<Integer,Vertex<E>>> v1List = adjList.get(v1);
		
		for(Pair<Integer,Vertex<E>> p : v1List) {
							
			Vertex<E> v2 = p.getValue();
			
			int weight = p.getKey();
			
			edgeList.add(new Edge<E>(v1, v2, weight));
			
		}
		
		return edgeList;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// Get vertices

	@Override
	public Hashtable<Integer,Vertex<E>> getVertices()  {				
		return vertices;
	}
	
	//------------------------------------------------------------------------------------
	
	// Get adjacent vertices

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
		
		List<Pair<Integer,Vertex<E>>> v1List = adjList.get(v1);
		
		for(Pair<Integer,Vertex<E>> p : v1List) {
							
			Vertex<E> v2 = p.getValue();
			
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
	
	// is weight method

	@Override
	public boolean isWeighted() {
		return isWeighted;
	}
	
	//------------------------------------------------------------------------------------
	
}
