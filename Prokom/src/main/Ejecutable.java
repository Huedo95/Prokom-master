package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.TrabajadorSceneBuilder;
import persistencia.CargarDatos;
import vista.PantallaAddTrabajadorController;
import vista.LoginController;
public class Ejecutable extends Application {
	@FXML
	Stage stage;
	@FXML
	Label logoLabel;
	//********************************************CARGAR PANTALLA*****************************************************************
	@Override
	public void start(Stage myStage) throws Exception {

		stage = myStage;

		AbrirDatos();

	}

	private void AbrirDatos() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"../vista/Splash.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
	        
	       

			// AÑADIR FUENTES
			/*Font.loadFont(
					getClass().getResourceAsStream(
							"assets/Sacramento-Regular.ttf"), 20);*/

			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public void closeStage() {
		stage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	 public ObservableList<TrabajadorSceneBuilder> getListaTrabajadores() {
        return trabajadorData;
    }
	public Ejecutable() {
		CargarDatos cargaD = new CargarDatos();
		cargaD.cargarDatos();
		
	}

	public void mostrarPrincipal(){
		try {	
		    Stage stage = new Stage();
		
			//Stage stage = (Stage) page.getScene().getWindow();
			   // stage.close()
		
			 FXMLLoader loader = new FXMLLoader();
		
		     loader.setLocation(Ejecutable.class.getResource("../vista/Principal.fxml"));
		        
		    AnchorPane page = (AnchorPane)loader.load();
			PantallaPrincipalController controller = loader.getController();
			controller.setEjecutable(this);;
		    stage.setTitle("Datos");
		    Scene scene = new Scene(page);
		    stage.initStyle(StageStyle.UNDECORATED);
		
		    stage.setScene(scene);    
		
		    stage.show();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */
	
	
}
