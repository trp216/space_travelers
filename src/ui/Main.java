/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS
 * TAREA INTEGRADORA 3
 * DIAZ - MARTINEZ - RODAS
 */

package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.NavigationSystem;

public class Main extends Application {
	
	//------------------------------------------------------------------------------------
	
	private NavigationSystem ns;
	
	// RELACION CON LA CLASE PRINCIPAL CONTROLADORA
	
	private PrincipalController controladora;
	
	//------------------------------------------------------------------------------------
	
	public Main() {
		
		ns = new NavigationSystem();
		
		controladora = new PrincipalController(ns);
		
	}
	
	//------------------------------------------------------------------------------------
	
	// METODO START DEL METODO MAIN

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("principalPane.fxml"));

			fxmlLoader.setController(controladora);
			
			Parent root = fxmlLoader.load();
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Space Travelers");
			
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
	// METODO MAIN PRINCIPAL (EJECUTABLE)
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	//------------------------------------------------------------------------------------

}
