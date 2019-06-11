package serverSocket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Administrador;
import model.Trabajador;
import persistenciaServer.BorrarTrabajador;
import persistenciaServer.CargarDatos;
import persistenciaServer.CargarDatosFiltro;
import persistenciaServer.ComprobarLogin;
import persistenciaServer.ModificarTrabajador;
import persistenciaServer.AñadirTrabajador;

public class HiloServidor extends Thread {
	
	Socket socket;

   public HiloServidor(Socket clienteConectado) {
	   this.socket = clienteConectado;
   }
   
   public void run() {
	// CREO FLUJO DE ENTRADA DE CLIENTE
		InputStream entrada = null;

	   ObjectOutputStream flujoSalidaObj = null;
	   ObjectInputStream flujoEntradaObj = null;
		DataOutputStream flujoSalida = null;
		DataInputStream flujoEntrada = null;

	
	

	try {
		
//		flujoSalidaObj = new ObjectOutputStream(
//				socket.getOutputStream());
		entrada = socket.getInputStream();
		flujoEntrada = new DataInputStream(entrada);
		
		//flujoEntrada = new DataInputStream(socket.getInputStream());

		entrada = socket.getInputStream();
		flujoEntradaObj = new ObjectInputStream(entrada);
		
		

		// EL CLIENTE ME ENVÍA UN MENSAJE

		int codigo = flujoEntrada.readInt();
		System.out.println("Recibiendo del Trabajador: \n\t" + codigo);
		if (codigo == 1)
			AddTrabajador(socket, flujoEntradaObj);
		else if (codigo == 2)
			ModificarTrabajador(socket, flujoEntradaObj);
		else if (codigo == 3)
			BorrarTrabajador(socket, flujoEntradaObj);
		else if (codigo == 4)
			CargarTrabajador(socket, flujoSalidaObj);
		else if (codigo == 5)
			CargarTrabajadorFiltrado(socket, flujoEntrada, flujoSalidaObj);
		else if (codigo == 6)
			ComprobarUsuario(socket, flujoEntradaObj, flujoSalida);


			
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


private static void AddTrabajador(Socket socket, ObjectInputStream flujoEntradaObj) {
	
	Trabajador trabajador = new Trabajador();
	AñadirTrabajador añadirT = new AñadirTrabajador();


	try {
		System.out.println("Entra en aDD");
		trabajador = (Trabajador)flujoEntradaObj.readObject();
		System.out.println("Abre paquete de entrada");

		añadirT.añadirTrabajador(trabajador);
		System.out.println("Trabajador Guardado");

		//trabajador2 = trabajador;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	


}


private static void ModificarTrabajador(Socket socket, ObjectInputStream flujoEntradaObj) {
	Trabajador trabajador = new Trabajador();
	ModificarTrabajador modifT = new ModificarTrabajador();



	try {
		trabajador = (Trabajador)flujoEntradaObj.readObject();
		modifT.modifTrabajador(trabajador);	
		//trabajador2 = trabajador;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
}

private static void BorrarTrabajador(Socket socket, ObjectInputStream flujoEntradaObj) {
	Trabajador trabajador = new Trabajador();


	try {
		trabajador = (Trabajador)flujoEntradaObj.readObject();
		
		BorrarTrabajador borrarT = new BorrarTrabajador();
		borrarT.borTrabajador(trabajador);
		//trabajador2 = trabajador;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



}
private static void CargarTrabajador(Socket socket, ObjectOutputStream flujoSalidaObj) {
	
	Trabajador trabajador = new Trabajador();
	
	CargarDatos cargarDatos = new CargarDatos();

	
	
	try {
		cargarDatos.cargarTrabajador();
		flujoSalidaObj.writeObject(trabajador);
		
	} catch (IOException e) {
		
	}

}
private static void CargarTrabajadorFiltrado(Socket socket, DataInputStream flujoEntrada,
		ObjectOutputStream flujoSalidaObj) {
	
	Trabajador trabajador = new Trabajador();

	CargarDatosFiltro cargarDatosFiltro = new CargarDatosFiltro();
	

	
	
	try {
		String consulta = flujoEntrada.readUTF();
		cargarDatosFiltro.cargarTrabajadorFiltrado(consulta);
		flujoSalidaObj.writeObject(trabajador);
		
	} catch (IOException e) {
		
	}

}
private static void ComprobarUsuario(Socket socket, ObjectInputStream flujoEntradaObj, DataOutputStream flujoSalida) {
	Administrador administrador = new Administrador();
	ComprobarLogin comproLogin = new ComprobarLogin();
	boolean respuesta = false;	
	ObjectInputStream objEntrada;
	try {
		objEntrada = new ObjectInputStream(socket.getInputStream());
		administrador = (Administrador)objEntrada.readObject();
		
		comproLogin.comprobar(administrador);
		
		flujoSalida.writeBoolean(respuesta);
	} catch (IOException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
	

