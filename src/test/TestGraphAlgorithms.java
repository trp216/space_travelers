package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Hashtable;
import java.util.List;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.Test;
import collections.Graph;
import collections.GraphAlgorithms;
import collections.MatrixGraph;
import collections.Vertex;

class TestGraphAlgorithms {

	Graph<Integer> graphND;		
	Graph<Integer> graphD;
	
	void setup1() {
		graphND = new MatrixGraph<Integer>(false,true);
	}
	
	void setup2() {
		setup1();
		
		for (int i = 1; i <= 5; i++) {			
			graphND.addVertex(i,i);
		}
	}
	
	void setup3() throws InvalidAttributesException, IllegalArgumentException {
		setup2();
		
		graphND.addEdge(1,2,5);
		graphND.addEdge(5,4,4);
		graphND.addEdge(2,3,8);
		graphND.addEdge(5,3,1);
		graphND.addEdge(5,2,9);
		graphND.addEdge(3,1,6);		
	}
	
	void setup4() {
		
		graphD = new MatrixGraph<Integer>(true,true);
			
	}
	
	void setup5() {
		setup4();
		
		for (int i = 1; i <= 5; i++) {	
			graphD.addVertex(i,i);
		}
	}
	
	void setup6() throws InvalidAttributesException, IllegalArgumentException {
		setup5();

		graphD.addEdge(1,2,5);
		graphD.addEdge(5,4,4);
		graphD.addEdge(2,3,8);
		graphD.addEdge(5,3,1);
		graphD.addEdge(5,2,9);
		graphD.addEdge(3,1,6);
		
	}
	
	@Test
	void testBFS1() throws Exception {
		setup1();
		setup4();
		assertThrows(Exception.class, () -> GraphAlgorithms.BFS(graphND, 1));
		assertThrows(Exception.class, () -> GraphAlgorithms.BFS(graphD, 1));
	}
	
	@Test
	void testBFS2() throws Exception {
		setup2();
		setup5();
		
		List<Integer> traversalList = GraphAlgorithms.BFS(graphND, 1);		
		assertEquals(1, traversalList.get(0));
		assertEquals(1, traversalList.size());
		
		traversalList = GraphAlgorithms.BFS(graphD, 1);	
		assertEquals(1, traversalList.get(0));
		assertEquals(1, traversalList.size());
	}
	
	@Test
	void testBFS3() throws Exception{
		setup3();
		setup6();
		
		//NDI 1 3 2 5 4	
		List<Integer> traversalList = GraphAlgorithms.BFS(graphND, 1);
 		
		assertEquals(1,traversalList.get(0));
		assertEquals(3,traversalList.get(1));
		assertEquals(2,traversalList.get(2));
		assertEquals(5,traversalList.get(3));
		assertEquals(4,traversalList.get(4));
		assertEquals(5,traversalList.size());
		
		//NDII
		assertThrows(Exception.class, () -> GraphAlgorithms.BFS(graphND, 9));
				
		//DI
		traversalList = GraphAlgorithms.BFS(graphD, 5);
		
		assertEquals(5,traversalList.get(0));
		assertEquals(4,traversalList.get(1));
		assertEquals(3,traversalList.get(2));
		assertEquals(2,traversalList.get(3));
		assertEquals(1,traversalList.get(4));
		assertEquals(5,traversalList.size());
		
		//DII
		traversalList = GraphAlgorithms.BFS(graphD, 2);

		assertEquals(2,traversalList.get(0));
		assertEquals(3,traversalList.get(1));
		assertEquals(1,traversalList.get(2));
		assertEquals(3,traversalList.size());
		
		//DIII
		assertThrows(Exception.class, () -> GraphAlgorithms.BFS(graphD, 9));
	}
	
	@Test
	void testDFS1() throws Exception {
		setup1();
		setup4();
		
		assertThrows(Exception.class, () -> GraphAlgorithms.DFS(graphND, 1, 3));
		assertThrows(Exception.class, () -> GraphAlgorithms.DFS(graphD, 1, 3));
	}
	
	@Test
	void testDFS2() throws Exception {
		setup2();
		setup5();
		
		assertNull(GraphAlgorithms.DFS(graphND, 1, 3));
		assertNull(GraphAlgorithms.DFS(graphD, 1, 3));
	}
	
	@Test
	void testDFS3() throws Exception {
		setup3();
		setup6();
		
		assertEquals(3, GraphAlgorithms.DFS(graphND, 1, 3));
		assertThrows(Exception.class, () -> GraphAlgorithms.DFS(graphND, 9, 1));
		assertEquals(1, GraphAlgorithms.DFS(graphD, 5, 1));
		assertNull(GraphAlgorithms.DFS(graphD, 1, 5));
		assertThrows(Exception.class, () -> GraphAlgorithms.DFS(graphD,1,9));
	}

	@Test
	void testDijkstra1() throws Exception {
		setup1();
		setup4();
		
		assertThrows(Exception.class, () -> GraphAlgorithms.dijkstra(graphND, 1));
		assertThrows(Exception.class, () -> GraphAlgorithms.dijkstra(graphD, 1));
	}
	
	@Test
	void testDijkstra2() throws Exception {
		setup2();
		setup5();
		
		Hashtable<Vertex<Integer>,Integer> distND = GraphAlgorithms.dijkstra(graphND, 1);
		Hashtable<Vertex<Integer>,Integer> distD = GraphAlgorithms.dijkstra(graphD, 1);
		
		Hashtable<Integer,Vertex<Integer>> verticesND = graphND.getVertices();
		Hashtable<Integer,Vertex<Integer>> verticesD = graphD.getVertices();
		
		assertEquals(0,distND.get(verticesND.get(1)));
		for (int i = 2; i <= 5; i++) {
			assertEquals(1000000000, distND.get(verticesND.get(i)));
		}
		
		assertEquals(0,distD.get(verticesD.get(1)));
		for (int i = 2; i <= 5; i++) {
			assertEquals(1000000000, distD.get(verticesD.get(i)));
		}
		
	}
	
	@Test
	void testDijkstra3() throws Exception {
		setup3();
		setup6();
		Hashtable<Vertex<Integer>,Integer> distNDI = GraphAlgorithms.dijkstra(graphND, 1);
		Hashtable<Vertex<Integer>,Integer> distNDII = GraphAlgorithms.dijkstra(graphND, 3);
		Hashtable<Vertex<Integer>,Integer> distDI = GraphAlgorithms.dijkstra(graphD, 1);
		Hashtable<Vertex<Integer>,Integer> distDII = GraphAlgorithms.dijkstra(graphD, 5);
		
		Hashtable<Integer,Vertex<Integer>> verticesND = graphND.getVertices();
		Hashtable<Integer,Vertex<Integer>> verticesD = graphD.getVertices();
			
		
		//NDI
		assertEquals(0,distNDI.get(verticesND.get(1)));
		assertEquals(5,distNDI.get(verticesND.get(2)));
		assertEquals(6,distNDI.get(verticesND.get(3)));
		assertEquals(11,distNDI.get(verticesND.get(4)));
		assertEquals(7,distNDI.get(verticesND.get(5)));
		
		//NDII
		assertEquals(6,distNDII.get(verticesND.get(1)));
		assertEquals(8,distNDII.get(verticesND.get(2)));
		assertEquals(0,distNDII.get(verticesND.get(3)));
		assertEquals(5,distNDII.get(verticesND.get(4)));
		assertEquals(1,distNDII.get(verticesND.get(5)));
		
		//NDIII
		
		assertThrows(Exception.class, () -> GraphAlgorithms.dijkstra(graphND,9));
		
		//DI
		assertEquals(0,distDI.get(verticesD.get(1)));
		assertEquals(5,distDI.get(verticesD.get(2)));
		assertEquals(13,distDI.get(verticesD.get(3)));
		assertEquals(1000000000,distDI.get(verticesD.get(4)));
		assertEquals(1000000000,distDI.get(verticesD.get(5)));
		
		//DII
		assertEquals(7,distDII.get(verticesD.get(1)));
		assertEquals(9,distDII.get(verticesD.get(2)));
		assertEquals(1,distDII.get(verticesD.get(3)));
		assertEquals(4,distDII.get(verticesD.get(4)));
		assertEquals(0,distDII.get(verticesD.get(5)));
		
		//DIII
		
		assertThrows(Exception.class, () -> GraphAlgorithms.dijkstra(graphD,9));
		
	}
	
	//As floyd-warshall, prim and kruskal are not used they are not tested
}
