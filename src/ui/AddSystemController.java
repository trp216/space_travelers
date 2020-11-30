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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AddSystemController {

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE ADD SYSTEM CONTROLLER

	public AddSystemController() {

		// TODO VA A AQUI

	}

	//------------------------------------------------------------------------------------

	/*
	 * ACCIONES EN EL JAVA FX
	 *ESTA ES LA PARTE DE ARRIBA DE LA VENTANA
	 */

	@FXML
	private TextField nameText;

	@FXML
	private DatePicker discorveryDate;

	@FXML
	private TextField coordinatesText;

	// ***********************************************

	// ESTA ES LA MITAD DE LA PANTALLA (FUNCIONA PARA VALIDAR ALGUNAS DISPONIBILIDADES)

	@FXML
	private CheckBox civilizationsCB;

	@FXML
	private CheckBox planetsCB;

	@FXML
	private CheckBox startsCB;

	// ***********************************************

	// ACCIONES DE JAVA FX PARA AGREGAR CIVILIZACIONES

	@FXML
	private TextField civilizationsText;

	@FXML
	private ToggleGroup tipo;

	@FXML
	private RadioButton t1;

	@FXML
	private RadioButton t2;

	@FXML
	private RadioButton t3;

	@FXML
	private Button civilizationButton;

	// ***********************************************

	// ACCIONES DE JAVA FX PARA AGREGAR PLANETAS

	@FXML
	private TextField planetsText;

	@FXML
	private Button planetButton;

	// ***********************************************

	// ACCIONES DE JAVA FX PARA AGREGAR ESTRELLAS

	@FXML
	private TextField startsText;

	@FXML
	private Button startButton;

	// ***********************************************

	@FXML
	private Button systemButtton;

	//------------------------------------------------------------------------------------
	
	// METODO DE VALIDACION EN EL CHECK BOX 1

	@FXML
	void validationCivilizations(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO DE VALIDACION EN EL CHECK BOX 2

	@FXML
	void validationPlanets(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO DE VALIDACION EN EL CHECK BOX 2

	@FXML
	void validationStars(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------
	
	// METODO PARA AGREGAR UNA CIVILIZACION

	@FXML
	void addCivilization(ActionEvent event) {

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA AGREGAR UN PLANETA

	@FXML
	void addPlanet(ActionEvent event) {

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO PARA AGREGAR UNA ESTRELLA

	@FXML
	void addStart(ActionEvent event) {

	}
	
	//------------------------------------------------------------------------------------
	
	// METODO FINAL PARA AGREGAR UN SISTEMA

	@FXML
	void addSystem(ActionEvent event) {

	}

	//------------------------------------------------------------------------------------

}
