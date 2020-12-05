/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import model.NavigationSystem;
import model.PlanetarySystem;
import exceptions.InsufficientInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class NavigationController{
	//------------------------------------------------------------------------------------

	private NavigationSystem ns;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE NAVEGATION CONTROLLER

	public NavigationController(NavigationSystem ns) {

		this.ns = ns;

	}
	
	//------------------------------------------------------------------------------------
	
	// ACCIONES DE JAVA'FX

	@FXML
	private Label actualSystemLabel;

	@FXML
	private TextField objetiveSystemTextField;

	@FXML
	private TableView<String> tableStartsSearch;

	@FXML
	private TableColumn<PlanetarySystem, String> starsColumn;

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
	
	//------------------------------------------------------------------------------------
	
	// SEARCH SYSTEM METHOD

	@FXML
	void searchSystem(ActionEvent event) {

		try {
			
			if(objetiveSystemTextField.getText().equals("")) {
				
				throw new InsufficientInformationException();
				
			} else {
				
				PlanetarySystem p = ns.search(Integer.parseInt(objetiveSystemTextField.getText()));
				
				if(p!=null) {
					
					objetiveSystemName.setText(p.getName());
					
					objetiveSystemDiscoveryDate.setText(p.getDiscoveryDate().toString());
					
					objetiveSystemCoordinates.setText(p.getCoordinates());
					
					objetiveSystemId.setText(p.getId() + "");
					
					objetiveSystemDistance.setText(ns.calculateDistance(ns.getCurrentSystem().getId(), p.getId()) + "");
					
					ObservableList<String> observableList = FXCollections.observableArrayList(p.getStars());
			    	
					tableStartsSearch.setItems(observableList); //
					
					starsColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("name")); //
					
			    	//agregar lo de las tablas
					
				} else {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Couldn't find your search");
					alert.setContentText("It seems like the specified planetary system does not exist in the program");

					alert.showAndWait();
				}
				
			}
			
		}catch(InsufficientInformationException e) {
			
			insufficientDataAlert();
			
		}

	}

	//------------------------------------------------------------------------------------
	
	// INITIALIZE
	
	@FXML
	public void initialize() {
		
		if(ns.getCurrentSystem()!=null) {
			
			actualSystemLabel.setText(ns.getCurrentSystem().getName());
			
		} else {
			
			//improvise a ver
		
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	// INSUFFICIENT DATA ALERT

	@FXML
	void insufficientDataAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("Some necessary fields are empty");
		alert.setContentText("Please fill the missing fields to continue with the operation");

		alert.showAndWait();

	}

	//------------------------------------------------------------------------------------
	
	// CHANGE CURRENT SYSTEM

	@FXML
	void changeCurrentSystem(ActionEvent event) {

	}
	
	//------------------------------------------------------------------------------------
	
}

