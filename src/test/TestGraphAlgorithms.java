package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.naming.directory.InvalidAttributesException;

import org.junit.jupiter.api.Test;

import collections.AdjacencyListGraph;
import collections.Graph;
import collections.MatrixGraph;

class TestGraphAlgorithms {

	Graph<Integer> matrixGraphND;	
	Graph<Integer> adjListGraphND;
	
	Graph<Integer> matrixGraphD;	
	Graph<Integer> adjListGraphD;
	
	void setup1() {
		matrixGraphND = new MatrixGraph<Integer>(false,true);
	
		adjListGraphND = new AdjacencyListGraph<Integer>(false,true);
	}
	
	void setup2() {
		setup1();
		
		for (int i = 1; i <= 5; i++) {			
			matrixGraphND.addVertex(i,i);
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
		
		matrixGraphND.addEdge(1,2,5);
		matrixGraphND.addEdge(5,4,4);
		matrixGraphND.addEdge(2,3,8);
		matrixGraphND.addEdge(5,3,1);
		matrixGraphND.addEdge(5,2,9);
		matrixGraphND.addEdge(3,1,6);		
	}
	
	void setup4() {
		
		matrixGraphND = new MatrixGraph<Integer>(true,true);
		
		adjListGraphND = new AdjacencyListGraph<Integer>(true,true);
			
	}
	
	void setup5() {
		setup4();
		
		for (int i = 1; i <= 5; i++) {			
			matrixGraphD.addVertex(i,i);
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
		
		matrixGraphD.addEdge(1,2,5);
		matrixGraphD.addEdge(5,4,4);
		matrixGraphD.addEdge(2,3,8);
		matrixGraphD.addEdge(5,3,1);
		matrixGraphD.addEdge(5,2,9);
		matrixGraphD.addEdge(3,1,6);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
