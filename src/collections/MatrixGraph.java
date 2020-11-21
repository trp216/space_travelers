/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

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
	public boolean removeVertex(int vertexId) {
		
		if(vertices.get(vertexId) == null) {
			return false;
		}
		
		if(adjMatrix.remove(vertexId) == null) {
			return false;
		}		
		
		return true;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public boolean removeEdge(int vertexId1, int vertexId2) {
		
		if(vertices.get(vertexId1) == null || vertices.get(vertexId1) == null) {
			return false;
		}
		
		if(adjMatrix.get(vertexId1).remove(vertexId2) == null) {
			return false;
		}
			
		return true;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public Hashtable<Integer, Hashtable<Integer, Integer>> getWeightMatrix() {
		return adjMatrix;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>> getAdjacencyList() {
		List<Pair<Integer,Vertex<E>>> adjacentVerticesList;
		Hashtable<Vertex<E>,List<Pair<Integer,Vertex<E>>>> adjList = new Hashtable<>();
				
		Object[] verticesIds = vertices.values().toArray();
		
		for(Object obj : verticesIds) {
			
			adjacentVerticesList = new ArrayList<>();
			
			int vertexId1 = (Integer) obj;
			
			Vertex<E> vertex1 = vertices.get(vertexId1);
			
			for (Object obj2 : verticesIds) {
				
				int vertexId2 = (Integer) obj2;
				
				Integer weight = adjMatrix.get(vertexId1).get(vertexId2);
				
				Vertex<E> vertex2 = vertices.get(vertexId2);
				
				if(weight != null) {
					adjacentVerticesList.add(new Pair<Integer,Vertex<E>>(weight,vertex2));
				}				
				
			}	
			
			adjList.put(vertex1, adjacentVerticesList);
		}
		
		return adjList;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<Edge<E>> getEdgeList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//------------------------------------------------------------------------------------

	@Override
	public List<Edge<E>> getEdgeList(int vertexId) {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------------------------
	
	@Override
	public Collection<Vertex<E>> getVertices()  {				
		return vertices.values();
	}	
	
	//------------------------------------------------------------------------------------
	
	@Override
	public List<Vertex<E>> getAdjacentVertices(int vertexId) {
		// TODO Auto-generated method stub
		return null;
	}

	//------------------------------------------------------------------------------------
}
