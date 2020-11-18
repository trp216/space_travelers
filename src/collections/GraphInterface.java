/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 2
 * MARTINEZ - DIAZ - RODAS
 */

package collections;

public interface GraphInterface<B> {
		
	//------------------------------------------------------------------------------------
	
	public boolean addVertex(GraphInterface<B> graph, B vertex) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean addEdge(GraphInterface<B> graph, B v1, B v2, int weight) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean addEdge(GraphInterface<B> graph, B v1, B v2) ;
	
	//------------------------------------------------------------------------------------
		
	public boolean isEmpty(GraphInterface<B> graph) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean removeVertex(GraphInterface<B> graph, B vertex) ;
	
	//------------------------------------------------------------------------------------
	
	public boolean removeEdge(GraphInterface<B> graph, B v1, B v2) ;
	
	//------------------------------------------------------------------------------------
	
	public B search(GraphInterface<B> graph) ;
	
	//------------------------------------------------------------------------------------
	
	public int[][] getWeightedMatrix() ;
	
	//------------------------------------------------------------------------------------

}
