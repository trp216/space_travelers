/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import exceptions.InsufficientInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.NavigationSystem;
import model.PlanetarySystem;
import utilities.Pair;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class SearchAndEditSystemController {

	//------------------------------------------------------------------------------------

	// RELACION CON OTRAS CLASES

	private NavigationSystem ns;
	
	private ArrayList<Pair<String,Integer>> civilizationsTemp;

	private ArrayList<String> planetsTemp;
	
	private ArrayList<String> starsTemp;
	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE EDIT SYSTEM CONTROLLER

	public SearchAndEditSystemController(NavigationSystem ns) {

		this.ns = ns;
		civilizationsTemp = new ArrayList<>();
		planetsTemp = new ArrayList<>();
		starsTemp = new ArrayList<>();
	}

	//------------------------------------------------------------------------------------

	/*
	 * POSIBLES ACCIONES DE JAVA FX
	 * ESTA ES LA PARTE DE ARRIBA DE LA VENTANA
	 */

	@FXML
	private TextField idEditText;

	@FXML
	private Button searchAndEditButton;

	// ***********************************************

	// DIFERENTES CHECK BOX PARA VALIDAR EL SISTEMA

	@FXML
	private CheckBox nameEditCB;

	@FXML
	private CheckBox discoveryDateEditCB;

	@FXML
	private CheckBox coordinatesEditCB;

	@FXML
	private CheckBox civilizationsEditCB;

	@FXML
	private CheckBox planetsEditCB;

	@FXML
	private CheckBox startsEditCB;

	// ***********************************************

	// SE EMPIEZA LA EDICION DE ALGUNOS TEXTOS Y FECHAS

	@FXML
	private TextField nameEditText;

	@FXML
	private TextField coordinatesEditText;

	@FXML
	private DatePicker discoveryDateEdit;

	// ***********************************************

	// TABLAS PARA VISUALIZAR Y EDITAR LA INFORMACION

	@FXML
	private TableView<Pair<String,Integer>> tableCivilizations;

    @FXML
    private TableColumn<Pair<String,Integer>, String> civilNameColumn;

    @FXML
    private TableColumn<Pair<String,Integer>, Integer> civilTypeColumn;

	@FXML
	private TableView<Pair<String,String>> tablePlanets;

	@FXML
	private TableColumn<Pair<String,String>, String> planetsColumn;

	@FXML
	private TableView<Pair<String,String>> tableStarts;

	@FXML
	private TableColumn<Pair<String,String>, String> startsColumn;

	// ***********************************************

	// BOTON FINAL PARA EDITAR

	@FXML
	private Button saveButton;

	@FXML
	private Button removeButton;
	
	@FXML
	private Button resetButton;


	//------------------------------------------------------------------------------------

	// METODO PARA BUSCAR Y EDITAR UN SISTEMA

	@FXML
	void search(ActionEvent event) {

		try {

			if(idEditText.getText().equals("")) {

				throw new InsufficientInformationException();

			}
			else {

				PlanetarySystem ps = ns.search(Integer.parseInt(idEditText.getText()));

				if(ps != null) {
					
					loadInformation(ps);					
					editSelection();
					updateValidationsAvailability(true);
					updateButtonsAvailability(true, true, true);
				}
				else {
					systemNotFoundAlert();
				}

			}

		}
		catch(InsufficientInformationException e) {
			insufficientDataAlert();
		}
		catch(Exception ex) {
			systemNotFoundAlert();
		}

	}

	private void systemNotFoundAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Couldn't find the system");
		alert.setContentText("It seems like the specified planetary system does not exist in the program");

		alert.showAndWait();
	}

	@SuppressWarnings("unchecked")
	void loadInformation(PlanetarySystem ps) {
		//name
		nameEditText.setText(ps.getName());

		//Coordinates
		coordinatesEditText.setText(ps.getCoordinates());

		//Discovery date
		discoveryDateEdit.setValue(ps.getDiscoveryDate());

		//Planets
		
		planetsTemp = (ArrayList<String>) ps.getPlanets().clone();
		
		ArrayList<Pair<String,String>> pairs = new ArrayList<>();
		
		for (String planet : planetsTemp) {
			pairs.add(new Pair<String,String>(planet,planet));
		}
		
		ObservableList<Pair<String,String>> obsArrayList1 = FXCollections.observableArrayList(pairs);
		
		tablePlanets.getItems().clear();
		
		tablePlanets.setItems(obsArrayList1);	
		
		planetsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));									

		//Stars
		starsTemp = (ArrayList<String>) ps.getStars().clone();
		
		pairs = new ArrayList<>();
		
		for (String star : starsTemp) {
			pairs.add(new Pair<String,String>(star,star));
		}
		
		ObservableList<Pair<String,String>> observableList2 = FXCollections.observableArrayList(pairs);
		
		tableStarts.getItems().clear();
		
		tableStarts.setItems(observableList2);
		
		startsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));
		
		//Civilizations
		
		civilizationsTemp = (ArrayList<Pair<String, Integer>>) ps.getCivilizations().clone();
		
		ObservableList<Pair<String,Integer>> observableList3 = FXCollections.observableArrayList(civilizationsTemp);
		
		tableCivilizations.getItems().clear();
		
		tableCivilizations.setItems(observableList3);
		
		civilNameColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,String>("key"));
		civilTypeColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,Integer>("value"));

	}
	
	//------------------------------------------------------------------------------------

	// INSUFFICIENT DATA ALERT

	@FXML
	void insufficientDataAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("Some necessary fields are empty or in wrong format");
		alert.setContentText("Please fill or correct the necessary fields to continue with the operation");

		alert.showAndWait();

	}

	//------------------------------------------------------------------------------------

	// EDIT SELECTION

	void editSelection() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Instructions");
		alert.setHeaderText("Make a selection");
		alert.setContentText("Plase select the field of the planetary system that you want to edit");

		alert.showAndWait();

	}
	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR EL NOMBRE (FUTURA EDICION)

	@FXML
	void validationNameEdit(ActionEvent event) {

		nameEditText.setDisable(!nameEditText.isDisable());
		nameEditText.setText(ns.getCurrentSystem().getName());
		
	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS COORDENADAS (FUTURA EDICION)

	@FXML
	void validationCoordinatesEdit(ActionEvent event) {

		coordinatesEditText.setDisable(!coordinatesEditText.isDisable());

		coordinatesEditText.setText(ns.getCurrentSystem().getCoordinates());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LA FECHA DE DESCUBRIMIENTO (FUTURA EDICION)

	@FXML
	void validationDiscoveryDateEdit(ActionEvent event) {

		discoveryDateEdit.setDisable(!discoveryDateEdit.isDisable());
		
		discoveryDateEdit.setValue(ns.getCurrentSystem().getDiscoveryDate());
	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS CIVILIZACIONES (FUTURA EDICION)

	@FXML
	void validationCivilizationsEdit(ActionEvent event) {

		tableCivilizations.setDisable(!tableCivilizations.isDisable());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LOS PLANETAS (FUTURA EDICION)

	@FXML
	void validationPlanetsEdit(ActionEvent event) {

		tablePlanets.setDisable(!tablePlanets.isDisable());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS ESTRELLAS (FUTURA EDICION)

	@FXML
	void validationStartsEdit(ActionEvent event) {

		tableStarts.setDisable(!tableStarts.isDisable());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA EDITAR FINAL

	@FXML
	void saveChanges(ActionEvent event) {
		
		String name = nameEditText.getText();			
		String[] splitCoordinates = coordinatesEditText.getText().trim().split(",");		
		LocalDate discDate = discoveryDateEdit.getValue();
		PlanetarySystem currentSystem = ns.getCurrentSystem();
			
		if(name.isEmpty() 
				|| splitCoordinates == null 
				|| splitCoordinates.length != 3 
				|| discDate == null 
				|| civilizationsTemp.isEmpty()
				|| planetsTemp.isEmpty()
				|| starsTemp.isEmpty()) {
				
			insufficientDataAlert();
				
		}	
		else {
			currentSystem.setName(name);
			
			currentSystem.setDiscoveryDate(discoveryDateEdit.getValue());
			
			int coordX = Integer.parseInt(splitCoordinates[0]);			
			int coordY = Integer.parseInt(splitCoordinates[1]);			
			int coordZ = Integer.parseInt(splitCoordinates[2]);
			
			currentSystem.setCoordinates(coordX, coordY, coordZ);			
			ns.updateEdges(currentSystem);
			
			currentSystem.setCivilizations(civilizationsTemp);
			
			currentSystem.setPlanets(planetsTemp);
			
			currentSystem.setStars(starsTemp);
			
			updateValidationsAvailability(false);
			updateButtonsAvailability(false, false, false);
			clear();
			saveSuccessfulAlert();
		}		

	}

	//------------------------------------------------------------------------------------

	// METODO PARA REMOVER FINAL

	@FXML
	void remove(ActionEvent event) {
		
		ns.removePlanetarySystem(Integer.parseInt(idEditText.getText()));
		removeSuccessfulAlert();
		clear();
		updateButtonsAvailability(false, false, false);
		updateValidationsAvailability(false);		

	}

	//------------------------------------------------------------------------------------

	// METODO INITIALIZE

	@FXML
	void initialize() {

		//Set up of editable civilizations table
		civilNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		civilTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));		
		civilNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Pair<String,Integer>,String>>(){
		
			@Override
			public void handle(CellEditEvent<Pair<String, Integer>, String> event) {
				
				String newName = event.getNewValue();
				String oldName = event.getOldValue();
				
				boolean replace = false;
				
				for(int i = 0; i < civilizationsTemp.size() && !replace;i++) {
					
					Pair<String,Integer> civil = civilizationsTemp.get(i);
					
					if(civil.getKey().equals(oldName)) {	
						civilizationsTemp.set(i, new Pair<String,Integer>(newName, civil.getValue()));
						replace = true;
					}
				}
						
			}
			
		});
		
		civilTypeColumn.setOnEditCommit(new EventHandler<CellEditEvent<Pair<String,Integer>,Integer>>(){
			
			@Override
			public void handle(CellEditEvent<Pair<String, Integer>, Integer> event) {
				
				Integer newType = event.getNewValue();
				Integer oldType = event.getOldValue();
				
				boolean replace = false;
				
				for(int i = 0; i < civilizationsTemp.size() && !replace;i++) {
					
					Pair<String,Integer> civil = civilizationsTemp.get(i);
					
					if(civil.getValue().equals(oldType)) {	
						civilizationsTemp.set(i, new Pair<String,Integer>(civil.getKey(), newType));
						replace = true;
					}
				}
				
				
						
			}
			
		});
		
		//Set up of editable planets table
		planetsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		planetsColumn.setOnEditCommit(new EventHandler<CellEditEvent<Pair<String,String>,String>>(){
			
			@Override
			public void handle(CellEditEvent<Pair<String, String>, String> event) {
				
				String newName = event.getNewValue();
				String oldName = event.getOldValue();
				
				boolean replace = false;
				
				for(int i = 0; i < planetsTemp.size() && !replace;i++) {															
					if(planetsTemp.get(i).equals(oldName)) {	
						planetsTemp.set(i, newName);
						replace = true;
					}
				}						
			}
			
		});
		
		//Set up of editable s table
		startsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		startsColumn.setOnEditCommit(new EventHandler<CellEditEvent<Pair<String,String>,String>>(){
			
			@Override
			public void handle(CellEditEvent<Pair<String, String>, String> event) {
				
				String newName = event.getNewValue();
				String oldName = event.getOldValue();
				
				boolean replace = false;
				
				for(int i = 0; i < starsTemp.size() && !replace;i++) {															
					if(starsTemp.get(i).equals(oldName)) {	
						starsTemp.set(i, newName);
						replace = true;
					}
				}						
			}
			
		});		

	}

	//------------------------------------------------------------------------------------
    
    @FXML
    void resetFields(ActionEvent event) {
    	loadInformation(ns.getCurrentSystem());
    }
    
    void updateValidationsAvailability(boolean areEnable) {
    	nameEditCB.setDisable(!areEnable);
    	discoveryDateEditCB.setDisable(!areEnable);
    	coordinatesEditCB.setDisable(!areEnable);
    	civilizationsEditCB.setDisable(!areEnable);
    	planetsEditCB.setDisable(!areEnable);
    	startsEditCB.setDisable(!areEnable);
    }
    
    void updateButtonsAvailability(boolean saveIsEnable, boolean removeIsEnable, boolean resetIsEnable) {
    	saveButton.setDisable(!saveIsEnable);
    	removeButton.setDisable(!removeIsEnable);
    	resetButton.setDisable(!resetIsEnable);
    }
    
    void clear() {
    	nameEditText.setText("");
    	idEditText.setText("");
    	discoveryDateEdit.setValue(null);
    	coordinatesEditText.setText("");
    	tableCivilizations.getItems().clear();   
    	tableCivilizations.setDisable(true);
    	tableStarts.getItems().clear();
    	tableStarts.setDisable(true);
    	tablePlanets.getItems().clear();
    	tablePlanets.setDisable(true);
    	civilizationsTemp = new ArrayList<>();
    	starsTemp = new ArrayList<>();
    	planetsTemp = new ArrayList<>();
    }
    
    void saveSuccessfulAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success!");
		alert.setHeaderText("Changes saved successfully");
		alert.showAndWait();
    }
    
    void removeSuccessfulAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success!");
		alert.setHeaderText("System removed successfully");
		alert.showAndWait();
    }
}
