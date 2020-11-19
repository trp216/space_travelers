package collections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import utilities.Pair;

public class AdjacencyListGraph<V> implements Graph<V>{
	
	Hashtable<V, List<Pair<Integer, V>>>  adList;
	
	@Override
	public boolean addVertex(V vertex) {
		boolean added = false;
		
		//agregar if no se ha agregado el vertice antes
		if(adList.get(vertex)==null){
			adList.put(vertex, new ArrayList<Pair<Integer,V>>());
			added = true;
		}
		
		return added;
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
	public Hashtable<V, Hashtable<V, Integer>> getWeightMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable<V, List<Pair<Integer, V>>> getAdjacencyList() {
		// TODO Auto-generated method stub
		return adList;
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
