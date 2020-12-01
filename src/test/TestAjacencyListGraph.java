/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.Test;
import collections.AdjacencyListGraph;
import collections.Vertex;
import utilities.Pair;

class TestAjacencyListGraph {
	
	//------------------------------------------------------------------------------------
	
	// RELATION WITH THE CLASS ADJACENCY LIST GRAPH

	private AdjacencyListGraph<Integer> adjListGraphND;
	
	private AdjacencyListGraph<Integer> adjListGraphD;
	
	//------------------------------------------------------------------------------------
	
	void setup1() {	
		adjListGraphND = new AdjacencyListGraph<Integer>(false,true);
	}
	
	void setup2() {
		setup1();
		
		for (int i = 1; i <= 5; i++) {		
			adjListGraphND.addVertex(i,i);
		}
	}
	
	void setup3() throws InvalidAttributesException, IllegalArgumentException {
		setup2();
		
		adjListGraphND.addEdge(1,2,5);
		adjListGraphND.addEdge(5,4,4);
		adjListGraphND.addEdge(2,3,8);
		adjListGraphND.addEdge(5,3,1);
		adjListGraphND.addEdge(5,2,9);
		adjListGraphND.addEdge(3,1,6);		
	}
	
	void setup4() {
		
		adjListGraphD = new AdjacencyListGraph<Integer>(true,true);
			
	}
	
	void setup5() {
		setup4();
		
		for (int i = 1; i <= 5; i++) {	
			adjListGraphD.addVertex(i,i);
		}
	}
	
	void setup6() throws InvalidAttributesException, IllegalArgumentException {
		setup5();
		
		adjListGraphD.addEdge(1,2,5);
		adjListGraphD.addEdge(5,4,4);
		adjListGraphD.addEdge(2,3,8);
		adjListGraphD.addEdge(5,3,1);
		adjListGraphD.addEdge(5,2,9);
		adjListGraphD.addEdge(3,1,6);	
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 1

	@Test
	public void testAddVertex1() {
		
		setup1();
		setup4();

		for (int i = 1; i <= 5; i++) {		
			assertTrue(adjListGraphND.addVertex(i,i));
		}
		
		for (int i = 1; i <= 5; i++) {		
			assertTrue(adjListGraphD.addVertex(i,i));
		}	
		
		Hashtable<Integer,Vertex<Integer>> verticesND = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 5; i++) {		
			assertEquals(i,verticesND.get(i).getElement());
		}	
		
		Hashtable<Integer,Vertex<Integer>> verticesD = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 5; i++) {		
			assertEquals(i,verticesD.get(i).getElement());
		}	
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 2

	@Test
	public void testAddVertex2() throws InvalidAttributesException, IllegalArgumentException {
		
		setup2();
		setup5();

		for (int i = 6; i <= 15; i++) {		
			assertTrue(adjListGraphND.addVertex(i,i));
		}
		
		for (int i = 6; i <= 15; i++) {		
			assertTrue(adjListGraphD.addVertex(i,i));
		}	
		
		assertFalse(adjListGraphND.addVertex(99,1));
		assertFalse(adjListGraphD.addVertex(99,1));
		
		
		Hashtable<Integer,Vertex<Integer>> verticesND = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 15; i++) {		
			assertEquals(i,verticesND.get(i).getElement());
		}	
		
		Hashtable<Integer,Vertex<Integer>> verticesD = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 15; i++) {		
			assertEquals(i,verticesD.get(i).getElement());
		}
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD VERTEX 3

	@Test
	public void testAddVertex3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		setup6();

		for (int i = 6; i <= 15; i++) {		
			assertTrue(adjListGraphND.addVertex(i,i));
		}
		
		for (int i = 6; i <= 15; i++) {		
			assertTrue(adjListGraphD.addVertex(i,i));
		}	
		
		assertFalse(adjListGraphND.addVertex(99,1));
		assertFalse(adjListGraphD.addVertex(99,1));
		
		
		Hashtable<Integer,Vertex<Integer>> verticesND = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 15; i++) {		
			assertEquals(i,verticesND.get(i).getElement());
		}	
		
		Hashtable<Integer,Vertex<Integer>> verticesD = adjListGraphND.getVertices();
		
		for (int i = 1; i <= 15; i++) {		
			assertEquals(i,verticesD.get(i).getElement());
		}

	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 1
	//Test both methods add
	@Test
	public void testAddEdge1() throws InvalidAttributesException, IllegalArgumentException {
		
		setup1();
		setup4();
		
		assertFalse(adjListGraphND.addEdge(1,2,5));
		assertFalse(adjListGraphND.addEdge(5,4,4));
		assertFalse(adjListGraphND.addEdge(2,3,8));
		assertFalse(adjListGraphND.addEdge(5,3,1));
		assertFalse(adjListGraphND.addEdge(5,2,9));
		assertFalse(adjListGraphND.addEdge(3,1,6));
		
		assertFalse(adjListGraphD.addEdge(1,2,5));
		assertFalse(adjListGraphD.addEdge(5,4,4));
		assertFalse(adjListGraphD.addEdge(2,3,8));
		assertFalse(adjListGraphD.addEdge(5,3,1));
		assertFalse(adjListGraphD.addEdge(5,2,9));
		assertFalse(adjListGraphD.addEdge(3,1,6));
				
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 2

	@Test
	public void testAddEdge2() throws InvalidAttributesException, IllegalArgumentException {
		
		setup2();
		setup5();
		
		assertTrue(adjListGraphND.addEdge(1,2,5));
		assertTrue(adjListGraphND.addEdge(5,4,4));
		assertTrue(adjListGraphND.addEdge(2,3,8));
		assertTrue(adjListGraphND.addEdge(5,3,1));
		assertTrue(adjListGraphND.addEdge(5,2,9));
		assertTrue(adjListGraphND.addEdge(3,1,6));
		
		assertTrue(adjListGraphD.addEdge(1,2,5));
		assertTrue(adjListGraphD.addEdge(5,4,4));
		assertTrue(adjListGraphD.addEdge(2,3,8));
		assertTrue(adjListGraphD.addEdge(5,3,1));
		assertTrue(adjListGraphD.addEdge(5,2,9));
		assertTrue(adjListGraphD.addEdge(3,1,6));
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListND = adjListGraphND.getAdjacencyList();
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListD = adjListGraphD.getAdjacencyList();
		
		Hashtable<Integer, Vertex<Integer>> verticesND = adjListGraphND.getVertices();
		Hashtable<Integer, Vertex<Integer>> verticesD = adjListGraphD.getVertices();
		
		//Vertex1
		List<Pair<Integer, Vertex<Integer>>> list = adjListND.get(verticesND.get(1));
		
		Pair<Integer, Vertex<Integer>> p = list.get(0);
		
		assertEquals(5,p.getKey());
		assertEquals(2,p.getValue().getId());		
		
		p = list.get(1);
		
		assertEquals(6,p.getKey());
		assertEquals(3,p.getValue().getId());
		
		//Vertex 2
		list = adjListND.get(verticesND.get(2));		
		
		p = list.get(0);
		
		assertEquals(5,p.getKey());
		assertEquals(1,p.getValue().getId());	
		
		p = list.get(1);
		
		assertEquals(8,p.getKey());
		assertEquals(3,p.getValue().getId());
		
		p = list.get(2);
		
		assertEquals(9,p.getKey());
		assertEquals(5,p.getValue().getId());
				
		//Vertex 3
		list = adjListND.get(verticesND.get(3));		
		
		p = list.get(0);
		
		assertEquals(8,p.getKey());
		assertEquals(2,p.getValue().getId());		
		
		p = list.get(1);
		
		assertEquals(1,p.getKey());
		assertEquals(5,p.getValue().getId());
		
		p = list.get(2);
		
		assertEquals(6,p.getKey());
		assertEquals(1,p.getValue().getId());
		
		//Vertex 4
		list = adjListND.get(verticesND.get(4));
		
		p = list.get(0);
		
		assertEquals(4,p.getKey());
		assertEquals(5,p.getValue().getId());		
		
		//Vertex 5
		list = adjListND.get(verticesND.get(5));
		
		p = list.get(0);
		
		assertEquals(4,p.getKey());
		assertEquals(4,p.getValue().getId());		
		
		p = list.get(1);
		
		assertEquals(1,p.getKey());
		assertEquals(3,p.getValue().getId());
		
		p = list.get(2);
		
		assertEquals(9,p.getKey());
		assertEquals(2,p.getValue().getId());
		
		
		//D
		//Vertex1		
		
		list = adjListD.get(verticesD.get(1));
		
		p = list.get(0);
		
		assertEquals(5,p.getKey());
		assertEquals(2,p.getValue().getId());		
		
		//Vertex 2
		list = adjListD.get(verticesD.get(2));	
		
		p = list.get(0);	
		
		assertEquals(8,p.getKey());
		assertEquals(3,p.getValue().getId());

				
		//Vertex 3
		list = adjListD.get(verticesD.get(3));		
		
		p = list.get(0);
		
		assertEquals(6,p.getKey());
		assertEquals(1,p.getValue().getId());
		
		//Vertex 4
		list = adjListD.get(verticesD.get(4));
		
		assertTrue(list.isEmpty());
		
		//Vertex 5
		list = adjListD.get(verticesD.get(5));
		
		p = list.get(0);
		
		assertEquals(4,p.getKey());
		assertEquals(4,p.getValue().getId());		
		
		p = list.get(1);
		
		assertEquals(1,p.getKey());
		assertEquals(3,p.getValue().getId());
		
		p = list.get(2);
		
		assertEquals(9,p.getKey());
		assertEquals(2,p.getValue().getId());
		
		
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST ADD EDGE 3

	@Test
	public void testAddEdge3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		setup6();
		
		assertTrue(adjListGraphND.addEdge(3, 4, 1));
		assertTrue(adjListGraphD.addEdge(3, 4, 1));
	
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListND = adjListGraphND.getAdjacencyList();
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListD = adjListGraphD.getAdjacencyList();
		
		Hashtable<Integer, Vertex<Integer>> verticesND = adjListGraphND.getVertices();
		Hashtable<Integer, Vertex<Integer>> verticesD = adjListGraphD.getVertices();
				
		List<Pair<Integer, Vertex<Integer>>> list = adjListND.get(verticesND.get(3));
		
		Pair<Integer, Vertex<Integer>> p = list.get(3);
		assertEquals(1,p.getKey());
		assertEquals(4,p.getValue().getId());
		
		list = adjListND.get(verticesND.get(4));
		p = list.get(1);
		
		assertEquals(1,p.getKey());
		assertEquals(3,p.getValue().getId());
		
		
		list = adjListD.get(verticesD.get(3));
		
		p = list.get(1);
		assertEquals(1,p.getKey());
		assertEquals(4,p.getValue().getId());
		
		list = adjListD.get(verticesD.get(4));
		assertTrue(list.isEmpty());
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 1
	
	@Test
	public void testRemoveVertex1() {
		
		setup1();
		setup4();
		
		assertFalse(adjListGraphND.removeVertex(70));
		assertFalse(adjListGraphD.removeVertex(70));
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 2
	
	@Test
	public void testRemoveVertex2() throws InvalidAttributesException, IllegalArgumentException {
		
		setup2();
		setup5();
		
		assertFalse(adjListGraphND.removeVertex(70));
		assertFalse(adjListGraphD.removeVertex(70));
		assertTrue(adjListGraphND.removeVertex(1));
		assertTrue(adjListGraphD.removeVertex(1));
				
		assertEquals(4, adjListGraphND.getVertices().size());
		assertEquals(4, adjListGraphD.getVertices().size());
				
		assertNull(adjListGraphND.getVertices().get(1));
		assertNull(adjListGraphND.getVertices().get(1));		
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE VERTEX 3
	
	@Test
	public void testRemoveVertex3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		setup6();	
		
		assertTrue(adjListGraphND.removeVertex(1));
		assertTrue(adjListGraphD.removeVertex(1));
				
		assertEquals(4, adjListGraphND.getVertices().size());
		assertEquals(4, adjListGraphD.getVertices().size());
		
		assertTrue(adjListGraphD.getAdjacencyList().get(adjListGraphD.getVertices().get(3)).isEmpty());
		assertEquals(2,adjListGraphND.getAdjacencyList().get(adjListGraphND.getVertices().get(2)).size());
		assertEquals(2,adjListGraphND.getAdjacencyList().get(adjListGraphND.getVertices().get(3)).size());
		
		for (int i = 2; i <= 5; i++) {
			assertTrue(adjListGraphND.removeVertex(i));
			assertTrue(adjListGraphD.removeVertex(i));
		}
		
		assertTrue(adjListGraphND.getVertices().isEmpty());
		assertTrue(adjListGraphD.getVertices().isEmpty());
		
		assertTrue(adjListGraphND.getAdjacencyList().isEmpty());
		assertTrue(adjListGraphD.getAdjacencyList().isEmpty());
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 1
	
	@Test
	public void testRemoveEdge1() throws InvalidAttributesException, IllegalArgumentException {
		
		setup1();
		setup4();
		
		assertFalse(adjListGraphND.removeEdge(18,11));
		assertFalse(adjListGraphD.removeEdge(18,11));
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 2
	
	@Test
	public void testRemoveEdge2() throws InvalidAttributesException, IllegalArgumentException {
		
		setup2();
		setup5();
		
		assertFalse(adjListGraphND.removeEdge(18,11));
		assertFalse(adjListGraphD.removeEdge(18,11));
		assertFalse(adjListGraphND.removeEdge(1,5));
		assertFalse(adjListGraphD.removeEdge(1,5));
		assertFalse(adjListGraphND.removeEdge(3,1));
		assertFalse(adjListGraphD.removeEdge(3,1));
		
	}
	
	//------------------------------------------------------------------------------------
	
	// TEST REMOVE EDGE 3
	
	@Test
	public void testRemoveEdge3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		setup6();
		
		assertTrue(adjListGraphND.removeEdge(1,2));
		assertTrue(adjListGraphD.removeEdge(1,2));
		
		assertTrue(adjListGraphND.removeEdge(5,4));
		assertTrue(adjListGraphD.removeEdge(5,4));
		
		assertTrue(adjListGraphND.removeEdge(2,3));
		assertTrue(adjListGraphD.removeEdge(2,3));
		
		assertTrue(adjListGraphND.removeEdge(5,3));
		assertTrue(adjListGraphD.removeEdge(5,3));
		
		assertTrue(adjListGraphND.removeEdge(5,2));
		assertTrue(adjListGraphD.removeEdge(5,2));
		
		assertTrue(adjListGraphND.removeEdge(3,1));
		assertTrue(adjListGraphD.removeEdge(3,1));
		
		Enumeration<List<Pair<Integer, Vertex<Integer>>>> lists = adjListGraphND.getAdjacencyList().elements();
		
		while (lists.hasMoreElements()) {
			List<Pair<Integer, Vertex<Integer>>> list = lists.nextElement();
			
			assertTrue(list.isEmpty());
			
		}
		
		lists = adjListGraphD.getAdjacencyList().elements();
		
		while (lists.hasMoreElements()) {
			List<Pair<Integer, Vertex<Integer>>> list = lists.nextElement();
			
			assertTrue(list.isEmpty());
			
		}
		
	}
	
	//------------------------------------------------------------------------------------

}
