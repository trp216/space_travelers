/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SearchSystemController {

	//------------------------------------------------------------------------------------
	
	// METODO CONSTRUCTOR DE LA CLASE SEARCH SYSTEM CONTROLLER

	public SearchSystemController() {

		// TODO VA A AQUI

	}

	//------------------------------------------------------------------------------------

	// POSIBLES ACCIONES DE JAVA FX

	@FXML
	private TextField idSearchEdit;

	@FXML
	private Button searchButton;

	// ***********************************************

	@FXML
	private Label nameLabel;

	@FXML
	private Label coordinatesLabel;

	@FXML
	private Label discoveryDateLabel;

	// ***********************************************

	@FXML
	private TableView<String> tableCivilizationsSearch;

	@FXML
	private TableColumn<String, String> civilizationsSearchColumn;

	@FXML
	private TableView<String> tablePlanetsSearch;

	@FXML
	private TableColumn<String, String> planetsSearchColumn;

	@FXML
	private TableView<String> tableStartsSearch;

	@FXML
	private TableColumn<String, String> startsSearchColumn;

	//------------------------------------------------------------------------------------

	@FXML
	void search(ActionEvent event) {
		
		

	}

	//------------------------------------------------------------------------------------
	
	// METODO INITIALIZE
	
	@FXML
	void initialize() {
		
		nameLabel.setDisable(true);
		
		coordinatesLabel.setDisable(true);
		
		discoveryDateLabel.setDisable(true);
		
		tableCivilizationsSearch.setDisable(true);
		
		tablePlanetsSearch.setDisable(true);
		
		tableStartsSearch.setDisable(true);
		
	}
	
	//------------------------------------------------------------------------------------

}
