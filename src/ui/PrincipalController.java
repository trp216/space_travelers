/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class PrincipalController {
	
	//------------------------------------------------------------------------------------
	
	private AddSystemController controladoraAgregar;
	
	private EditSystemController controladoraEditar;
	
	private SearchSystemController controladoraBuscar;
	
	private NavegationController controladoraNavegar;
	
	private UniverseController controladoraUniverso;
	
	//------------------------------------------------------------------------------------

	public PrincipalController() {

		controladoraAgregar = new AddSystemController();

		controladoraEditar = new EditSystemController();

		controladoraBuscar = new SearchSystemController();

		controladoraNavegar = new NavegationController();

		controladoraUniverso = new UniverseController();

	}

	//------------------------------------------------------------------------------------

	// ACCIONES QUE SE USAN EN EL JAVAFX

	@FXML
	private Tab welcome;

	@FXML
	private Tab addSystemTab;

	@FXML
	private Tab editSystem;

	@FXML
	private Tab searchSystem;

	@FXML
	private Tab navegation;

	@FXML
	private Tab universe;

	//------------------------------------------------------------------------------------

}
