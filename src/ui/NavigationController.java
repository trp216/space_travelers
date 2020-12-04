/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import model.NavigationSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class NavigationController{
//------------------------------------------------------------------------------------
	
	private NavigationSystem ns;
	
	//------------------------------------------------------------------------------------
	
	// METODO CONSTRUCTOR DE LA CLASE NAVEGATION CONTROLLER
	
	public NavigationController(NavigationSystem ns) {
		
		this.ns = ns;
		
	}
	

	
	@FXML
	private Label actualSystemLabel;

	@FXML
	private TextField objetiveSystemTextField;

	@FXML
	private TableView<?> tableStartsSearch;

	@FXML
	private TableColumn<?, ?> starsColumn;

	@FXML
	private TableView<?> tablePlanetsSearch;

	@FXML
	private TableColumn<?, ?> planetsColumn;

	@FXML
	private TableView<?> tableCivilizationsSearch;

	@FXML
	private TableColumn<?, ?> civilizationsNameColumn;

	@FXML
	private TableColumn<?, ?> civilizationsTypeColumn;

	@FXML
	private Label objetiveSystemName;

	@FXML
	private Label objetiveSystemDiscoveryDate;

	@FXML
	private Label objetiveSystemCoordinates;

	@FXML
	private Label objetiveSystemId;

	@FXML
	private Label objetiveSystemDistance;

	@FXML
	void searchSystem(ActionEvent event) {
	    	
	}
	
	@FXML
    void changeCurrentSystem(ActionEvent event) {

    }
}

