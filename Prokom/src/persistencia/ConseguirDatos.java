package persistencia;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.TrabajadorSceneBuilder;
import persistencia.ValidarDni;

//FUTURO EJECUTABLE
//https://code.makery.ch/es/library/javafx-tutorial/part3/
public class ConseguirDatos {
	private JTextComponent consultaLabel;
	private JTextComponent filtro;
	private JComboBox cBFiltro;	
	private JTextComponent dniLabel;
	private JTextComponent nombreLabel;
	private JTextComponent apellido1Label;
	private JTextComponent apellido2Label;
	private JTextComponent DomicilioLabel;
	private JTextComponent domicilioSocialLabel;
	private JTextComponent nacionalidadLabel;
	private JTextComponent paisLabel;
	private JTextComponent MunicipioLabel;
	private JTextComponent codigoPostalLabel;
	private JTextComponent numeroSeguridadLabel;


	
	
//MOVER A LA VENTANA
//CARGA LOS DATOS EN LA LISTA DE TRABAJADORES
    
    //FUTURA lista de trabajadores se puede descartar
	
	 	
	
	
	
	
	public String filtrar() {
		
		String consulta = consultaLabel.getText();

		if (!filtro.getText().equals("")) {
			if (cBFiltro.getSelectedIndex() == 1) {//nombre
				consulta = "Select * from trabajador where nombre like '%" + filtro.getText() + "%'";
			} else if (cBFiltro.getSelectedIndex() == 2) {//apellido1
				consulta = "Select * from trabajador where apellido1 '%" + filtro.getText() + "%'";
			} else if (cBFiltro.getSelectedIndex() == 3) {//apellido2
				consulta = "Select * from trabajador where apellido2 like '%" + filtro.getText() + "%'";
			} else if (cBFiltro.getSelectedIndex() == 4) {//dni
				consulta = "Select * from trabajador where dni  =" + filtro.getText();
			} else {
			JOptionPane.showConfirmDialog(null, "No debe dejar el espacion en blanco", "Error",
					JOptionPane.CANCEL_OPTION);
		}
	}
		return consulta;


	}
	/*
	public void mostrarTrabajadores(ArrayList<Trabajador> trab) {

		DefaultListModel<Trabajador> model = new DefaultListModel<Trabajador>();

		for (int i = 0; i < trab.size(); i++) {

			model.addElement(trab.get(i));
		}
		listaTrabajadores.setAll(model);
	}
	/*
	public Trabajador TrabajadorSeleccionado() {

		Trabajador trabajador = null;

		trabajador = (listaTrabajadores).getSelectedValue();

		return trabajador;
	}*/
	
    /*public static void main(String[] args) {
        launch(args);
    }*/

}



