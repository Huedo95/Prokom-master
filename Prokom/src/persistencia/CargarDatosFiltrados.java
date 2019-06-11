package persistencia;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextField;

import model.TrabajadorSceneBuilder;

public class CargarDatosFiltrados {
	public TrabajadorSceneBuilder cargarDatosFiltrados(String consulta, int numConsulta) {
		TrabajadorSceneBuilder trabajadorScrollFiltrado = null;
		ConseguirDatos princi = new ConseguirDatos();
		boolean codIncorrecto;
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
		
			ObjectInputStream inputObjeto = new ObjectInputStream(cliente.getInputStream());


			
			/*METODO PARA COMPROBAR LOS CAMBIOS EN UN FUTURO
			
			ObjectInputStream dato = new ObjectInputStream(socket.getInputStream());
			trabajador = (Trabajador)objEntrada.readObject();
			
			System.out.println("Recibo: " + dato.getDni() +"*"+ dato.getNombre()
			+"*"+ dato.getApellido1()+"*"+ dato.getApellido2()+"*"+ dato.getDomicilio()
			+"*"+ dato.getDomicilioSocial()+"*"+ dato.getNacionalidad()+"*"+ dato.getPais()
			+"*"+ dato.getMunicipio()+"*"+ dato.getCodigoPostal()+"*"+ dato.getNumeroSeguridad());*/

            codigo = 5;
            	consulta = princi.filtrar();
				flujoSalida.writeInt(codigo);
				flujoSalida.writeUTF(consulta);
//**********************************************REVISAR esta funcion **************************************************
            	try {
					trabajadorScrollFiltrado = (TrabajadorSceneBuilder) inputObjeto.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
      
				
            	flujoSalida.close();
				inputObjeto.close();
				cliente.close();
			
				if (codigo == 0){
					System.out.println("ERROR, FILTRO SERVIDOR");
				} 
 
            

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return trabajadorScrollFiltrado;
		
	}

}
