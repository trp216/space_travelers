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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.NavigationSystem;
import model.PlanetarySystem;
import utilities.Pair;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class SearchAndEditSystemController {
	
	//=====================================================================================================
    //Relations

	private NavigationSystem ns;
	
	private ArrayList<Pair<String,Integer>> civilizationsTemp;

	private ArrayList<String> planetsTemp;
	
	private ArrayList<String> starsTemp;
	
	//=====================================================================================================
    //Constructor

	public SearchAndEditSystemController(NavigationSystem navigationSystem) {

		ns = navigationSystem;
		civilizationsTemp = new ArrayList<>();
		planetsTemp = new ArrayList<>();
		starsTemp = new ArrayList<>();
	}	

	//=====================================================================================================
    //Check boxes
	
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
	private CheckBox starsEditCB;

	//=====================================================================================================
    //Fields and date pickers

	@FXML
	private TextField nameEditText;

	@FXML
	private TextField coordinatesEditText;

	@FXML
	private TextField idEditText;
	
	@FXML
    private TextField newStarTextField;	

    @FXML
    private TextField newCivilizationNameTextField;

    @FXML
    private TextField newPlanetTextField;
	
	@FXML
	private DatePicker discoveryDateEdit;

	//=====================================================================================================
    //Tables

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
	private TableView<Pair<String,String>> tableStars;

	@FXML
	private TableColumn<Pair<String,String>, String> starsColumn;

	//=====================================================================================================
    //Buttons and radio buttons
  
	@FXML
	private Button saveButton;

	@FXML
	private Button removeButton;
	
	@FXML
	private Button resetButton;
	
	@FXML
	private Button searchAndEditButton;	
	
	@FXML
    private Button removeCivilizationButton;

    @FXML
    private Button removePlanetButton;

    @FXML
    private Button removeStarButton;

    @FXML
    private Button addCivilizationButton;

    @FXML
    private Button addPlanetButton;

    @FXML
    private Button addStarButton;
	
	@FXML
	private ToggleGroup tipo;

	@FXML
	private RadioButton t1;   

	@FXML
	private RadioButton t3;

	@FXML
	private RadioButton t2;
		
	
	//=====================================================================================================
    //Initialize method to set up tables
  
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
		starsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		starsColumn.setOnEditCommit(new EventHandler<CellEditEvent<Pair<String,String>,String>>(){
			
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

	//=====================================================================================================
    //Main methods to update planetary system attributes or removing it completely
  
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
					editSelectionAlerts();
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

	@FXML
	void remove(ActionEvent event) {
		
		ns.removePlanetarySystem(Integer.parseInt(idEditText.getText()));
		removeSuccessfulAlert();
		clear();
		updateButtonsAvailability(false, false, false);
		updateValidationsAvailability(false);
		updateCivilizationModificationAvailability(false);
    	updateStarsModificationAvailability(false);
    	updatePlanetsModificationAvailability(false);
    	updateTextFieldsAndDatePickersAvailability(false);
	}
	
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
			updateCivilizationModificationAvailability(false);
	    	updateStarsModificationAvailability(false);
	    	updatePlanetsModificationAvailability(false);
	    	updateTextFieldsAndDatePickersAvailability(false);
			clear();
			saveSuccessfulAlert();
		}		

	}
	
	//=====================================================================================================
    //Methods to update fields content
  
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
		
		tableStars.getItems().clear();
		
		tableStars.setItems(observableList2);
		
		starsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));
		
		//Civilizations
		
		civilizationsTemp = (ArrayList<Pair<String, Integer>>) ps.getCivilizations().clone();
		
		ObservableList<Pair<String,Integer>> observableList3 = FXCollections.observableArrayList(civilizationsTemp);
		
		tableCivilizations.getItems().clear();
		
		tableCivilizations.setItems(observableList3);
		
		civilNameColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,String>("key"));
		civilTypeColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,Integer>("value"));

	}
	
    @FXML
    void resetFields(ActionEvent event) {
    	loadInformation(ns.getCurrentSystem());
    }
    
    //=====================================================================================================
    //Methods to update availability of window elements
  
  	@FXML
  	private void validationNameEdit(ActionEvent event) {

  		nameEditText.setDisable(!nameEditText.isDisable());
  		nameEditText.setText(ns.getCurrentSystem().getName());
  		
  	}

  	@FXML
  	private void validationCoordinatesEdit(ActionEvent event) {

  		coordinatesEditText.setDisable(!coordinatesEditText.isDisable());

  		coordinatesEditText.setText(ns.getCurrentSystem().getCoordinates());

  	}

  	@FXML
  	private void validationDiscoveryDateEdit(ActionEvent event) {

  		discoveryDateEdit.setDisable(!discoveryDateEdit.isDisable());
  		
  		discoveryDateEdit.setValue(ns.getCurrentSystem().getDiscoveryDate());
  	}

  	@FXML
  	private void validationCivilizationsEdit(ActionEvent event) {

  		updateCivilizationModificationAvailability(civilizationsEditCB.isSelected());

  	}

  	@FXML
  	private void validationPlanetsEdit(ActionEvent event) {

  		updatePlanetsModificationAvailability(planetsEditCB.isSelected());

  	}

  	@FXML
  	private void validationStartsEdit(ActionEvent event) {

  		updateStarsModificationAvailability(starsEditCB.isSelected());

  	}

    private void updateTextFieldsAndDatePickersAvailability(boolean areEnable) {
    	nameEditText.setDisable(!areEnable);
    	discoveryDateEdit.setDisable(!areEnable);
    	coordinatesEditText.setDisable(!areEnable);
    }
    
    private void updateValidationsAvailability(boolean areEnable) {
    	nameEditCB.setDisable(!areEnable);
    	discoveryDateEditCB.setDisable(!areEnable);
    	coordinatesEditCB.setDisable(!areEnable);
    	civilizationsEditCB.setDisable(!areEnable);
    	planetsEditCB.setDisable(!areEnable);
    	starsEditCB.setDisable(!areEnable);
    }
    
    private void updateButtonsAvailability(boolean saveIsEnable, boolean removeIsEnable, boolean resetIsEnable) {
    	saveButton.setDisable(!saveIsEnable);
    	removeButton.setDisable(!removeIsEnable);
    	resetButton.setDisable(!resetIsEnable);
    }
    
    private void updateCivilizationModificationAvailability(boolean isEnable) {
    	tableCivilizations.setDisable(!isEnable);
    	t1.setDisable(!isEnable);
    	t2.setDisable(!isEnable);
    	t3.setDisable(!isEnable);
    	newCivilizationNameTextField.setDisable(!isEnable);
    	addCivilizationButton.setDisable(!isEnable);
    	removeCivilizationButton.setDisable(!isEnable);
    }
    
    private void updateStarsModificationAvailability(boolean isEnable) {
    	tableStars.setDisable(!isEnable);
    	newStarTextField.setDisable(!isEnable);
    	addStarButton.setDisable(!isEnable);
    	removeStarButton.setDisable(!isEnable);    	
    }
    
    private void updatePlanetsModificationAvailability(boolean isEnable) {
		tablePlanets.setDisable(!isEnable);
    	newPlanetTextField.setDisable(!isEnable);
    	addPlanetButton.setDisable(!isEnable);
    	removePlanetButton.setDisable(!isEnable);
    }
    
    //=====================================================================================================
    //Method to clear fields
    
    private void clear() {
    	nameEditText.setText("");
    	idEditText.setText("");
    	discoveryDateEdit.setValue(null);
    	coordinatesEditText.setText("");
    	
    	tableCivilizations.getItems().clear();
    	tableStars.getItems().clear();
    	tablePlanets.getItems().clear();
    	
    	civilizationsTemp = new ArrayList<>();
    	starsTemp = new ArrayList<>();
    	planetsTemp = new ArrayList<>();
    	
    	newCivilizationNameTextField.clear();
    	newPlanetTextField.clear();
    	newStarTextField.clear();
    	
    	t1.setSelected(false);
    	t2.setSelected(false);
    	t3.setSelected(false);   
    	nameEditCB.setSelected(false);
    	civilizationsEditCB.setSelected(false);
    	discoveryDateEditCB.setSelected(false);
    	coordinatesEditCB.setSelected(false);
    	planetsEditCB.setSelected(false);
    	starsEditCB.setSelected(false);
    	
    }
    
    //=====================================================================================================
    //Methods to add civilizations, planets and stars
    
    @FXML
    private void addCivilization(ActionEvent event) {
    	try {

			String civilizationName = newCivilizationNameTextField.getText();

			int type = 0 ;

			if(t1.isSelected()) {

				type = 1 ;

			}
			else if(t2.isSelected()) {

				type = 2;

			}
			else if(t3.isSelected()) {

				type = 3;

			}

			if(civilizationName == null || civilizationName.isEmpty() || type == 0) {

				throw new InsufficientInformationException();

			}
			else {

				civilizationsTemp.add(new Pair<String, Integer>(civilizationName, type));
				newCivilizationNameTextField.setText("");
				t1.setSelected(false);
				t2.setSelected(false);
				t3.setSelected(false);
			
				tableCivilizations.getItems().clear();
				tableCivilizations.getItems().addAll(civilizationsTemp);
			}

		}
    	catch(InsufficientInformationException e1) {

			insufficientDataAlert();

		}
    }

    @FXML
    private void addPlanet(ActionEvent event) {
    	try {

			String name = newPlanetTextField.getText();

			if(name.isEmpty()) {

				throw new InsufficientInformationException();

			} else {

				planetsTemp.add(name);				
				newPlanetTextField.clear();
				
				ArrayList<Pair<String,String>> pairs = new ArrayList<>();
				
				for (String planet : planetsTemp) {
					pairs.add(new Pair<String,String>(planet,planet));
				}
				
				
				tablePlanets.getItems().clear();
				tablePlanets.getItems().addAll(FXCollections.observableArrayList(pairs));
				
			}

		} 
    	catch(InsufficientInformationException e1) {

			insufficientDataAlert();

		}
    }

    @FXML
    private void addStar(ActionEvent event) {
    	try {

			String name = newStarTextField.getText();

			if(name.isEmpty()) {

				throw new InsufficientInformationException();

			} else {

				starsTemp.add(name);				
				newStarTextField.clear();
				
				ArrayList<Pair<String,String>> pairs = new ArrayList<>();
				
				for (String star : starsTemp) {
					pairs.add(new Pair<String,String>(star,star));
				}
								
				tableStars.getItems().clear();
				tableStars.getItems().addAll(FXCollections.observableArrayList(pairs));
				
			}

		} 
    	catch(InsufficientInformationException e1) {

			insufficientDataAlert();

		}
    }
    
    //=====================================================================================================
    //Methods to remove civilizations, planets and stars
    
    @FXML
    private void removeSelectedCivilization(ActionEvent event) {
    	Pair<String,Integer> removeCivil = tableCivilizations.getSelectionModel().getSelectedItem();
    	
    	if(removeCivil == null) {
    		elementNotSelectedAlert();
    	}
    	else {
    		civilizationsTemp.remove(removeCivil);
    		tableCivilizations.getItems().remove(removeCivil);
    	}
    
    }

    @FXML
    private void removeSelectedPlanet(ActionEvent event) {
    	Pair<String, String> removePlanetPair = tablePlanets.getSelectionModel().getSelectedItem();
    	
    	if(removePlanetPair == null) {
    		elementNotSelectedAlert();
    	}
    	else {
    		String removePlanet = removePlanetPair.getKey();
    		planetsTemp.remove(removePlanet);
    		tablePlanets.getItems().remove(removePlanetPair);
    	}
    }

    @FXML
    private void removeSelectedStar(ActionEvent event) {
    	Pair<String, String> removeStarPair = tableStars.getSelectionModel().getSelectedItem();
    	
    	if(removeStarPair == null) {
    		elementNotSelectedAlert();
    	}
    	else {
    		String removePlanet = removeStarPair.getKey();
    		starsTemp.remove(removePlanet);
    		tableStars.getItems().remove(removeStarPair);
    	}
    }
    
    //=====================================================================================================
    //Utility Alerts
    
    private void editSelectionAlerts() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Instructions");
		alert.setHeaderText("Make a selection");
		alert.setContentText("Plase select the field of the planetary system that you want to edit");
		alert.showAndWait();
	}
    
    private void elementNotSelectedAlert() {
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No selected element");
		alert.setHeaderText("Please select an element");
		alert.showAndWait();
    }
    
	private void insufficientDataAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("Some necessary fields are empty or in wrong format");
		alert.setContentText("Please fill or correct the necessary fields to continue with the operation");
		alert.showAndWait();
	}
    
	private void systemNotFoundAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Couldn't find the system");
		alert.setContentText("It seems like the specified planetary system does not exist in the program");
		alert.showAndWait();
	}
	   
    private void saveSuccessfulAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success!");
		alert.setHeaderText("Changes saved successfully");
		alert.showAndWait();
    }
    
    private void removeSuccessfulAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success!");
		alert.setHeaderText("System removed successfully");
		alert.showAndWait();
    }
}
