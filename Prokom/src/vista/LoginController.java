package vista;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.Ejecutable;
import model.Administrador;
import model.TrabajadorSceneBuilder;
import persistencia.CargarDatos;
import persistencia.ComprobarUsuario;
import persistencia.ValidarDni;
import sun.applet.Main;


public class LoginController {

	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private Pane pane4;
	@FXML
    private JFXTextField usuario;
    @FXML
    private JFXPasswordField password;
    @FXML
	private AnchorPane rootPane;
    @FXML
	private PantallaDeCargaController pantallaDeCargaController;

	
    public LoginController() {
    }
	public void initialize() {

		pane1.setStyle("-fx-background-image: url('img/1.jpg')");
		pane2.setStyle("-fx-background-image: url('img/2.jpg')");
		pane3.setStyle("-fx-background-image: url('img/3.jpg')");
		pane4.setStyle("-fx-background-image: url('img/4.jpg')");

		backgroundAnimation();

	}

	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5),
				pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		fadeTransition
				.setOnFinished(event -> {

					FadeTransition fadeTransition1 = new FadeTransition(
							Duration.seconds(3), pane3);
					fadeTransition1.setFromValue(1);
					fadeTransition1.setToValue(0);
					fadeTransition1.play();
					fadeTransition1.setOnFinished(event1 -> {
						FadeTransition fadeTransition2 = new FadeTransition(
								Duration.seconds(3), pane2);
						fadeTransition2.setFromValue(1);
						fadeTransition2.setToValue(0);
						fadeTransition2.play();				
						fadeTransition2.setOnFinished(event2 -> {

							FadeTransition fadeTransition0 = new FadeTransition(
									Duration.seconds(3), pane2);
							fadeTransition0.setFromValue(0);
							fadeTransition0.setToValue(1);
							fadeTransition0.play();
							fadeTransition0.setOnFinished(event3 -> {

								FadeTransition fadeTransition11 = new FadeTransition(
										Duration.seconds(3), pane3);

								fadeTransition11.setFromValue(0);
								fadeTransition11.setToValue(1);
								fadeTransition11.play();
								fadeTransition11.setOnFinished(event4 -> {

									FadeTransition fadeTransition22 = new FadeTransition(
											Duration.seconds(3), pane4);

									fadeTransition22.setFromValue(0);
									fadeTransition22.setToValue(1);
									fadeTransition22.play();
									fadeTransition22.setOnFinished(event5 -> {

										backgroundAnimation();
									});

								});

							});

						});
					});

				});
	}
	
	@FXML
    void pantallaCarga(ActionEvent event)  {
//		ComprobarUsuario comproUsuario = new ComprobarUsuario();
//		Boolean respuesta = false;
//			try {
//				respuesta = comproUsuario.ComprobarUsuario();
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		if(respuesta == true) {
	    Stage thisStage = (Stage) rootPane.getScene().getWindow();
        thisStage.close();

			try {	
	            Stage stage = new Stage();

				//Stage stage = (Stage) page.getScene().getWindow();
		    	   // stage.close()

				 FXMLLoader loader = new FXMLLoader();

		         loader.setLocation(Ejecutable.class.getResource("../vista/Principal.fxml"));
		            
	            AnchorPane page = (AnchorPane)loader.load();
				PantallaPrincipalController controller = loader.getController();
//				PantallaPrincipalController.setCargarDatos(this);
	            stage.setTitle("Datos");
	            Scene scene = new Scene(page);
	            stage.initStyle(StageStyle.UNDECORATED);

	            stage.setScene(scene);    

	            stage.show();


			} catch (IOException e) {
				e.printStackTrace();
			}
	//	}
    }
	


	public void setLoginController(PantallaDeCargaController pantallaDeCargaController) {
        this.pantallaDeCargaController = pantallaDeCargaController;
		
	}
}
