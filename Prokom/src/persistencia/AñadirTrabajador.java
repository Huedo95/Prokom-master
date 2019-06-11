package persistencia;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Trabajador;


public class AñadirTrabajador {
	public void AñadirTrabajador(Trabajador trabajador) throws ClassNotFoundException, IOException {
		int codigo;
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

			
			/*
			METODO PARA COMPROBAR LOS CAMBIOS EN UN FUTURO
			
			
			String nombre =  nombreLabel.getText();
						String apellido1 =  nombreLabel.getText();
						String apellido2 =  nombreLabel.getText();
						String domicilio =  nombreLabel.getText();
						String domicilioSocial =  nombreLabel.getText();
						String nacionalidad =  nombreLabel.getText();
						String pais =  nombreLabel.getText();
						String municipio =  nombreLabel.getText();
						int codigoPostal = Integer.parseInt(codigoPostalLabel.getText());
						int numSeguridadS = Integer.parseInt(numeroSeguridadLabel.getText());


						trabajador = new Trabajador(dni, nombre, apellido1, apellido2, domicilio, domicilioSocial,
								nacionalidad, pais, municipio, codigoPostal, numSeguridadS);
			
			ObjectInputStream dato = new ObjectInputStream(socket.getInputStream());
			trabajador = (Trabajador)objEntrada.readObject();
			
			System.out.println("Recibo: " + dato.getDni() +"*"+ dato.getNombre()
			+"*"+ dato.getApellido1()+"*"+ dato.getApellido2()+"*"+ dato.getDomicilio()
			+"*"+ dato.getDomicilioSocial()+"*"+ dato.getNacionalidad()+"*"+ dato.getPais()
			+"*"+ dato.getMunicipio()+"*"+ dato.getCodigoPostal()+"*"+ dato.getNumeroSeguridad());*/

            codigo = 1;
            	//MOVER CONSEGUIR DATOS A LA VENTANA DE AÑADIR
            	//
				flujoSalida.writeInt(codigo);

				outObjeto.writeObject(trabajador);
				
				outObjeto.close();
				flujoSalida.close();
				cliente.close();
			
				if (codigo == 0){
					System.out.println("ERROR, FILTRO SERVIDOR");
				} 
            

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}		
		
