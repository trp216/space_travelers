/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.time.LocalDate;
import exceptions.InsufficientInformationException;
import exceptions.InsufficientPlanetsAndStars;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.NavigationSystem;
import model.PlanetarySystem;

public class AddSystemController {

	//------------------------------------------------------------------------------------

	private PlanetarySystem planetarySystem;

	private NavigationSystem navegationSystem;

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

		if(civilizationsCB.isSelected()) {

			civilizationsText.setDisable(false);

			t1.setDisable(false);

			t2.setDisable(false);

			t3.setDisable(false);

			civilizationButton.setDisable(false);

		} else {

			civilizationsText.setDisable(true);

			t1.setDisable(true);

			t2.setDisable(true);

			t3.setDisable(true);

			civilizationButton.setDisable(true);

		}

	}

	//------------------------------------------------------------------------------------

	// METODO DE VALIDACION EN EL CHECK BOX 2

	@FXML
	void validationPlanets(ActionEvent event) {

		if(planetsCB.isSelected()) {

			planetsText.setDisable(false);

			planetButton.setDisable(false);

		} else {

			planetsText.setDisable(true);

			planetButton.setDisable(true);

		}

	}

	//------------------------------------------------------------------------------------

	// METODO DE VALIDACION EN EL CHECK BOX 2

	@FXML
	void validationStars(ActionEvent event) {

		if(startsCB.isSelected()) {

			startsText.setDisable(false);

			startButton.setDisable(false);

		} else {

			startsText.setDisable(true);

			startButton.setDisable(true);

		}

	}

	//------------------------------------------------------------------------------------

	// METODO PARA AGREGAR UNA CIVILIZACION

	@FXML
	void addCivilization(ActionEvent event) {

		try {

			String nombreCivilizacion = civilizationsText.getText();

			int tipo = 0 ;

			if(t1.isSelected()) {

				tipo = 1 ;

			} else if(t2.isSelected()) {

				tipo = 2;

			} else if(t3.isSelected()) {

				tipo = 3;

			}

			if(nombreCivilizacion.isEmpty() || tipo == 0) {

				throw new InsufficientInformationException();

			} else {

				planetarySystem.addCivilization(nombreCivilizacion, tipo);

				civilizationsText.setText("");

				civilizationsText.setDisable(true);

				civilizationButton.setDisable(true);

				t1.setSelected(false);

				t1.setDisable(true);

				t2.setSelected(false);

				t2.setDisable(true);

				t3.setSelected(false);

				t3.setDisable(true);

			}

		} catch(InsufficientInformationException e1) {

			mensajeDatosInsuficientes();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO PARA AGREGAR UN PLANETA

	@FXML
	void addPlanet(ActionEvent event) {

		try {

			String name = planetsText.getText();

			if(name.isEmpty()) {

				throw new InsufficientInformationException();

			} else {

				planetarySystem.addplanet(name);

				planetButton.setDisable(true);

				planetsText.setDisable(true);

				planetsText.setText("");

			}

		} catch(InsufficientInformationException e1) {

			mensajeDatosInsuficientes();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO PARA AGREGAR UNA ESTRELLA

	@FXML
	void addStart(ActionEvent event) {

		try {

			String name = startsText.getText();

			if(name.isEmpty()) {

				throw new InsufficientInformationException();

			} else {

				planetarySystem.addStart(name);

				startsText.setText("");

				startsText.setDisable(true);

				startButton.setDisable(true);

			}

		} catch(InsufficientInformationException e1) {

			mensajeDatosInsuficientes();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO FINAL PARA AGREGAR UN SISTEMA

	@FXML
	void addSystem(ActionEvent event) {

		try {

			String name = nameText.getText();

			LocalDate date = discorveryDate.getValue();

			Integer coordinates = Integer.parseInt(coordinatesText.getText());

			if(name.isEmpty() || date == null || coordinates == null) {

				throw new InsufficientInformationException();

			} else if(planetarySystem.getPlanets().size() == 0 || planetarySystem.getStars().size() == 0) {

				throw new InsufficientPlanetsAndStars();

			} else {

				navegationSystem.addPlanetarySystem(name, date, coordinates);

				nameText.setText("");

				discorveryDate.setValue(null);

				coordinatesText.setText("");

				t1.setDisable(true);

				t1.setSelected(false);

				t2.setDisable(true);

				t2.setSelected(false);

				t3.setDisable(true);

				t3.setSelected(false);

				// *******************************************

				civilizationsText.setText("");

				civilizationsText.setDisable(true);

				civilizationButton.setDisable(true);

				t1.setSelected(false);

				t1.setDisable(true);

				t2.setSelected(false);

				t2.setDisable(true);

				t3.setSelected(false);

				t3.setDisable(true);

				// *******************************************

				planetarySystem.addplanet(name);

				planetButton.setDisable(true);

				planetsText.setDisable(true);

				planetsText.setText("");

				// *******************************************

				planetarySystem.addStart(name);

				startsText.setText("");

				startsText.setDisable(true);

				startButton.setDisable(true);

			}

		} catch(InsufficientInformationException e1) {

			mensajeDatosInsuficientes();

		} catch(InsufficientPlanetsAndStars e2) {

			mensajePlanetasEstrellasInsuficientes();

		}

	}

	//------------------------------------------------------------------------------------

	// MENSAJE DE DATOS INSUFICIENTES

	@FXML
	void mensajeDatosInsuficientes() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("We can't add to the system");
		alert.setContentText("Check if the data is well digitized");

		alert.showAndWait();

	}

	//------------------------------------------------------------------------------------

	// MENSAJE DE PLANETAS Y ESTRELLAS INSUFICENTES

	@FXML
	void mensajePlanetasEstrellasInsuficientes() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Sorry");
		alert.setHeaderText("We can't add to the system");
		alert.setContentText("Please add planets and stars");

		alert.showAndWait();

	}

	//------------------------------------------------------------------------------------

	// METODO INITILIAZE

	@FXML
	void initialize() {

		civilizationsText.setDisable(true);

		planetsText.setDisable(true);

		startsText.setDisable(true);

		t1.setDisable(true);

		t2.setDisable(true);

		t3.setDisable(true);

		civilizationButton.setDisable(true);

		planetButton.setDisable(true);

		startButton.setDisable(true);

	}

	//------------------------------------------------------------------------------------

}
