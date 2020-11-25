/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnionFind<E> {

	//------------------------------------------------------------------------------------

	// Attributes of class UnionFind

	private HashMap<E,HashMap<E,E>> sets;

	//------------------------------------------------------------------------------------

	// Constructor of class UnionFind

	public UnionFind(){	

		sets = new HashMap<E,HashMap<E,E>>();

	}

	//------------------------------------------------------------------------------------

	// Make set method

	public boolean makeSet(E element){	

		if(findSet(element) == null) {		

			HashMap<E,E> map = new HashMap<>();

			map.put(element, element);

			sets.put(element, map);

			return true;

		} else {

			return false;

		}

	}

	//------------------------------------------------------------------------------------

	// Find set method

	public E findSet(E element){	

		if(sets.get(element) == null) {	

			E representative = null;

			boolean found = false;	

			for(Map.Entry<E,HashMap<E,E>> entry : sets.entrySet()) {				

				if(!found) {

					if(entry.getValue().containsKey(element)) {

						representative = entry.getKey();	

						found = true;

					}

				}else {

					break;

				}

			}	

			return representative;

		}else { 

			return element;

		}

	}

	//------------------------------------------------------------------------------------

	// Get set method

	public ArrayList<E> getSet(E elemento) {		

		E representative = findSet(elemento); 

		if(representative != null) { 

			Set<E> s = sets.get(representative).keySet();

			ArrayList<E> elementos = new ArrayList<>();

			for(E key  : s)

				elementos.add(key);	

			return elementos;	

		} else

			return null;

	}

	//------------------------------------------------------------------------------------
	
	// Union method
	
	public boolean union(E conjunto1, E conjunto2) {		
		
		E c1 = findSet(conjunto1);
		
		E c2 = findSet(conjunto2);		
		
		if(c1 != null && c2 != null) {			
			
			HashMap <E,E> mainSet = sets.get(c1);
			
			Set<E> elementos = sets.get(c2).keySet();		
			
			sets.remove(c2);			
			
			for(E e : elementos)
			
				mainSet.put(e, c1);		
			
			return true;

		} else

			return false;		
	
	}

	//------------------------------------------------------------------------------------
	
	// Size method

	public int size() {
		return sets.size();
	}

	//------------------------------------------------------------------------------------

}
