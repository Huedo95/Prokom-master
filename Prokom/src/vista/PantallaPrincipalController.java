package vista;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Ejecutable;
import model.Trabajador;
import model.TrabajadorSceneBuilder;
import persistencia.CargarDatos;
import persistencia.EliminarTrabajador;
import persistencia.ModificarTrabajador;
import persistencia.ValidarDni;



public class PantallaPrincipalController {
	
	@FXML
    private TableView<TrabajadorSceneBuilder> tablatrabajadores;
    @FXML    
    private TableColumn<TrabajadorSceneBuilder, String> dniColumn;
    @FXML
    private TableColumn<TrabajadorSceneBuilder, String> nombreColumn;
    @FXML
    private TableColumn<TrabajadorSceneBuilder, String> apellido1Column;
    @FXML
    private TableColumn<TrabajadorSceneBuilder, String> apellido2Column;
    
    
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
	private Ejecutable ejecutable;
    private boolean okClicked = false;

    public PantallaPrincipalController() {
    }
   @FXML
    private void initialize() {
    	//desactivarCampos();
		//ActualizarTabla();
    }
	public void ActualizarTabla() {		
    	dniColumn.setCellValueFactory(cellData -> cellData.getValue().dniProperty());
    	nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    	apellido1Column.setCellValueFactory(cellData -> cellData.getValue().apellido1Property());
    	apellido2Column.setCellValueFactory(cellData -> cellData.getValue().apellido2Property());
//    	desactivarCampos();
//    	mostrarTrabajadores(null);
//        tablatrabajadores.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> mostrarTrabajadores(newValue));
	}
//    public void setCargarDatos(Ejecutable ejecutable) {
//        this.ejecutable = ejecutable;
//
//        tablatrabajadores.setItems(ejecutable.getListaTrabajadores()); 
//    }
    
    private void mostrarTrabajadores(TrabajadorSceneBuilder trabajador) {
    	CargarDatos cargarD = new CargarDatos();
    	trabajador = cargarD.cargarDatos();
	    if (trabajador != null) {	
	    	dniLabel.setText(trabajador.getDni());
	        nombreLabel.setText(trabajador.getNombre());
	        apellido1Label.setText(trabajador.getApellido1());
	        apellido2Label.setText(trabajador.getApellido2());
	        DomicilioLabel.setText(trabajador.getDomicilio());
	        domicilioSocialLabel.setText(trabajador.getDomicilioSocial());
	        nacionalidadLabel.setText(trabajador.getNacionalidad());
	        paisLabel.setText(trabajador.getPais());
	        MunicipioLabel.setText(trabajador.getMunicipio());
	        codigoPostalLabel.setText(Integer.toString(trabajador.getCodigoPostal()));
	        numeroSeguridadLabel.setText(Integer.toString(trabajador.getNumeroSeguridad()));
	        
	    } else {
	    	dniLabel.setText("");
	        nombreLabel.setText("");
	        apellido1Label.setText("");
	        apellido2Label.setText("");
	        DomicilioLabel.setText("");
	        domicilioSocialLabel.setText("");
	        nacionalidadLabel.setText("");
	        paisLabel.setText("");
	        MunicipioLabel.setText("");
	        codigoPostalLabel.setText("");
	        numeroSeguridadLabel.setText("");
	    }    
    }
 
    public void modificarTrabajador() {	
    	if(	nombreLabel.isVisible()== true){
	    	ModificarTrabajador modTrab = new ModificarTrabajador();
	    	try {
	    		Trabajador trabajador = conseguirDatos();
				modTrab.ModificarTrabajador(trabajador);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//ActualizarTabla();
	    	//desactivarCampos();
    	}else if(nombreLabel.isVisible()== true) {
    		if(nombreLabel.getText().equals("") || apellido1Label.getText().equals("")
			|| apellido2Label.getText().equals("") ||  DomicilioLabel.getText().equals("") 
			|| domicilioSocialLabel.getText().equals("")|| nacionalidadLabel.getText().equals("") 
			|| paisLabel.getText().equals("") || MunicipioLabel.getText().equals("")
			|| codigoPostalLabel.getText().equals("")|| numeroSeguridadLabel.getText().equals("")) 

		JOptionPane.showMessageDialog(null, "Tienes que rellenas los campos");
	
    	}
    	habilitarCampos();
    			
    			
    	
	}
    
    
    public void borrar() {
    	EliminarTrabajador deleteTrab = new EliminarTrabajador();
    	Trabajador trabajador = conseguirDatos();
    	try {
			deleteTrab.EliminarTrabajador(trabajador);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//ActualizarTabla();
    }
    public void vAddTrabajador(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Ejecutable.class.getResource("../vista/addTrabajador.fxml"));
            
        AnchorPane page = (AnchorPane)loader.load();
        Stage sendStage = new Stage();
        sendStage.setTitle("Datos");
        Scene scene = new Scene(page);
        
        sendStage.initStyle(StageStyle.UNDECORATED);

        sendStage.setScene(scene);

        sendStage.show();
         } catch (IOException e) {
            e.printStackTrace();
         }
     }
    private void desactivarCampos() {
		dniLabel.setVisible(false);
		nombreLabel.setVisible(false);
		apellido1Label.setVisible(false);
		apellido2Label.setVisible(false);
		DomicilioLabel.setVisible(false);
		domicilioSocialLabel.setVisible(false);
		nacionalidadLabel.setVisible(false);
		paisLabel.setVisible(false);
		MunicipioLabel.setVisible(false);
		codigoPostalLabel.setVisible(false);
		numeroSeguridadLabel.setVisible(false);


	}
    private void habilitarCampos() {
		nombreLabel.setVisible(true);
		dniLabel.setVisible(true);
		apellido1Label.setVisible(true);
		apellido2Label.setVisible(true);
		DomicilioLabel.setVisible(true);
		domicilioSocialLabel.setVisible(true);
		nacionalidadLabel.setVisible(true);
		paisLabel.setVisible(true);
		MunicipioLabel.setVisible(true);
		codigoPostalLabel.setVisible(true);
		numeroSeguridadLabel.setVisible(true);
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
    @FXML
    private void handleEditPerson() {
        TrabajadorSceneBuilder selectedTrabajador = tablatrabajadores.getSelectionModel().getSelectedItem();
        if (selectedTrabajador != null) {
        //    boolean okClicked = Ejecutable.showPersonEditDialog(selectedTrabajador);
            if (okClicked) {
                mostrarTrabajadores(selectedTrabajador);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
//    public boolean isOkClicked() {
//        return okClicked;
//    }
//
//    /**
//     * Called when the user clicks ok.
//     */
//    @FXML
//    private void handleOk() {
//        if (isInputValid()) {
//        	
//        	trabajador.setDni(dni.setText());
//        	trabajador.setNombre(nombre.setText());
//        	trabajador.setApellido1(apellido1.setText());
//        	trabajador.setApellido2(apellido2.setText());
//        	trabajador.setDomicilio(Domicilio.setText());
//        	trabajador.setDomicilioSocial(domicilioSocial.setText());
//        	trabajador.setNacionalidad(nacionalidad.setText());
//        	trabajador.setPais(pais.setText());
//        	trabajador.setMunicipio(Municipio.setText());
//        	trabajador.setCodigoPostal(Integer.parseInt(codigoPostal.setText()));
//        	trabajador.setText(Integer.parseInt(numeroSeguridad.setText()));
//        	
//
//            okClicked = true;
//            dialogStage.close();
//        }
//    }
//
//    /**
//     * Called when the user clicks cancel.
//     */
//    @FXML
//    private void handleCancel() {
//        dialogStage.close();
//    }
//    private boolean isInputValid() {
//        String errorMessage = "";
//
//        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//            errorMessage += "No valid first name!\n"; 
//        }
//        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//            errorMessage += "No valid last name!\n"; 
//        }
//        if (streetField.getText() == null || streetField.getText().length() == 0) {
//            errorMessage += "No valid street!\n"; 
//        }
//
//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n"; 
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n"; 
//            }
//        }
//
//        if (cityField.getText() == null || cityField.getText().length() == 0) {
//            errorMessage += "No valid city!\n"; 
//        }
//
//        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//            errorMessage += "No valid birthday!\n";
//        } else {
//            if (!DateUtil.validDate(birthdayField.getText())) {
//                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
//            }
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.initOwner(dialogStage);
//            alert.setTitle("Invalid Fields");
//            alert.setHeaderText("Please correct invalid fields");
//            alert.setContentText(errorMessage);
//            
//            alert.showAndWait();
//            
//            return false;
//        }
//    }


    /*
    private ObservableList<Trabajador> listaTrabajadores = FXCollections.observableArrayList();

    private ConseguirDatos conseguirDatos;

    public  void conseguirDatos() {
		
		Trabajador trabajador = null;
		String dni = dniLabel.getText();
		
		if (nombreLabel.getText().equals("") || apellido1Label.getText().equals("")
				|| apellido2Label.getText().equals("") ||  DomicilioLabel.getText().equals("") 
				|| domicilioSocialLabel.getText().equals("")|| nacionalidadLabel.getText().equals("") 
				|| paisLabel.getText().equals("") || MunicipioLabel.getText().equals("")
				|| codigoPostalLabel.getText().equals("")|| numeroSeguridadLabel.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Tienes que rellenas los campos");
		} else {
			ValidarDni Vdni = new ValidarDni(dni);
			if(Vdni.validar() == true) {
					try {
						listaTrabajadores.add(new Trabajador(dni,nombreLabel.getText()
								, apellido1Label.getText(),apellido2Label.getText(), DomicilioLabel.getText()
								, domicilioSocialLabel.getText(), nacionalidadLabel.getText(), paisLabel.getText(), MunicipioLabel.getText()
								, Integer.parseInt(codigoPostalLabel.getText()), Integer.parseInt(numeroSeguridadLabel.getText())));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error, el codigo postal y el numero de la seguridad social tienen que ser numerico");
					}
				}
			}
		

	}
	public ObservableList<Trabajador> getListaTrabajadores() {
    return listaTrabajadores;
	}
	public void setConseguirDatos(conseguirDatos) {
        this.conseguirDatos = conseguirDatos;

        // Add observable list data to the table
        personTable.setItems(conseguirDatos.getPersonData());
    }
        
	public String filtrar() {
		
		String consulta = "";
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
    
    
    }*/
    
}
