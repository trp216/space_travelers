/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import model.NavigationSystem;
import model.PlanetarySystem;
import utilities.Pair;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class NavigationController{

	//------------------------------------------------------------------------------------

	// RELATION WITH ANOTHER CLASS

	private NavigationSystem ns;

	private PlanetarySystem foundPS;

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
	private TableView<Pair<String,String>> starsTable;

	@FXML
	private TableColumn<Pair<String,String>, String> starsColumn;

	@FXML
	private TableView<Pair<String,String>> planetsTable;

	@FXML
	private TableColumn<Pair<String,String>, String> planetsColumn;

	@FXML
	private TableView<Pair<String,Integer>> civilizationsTable;

	@FXML
	private TableColumn<Pair<String,Integer>, String> civilizationsNameColumn;

	@FXML
	private TableColumn<Pair<String,Integer>, Integer> civilizationsTypeColumn;

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
	private Button moveButton;

	//------------------------------------------------------------------------------------

	// SEARCH SYSTEM METHOD

	@FXML
	void searchSystem(ActionEvent event) {

		try {

			if(objetiveSystemTextField.getText().equals("")) {

				throw new InsufficientInformationException();

			} else {

				PlanetarySystem oPS = ns.search(Integer.parseInt(objetiveSystemTextField.getText()));

				if(oPS != null) {

					loadInformation(oPS);	

					foundPS = oPS;

					moveButton.setDisable(false);

				} else {

					systemNotFoundAlert();

				}

			}

		} catch(InsufficientInformationException e) {

			insufficientDataAlert();

		} catch(Exception ex) {

			systemNotFoundAlert();

		}

	}

	//------------------------------------------------------------------------------------
	
	// LOAD INFORMATION METHOD

	@SuppressWarnings("unchecked")
	private void loadInformation(PlanetarySystem oPS) {
		
		// Name
		
		objetiveSystemName.setText(oPS.getName());

		// Coordinates
		
		objetiveSystemCoordinates.setText(oPS.getCoordinates());

		// Discovery date
		
		objetiveSystemDiscoveryDate.setText(oPS.getDiscoveryDate().toString());

		// Planets

		ArrayList<String> planetsTemp = (ArrayList<String>) oPS.getPlanets().clone();

		ArrayList<Pair<String,String>> pairs = new ArrayList<>();

		for (String planet : planetsTemp) {
			
			pairs.add(new Pair<String,String>(planet,planet));
			
		}

		ObservableList<Pair<String,String>> obsArrayList1 = FXCollections.observableArrayList(pairs);

		planetsTable.getItems().clear();

		planetsTable.setItems(obsArrayList1);	

		planetsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));									

		// Stars
		
		ArrayList<String> starsTemp = (ArrayList<String>) oPS.getStars().clone();

		pairs = new ArrayList<>();

		for (String star : starsTemp) {
			
			pairs.add(new Pair<String,String>(star,star));
			
		}

		ObservableList<Pair<String,String>> observableList2 = FXCollections.observableArrayList(pairs);

		starsTable.getItems().clear();	
		
		starsTable.setItems(observableList2);

		starsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));

		// Civilizations

		ArrayList<Pair<String, Integer>> civilizationsTemp = (ArrayList<Pair<String, Integer>>) oPS.getCivilizations().clone();

		ObservableList<Pair<String,Integer>> observableList3 = FXCollections.observableArrayList(civilizationsTemp);

		civilizationsTable.getItems().clear();		
		
		civilizationsTable.setItems(observableList3);

		civilizationsNameColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,String>("key"));
		
		civilizationsTypeColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,Integer>("value"));

		try {
			
			objetiveSystemDistance.setText("" + ns.calculateDistance(ns.getCurrentLocationSystem().getId(), oPS.getId()));
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		objetiveSystemId.setText("" + oPS.getId());

	}

	//------------------------------------------------------------------------------------

	// INITIALIZE

	@FXML
	public void initialize() {

		if(ns.getCurrentLocationSystem()!=null) {

			actualSystemLabel.setText(ns.getCurrentLocationSystem().getName());

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

		ns.setCurrentLocationPlanetarySystem(foundPS);
		
		actualSystemLabel.setText(ns.getCurrentLocationSystem().getName());
		
		foundPS = null;
		
		clear();
		
		moveButton.setDisable(true);
		
	}

	//------------------------------------------------------------------------------------
	
	// SYSTEM NOT FOUND ALERT METHOD
	
	private void systemNotFoundAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Couldn't find the system");
		alert.setContentText("It seems like the specified planetary system does not exist in the program");
		
		alert.showAndWait();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// CLEAR METHOD

	private void clear() {
		
		objetiveSystemTextField.clear();
		
		civilizationsTable.getItems().clear();
		
		starsTable.getItems().clear();
		
		planetsTable.getItems().clear();
		
		objetiveSystemName.setText("...");
		
		objetiveSystemDiscoveryDate.setText("...");
		
		objetiveSystemId.setText("...");
		
		objetiveSystemCoordinates.setText("...");
		
		objetiveSystemDistance.setText("...");	
		
	}
	
	//------------------------------------------------------------------------------------
	
}

