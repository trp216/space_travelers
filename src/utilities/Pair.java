/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package utilities;

public class Pair<K, V> {

	//------------------------------------------------------------------------------------

	// Attributes of the Pair class

	private K key;
	private V value;

	//------------------------------------------------------------------------------------

	// Constructor method of the Pair class

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	//------------------------------------------------------------------------------------

	// Get's methods of the Pair class

	public void setKey(K key) { this.key = key; }
	
	public void setValue(V value) { this.value = value; }

	//------------------------------------------------------------------------------------

	// Set's methods of the Pair class

	public K getKey() { return key; }
	
	public V getValue() { return value; }	
	
	//------------------------------------------------------------------------------------

}
