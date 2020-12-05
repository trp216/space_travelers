/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.util.ArrayList;
import java.util.List;
import exceptions.InsufficientInformationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.NavigationSystem;
import model.PlanetarySystem;
import utilities.Pair;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchAndEditSystemController {

	//------------------------------------------------------------------------------------

	// RELACION CON OTRAS CLASES

	private NavigationSystem ns;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE EDIT SYSTEM CONTROLLER

	public SearchAndEditSystemController(NavigationSystem ns) {

		this.ns = ns;

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
	private Button editButton;

	@FXML
	private Button removeButton;

	//------------------------------------------------------------------------------------

	// METODO PARA BUSCAR Y EDITAR UN SISTEMA

	@FXML
	void searchAndEdit(ActionEvent event) {

		try {

			if(idEditText.getText().equals("")) {

				throw new InsufficientInformationException();

			} else {

				PlanetarySystem ps = ns.search(Integer.parseInt(idEditText.getText()));

				if(ps != null) {

					editSelection();
					
					//name
					nameEditText.setText(ps.getName());

					//Coordinates
					coordinatesEditText.setText(ps.getCoordinates());

					//Discovery date
					discoveryDateEdit.setValue(ps.getDiscoveryDate());

					//Planets
					
					List<String> planets = ps.getPlanets();
					
					ArrayList<Pair<String,String>> pairs = new ArrayList<>();
					
					for (String planet : planets) {
						pairs.add(new Pair<String,String>(planet,planet));
					}
					
					ObservableList<Pair<String,String>> obsArrayList1 = FXCollections.observableArrayList(pairs);
					
					tablePlanets.setItems(obsArrayList1);	
					
					planetsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));									

					//Stars
					List<String> stars = ps.getStars();
					
					pairs = new ArrayList<>();
					
					for (String star : stars) {
						pairs.add(new Pair<String,String>(star,star));
					}
					
					ObservableList<Pair<String,String>> observableList2 = FXCollections.observableArrayList(pairs);
					
					tableStarts.setItems(observableList2);
					
					startsColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,String>,String>("value"));
					
					//Civilizations
					
					
					ObservableList<Pair<String,Integer>> observableList3 = FXCollections.observableArrayList(ps.getCivilizations());
					
					tableCivilizations.setItems(observableList3);
					
					civilNameColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,String>("key"));
					civilTypeColumn.setCellValueFactory(new PropertyValueFactory<Pair<String,Integer>,Integer>("value"));

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
		catch(Exception ex) {
			ex.printStackTrace();
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

	// EDIT SELECTION

	@FXML
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
	void validationPlanets(ActionEvent event) {

		tablePlanets.setDisable(!tablePlanets.isDisable());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS ESTRELLAS (FUTURA EDICION)

	@FXML
	void validationStars(ActionEvent event) {

		tableStarts.setDisable(!tableStarts.isDisable());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA EDITAR FINAL

	@FXML
	void edit(ActionEvent event) {

		if(!nameEditText.getText().equals("")) {

			ns.getCurrentSystem().setName(nameEditText.getText());

		}

		if(!coordinatesEditText.getText().equals("")){			
			
			String[] splitCoordinates = coordinatesEditText.getText().split(",");
			
			int coordX = Integer.parseInt(splitCoordinates[0]);
			
			int coordY = Integer.parseInt(splitCoordinates[1]);
			
			int coordZ = Integer.parseInt(splitCoordinates[2]);
			
			ns.getCurrentSystem().setCoordinates(coordX, coordY, coordZ);

		}

		if(discoveryDateEdit.getValue()!=null) {

			ns.getCurrentSystem().setDiscoveryDate(discoveryDateEdit.getValue());

		}

	}

	//------------------------------------------------------------------------------------

	// METODO PARA REMOVER FINAL

	@FXML
	void remove(ActionEvent event) {

		try {

			if(idEditText.getText().equals("")) {

				throw new InsufficientInformationException();

			} else {

				ns.removePlanetarySystem(Integer.parseInt(idEditText.getText()));

			}

		}catch(InsufficientInformationException e) {

			insufficientDataAlert();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO INITIALIZE

	@FXML
	void initialize() {

		nameEditText.setDisable(true);

		coordinatesEditText.setDisable(true);

		discoveryDateEdit.setDisable(true);

		tableCivilizations.setDisable(true);

		tablePlanets.setDisable(true);

		tableStarts.setDisable(true);


		//Listeners of changes in selected item of each table
		

	}

	//------------------------------------------------------------------------------------
	
	// VALIDATION PLANETS EDIT

	@FXML
	void validationPlanetsEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// VALIDATION STARTS EDIT

	@FXML
	void validationStartsEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// EDIT CIVILIATION NAME

	void editCivilizationName(String oldName) {

	}

	//------------------------------------------------------------------------------------
	
	// EDIT STAR NAME

	void editStarName(String oldName) {

	}

	//------------------------------------------------------------------------------------
	
	// EDIT PLANET NAME

	void editPlanetName(String oldName) {

	}

	//------------------------------------------------------------------------------------
	
}
