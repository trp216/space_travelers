/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;

import utilities.Pair;

public class GraphAlgorithms {

	//------------------------------------------------------------------------------------
	
	public static <V> List<V> BFS(Graph<V> graph, V vertex) {
		Hashtable<V,List<Pair<V,Integer>>> adjacencyList = graph.getAdjacencyList();
		
		//More efficient than Stack
		Queue<V> queue = new ArrayDeque<V>();
		
		queue.offer(graph.getVertexList().get(vertex));
		
		int N = adjacencyList.size();
		
		Hashtable<V,Boolean> visitedNodes = new Hashtable<V,Boolean>(N);
		
		visitedNodes.put(vertex, true);
		
		while(!queue.isEmpty()){
			
			V node = queue.poll();
			
			for (Pair<V,Integer> p: adjacencyList.get(node)) {
								
				V adjacentNode = p.getKey();
				
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
		
		Hashtable<V,List<Pair<V,Integer>>> adjacencyList = graph.getAdjacencyList();
				
		//More efficient than Stack
		ArrayDeque<V> stack = new ArrayDeque<V>();
		
		stack.push(graph.getVertexList().get(vertex));
		
		int N = adjacencyList.size();
		
		Hashtable<V,Boolean> visitedNodes = new Hashtable<V,Boolean>(N);
		
		visitedNodes.put(vertex, true);
		
		while(!stack.isEmpty()){
			
			V node = stack.pop();
			
			for (Pair<V,Integer> p: adjacencyList.get(node)) {
								
				V adjacentNode = p.getKey();
				
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
	
	public <V> int dijkstra(Graph<V> graph, V sourcevertex, V endVertex) {
		return -1;		
	}
	
	//------------------------------------------------------------------------------------
	
	public <V> List<Pair<List<V>,Integer>> dijkstra(Graph<V> graph, V sourcevertex) {
			return null;		
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
