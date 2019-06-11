package serverSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sevidor {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int numeroPuerto = 60000;
		ServerSocket servidor = null;

		try {
			servidor = new ServerSocket(numeroPuerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			Socket clienteConectado = null;
			System.out.println("Esperando al cliente...");
			try {
				clienteConectado = servidor.accept();
				HiloServidor hilo = new HiloServidor(clienteConectado);
				hilo.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}	
		
}
