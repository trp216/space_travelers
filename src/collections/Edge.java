package collections;

public class Edge<E> {

	private Vertex<E> vertex1;
	
	private Vertex<E> vertex2;
	
	private int weight;

	public Edge(Vertex<E> vertex1, Vertex<E> vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public Vertex<E> getVertex1() {
		return vertex1;
	}

	public Vertex<E> getVertex2() {
		return vertex2;
	}

	public int getWeight() {
		return weight;	}
	
	
	
}
