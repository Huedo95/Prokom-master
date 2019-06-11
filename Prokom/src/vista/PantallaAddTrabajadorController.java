package vista;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Trabajador;
import model.TrabajadorSceneBuilder;
import persistencia.AñadirTrabajador;
import persistencia.ConseguirDatos;
import persistencia.ValidarDni;

public class PantallaAddTrabajadorController {
	@FXML
    private TextField dniLabel;
    @FXML
    private TextField nombreLabel;
    @FXML
    private TextField apellido1Label;
    @FXML
    private TextField apellido2Label;
    @FXML
    private TextField DomicilioLabel;
    @FXML
    private TextField domicilioSocialLabel;
    @FXML
    private TextField nacionalidadLabel;
    @FXML
    private TextField paisLabel;
    @FXML
    private TextField MunicipioLabel;
    @FXML
    private TextField codigoPostalLabel;
    @FXML
    private TextField numeroSeguridadLabel;
    @FXML 
    private Button closeButton;
    @FXML
	private AnchorPane rootPane;

    public PantallaAddTrabajadorController() {
    }
    Stage stage;
    public void start(Stage myStage) throws Exception {
		stage = myStage;
	}
    public void addTrabajador() {

    	AñadirTrabajador addTrab = new AñadirTrabajador();
    	Trabajador trabajador = conseguirDatos();
    	try {
			addTrab.AñadirTrabajador(trabajador);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Stage thisStage = (Stage) rootPane.getScene().getWindow();
  	    thisStage.close();	
		//pantallaPrincipal.ActualizarTabla();
    }
    public void cerrar() {
       
        Stage thisStage = (Stage) rootPane.getScene().getWindow();
	    thisStage.close();
	}
    public  Trabajador conseguirDatos() {
		Trabajador trabajador = null;


		if (nombreLabel.getText().equals("") || apellido1Label.getText().equals("")
				|| apellido2Label.getText().equals("") ||  DomicilioLabel.getText().equals("") 
				|| domicilioSocialLabel.getText().equals("")|| nacionalidadLabel.getText().equals("") 
				|| paisLabel.getText().equals("") || MunicipioLabel.getText().equals("")
				|| codigoPostalLabel.getText().equals("")|| numeroSeguridadLabel.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Tienes que rellenas los campos");
		} else {
			//**********************************METODO PARA VALIDAR DNI**********************
			String dni = dniLabel.getText();
			ValidarDni Vdni = new ValidarDni(dni);
			if(Vdni.validar() == true) {
						String nombre =  nombreLabel.getText();
						String apellido1 =  apellido1Label.getText();
						String apellido2 =  apellido2Label.getText();
						String domicilio =  DomicilioLabel.getText();
						String domicilioSocial =  domicilioSocialLabel.getText();
						String nacionalidad =  nacionalidadLabel.getText();
						String pais =  paisLabel.getText();
						String municipio =  MunicipioLabel.getText();
						int codigoPostal = Integer.parseInt(codigoPostalLabel.getText().trim());
						int numSeguridadS = Integer.parseInt(numeroSeguridadLabel.getText().trim());


						trabajador = new Trabajador(dni, nombre, apellido1, apellido2, domicilio, domicilioSocial,
								nacionalidad, pais, municipio, codigoPostal, numSeguridadS);
					
				}else {
					JOptionPane.showMessageDialog(null, "Tiene que poner un dni valido");
				}

			}
		return trabajador;
		

	}
}
