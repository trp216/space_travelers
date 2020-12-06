/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import exceptions.InsufficientInformationException;
import exceptions.InsufficientPlanetsAndStars;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.NavigationSystem;
import utilities.Pair;

public class AddSystemController {

	//------------------------------------------------------------------------------------
	
	// RELATION WITH ANOTHER CLASS

	private NavigationSystem ns;
	
	private ArrayList<String> stars;
	
	private ArrayList<String> planets;
	
	private ArrayList<Pair<String,Integer>> civilizations;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE ADD SYSTEM CONTROLLER

	public AddSystemController(NavigationSystem navegationSystem) {

		stars = new ArrayList<>();
		
		planets = new ArrayList<>();
		
		civilizations = new ArrayList<>();		
		
		this.ns = navegationSystem;

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
	private TextField starsText;

	@FXML
	private Button starButton;

	// ***********************************************

	@FXML
	private Button systemButtton;

	//------------------------------------------------------------------------------------

	// METODO PARA AGREGAR UNA CIVILIZACION

	@FXML
	void addCivilization(ActionEvent event) {

		try {

			String civilizationName = civilizationsText.getText();

			int type = 0 ;

			if(t1.isSelected()) {

				type = 1 ;

			} else if(t2.isSelected()) {

				type = 2;

			} else if(t3.isSelected()) {

				type = 3;

			}

			if(civilizationName == null || civilizationName.isEmpty() || type == 0) {

				throw new InsufficientInformationException();

			} else {

				civilizations.add(new Pair<String, Integer>(civilizationName, type));

				civilizationsText.setText("");

				t1.setSelected(false);

				t2.setSelected(false);

				t3.setSelected(false);

			}

		} catch(InsufficientInformationException e1) {

			missingDataAlert();

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

				planets.add(name);
				
				planetsText.setText("");

			}

		} catch(InsufficientInformationException e1) {

			missingStarAndPlanetsAlert();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO PARA AGREGAR UNA ESTRELLA

	@FXML
	void addStar(ActionEvent event) {

		try {

			String name = starsText.getText();

			if(name.isEmpty()) {

				throw new InsufficientInformationException();

			} else {

				stars.add(name);

				starsText.setText("");

			}

		} catch(InsufficientInformationException e1) {

			missingDataAlert();

		}

	}

	//------------------------------------------------------------------------------------

	// METODO FINAL PARA AGREGAR UN SISTEMA

	@FXML
	void addSystem(ActionEvent event) {

		try {

			int coordX, coordY, coordZ;
			
			String name = nameText.getText();

			LocalDate date = discorveryDate.getValue();

			String coordinates = coordinatesText.getText();			
			
			String[] splitCoordinates = coordinates.split(",");			
			
			coordX = Integer.parseInt(splitCoordinates[0]);
			
			coordY = Integer.parseInt(splitCoordinates[1]);			
			
			coordZ = Integer.parseInt(splitCoordinates[2]);
			
			if(name.isEmpty() || date == null || coordinates == null) {

				throw new InsufficientInformationException();

			} else if(planets.size() == 0 || stars.size() == 0) {

				throw new InsufficientPlanetsAndStars();

			} else {
				
				int id = ns.addPlanetarySystem(name, date, coordX, coordY, coordZ, civilizations, planets, stars);
				
				successAlert(id);
				
				clear(new ActionEvent());
				
			}

		} catch(InsufficientInformationException e1) {

			missingDataAlert();

		} catch(InsufficientPlanetsAndStars e2) {

			missingStarAndPlanetsAlert();

		} catch(NumberFormatException ex) {
			missingDataAlert();
		
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

	//------------------------------------------------------------------------------------

	// MENSAJE DE DATOS INSUFICIENTES

	@FXML
	void missingDataAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Missing Information");
		alert.setContentText("Please check fot empty fields and fill them");
		
		alert.showAndWait();
		
	}

	//------------------------------------------------------------------------------------

	// MENSAJE DE PLANETAS Y ESTRELLAS INSUFICENTES

	@FXML
	void missingStarAndPlanetsAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Missing stars and/or planets");
		alert.setContentText("Planetary system must have at least 1 star and 1 planet, please add more");
		
		alert.showAndWait();
		
	}

	//------------------------------------------------------------------------------------
	
	// CLEAR METHOD
	
	@FXML
	void clear(ActionEvent event) {
		
		nameText.setText("");

		discorveryDate.setValue(null);

		coordinatesText.setText("");

		t1.setSelected(false);

		t2.setSelected(false);

		t3.setSelected(false);

		civilizationsText.setText("");

		planetsText.setText("");

		starsText.setText("");
		
		stars = new ArrayList<>();
		
		planets = new ArrayList<>();
		
		civilizations = new ArrayList<>();	
		
		successClear();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// SUCCESS CLEAR METHOD
	
	void successClear() {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Information has been cleared succesfully");
		alert.setTitle("Information Cleared!");
		
		alert.showAndWait();
		
	}
	
	//------------------------------------------------------------------------------------
	
	// SUCESS ALERT METHOD
	
	void successAlert(int id) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Planetary system added succesfully with id: " + id);
		alert.setTitle("Information");
		
		alert.showAndWait();
		
	}
	
	//------------------------------------------------------------------------------------
	
}
