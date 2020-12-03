package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import model.NavigationSystem;

public class WelcomeController {
	
	private NavigationSystem navSys;
	
	public WelcomeController(NavigationSystem navigationSystem) {
		navSys = navigationSystem;
	}

    @FXML
    private AnchorPane welcomeAP;

    @FXML
    private RadioButton tipo1;

    @FXML
    private ToggleGroup tipoGrafo;

    @FXML
    private RadioButton tipo2;

    @FXML
    private Button tipoGrafoButton;

    @FXML
    void selectGrafo(ActionEvent event) {

    }
    
    @FXML
    void initializa() {
    	
    }
}
