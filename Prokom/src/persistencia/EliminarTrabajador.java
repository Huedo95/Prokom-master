package persistencia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Trabajador;
import model.TrabajadorSceneBuilder;

public class EliminarTrabajador {
	public void EliminarTrabajador(Trabajador trabajador) throws ClassNotFoundException, IOException {
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

	/*METODO PARA COMPROBAR LOS CAMBIOS EN UN FUTURO
			
			ObjectInputStream dato = new ObjectInputStream(socket.getInputStream());
			trabajador = (Trabajador)objEntrada.readObject();
			
			System.out.println("Recibo: " + dato.getDni() +"*"+ dato.getNombre()
			+"*"+ dato.getApellido1()+"*"+ dato.getApellido2()+"*"+ dato.getDomicilio()
			+"*"+ dato.getDomicilioSocial()+"*"+ dato.getNacionalidad()+"*"+ dato.getPais()
			+"*"+ dato.getMunicipio()+"*"+ dato.getCodigoPostal()+"*"+ dato.getNumeroSeguridad());*/

            codigo=3;
				flujoSalida.writeInt(codigo);

				outObjeto.writeObject(trabajador);
				
				outObjeto.close();
				flujoSalida.close();
				cliente.close();
			
				if (codigo != 3){
					System.out.println("ERROR, FILTRO SERVIDOR");
				}
 
            
			
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
