/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import utilities.Pair;

public class GraphAlgorithms {

	//------------------------------------------------------------------------------------
	
	public static <V> List<V> BFS(Graph<V> graph, V vertex) {
		Hashtable<V, List<Pair<Integer, V>>> adjacencyList = graph.getAdjacencyList();
		
		//More efficient than Stack
		Queue<V> queue = new ArrayDeque<V>();
		
		queue.offer(graph.getVertexList().get(vertex));
		
		int N = adjacencyList.size();
		
		Hashtable<V,Boolean> visitedNodes = new Hashtable<V,Boolean>(N);
		
		visitedNodes.put(vertex, true);
		
		while(!queue.isEmpty()){
			
			V node = queue.poll();
			
			for (Pair<Integer,V> p: adjacencyList.get(node)) {
								
				V adjacentNode = p.getValue();
				
				if(!visitedNodes.containsKey(adjacentNode)) {					
					visitedNodes.put(adjacentNode, true);					
					queue.offer(adjacentNode);
										
				}			
				
			}
			
		}
		
		return null;		
	}
	
	//------------------------------------------------------------------------------------
	
	public static <V> V DFS(Graph<V> graph, V vertex) {
		
		Hashtable<V,List<Pair<Integer,V>>> adjacencyList = graph.getAdjacencyList();
				
		//More efficient than Stack
		ArrayDeque<V> stack = new ArrayDeque<V>();
		
		stack.push(graph.getVertexList().get(vertex));
		
		int N = adjacencyList.size();
		
		Hashtable<V,Boolean> visitedNodes = new Hashtable<V,Boolean>(N);
		
		visitedNodes.put(vertex, true);
		
		while(!stack.isEmpty()){
			
			V node = stack.pop();
			
			for (Pair<Integer,V> p: adjacencyList.get(node)) {
								
				V adjacentNode = p.getValue();
				
				if(!visitedNodes.containsKey(adjacentNode)) {					
					visitedNodes.put(adjacentNode, true);					
					stack.push(adjacentNode);
					
					if(adjacentNode.equals(vertex)) {
						return adjacentNode;
					}
					
				}			
				
			}
			
		}
		
		return null;		
	}
	
	//------------------------------------------------------------------------------------
	
	public <V> int dijkstra(Graph<V> graph, V sourceVertex, V endVertex) {
		
		Hashtable<V,Integer> dist = dijkstra(graph,sourceVertex);
		
		return dist.get(endVertex);				
	}
	
	//------------------------------------------------------------------------------------
	
	public <V> Hashtable<V,Integer> dijkstra(Graph<V> graph, V sourceVertex) {
		
		Hashtable<V, List<Pair<Integer,V>>> adjacencyList = graph.getAdjacencyList();
		Hashtable<V,Integer> dist = new Hashtable<>();
		Hashtable<V,V> vertices = graph.getVertexList();
		
		Collection<V> aloneVertices = vertices.values();
		
		for (V vertex : aloneVertices) {
			dist.put(vertex, 1000000000);
		}
				
		PriorityQueue<Pair<Integer,V>> pq = new PriorityQueue<Pair<Integer,V>>(10, 
			      new Comparator< Pair<Integer,V> >() {
	        public int compare(Pair<Integer,V> i, Pair<Integer,V> j) {
	          return i.getKey().compareTo(j.getKey());
	        }
	      }
	    );
		
		pq.offer(new Pair<Integer,V>(0,sourceVertex));
		
		while (!pq.isEmpty()) { 
			Pair<Integer,V> top = pq.poll();
			
			int distance = top.getKey();
			
			V vertex = top.getValue();
			
			if (distance > dist.get(vertex)) continue;
			
			List<Pair<Integer,V>> adjacentVertices = adjacencyList.get(top);
			
			for (Pair<Integer, V> p : adjacentVertices) {
							
				V adjacentVertex = p.getValue();
				
				int weight = p.getKey();
		        
		        if (dist.get(vertex) + weight < dist.get(adjacentVertex)) {     
		        	
		        	dist.replace(adjacentVertex, dist.get(vertex) + weight);  
		        	
		        	pq.offer(new Pair<Integer,V>(dist.get(adjacentVertex), adjacentVertex)); 
		            
		        } 
			} 
		}
		
		return dist;
	}
		
	/*
	
	//------------------------------------------------------------------------------------
		
	public <V> List<List<Integer>> floydWarshall(Graph<V> graph) {
		return null;		
	}
		
	//------------------------------------------------------------------------------------
		
	public <V> Graph<V> prim(Graph<V> graph, V vertex) {
		return null;		
	}
		
	//------------------------------------------------------------------------------------
		
	public <V> Graph<V> kruskal(Graph<V> graph, V vertex) {
		return null;		
	}
	*/
	
}
