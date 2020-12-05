/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

/*
 * Kruskal algorithm taken from https://youtu.be/RIayaaOCllU
 */

package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Comparator;
import java.util.Enumeration;

import utilities.Pair;

public class GraphAlgorithms {

	//------------------------------------------------------------------------------------

	// DFS METHOD

	public static <E> E DFS(Graph<E> graph, int sourceVertexID, int objetiveVertexId) throws Exception {

		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();

		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();

		List<E> traversal = new ArrayList<>();

		//More efficient than Linked List Queue
		ArrayDeque<Vertex<E>> stack = new ArrayDeque<>();
		
		Vertex<E> vertex = vertices.get(sourceVertexID);
		
		if (vertex == null) throw new Exception("Source vertex not found");
		
		if (vertices.get(objetiveVertexId) == null) throw new Exception("Objetive vertex not found");
			
		stack.push(vertex);

		int N = adjacencyList.size();

		Hashtable<Vertex<E>,Boolean> visitedNodes = new Hashtable<>(N);

		visitedNodes.put(vertices.get(sourceVertexID), true);

		traversal.add(vertices.get(sourceVertexID).getElement());

		while(!stack.isEmpty()){

			vertex = stack.pop();

			for (Pair<Integer, Vertex<E>> p: adjacencyList.get(vertex)) {

				Vertex<E> adjacentVertex = p.getValue();

				if(!visitedNodes.containsKey(adjacentVertex)) {		

					visitedNodes.put(adjacentVertex, true);	

					stack.push(adjacentVertex);

					traversal.add(adjacentVertex.getElement());		

					if(adjacentVertex.getId() == objetiveVertexId) {

						return adjacentVertex.getElement();

					}

				}			

			}

		}

		return null;

	}

	//------------------------------------------------------------------------------------

	// BFS METHOD

	public static <E> List<E> BFS(Graph<E> graph, int vertexId) throws Exception {

		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();
		
		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();

		List<E> traversal = new ArrayList<>();

		//More efficient than Linked list queue
		Queue<Vertex<E>> queue = new ArrayDeque<>();
		
		Vertex<E> vertex = vertices.get(vertexId);
		
		if (vertex == null) { throw new Exception("Vertex not found"); }

		queue.offer(vertices.get(vertexId));

		int N = adjacencyList.size();

		Hashtable<Vertex<E>,Boolean> visitedNodes = new Hashtable<>(N);

		visitedNodes.put(vertices.get(vertexId), true);

		traversal.add(vertices.get(vertexId).getElement());

		while(!queue.isEmpty()){

			vertex = queue.poll();

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

	public static <E> int dijkstra(Graph<E> graph, int sourceVertexId, int endVertexId) throws Exception {

		//<vertex,distance>
		Hashtable<Vertex<E>,Integer> dist = dijkstra(graph,sourceVertexId);

		//<id,vertex>
		Hashtable<Integer, Vertex<E>> vertices = graph.getVertices();

		return dist.get(vertices.get(endVertexId));	

	}

	//------------------------------------------------------------------------------------

	// RETURN E DIJKSTRA METHOD

	public static <E> Hashtable<Vertex<E>,Integer> dijkstra(Graph<E> graph, int sourceVertexId) throws Exception {
		
		//<Vertex,List<Pair<weight,vertex>>
		Hashtable<Vertex<E>, List<Pair<Integer, Vertex<E>>>> adjacencyList = graph.getAdjacencyList();

		//<Vertex,distance>
		Hashtable<Vertex<E>,Integer> dist = new Hashtable<>();
		
		//<id,vertex>
		Hashtable<Integer,Vertex<E>> vertices = graph.getVertices();

		Collection<Vertex<E>> aloneVertices = vertices.values();
		
		Vertex<E> vertex = vertices.get(sourceVertexId);
		
		if (vertex == null) { throw new Exception("Vertex not found"); }

		for (Vertex<E> v : aloneVertices) {

			dist.put(v, 1000000000);

		}

		dist.replace(vertices.get(sourceVertexId), 0);
		
		PriorityQueue<Pair<Integer,Vertex<E>>> pq = new PriorityQueue<Pair<Integer,Vertex<E>>>(10, 
				new Comparator< Pair<Integer,Vertex<E>> >() {

			public int compare(Pair<Integer,Vertex<E>> i, Pair<Integer,Vertex<E>> j) {

				return i.getKey().compareTo(j.getKey());

			}

		});

		pq.offer(new Pair<Integer,Vertex<E>>(0,vertex));

		while (!pq.isEmpty()) { 
						
			Pair<Integer,Vertex<E>> top = pq.poll();

			int distance = top.getKey();

			vertex = top.getValue();

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



	//------------------------------------------------------------------------------------

	// FLOYD WARSHALL METHOD

	public <E> Hashtable<Integer, Hashtable<Integer, Integer>> floydWarshall(Graph<E> graph) {

		@SuppressWarnings("unchecked")
		Hashtable<Integer, Hashtable<Integer, Integer>> dist = (Hashtable<Integer, Hashtable<Integer, Integer>>) graph.getWeightMatrix().clone();							//arreglar luego

		Enumeration<Integer> rowKeys = dist.keys();
		
		Set<Integer> vertices = graph.getVertices().keySet();
				
		while(rowKeys.hasMoreElements()) {
			
			int k = rowKeys.nextElement();
			
			Enumeration<Integer> columnKeys = dist.get(k).keys();
			
			while(columnKeys.hasMoreElements()) {
				
				int i = columnKeys.nextElement();
				
				
				for (Integer j : vertices) {
					try {
						if (dist.get(i).get(k) + dist.get(k).get(j) < dist.get(i).get(j))

						dist.get(i).replace(j,dist.get(i).get(k) + dist.get(k).get(j));
					}
					catch(NullPointerException ex) {
						//Should get here in some cases
					}
				}
				
			}
			
		}
		
		return dist;

	}

	//------------------------------------------------------------------------------------
	
	// PRIM METHOD

	public <V> Hashtable<Integer,Hashtable<Integer,Integer>> prim(Graph<V> graph, V vertex) {
		
		Hashtable<Integer,Hashtable<Integer,Integer>> wm = graph.getWeightMatrix();

		int[] mst = new int[wm.size()];	
		
		int[] weight = new int[wm.size()];	
		
		boolean[] inMst = new boolean[wm.size()];
		
		for (int i = 0; i < wm.size(); i++) {
			
			weight[i] = Integer.MAX_VALUE;
			
			inMst[i] = false;
		
		}		

		weight[0] = 0; 
		
		mst[0] = -1;			

		for (int i = 0; i < wm.size()-1; i++) {
			
			int u = minVertex(weight, inMst, wm.size()); 
			
			inMst[u] = true;
			
			for (int j = 0; j < wm.size(); j++) {
				
				if(wm.get(u).get(j) != 0 && inMst[j] == false && wm.get(u).get(j) < weight[j]){
					
					mst[j] = u;
					
					weight[j] = (int) wm.get(u).get(j);
				
				}
			
			}
		
		}	
		
		return wm;
	
	}
	
	//------------------------------------------------------------------------------------
	
	// MIN VERTEX METHOD

	private int minVertex(int[] weight, boolean[] inMst, int vertices){
		
		int minValue = Integer.MAX_VALUE;
		
		int minVertex = -1;
		
		for (int i = 0; i < vertices; i++) {
			
			if(inMst[i] == false && weight[i] < minValue){
			
				minValue = weight[i];
				
				minVertex = i;
			
			}
		
		}
		
		return minVertex;
	
	}

	//------------------------------------------------------------------------------------
	
	// KRUSKAL METHOD

	public static <V> double[][] kruskal(Graph<V> graph, int vertexid) {
		
		int inf = Integer.MAX_VALUE;
		
		UnionFind<Integer> set = new UnionFind<>();

		Hashtable<Integer,Hashtable<Integer,Integer>> wm = graph.getWeightMatrix();

		double[][] MST = new double[wm.size()][wm.size()];

		for (int i = 0; i < graph.getWeightMatrix().size(); i++)
			
			set.makeSet(i);
		
		class obj {
			
			int A;
			
			int B;
			
			double P;

			obj(int a, int b, double weight) {
				
				A = a;
				B = b;
				P = weight;
				
			}

			int getA() {
				return A;
			}

			int getB() {
				return B;
			}

			double getP() {
				return P;
			}
			
		}
		
		ArrayList<obj> aristas = new ArrayList<>();
		
		for (int i = 0; i < wm.size(); i++) {
		
			for (int j = 0; j < wm.size(); j++) {
			
				double weight = wm.get(i).get(j); 
				
				if (weight > 0 && weight < inf) {
				
					obj o = new obj(i, j, weight);
					
					aristas.add(o);
				
				}
			
			}
		
		}

		Comparator<obj> comparator = new Comparator<obj>() {

			public int compare(obj a, obj b) {
				
				if (a.getP() > b.getP())
					
					return 1;
				
				else if (a.getP() < b.getP())
					
					return -1;
				
				else
					
					return 0;
			
			}
		
		};

		aristas.sort(comparator);
		
		for (int i = 0; i < aristas.size(); i++) {
			
			obj arista = aristas.get(i);
			
			if (set.findSet(arista.getA()) != set.findSet(arista.getB())) {
				
				set.union(arista.getA(), arista.getB());
				
				MST[arista.getA()][arista.getB()] = arista.getP();
				
				MST[arista.getB()][arista.getA()] = arista.getP();
			
			}
		
		}

		return MST;
		
	}

	//------------------------------------------------------------------------------------

}
