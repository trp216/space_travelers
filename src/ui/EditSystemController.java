/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EditSystemController {

	//------------------------------------------------------------------------------------

	public EditSystemController() {

		// METODO CONTRUCTOR

		// TODO VA A AQUI

	}

	//------------------------------------------------------------------------------------

	/*
	 * POSIBLES ACCIONES DE JAVA FX PARA LA TERCERA PANTALLA
	 * ESTA ES LA PARTE DE ARRIBA DE LA VENTANA
	 */

	@FXML
	private TextField nameEditSAE;

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

	//------------------------------------------------------------------------------------

	// METODO PARA BUSCAR Y EDITAR UN SISTEMA

	@FXML
	void searchAndEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR EL NOMBRE (FUTURA EDICION)

	@FXML
	void validationNameEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------

	// METODO PARA VALIDAR LAS COORDENADAS (FUTURA EDICION)

	@FXML
	void validationCoordinatesEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA VALIDAR LA FECHA DE DESCUBRIMIENTO (FUTURA EDICION)

	@FXML
	void validationDiscoveryDateEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA VALIDAR LAS CIVILIZACIONES (FUTURA EDICION)

	@FXML
	void validationCivilizationsEdit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA VALIDAR LOS PLANETAS (FUTURA EDICION)

	@FXML
	void validationPlanets(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA VALIDAR LAS ESTRELLAS (FUTURA EDICION)

	@FXML
	void validationStars(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA EDITAR FINAL

	@FXML
	void edit(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	@FXML
	void initialize() {
		
		nameEditText.setDisable(true);
		
		coordinatesEditText.setDisable(true);
		
		discoveryDateEditCB.setDisable(true);
		
		tableCivilizations.setDisable(true);
		
		tablePlanets.setDisable(true);
		
		tableStarts.setDisable(true);
		
	}
	
	//------------------------------------------------------------------------------------

}
