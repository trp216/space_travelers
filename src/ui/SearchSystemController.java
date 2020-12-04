/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.util.ArrayList;
import exceptions.InsufficientInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import model.NavigationSystem;
import model.PlanetarySystem;

public class SearchSystemController {

	//------------------------------------------------------------------------------------

	private NavigationSystem ns;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE SEARCH SYSTEM CONTROLLER

	public SearchSystemController(NavigationSystem ns) {

		this.ns = ns;

	}

	//------------------------------------------------------------------------------------

	// POSIBLES ACCIONES DE JAVA FX

	@FXML
	private TextField idSearchText;

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
	private TableColumn<PlanetarySystem, String> civilizationsSearchColumn;

	@FXML
	private TableView<String> tablePlanetsSearch;

	@FXML
	private TableColumn<PlanetarySystem, String> planetsSearchColumn;

	@FXML
	private TableView<String> tableStartsSearch;

	@FXML
	private TableColumn<PlanetarySystem, String> startsSearchColumn;

	//------------------------------------------------------------------------------------

	@FXML
	void search(ActionEvent event) {

		PlanetarySystem pn = null;

		try {
			
			if(idSearchText.getText().equals("")) {
				
				throw new InsufficientInformationException();
				
			} else {
				
				pn = ns.search(Integer.parseInt(idSearchText.getText()));

				if(pn!=null) {
					
					enable();

					//name
					nameLabel.setText(pn.getName());

					//Coordinates
					coordinatesLabel.setText(pn.getCoordinates());

					//Discovery date
					discoveryDateLabel.setText(pn.getDiscoveryDate().toString());

					//Planets
					ObservableList<String> observableList1 = FXCollections.observableArrayList(pn.getPlanets());
					
					tablePlanetsSearch.setItems(observableList1);
					
					planetsSearchColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("planets"));

					//Stars
					ObservableList<String> observableList2 = FXCollections.observableArrayList(pn.getStars());
					
					tablePlanetsSearch.setItems(observableList2);
					
					planetsSearchColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("stars"));

					//Civilizations
					ArrayList<String> aux = new ArrayList<String>();
					
					for(int i = 0;i<aux.size();i++) {
						
						aux.add(pn.getCivilizations().get(i).getKey());
						
					}
					
					ObservableList<String> observableList3 = FXCollections.observableArrayList(aux);
					
					tablePlanetsSearch.setItems(observableList3);
					
					planetsSearchColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("planets"));

				} else {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Couldn't find your search");
					alert.setContentText("It seems like the specified planetary system does not exist in the program");

					alert.showAndWait();
				}
				
			}

		} catch(InsufficientInformationException e) {
			
			insufficientDataAlert();
			
		}

	}

	//------------------------------------------------------------------------------------
	
	// INSUFFIENT DATA ALERT JAVA

	@FXML
	void insufficientDataAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("Some necessary fields are empty");
		alert.setContentText("Please fill the missing fields to continue with the operation");

		alert.showAndWait();

	}

	//------------------------------------------------------------------------------------
	
	// ENABLE METHOD

	@FXML
	void enable() {

		nameLabel.setDisable(false);

		coordinatesLabel.setDisable(false);

		discoveryDateLabel.setDisable(false);

		tableCivilizationsSearch.setDisable(false);

		tablePlanetsSearch.setDisable(false);

		tableStartsSearch.setDisable(false);

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
