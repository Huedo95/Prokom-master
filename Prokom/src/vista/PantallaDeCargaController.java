package vista;


import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.Ejecutable;

public class PantallaDeCargaController {

	@FXML
	ImageView logoLabel ;

	@FXML
	Pane spinnerPane;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label helloLabel;

	@FXML
	Label nameLabel;

	public PantallaDeCargaController() {
	    }
	public void cargarLogin(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass()
					.getResource("Inicio.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);

			LoginController controller = loader.getController();
	        controller.setLoginController(this);
            Stage stage = new Stage();
	        stage.initModality(Modality.WINDOW_MODAL);//POSIBLE ELEMENTO A BORRAR
			stage.initStyle(StageStyle.UNDECORATED);

            stage.setScene(scene);
            stage.show();

	    //    VBox newWindow = (VBox)loader.load();
//	        LoginController controller = loader.getController();
//	        controller.setLoginController(this);
//	        Stage stage = new Stage();
//	        stage.initModality(Modality.WINDOW_MODAL);//POSIBLE ELEMENTO A BORRAR
//	        stage.setScene(scene);
//	        stage.show();   
			
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Ejecutable.class.getResource("..vista/Inicio.fxml"));
//			AnchorPane page = (AnchorPane) loader.load();
//			Stage homeStage = new Stage();
//			homeStage.setTitle("Main Menu");
//			Scene scene=new Scene(page);
//			homeStage.setScene(scene);
//			homeStage.setMaximized(true);
//			homeStage.show();
//			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}


	public void initialize() {

		TranslateTransition translateTransition = new TranslateTransition(
				Duration.seconds(0.1), logoLabel);
		translateTransition.setByY(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(
				Duration.seconds(0.1), nameLabel);
		translateTransition0.setByY(700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(
				Duration.seconds(0.1), helloLabel);
		translateTransition00.setByY(700);
		translateTransition00.play();

		translateTransition
				.setOnFinished(event -> {
					
					
					TranslateTransition translateTransition1 = new TranslateTransition(
							Duration.seconds(1), logoLabel);
					translateTransition1.setByY(-700);
					
					translateTransition1.play();

					translateTransition1.setOnFinished(event1 -> {

						nameLabel.setVisible(true);

						TranslateTransition translateTransition11 = new TranslateTransition(
								Duration.seconds(1), nameLabel);
						translateTransition11.setByY(-700);
						translateTransition11.play();

						translateTransition11.setOnFinished(event2 -> {

							helloLabel.setVisible(true);
							TranslateTransition translateTransition111 = new TranslateTransition(
									Duration.seconds(1), helloLabel);
							translateTransition111.setByY(-700);
							translateTransition111.play();

							translateTransition111.setOnFinished(event3 -> {
								spinnerPane.setVisible(true);

								FadeTransition fadeTransition = new FadeTransition(
										Duration.seconds(3), spinnerPane);
								fadeTransition.setFromValue(0);
								fadeTransition.setToValue(1);
								fadeTransition.play();

								fadeTransition.setOnFinished(event4 -> {

									FadeTransition fadeTransition1 = new FadeTransition(
											Duration.seconds(2), rootPane);
									fadeTransition1.setFromValue(1);
									fadeTransition1.setToValue(0.1);
									fadeTransition1.play();

									fadeTransition1.setOnFinished(event5 -> {
//										main.closeStage();
							    	    Stage thisStage = (Stage) rootPane.getScene().getWindow();
							    	    thisStage.close();
							    	    cargarLogin(thisStage);
										System.out
												.println("La pantalla de carga termino");
									});

								});

							});

						});
					});

				});

	}
}
	