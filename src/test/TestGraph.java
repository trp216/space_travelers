/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.MatrixGraph;

class TestGraph {
	
	//------------------------------------------------------------------------------------
	
	// RELATION WITH THE CLASS MATRIZ GRAPH

	private MatrixGraph<Integer> graph;
	
	//------------------------------------------------------------------------------------
	
	// SETUP1

	void setup1() {
		
		graph = new MatrixGraph<Integer>();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// SETUP2

	void setup2() {
		
		setup1();

		for(int i = 0;i<=20;i++) {
			
			graph.addVertex(i);
			
		}

		graph.addEdge(0, 1, 4);
		
		graph.addEdge(5, 7, 69);
		
		graph.addEdge(18, 11, 33);
		
		graph.addEdge(6, 12, 20);
		
		graph.addEdge(20, 20, 55);
		
		graph.addEdge(17, 19, 82);
		
		graph.addEdge(3, 16, 8);
		
		graph.addEdge(2, 5, 76);
		
		graph.addEdge(11, 14, 13);
		
		graph.addEdge(4, 8, 45);

	}
	
	//------------------------------------------------------------------------------------
	
	// SETUP3

	void setup3() {
		
		setup1();

		for(int i=1;i<=1000;i++){
			
			graph.addVertex(i);
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 1

	@Test
	public void testAddVertex1() {
		
		setup1();

		assertTrue(graph.addVertex(21));
		
		assertTrue(graph.getVertexList().contains(21));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 2

	@Test
	public void testAddVertex2() {
		
		setup2();

		assertTrue(graph.addVertex(64));
		
		assertTrue(graph.getVertexList().contains(64));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 3

	@Test
	public void testAddVertex3() {
		
		setup1();

		for(int i = 0;i<=1000;i++) {
			
			assertTrue(graph.addVertex(i));
			
		}

	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 1

	@Test
	public void testAddEdge1() {
		
		setup2();
		
		int v1 = 2;
		
		int v2 = 15;
		
		int weight = 67;
		
		assertTrue(graph.addEdge(v1, v2, weight));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 2

	@Test
	public void testAddEdge2() {
		
		setup2();
		
		assertTrue(graph.addEdge(3, 16, 9));
	
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 3

	@Test
	public void testAddEdge3() {
		
		setup3();
		
		assertTrue(graph.addEdge(13, 35));
	
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST IS EMPTY 1
	
	@Test
	public void testIsEmpty1() {
		
		setup1();
		
		assertTrue(graph.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST IS EMPTY 2
	
	@Test
	public void testIsEmpty2() {
		
		setup2();
		
		assertFalse(graph.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST IS EMPTY 3

	@Test
	public void testIsEmpty3() {
		
		setup3();
		
		assertFalse(graph.isEmpty());
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 1
	
	@Test
	public void testRemoveVertex1() {
		
		setup1();
		
		assertFalse(graph.removeVertex(70));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 2
	
	@Test
	public void testRemoveVertex2() {
		
		setup2();
		
		assertTrue(graph.removeVertex(20));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 3
	
	@Test
	public void testRemoveVertex3() {
		
		setup3();
		
		assertFalse(graph.removeVertex(1459));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 1
	
	@Test
	public void testRemoveEdge1() {
		
		setup2();
		
		assertTrue(graph.removeEdge(18, 11));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 2
	
	public void testRemoveEdge2() {
		
		setup2();
		
		assertFalse(graph.removeEdge(7, 1));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 3
	
	@Test
	public void testRemoveEdge3() {
		
		setup3();
		
		assertFalse(graph.removeEdge(50, 700));
		
	}
	
	//------------------------------------------------------------------------------------

}
