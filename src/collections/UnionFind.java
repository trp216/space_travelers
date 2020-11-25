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

	// ATRIBUTO DE LA CLASE UNION FIND

	private HashMap<E,HashMap<E,E>> conjuntos;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE UNION FIND

	public UnionFind(){	

		conjuntos = new HashMap<E,HashMap<E,E>>();

	}

	//------------------------------------------------------------------------------------

	// METODO MAKE SET

	/**
	 * CREA UN CONJUNTO DISYUNTO
	 * @PARAM element ELEMENTO QUE REPRESENTARA EL CONJUNTO
	 */

	public boolean makeSet(E element){	

		if(findSet(element) == null) {		

			HashMap<E,E> map = new HashMap<>();

			map.put(element, element);

			conjuntos.put(element, map);

			return true;

		} else {

			return false;

		}

	}

	//------------------------------------------------------------------------------------

	// METODO FIND SET

	/**
	 * BUSCA EL REPRESENTANTE DEL CONJUNTO AL QUE PERTENECE EL ELEMENTO
	 * @param element
	 * @return EL REPRESENTANTE DE UN CONJUNTO O NULL SI NO PERTENECE A NINGUN CONJUNTO
	 */

	public E findSet(E element){	

		if(conjuntos.get(element) == null) {	

			E representante = null;

			boolean found = false;	

			for(Map.Entry<E,HashMap<E,E>> entry : conjuntos.entrySet()) {				

				if(!found) {

					if(entry.getValue().containsKey(element)) {

						representante = entry.getKey();	

						found = true;

					}

				}else {

					break;

				}

			}	

			return representante;

		}else { 

			return element;

		}

	}

	//------------------------------------------------------------------------------------

	// METODO GET SET

	/**
	 * RETORNA LOS ELEMENTOS DE UN CONJUNTO
	 * @param ELEMENTO DE UN CONJUNTo
	 * @RETURN LOS ELEMENTOS DEL CONJUNTO O NULL SI NO HAY CONJUNTO
	 */

	public ArrayList<E> getSet(E elemento) {		

		E representante = findSet(elemento); 

		if(representante != null) { 

			Set<E> conjunto = conjuntos.get(representante).keySet();

			ArrayList<E> elementos = new ArrayList<>();

			for(E key  : conjunto)

				elementos.add(key);	

			return elementos;	

		} else

			return null;

	}

	//------------------------------------------------------------------------------------
	
	// METODO UNION DE LA CLASE UNION FIND
	
	/**
	 * UNE METE TODOS LOS ELEMENTOS DEL CONJUNTO 2 AL CONJUNTO 1
	 * @param CONJUNTO 1
	 * @param CONJUNTO 2
	 * @return TRUE SI SE UNIERON LOS CONJUNTOS	 
	 */
	
	public boolean union(E conjunto1, E conjunto2) {		
		
		E c1 = findSet(conjunto1);
		
		E c2 = findSet(conjunto2);		
		
		if(c1 != null && c2 != null) {			
			
			HashMap <E,E> conjuntoPrincipal = conjuntos.get(c1);
			
			Set<E> elementos = conjuntos.get(c2).keySet();		
			
			conjuntos.remove(c2);			
			
			for(E e : elementos)
			
				conjuntoPrincipal.put(e, c1);		
			
			return true;

		} else

			return false;		
	
	}

	//------------------------------------------------------------------------------------
	
	// METODO SIZE DE LA CLASE UNION FIND

	public int size() {
		return conjuntos.size();
	}

	//------------------------------------------------------------------------------------

}
