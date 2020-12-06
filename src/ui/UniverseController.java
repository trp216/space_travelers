/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableColumn<PlanetarySystem, Integer> idColumn;

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
	@FXML
	void updateTable(ActionEvent event) {
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("name"));
		
		coordinatesColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,String>("coordinates"));
		
		idColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,Integer>("id"));
		
		discoveryDateColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,LocalDate>("discoveryDate"));
		
		civilizationNumberColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,Integer>("civilizationsNumber"));
		
		starsNumberColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,Integer>("starsNumber"));
		
		planetNumberColumn.setCellValueFactory(new PropertyValueFactory<PlanetarySystem,Integer>("planetsNumber"));
	
		systemsTableView.getItems().clear();
		
		systemsTableView.setItems(FXCollections.observableArrayList(navSys.getSystems()));
		
	}

	//------------------------------------------------------------------------------------
	
}
