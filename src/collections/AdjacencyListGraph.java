package collections;

import java.util.Hashtable;
import java.util.List;

import utilities.Pair;

public class AdjacencyListGraph<V extends Vertex> implements Graph<V>{
	
	@Override
	public boolean addVertex(V vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2, int weight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(V vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<V>> getWeightMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable<V, List<Pair<Integer, V>>> getAdjacencyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> getEdgeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> getEdgeList(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable<V, V> getVertexList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> getAdjacentVertices(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

}
