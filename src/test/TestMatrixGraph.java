/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.MatrixGraph;
import collections.Vertex;
import utilities.Pair;

class TestMatrixGraph {

	// ------------------------------------------------------------------------------------

	// RELATION WITH THE CLASS MATRIZ GRAPH

	private MatrixGraph<Integer> matrixGraphND;

	private MatrixGraph<Integer> matrixGraphD;

	// ------------------------------------------------------------------------------------
	
	// SETUP 1

	void setup1() {
		
		matrixGraphND = new MatrixGraph<Integer>(false, true);
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// SETUP 2

	void setup2() {
		
		setup1();

		for (int i = 1; i <= 5; i++) {
			
			matrixGraphND.addVertex(i, i);
			
		}
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// SETUP 3

	void setup3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup2();

		matrixGraphND.addEdge(1, 2, 5);
		
		matrixGraphND.addEdge(5, 4, 4);
		
		matrixGraphND.addEdge(2, 3, 8);
		
		matrixGraphND.addEdge(5, 3, 1);
		
		matrixGraphND.addEdge(5, 2, 9);
		
		matrixGraphND.addEdge(3, 1, 6);
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// SETUP 4

	void setup4() {

		matrixGraphD = new MatrixGraph<Integer>(true, true);

	}
	
	// ------------------------------------------------------------------------------------
	
	// SETUP 5

	void setup5() {
		
		setup4();

		for (int i = 1; i <= 5; i++) {
			
			matrixGraphD.addVertex(i, i);
			
		}
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// SETUP 6

	void setup6() throws InvalidAttributesException, IllegalArgumentException {
		
		setup5();

		matrixGraphD.addEdge(1, 2, 5);
		
		matrixGraphD.addEdge(5, 4, 4);
		
		matrixGraphD.addEdge(2, 3, 8);
		
		matrixGraphD.addEdge(5, 3, 1);
		
		matrixGraphD.addEdge(5, 2, 9);
		
		matrixGraphD.addEdge(3, 1, 6);
		
	}

	// ------------------------------------------------------------------------------------

	// TEST ADD VERTEX 1

	@Test
	public void testAddVertex1() {

		setup1();
		
		setup4();

		for (int i = 1; i <= 5; i++) {
			
			assertTrue(matrixGraphND.addVertex(i, i));
			
		}

		for (int i = 1; i <= 5; i++) {
			
			assertTrue(matrixGraphD.addVertex(i, i));
			
		}

		Hashtable<Integer, Vertex<Integer>> verticesND = matrixGraphND.getVertices();

		for (int i = 1; i <= 5; i++) {
			
			assertEquals(i, verticesND.get(i).getElement());
			
		}

		Hashtable<Integer, Vertex<Integer>> verticesD = matrixGraphND.getVertices();

		for (int i = 1; i <= 5; i++) {
			
			assertEquals(i, verticesD.get(i).getElement());
			
		}

	}

	// ------------------------------------------------------------------------------------

	// TEST ADD VERTEX 2

	@Test
	public void testAddVertex2() throws InvalidAttributesException, IllegalArgumentException {

		setup2();
		
		setup5();

		for (int i = 6; i <= 15; i++) {
			
			assertTrue(matrixGraphND.addVertex(i, i));
			
		}

		for (int i = 6; i <= 15; i++) {
			
			assertTrue(matrixGraphD.addVertex(i, i));
			
		}

		assertFalse(matrixGraphND.addVertex(99, 1));
		
		assertFalse(matrixGraphD.addVertex(99, 1));

		Hashtable<Integer, Vertex<Integer>> verticesND = matrixGraphND.getVertices();

		for (int i = 1; i <= 15; i++) {
			
			assertEquals(i, verticesND.get(i).getElement());
			
		}

		Hashtable<Integer, Vertex<Integer>> verticesD = matrixGraphND.getVertices();

		for (int i = 1; i <= 15; i++) {
			
			assertEquals(i, verticesD.get(i).getElement());
			
		}
		
	}

	// ------------------------------------------------------------------------------------

	// TEST ADD VERTEX 3

	@Test
	public void testAddVertex3() throws InvalidAttributesException, IllegalArgumentException {

		setup3();
		
		setup6();

		for (int i = 6; i <= 15; i++) {
			
			assertTrue(matrixGraphND.addVertex(i, i));
			
		}

		for (int i = 6; i <= 15; i++) {
			
			assertTrue(matrixGraphD.addVertex(i, i));
			
		}

		assertFalse(matrixGraphND.addVertex(99, 1));
		
		assertFalse(matrixGraphD.addVertex(99, 1));

		Hashtable<Integer, Vertex<Integer>> verticesND = matrixGraphND.getVertices();

		for (int i = 1; i <= 15; i++) {
			
			assertEquals(i, verticesND.get(i).getElement());
			
		}

		Hashtable<Integer, Vertex<Integer>> verticesD = matrixGraphND.getVertices();

		for (int i = 1; i <= 15; i++) {
			
			assertEquals(i, verticesD.get(i).getElement());
			
		}

	}

	// ------------------------------------------------------------------------------------

	// TEST ADD EDGE 1
	
	@Test
	public void testAddEdge1() throws InvalidAttributesException, IllegalArgumentException {

		setup1();
		
		setup4();

		assertFalse(matrixGraphND.addEdge(1, 2, 5));
		
		assertFalse(matrixGraphND.addEdge(5, 4, 4));
		
		assertFalse(matrixGraphND.addEdge(2, 3, 8));
		
		assertFalse(matrixGraphND.addEdge(5, 3, 1));
		
		assertFalse(matrixGraphND.addEdge(5, 2, 9));
		
		assertFalse(matrixGraphND.addEdge(3, 1, 6));

		assertFalse(matrixGraphD.addEdge(1, 2, 5));
		
		assertFalse(matrixGraphD.addEdge(5, 4, 4));
		
		assertFalse(matrixGraphD.addEdge(2, 3, 8));
		
		assertFalse(matrixGraphD.addEdge(5, 3, 1));
		
		assertFalse(matrixGraphD.addEdge(5, 2, 9));
		
		assertFalse(matrixGraphD.addEdge(3, 1, 6));

	}

	// ------------------------------------------------------------------------------------

	// TEST ADD EDGE 2

	@Test
	public void testAddEdge2() throws InvalidAttributesException, IllegalArgumentException {

		setup2();
		
		setup5();

		assertTrue(matrixGraphND.addEdge(1, 2, 5));
		
		assertTrue(matrixGraphND.addEdge(5, 4, 4));
		
		assertTrue(matrixGraphND.addEdge(2, 3, 8));
		
		assertTrue(matrixGraphND.addEdge(5, 3, 1));
		
		assertTrue(matrixGraphND.addEdge(5, 2, 9));
		
		assertTrue(matrixGraphND.addEdge(3, 1, 6));

		assertTrue(matrixGraphD.addEdge(1, 2, 5));
		
		assertTrue(matrixGraphD.addEdge(5, 4, 4));
		
		assertTrue(matrixGraphD.addEdge(2, 3, 8));
		
		assertTrue(matrixGraphD.addEdge(5, 3, 1));
		
		assertTrue(matrixGraphD.addEdge(5, 2, 9));
		
		assertTrue(matrixGraphD.addEdge(3, 1, 6));

		Hashtable<Integer, Hashtable<Integer, Integer>> matrixND = matrixGraphND.getWeightMatrix();
		
		Hashtable<Integer, Hashtable<Integer, Integer>> matrixD = matrixGraphD.getWeightMatrix();

		// Vertex1
		Hashtable<Integer,Integer> row = matrixND.get(1);

		assertEquals(5, row.get(2));
		
		assertEquals(6, row.get(3));

		// Vertex 2
		row = matrixND.get(2);

		assertEquals(5, row.get(1));
		
		assertEquals(8, row.get(3));
		
		assertEquals(9, row.get(5));
		
		// Vertex 3
		row = matrixND.get(3);

		assertEquals(6, row.get(1));
		
		assertEquals(8, row.get(2));
		
		assertEquals(1, row.get(5));

		// Vertex 4		
		row = matrixND.get(4);
		
		assertEquals(4, row.get(5));

		// Vertex 5
		row = matrixND.get(5);

		assertEquals(9, row.get(2));
		
		assertEquals(1, row.get(3));
		
		assertEquals(4, row.get(4));
		
		// D
		
		// Vertex1
		row = matrixD.get(1);
		
		assertEquals(5, row.get(2));
		
		// Vertex 2
		row = matrixD.get(2);
		
		assertEquals(8, row.get(3));
		
		// Vertex 3
		row = matrixD.get(3);

		assertEquals(6, row.get(1));
		
		// Vertex 4
		
		// Vertex 5
		row = matrixD.get(5);

		assertEquals(9, row.get(2));
		
		assertEquals(1, row.get(3));
		
		assertEquals(4, row.get(4));
		
	}

	// ------------------------------------------------------------------------------------

	// TEST ADD EDGE 3

	@Test
	public void testAddEdge3() throws InvalidAttributesException, IllegalArgumentException {

		setup3();
		
		setup6();

		assertTrue(matrixGraphND.addEdge(3, 4, 1));
		
		assertTrue(matrixGraphD.addEdge(3, 4, 1));

		Hashtable<Integer, Hashtable<Integer, Integer>> matrixND = matrixGraphND.getWeightMatrix();
		
		Hashtable<Integer, Hashtable<Integer, Integer>> matrixD = matrixGraphD.getWeightMatrix();

		Hashtable<Integer,Integer> row = matrixND.get(3);		
		
		assertEquals(1,row.get(4));
		
		row = matrixND.get(4);
		
		assertEquals(1,row.get(3));
		
		row = matrixD.get(3);		
		
		assertEquals(1,row.get(4));
		
		row = matrixD.get(4);
		
		assertNull(row.get(3));
		
	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE VERTEX 1

	@Test
	public void testRemoveVertex1() {

		setup1();
		
		setup4();

		assertFalse(matrixGraphND.removeVertex(70));
		
		assertFalse(matrixGraphD.removeVertex(70));
		
	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE VERTEX 2

	@Test
	public void testRemoveVertex2() throws InvalidAttributesException, IllegalArgumentException {

		setup2();
		
		setup5();

		assertFalse(matrixGraphND.removeVertex(70));
		
		assertFalse(matrixGraphD.removeVertex(70));
		
		assertTrue(matrixGraphND.removeVertex(1));
		
		assertTrue(matrixGraphD.removeVertex(1));

		assertEquals(4, matrixGraphND.getVertices().size());
		
		assertEquals(4, matrixGraphD.getVertices().size());

		assertNull(matrixGraphND.getVertices().get(1));
		
		assertNull(matrixGraphND.getVertices().get(1));

	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE VERTEX 3

	@Test
	public void testRemoveVertex3() throws InvalidAttributesException, IllegalArgumentException {

		setup3();
		
		setup6();

		assertTrue(matrixGraphND.removeVertex(1));
		
		assertTrue(matrixGraphD.removeVertex(1));

		assertEquals(4, matrixGraphND.getVertices().size());
		
		assertEquals(4, matrixGraphD.getVertices().size());

		assertTrue(matrixGraphD.getWeightMatrix().get(3).isEmpty());
		
		assertEquals(2, matrixGraphND.getWeightMatrix().get(2).size());
		
		assertEquals(2, matrixGraphND.getWeightMatrix().get(3).size());

		for (int i = 2; i <= 5; i++) {
			
			assertTrue(matrixGraphND.removeVertex(i));
			
			assertTrue(matrixGraphD.removeVertex(i));
			
		}

		assertTrue(matrixGraphND.getVertices().isEmpty());
		
		assertTrue(matrixGraphD.getVertices().isEmpty());

		assertTrue(matrixGraphND.getWeightMatrix().isEmpty());
		
		assertTrue(matrixGraphD.getWeightMatrix().isEmpty());
		
	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE EDGE 1

	@Test
	public void testRemoveEdge1() throws InvalidAttributesException, IllegalArgumentException {

		setup1();
		
		setup4();

		assertFalse(matrixGraphND.removeEdge(18, 11));
		
		assertFalse(matrixGraphD.removeEdge(18, 11));
		
	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE EDGE 2

	@Test
	public void testRemoveEdge2() throws InvalidAttributesException, IllegalArgumentException {

		setup2();
		
		setup5();

		assertFalse(matrixGraphND.removeEdge(18, 11));
		
		assertFalse(matrixGraphD.removeEdge(18, 11));
		
		assertFalse(matrixGraphND.removeEdge(1, 5));
		
		assertFalse(matrixGraphD.removeEdge(1, 5));
		
		assertFalse(matrixGraphND.removeEdge(3, 1));
		
		assertFalse(matrixGraphD.removeEdge(3, 1));

	}

	// ------------------------------------------------------------------------------------

	// TEST REMOVE EDGE 3

	@Test
	public void testRemoveEdge3() throws InvalidAttributesException, IllegalArgumentException {

		setup3();
		
		setup6();

		assertTrue(matrixGraphND.removeEdge(1, 2));
		
		assertTrue(matrixGraphD.removeEdge(1, 2));

		assertTrue(matrixGraphND.removeEdge(5, 4));
		
		assertTrue(matrixGraphD.removeEdge(5, 4));

		assertTrue(matrixGraphND.removeEdge(2, 3));
		
		assertTrue(matrixGraphD.removeEdge(2, 3));

		assertTrue(matrixGraphND.removeEdge(5, 3));
		
		assertTrue(matrixGraphD.removeEdge(5, 3));

		assertTrue(matrixGraphND.removeEdge(5, 2));
		
		assertTrue(matrixGraphD.removeEdge(5, 2));

		assertTrue(matrixGraphND.removeEdge(3, 1));
		
		assertTrue(matrixGraphD.removeEdge(3, 1));

		Enumeration<Hashtable<Integer, Integer>> rows = matrixGraphND.getWeightMatrix().elements();

		while (rows.hasMoreElements()) {
			
			Hashtable<Integer, Integer> row = rows.nextElement();

			assertTrue(row.isEmpty());

		}

		rows = matrixGraphD.getWeightMatrix().elements();

		while (rows.hasMoreElements()) {
			
			Hashtable<Integer, Integer> row = rows.nextElement();

			assertTrue(row.isEmpty());

		}

	}

	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENCY LIST 1
	
	@Test
	void testGetAdjacencyList1() {
		
		setup1();
		
		setup4();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListND = matrixGraphND.getAdjacencyList();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListD = matrixGraphD.getAdjacencyList();
		
		assertTrue(adjListND.isEmpty());
		
		assertTrue(adjListD.isEmpty());	
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENCY LIST 2
	
	@Test
	void testGetAdjacencyList2() {
		
		setup2();
		
		setup5();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListND = matrixGraphND.getAdjacencyList();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListD = matrixGraphD.getAdjacencyList();
		
		Set<Vertex<Integer>> verticesND = adjListND.keySet();		
		
		Set<Vertex<Integer>> verticesD = adjListD.keySet();	
		
		for(Vertex<Integer> vertex : verticesND) {
			
			assertTrue(adjListND.get(vertex).isEmpty());
			
		}
		
		for(Vertex<Integer> vertex : verticesD) {
			
			assertTrue(adjListD.get(vertex).isEmpty());
			
		}
		
	}	
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENCY LIST 3
	
	@Test
	void testGetAdjacencyList3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		
		setup6();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListND = matrixGraphND.getAdjacencyList();
		
		Hashtable<Vertex<Integer>, List<Pair<Integer, Vertex<Integer>>>> adjListD = matrixGraphD.getAdjacencyList();
		
		Set<Vertex<Integer>> verticesND = adjListND.keySet();	
		
		Set<Vertex<Integer>> verticesD = adjListD.keySet();	
		
		for (Vertex<Integer> vertex : verticesND) {
			
			List<Pair<Integer, Vertex<Integer>>> list = adjListND.get(vertex);
			
			switch(vertex.getId()) {
			
				case 1:
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(5,new Vertex<Integer>(2,2))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(6,new Vertex<Integer>(3,3))));
					
					break;
					
				case 2:
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(5,new Vertex<Integer>(1,1))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(8,new Vertex<Integer>(3,3))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(9,new Vertex<Integer>(5,5))));
						
					break;
					
				case 3:
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(8,new Vertex<Integer>(2,2))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(1,new Vertex<Integer>(5,5))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(6,new Vertex<Integer>(1,1))));
					
					break;
					
				case 4:
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(4,new Vertex<Integer>(5,5))));	
					
					break;
					
				case 5:
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(4,new Vertex<Integer>(4,4))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(1,new Vertex<Integer>(3,3))));
					
					assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(9,new Vertex<Integer>(2,2))));
					
					break;
					
			}
			
		}
		
		for (Vertex<Integer> vertex : verticesD) {
			
			List<Pair<Integer, Vertex<Integer>>> list = adjListD.get(vertex);
			
			switch(vertex.getId()) {
			
			case 1:
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(5,new Vertex<Integer>(2,2))));
				
				break;
				
			case 2:
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(8,new Vertex<Integer>(3,3))));
				
				break;
				
			case 3:
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(6,new Vertex<Integer>(1,1))));
				break;
				
			case 4:
				
				assertTrue(list.isEmpty());	
				break;
				
			case 5:
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(4,new Vertex<Integer>(4,4))));
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(1,new Vertex<Integer>(3,3))));
				
				assertTrue(list.contains(new Pair<Integer, Vertex<Integer>>(9,new Vertex<Integer>(2,2))));	
				
				break;
				
			}
			
		}	
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET EDGE LIST 1
	
	@Test
	void testGetEdgeList1() {
		
		setup1();
		
		setup4();
		
		assertTrue(matrixGraphND.getEdgeList().isEmpty());
		
		assertNull(matrixGraphND.getEdgeList(1));
		
		assertTrue(matrixGraphD.getEdgeList().isEmpty());
		
		assertNull(matrixGraphD.getEdgeList(1));
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET EDGE LIST 2
	
	@Test
	void testGetEdgeList2() {
		
		setup2();
		
		setup5();
		
		assertTrue(matrixGraphND.getEdgeList().isEmpty());
		
		assertTrue(matrixGraphND.getEdgeList(1).isEmpty());
		
		assertTrue(matrixGraphD.getEdgeList().isEmpty());
		
		assertTrue(matrixGraphD.getEdgeList(1).isEmpty());
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET EDGE LIST 3
	
	@Test
	void testGetEdgeList3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		
		setup6();
		
		List<Edge<Integer>> edgesND1 = matrixGraphND.getEdgeList();
		
		List<Edge<Integer>> edgesND2 = matrixGraphND.getEdgeList(1);
		
		Hashtable<Integer,Vertex<Integer>> verticesND = matrixGraphND.getVertices();
		
		
		List<Edge<Integer>> edgesD1 = matrixGraphD.getEdgeList();
		
		List<Edge<Integer>> edgesD2 = matrixGraphD.getEdgeList(1);
		
		Hashtable<Integer,Vertex<Integer>> verticesD = matrixGraphD.getVertices();
		
		//NDI
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(1),verticesND.get(2),5)));
		
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(5),verticesND.get(4),4)));
		
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(2),verticesND.get(3),8)));
		
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(5),verticesND.get(3),1)));
		
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(5),verticesND.get(2),9)));
		
		assertTrue(edgesND1.contains(new Edge<Integer>(verticesND.get(3),verticesND.get(1),6)));
				
		//NDII		
		assertTrue(edgesND2.contains(new Edge<Integer>(verticesND.get(1),verticesND.get(2),5)));
		
		assertTrue(edgesND2.contains(new Edge<Integer>(verticesND.get(1),verticesND.get(3),6)));
				
		//DI
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(1),verticesD.get(2),5)));
		
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(5),verticesD.get(4),4)));
		
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(2),verticesD.get(3),8)));
		
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(5),verticesD.get(3),1)));
		
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(5),verticesD.get(2),9)));
		
		assertTrue(edgesD1.contains(new Edge<Integer>(verticesD.get(3),verticesD.get(1),6)));
				
		
		//DII
		assertTrue(edgesD2.contains(new Edge<Integer>(verticesD.get(1),verticesD.get(2),5)));
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENT VERTICES 1
	
	@Test
	void testGetAdjacentVertices1() {
		
		setup1();
		
		setup4();
		
		assertNull(matrixGraphND.getAdjacentVertices(1));
		
		assertNull(matrixGraphD.getAdjacentVertices(1));
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENT VERTICES 2
	
	@Test
	void testGetAdjacentVertices2() {
		
		setup2();
		
		setup5();
		
		assertTrue(matrixGraphND.getAdjacentVertices(1).isEmpty());
		
		assertTrue(matrixGraphD.getAdjacentVertices(1).isEmpty());
		
	}
	
	// ------------------------------------------------------------------------------------
	
	// TEST GET ADJACENT VERTICES 3
	
	@Test
	void testGetAdjacentVertices3() throws InvalidAttributesException, IllegalArgumentException {
		
		setup3();
		
		setup6();
		
		List<Vertex<Integer>> adjVerticesND = matrixGraphND.getAdjacentVertices(1);
		
		List<Vertex<Integer>> adjVerticesD = matrixGraphD.getAdjacentVertices(1);
		
		assertTrue(adjVerticesND.contains(new Vertex<Integer>(3,3)));
		
		assertTrue(adjVerticesND.contains(new Vertex<Integer>(2,2)));
		
		assertTrue(adjVerticesD.contains(new Vertex<Integer>(2,2)));
		
		adjVerticesND = (ArrayList<Vertex<Integer>>) matrixGraphND.getAdjacentVertices(99);
		
		adjVerticesD = matrixGraphD.getAdjacentVertices(99);
		
		assertNull(adjVerticesND);
		
		assertNull(adjVerticesD);
		
	}
	
	// ------------------------------------------------------------------------------------

}
