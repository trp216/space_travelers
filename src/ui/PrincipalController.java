/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import model.NavigationSystem;

public class PrincipalController {

	//------------------------------------------------------------------------------------
	
	// RELACION CON LA CLASE PRINCIPAL DEL MODELO

	private NavigationSystem navSys;

	// RELACIONES CON LAS OTRAS CONTROLADORAS
	
	private WelcomeController welcomeC;
	
	private GenerateController generateC;

	private AddSystemController addC;

	private SearchAndEditSystemController searchAndEditC;

	private NavigationController navigationC;

	private UniverseController universeC;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE PRINCIPAL CONTROLLER

	public PrincipalController(NavigationSystem navegationSystem) {

		navSys = navegationSystem;
		
		welcomeC = new WelcomeController(navSys);
		
		generateC = new GenerateController(navSys);

		addC = new AddSystemController(navSys);

		searchAndEditC = new SearchAndEditSystemController(navSys);

		navigationC = new NavigationController(navSys);

		universeC = new UniverseController(navSys);

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
	private AnchorPane navigationAP;
	
    @FXML
    private Tab universe;

    @FXML
    private AnchorPane universeAP;

	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE BIENVENIDA

	public void loadWelcome() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcomeScreen.fxml"));

		fxmlLoader.setController(welcomeC);

		welcomeAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE GENERAR

	public void loadGenerate() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("generateScreen.fxml"));

		fxmlLoader.setController(generateC);

		generateAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE AGREGAR

	public void loadAdd() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addScreen.fxml"));

		fxmlLoader.setController(addC);

		addSystemAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE EDITAR

	public void loadSearchAndEdit() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editScreen.fxml"));

		fxmlLoader.setController(searchAndEditC);

		editSystemAP.getChildren().add(fxmlLoader.load());

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE NAVEGAR

	public void loadNavigation() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("navigationScreen.fxml"));
		
		fxmlLoader.setController(navigationC);
		
		navigationAP.getChildren().clear();
		
		navigationAP.getChildren().add(fxmlLoader.load());
	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA CARGAR LA VENTANA DE UNIVERSO

	public void loadUniverse() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("universeScreen.fxml"));
		
		fxmlLoader.setController(universeC);
		
		universeAP.getChildren().clear();
		
		universeAP.getChildren().add(fxmlLoader.load());
		
		universeC.updateTable();

	}

	//------------------------------------------------------------------------------------
	
	@FXML
	public void initialize() throws IOException {
		
		loadWelcome();
		
		loadGenerate();
		
		loadAdd();
		
		loadSearchAndEdit();
		
		loadNavigation();
		
		loadUniverse();
	}
	
	//------------------------------------------------------------------------------------

}
