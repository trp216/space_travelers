package test;

import static org.junit.jupiter.api.Assertions.*;

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
	
	void setup3() {
		
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
	
	void setup6() {
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
