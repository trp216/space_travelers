/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import model.NavigationSystem;

public class PrincipalController {

	//------------------------------------------------------------------------------------

	private NavigationSystem ns;

	// RELACIONES CON LAS OTRAS CONTROLADORAS
	
	private GenerateController controladoraGenerar;

	private AddSystemController controladoraAgregar;

	private EditSystemController controladoraEditar;

	private SearchSystemController controladoraBuscar;

	private NavegationController controladoraNavegar;

	private UniverseController controladoraUniverso;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE PRINCIPAL CONTROLLER

	public PrincipalController(NavigationSystem ns) {

		this.ns = ns;
		
		controladoraGenerar = new GenerateController(ns);

		controladoraAgregar = new AddSystemController(ns);

		controladoraEditar = new EditSystemController(ns);

		controladoraBuscar = new SearchSystemController(ns);

		controladoraNavegar = new NavegationController(ns);

		controladoraUniverso = new UniverseController(ns);

	}

	//------------------------------------------------------------------------------------

	// ACCIONES QUE SE USAN EN EL JAVAFX

	@FXML
	private Tab welcome;

	@FXML
	private AnchorPane welcomeAP;
	
	@FXML
	private Tab generateTAB;

	@FXML
	private AnchorPane generateAP;
	
	@FXML
	private Tab addSystemTab;

	@FXML
	private AnchorPane addSystemAP;

	@FXML
	private Tab editSystem;

	@FXML
	private AnchorPane editSystemAP;

	@FXML
	private Tab searchSystem;

	@FXML
	private AnchorPane searchSystemAP;

	@FXML
	private Tab navegation;

	@FXML
	private AnchorPane navegationAP;

	@FXML
	private Tab universe;

	@FXML
	private AnchorPane universeAP;

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
	
	// METODO PARA CARGAR LA VENTANA DE BIENVENIDA

	public void loadWelcome() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaBienvenida.fxml"));

		fxmlLoader.setController(this);

		welcomeAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE GENERAR

	public void loadGenerate() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaGenerar.fxml"));

		fxmlLoader.setController(controladoraGenerar);

		generateAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE AGREGAR

	public void loadAdd() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaAgregar.fxml"));

		fxmlLoader.setController(controladoraAgregar);

		addSystemAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE EDITAR

	public void loadEdit() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaEditar.fxml"));

		fxmlLoader.setController(controladoraEditar);

		editSystemAP.getChildren().add(fxmlLoader.load());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA CARGAR LA VENTANA DE EDITAR

	public void loadSearh() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaBuscar.fxml"));

		fxmlLoader.setController(controladoraBuscar);

		searchSystemAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE NAVEGAR

	public void loadNavegation() throws IOException {

		

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE UNIVERSO

	public void loadUniverse() throws IOException {

		

	}
	
	//------------------------------------------------------------------------------------

	// METODO SELECT GRAFO

	@FXML
	void selectGrafo(ActionEvent event) {



	}

	//------------------------------------------------------------------------------------
	
	@FXML
	public void initialize() throws IOException {
		
		loadWelcome();
		
		loadGenerate();
		
		loadAdd();
		
		loadEdit();
		
		loadSearh();
		
	}
	
	//------------------------------------------------------------------------------------

}
