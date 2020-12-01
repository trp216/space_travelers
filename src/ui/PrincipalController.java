/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;

public class PrincipalController {
	
	//------------------------------------------------------------------------------------
	
	// RELACIONES CON LAS OTRAS CONTROLADORAS
	
	private AddSystemController controladoraAgregar;
	
	private EditSystemController controladoraEditar;
	
	private SearchSystemController controladoraBuscar;
	
	private NavegationController controladoraNavegar;
	
	private UniverseController controladoraUniverso;
	
	//------------------------------------------------------------------------------------
	
	// METODO CONSTRUCTOR DE LA CLASE PRINCIPAL CONTROLLER

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
	
	// ***********************************************
	
	// PRIMERA PANTALLA DEL SISTEMA
	
    @FXML
    private ToggleGroup tipoGrafo;
	
    @FXML
    private RadioButton tipo1;

    @FXML
    private RadioButton tipo2;
    
    @FXML
    private Button tipoGrafoButton;

	//------------------------------------------------------------------------------------
    
    // METODO SELECT GRAFO
    
    @FXML
    void selectGrafo(ActionEvent event) {
    	
    	

    }
	
	//------------------------------------------------------------------------------------

}
