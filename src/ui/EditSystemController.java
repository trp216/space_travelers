/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import exceptions.InsufficientInformationException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert.AlertType;

public class EditSystemController {

	//------------------------------------------------------------------------------------

	private NavigationSystem ns;
	
	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE EDIT SYSTEM CONTROLLER

	public EditSystemController(NavigationSystem ns) {

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
	private TableView<String> tableCivilizations;

	@FXML
	private TableColumn<String, String> civilizationsColumn;

	@FXML
	private TableView<String> tablePlanets;

	@FXML
	private TableColumn<String, String> planetsColumn;

	@FXML
	private TableView<String> tableStarts;

	@FXML
	private TableColumn<String, String> startsColumn;

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
			}
			else {
				PlanetarySystem p = ns.search(Integer.parseInt(idEditText.getText()));
				if(p!=null) {
					editSelection();
				}
				else {
					
				}
			}
		}catch(InsufficientInformationException e) {
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
	
	@FXML
	void editSelection() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Instructions");
		alert.setHeaderText("Make a selection");
		alert.setContentText("Plase select the field of the planetary system that you want to edit");

		alert.showAndWait();

	}
	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR EL NOMBRE (FUTURA EDICION)

	@FXML
	void validationNameEdit(ActionEvent event) {

		nameEditText.setDisable(false);
		nameEditText.setText(ns.getCurrentSystem().getName());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS COORDENADAS (FUTURA EDICION)

	@FXML
	void validationCoordinatesEdit(ActionEvent event) {

		coordinatesEditText.setDisable(false);
		
		coordinatesEditText.setText(ns.getCurrentSystem().getCoordinates());

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LA FECHA DE DESCUBRIMIENTO (FUTURA EDICION)

	@FXML
	void validationDiscoveryDateEdit(ActionEvent event) {

		discoveryDateEdit.setDisable(false);
	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS CIVILIZACIONES (FUTURA EDICION)

	@FXML
	void validationCivilizationsEdit(ActionEvent event) {

		tableCivilizations.setDisable(false);

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LOS PLANETAS (FUTURA EDICION)

	@FXML
	void validationPlanets(ActionEvent event) {

		tablePlanets.setDisable(false);

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS ESTRELLAS (FUTURA EDICION)

	@FXML
	void validationStars(ActionEvent event) {

		tableStarts.setDisable(false);

	}

	//------------------------------------------------------------------------------------

	// METODO PARA EDITAR FINAL

	@FXML
	void edit(ActionEvent event) {

		if(!nameEditText.getText().equals("")) {
			ns.getCurrentSystem().setName(nameEditText.getText());
		}
		if(!coordinatesEditText.getText().equals("")){
			ns.getCurrentSystem().setCoordinates(coordinatesEditText.getText());
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
			}
			else {
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
		tableCivilizations.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				editCivilizationName(newValue);
				
			}
			
		});
		
		tablePlanets.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				editStarName(newValue);
			}
			
		});
		
		tableStarts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				editPlanetName(newValue);
			}
			
		});
		
		
	}

	//------------------------------------------------------------------------------------
	
	@FXML
	void validationPlanetsEdit(ActionEvent event) {

	}
	
	//------------------------------------------------------------------------------------
	
    @FXML
    void validationStartsEdit(ActionEvent event) {

    }
    
    //------------------------------------------------------------------------------------
    
    void editCivilizationName(String oldName) {
    	
    }
    
    void editStarName(String oldName) {
    	
    }
 
 	void editPlanetName(String oldName) {
 	
 	}
}
