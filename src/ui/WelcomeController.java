/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.NavigationSystem;

public class WelcomeController {

	//------------------------------------------------------------------------------------
	
	//Relations of class WelcomeController
	
	private NavigationSystem navSys;
	
	//------------------------------------------------------------------------------------

	//Constructor of class WelcomeController
	
	public WelcomeController(NavigationSystem navigationSystem) {
		navSys = navigationSystem;
	}
	
	//------------------------------------------------------------------------------------

	@FXML
	private AnchorPane welcomeAP;

	@FXML
	private RadioButton tipo1;

	@FXML
	private ToggleGroup tipoGrafo;

	@FXML
	private RadioButton tipo2;

	@FXML
	private Button tipoGrafoButton;

	//------------------------------------------------------------------------------------
	
	@FXML
	void selectGrafo(ActionEvent event) {

		if(tipo1.isSelected()) {
			navSys.graphSelected(true);
			success();
		}
		else if(tipo2.isSelected()) {
			navSys.graphSelected(false);
			success();
		}
		else {
			insufficientDataAlert();
		}

	}
	
	//------------------------------------------------------------------------------------
	
	@FXML
	void success() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Done");
		alert.setHeaderText("The software has been configurated");
		alert.setContentText("Please proceed to the generation tab");

		alert.showAndWait();

	}
	
	//------------------------------------------------------------------------------------
	
	@FXML
	void insufficientDataAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("Some necessary fields are empty");
		alert.setContentText("Please fill the missing fields to continue with the operation");

		alert.showAndWait();

	}
	
	//------------------------------------------------------------------------------------

	@FXML
	void initialize() {

	}
	
	//------------------------------------------------------------------------------------
}
