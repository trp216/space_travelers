/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.NavigationSystem;
import model.PlanetarySystem;

public class UniverseController {

	//------------------------------------------------------------------------------------

	// RELACION CON LA CLASE PRINCIPAL DEL MODELO

	private NavigationSystem navSys;

	//------------------------------------------------------------------------------------

	// METODO CONSTRUCTOR DE LA CLASE UNIVERSE CONTROLLER

	public UniverseController(NavigationSystem navigationSystem) {

		navSys = navigationSystem;

	}

	//------------------------------------------------------------------------------------

	// POSIBLES ACCIONES DE JAVA FX

	@FXML
	private TableView<PlanetarySystem> systemsTableView;

	@FXML
	private TableColumn<PlanetarySystem, String> nameColumn;

	@FXML
	private TableColumn<PlanetarySystem, String> coordinatesColumn;

	@FXML
	private TableColumn<PlanetarySystem, String> idColumn;

	@FXML
	private TableColumn<PlanetarySystem, LocalDate> discoveryDateColumn;

	@FXML
	private TableColumn<PlanetarySystem, Integer> civilizationNumberColumn;

	@FXML
	private TableColumn<PlanetarySystem, Integer> starsNumberColumn;

	@FXML
	private TableColumn<PlanetarySystem, Integer> planetNumberColumn;


	//------------------------------------------------------------------------------------
	
	// UPDATE TABLE METHOD

	public void updateTable() {

	}

	//------------------------------------------------------------------------------------

}
