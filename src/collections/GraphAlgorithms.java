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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import utilities.Pair;

public class GraphAlgorithms {

	//------------------------------------------------------------------------------------
	
	// DFS METHOD
	
	public static <E> E DFS(Graph<E> graph, int vertexId) {
		
		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();
		
		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();
		
		List<E> traversal = new ArrayList<>();
		
		//More efficient than Linked List Queue
		ArrayDeque<Vertex<E>> stack = new ArrayDeque<>();
		
		stack.push(vertices.get(vertexId));
		
		int N = adjacencyList.size();
		
		Hashtable<Vertex<E>,Boolean> visitedNodes = new Hashtable<>(N);
		
		visitedNodes.put(vertices.get(vertexId), true);
		
		traversal.add(vertices.get(vertexId).getElement());
		
		while(!stack.isEmpty()){
			
			Vertex<E> vertex = stack.pop();
			
			for (Pair<Integer, Vertex<E>> p: adjacencyList.get(vertex)) {
								
				Vertex<E> adjacentVertex = p.getValue();
				
				if(!visitedNodes.containsKey(adjacentVertex)) {		
					
					visitedNodes.put(adjacentVertex, true);	
					
					stack.push(adjacentVertex);
					
					traversal.add(adjacentVertex.getElement());		
					
					if(adjacentVertex.getId() == vertexId) {
						
						return adjacentVertex.getElement();
						
					}
					
				}			
				
			}
			
		}
		
		return null;
		
	}
	
	//------------------------------------------------------------------------------------
	
	// BFS METHOD
	
	public static <E> List<E> BFS(Graph<E> graph, int vertexId) {
		
		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();
		
		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();
		
		List<E> traversal = new ArrayList<>();
		
		//More efficient than Stack
		Queue<Vertex<E>> queue = new ArrayDeque<>();
		
		queue.offer(vertices.get(vertexId));
		
		int N = adjacencyList.size();
		
		Hashtable<Vertex<E>,Boolean> visitedNodes = new Hashtable<>(N);
		
		visitedNodes.put(vertices.get(vertexId), true);
		
		traversal.add(vertices.get(vertexId).getElement());
		
		while(!queue.isEmpty()){
			
			Vertex<E> vertex = queue.poll();
			
			for (Pair<Integer, Vertex<E>> p: adjacencyList.get(vertex)) {
								
				Vertex<E> adjacentVertex = p.getValue();
				
				if(!visitedNodes.containsKey(adjacentVertex)) {		
					
					visitedNodes.put(adjacentVertex, true);
					
					queue.offer(adjacentVertex);
					
					traversal.add(adjacentVertex.getElement());						
					
				}			
				
			}
			
		}
		
		return traversal;	
		
	}
	
	//------------------------------------------------------------------------------------
	
	// DIJKSTRA METHOD
	
	public <E> int dijkstra(Graph<E> graph, int sourceVertexId, int endVertexId) {
		
		//<vertex,distance>
		Hashtable<Vertex<E>,Integer> dist = dijkstra(graph,sourceVertexId);
		
		//<id,vertex>
		Hashtable<Integer, Vertex<E>> vertices = graph.getVertices();
		
		return dist.get(vertices.get(endVertexId));	
		
	}
	
	//------------------------------------------------------------------------------------
	
	// RETURN E DIJKSTRA METHOD
	
	public <E> Hashtable<Vertex<E>,Integer> dijkstra(Graph<E> graph, int sourceVertexId) {
		
		//<Vertex,List<Pair<weight,vertex>>
		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();
		
		//<Vertex,distance>
		Hashtable<Vertex<E>,Integer> dist = new Hashtable<>();
		
		//<id,vertex>
		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();
		
		Collection<Vertex<E>> aloneVertices = vertices.values();
		
		for (Vertex<E> vertex : aloneVertices) {
			
			dist.put(vertex, 1000000000);
			
		}
				
		PriorityQueue<Pair<Integer,Vertex<E>>> pq = new PriorityQueue<Pair<Integer,Vertex<E>>>(10, 
		new Comparator< Pair<Integer,Vertex<E>> >() {
			
	        public int compare(Pair<Integer,Vertex<E>> i, Pair<Integer,Vertex<E>> j) {
	        	
	          return i.getKey().compareTo(j.getKey());
	          
	        }
	        
	      }
		
	    );
		
		pq.offer(new Pair<Integer,Vertex<E>>(0,vertices.get(sourceVertexId)));
		
		while (!pq.isEmpty()) { 
			
			Pair<Integer,Vertex<E>> top = pq.poll();
			
			int distance = top.getKey();
			
			Vertex<E> vertex = top.getValue();
			
			if (distance > dist.get(vertex)) continue;
			
			List<Pair<Integer,Vertex<E>>> adjacentVertices = adjacencyList.get(vertex);
			
			for (Pair<Integer, Vertex<E>> p : adjacentVertices) {
							
				Vertex<E> adjacentVertex = p.getValue();
				
				int weight = p.getKey();
		        
		        if (dist.get(vertex) + weight < dist.get(adjacentVertex)) {     
		        	
		        	dist.replace(adjacentVertex, dist.get(vertex) + weight);  
		        	
		        	pq.offer(new Pair<Integer,Vertex<E>>(dist.get(adjacentVertex), adjacentVertex)); 
		            
		        } 
		        
			} 
			
		}
		
		return dist;
		
	}
		
	/*
	
	//------------------------------------------------------------------------------------
		
	public <E> List<List<Integer>> floydWarshall(Graph<E> graph) {
		return null;		
	}
		
	//------------------------------------------------------------------------------------
		
	public <E> Graph<E> prim(Graph<V> graph, V vertex) {
		return null;		
	}
		
	//------------------------------------------------------------------------------------
		
	public <V> Graph<V> kruskal(Graph<V> graph, V vertex) {
		return null;		
	}
	*/
	
	//------------------------------------------------------------------------------------
	
}
