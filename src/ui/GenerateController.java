/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javax.naming.directory.InvalidAttributesException;

import exceptions.InsufficientInformationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.NavigationSystem;

public class GenerateController {

	//------------------------------------------------------------------------------------

	private NavigationSystem ns;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE GENERATE CONTROLLER

	public GenerateController(NavigationSystem ns) {

		this.ns = ns;

	}

	//------------------------------------------------------------------------------------

	// ACCIONES DEL JAVA FX

	@FXML
	private TextField numberElementsGenerate;

	@FXML
	private Button generateButton;

	//------------------------------------------------------------------------------------

	// METODO GENERAR DE LA CLASE GENERATE CONTROLLER

	@FXML
	void generate(ActionEvent event) throws NumberFormatException, InvalidAttributesException, IllegalArgumentException {

		try {
			
			if(numberElementsGenerate.getText().equals("")) {
				
				throw new InsufficientInformationException();
				
			} else {
				
				ns.generateSystems(Integer.parseInt(numberElementsGenerate.getText()));
				
			}
			
		} catch(InsufficientInformationException e) {
			
			insufficientDataAlert();
			
		}

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
	
}
