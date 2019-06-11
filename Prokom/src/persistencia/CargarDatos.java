package persistencia;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TrabajadorSceneBuilder;

public class CargarDatos {
    private ObservableList<TrabajadorSceneBuilder> trabajadorData = FXCollections.observableArrayList();

	public TrabajadorSceneBuilder cargarDatos() {

		TrabajadorSceneBuilder trabajadorTableD = null;
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

            	codigo = 4;
				flujoSalida.writeInt(codigo);

            	try {
					trabajadorTableD = (TrabajadorSceneBuilder) inputObjeto.readObject();
					trabajadorData.add(new TrabajadorSceneBuilder(trabajadorTableD.getDni(), trabajadorTableD.getNombre()
							, trabajadorTableD.getApellido1(),trabajadorTableD.getApellido2(), trabajadorTableD.getDomicilio()
							, trabajadorTableD.getDomicilioSocial(), trabajadorTableD.getNacionalidad(), trabajadorTableD.getPais(), trabajadorTableD.getMunicipio()
							, trabajadorTableD.getCodigoPostal(), trabajadorTableD.getNumeroSeguridad()));
					
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
		return trabajadorTableD;
		
	}
	
	
}

