package persistencia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import model.Administrador;
import model.TrabajadorSceneBuilder;

public class ComprobarUsuario {
	private JFXTextField usuario;
	private JFXPasswordField password;
	

	public Boolean ComprobarUsuario() throws ClassNotFoundException, IOException {
		Administrador administrador = null;
		boolean codIncorrecto;
		int codigo;
		Boolean respuesta = false;
		String host = "localhost";
		int Puerto = 60000; // puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket cliente;
		try {
			cliente = new Socket(host, Puerto);
			// CREO FLUJO DE SALIDA AL SERVIDOR

			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

			// CREO FLUJO DE ENTRADA AL SERVIDOR

			ObjectOutputStream outObjeto = new ObjectOutputStream(
					cliente.getOutputStream());
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());


			
			/*METODO PARA COMPROBAR LOS CAMBIOS EN UN FUTURO
			
			ObjectInputStream dato = new ObjectInputStream(socket.getInputStream());
			trabajador = (Trabajador)objEntrada.readObject();
			
			System.out.println("Recibo: " + dato.getDni() +"*"+ dato.getNombre()
			+"*"+ dato.getApellido1()+"*"+ dato.getApellido2()+"*"+ dato.getDomicilio()
			+"*"+ dato.getDomicilioSocial()+"*"+ dato.getNacionalidad()+"*"+ dato.getPais()
			+"*"+ dato.getMunicipio()+"*"+ dato.getCodigoPostal()+"*"+ dato.getNumeroSeguridad());*/

			codIncorrecto = true;
            codigo = 6;
            while (codIncorrecto) {
            	administrador = conseguirUsuario();
				outObjeto.writeObject(administrador);
				flujoSalida.writeInt(codigo);
				//FALTA RECIBIR LA RESPUESTA Y SI ES FALSO NO DEJARLE PASAR****************************************************
				respuesta = flujoEntrada.readBoolean();
				
				
				outObjeto.close();
				flujoSalida.close();
				flujoEntrada.close();
				cliente.close();
			
				if (codigo == 0){
					System.out.println("ERROR, FILTRO SERVIDOR");
				} else {
					codIncorrecto = false;
				}
 
            }

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return respuesta;
	}


	
	public Administrador conseguirUsuario(){
		Administrador administrador = null;
		
		
		
		if (usuario.getText().equals("") || password.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Tienes que rellenas los campos");
		}try {
			administrador = new Administrador(usuario.getText(), password.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error de iniciar sesion");
		}
		return administrador;
		
	}

}
