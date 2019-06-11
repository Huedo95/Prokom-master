package persistenciaServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Trabajador;

public class BorrarTrabajador {
	private AccesoDB acceso;
	
	
//INICIALIZAR TODAS LAS CLASES
	public BorrarTrabajador() {
		acceso = new AccesoDB();
	}



	public void borTrabajador(Trabajador trabajador) {

		PreparedStatement st = null;
		Connection con = null;
		try {

			con = acceso.conectar();
			System.out.println("Conectado");
			//int id = new ObtenerID().obtenerID(trabajador);

			st = con.prepareStatement("DELETE FROM TRABAJADORES WHERE dni =?");
			st.setString(1, trabajador.getDni());

			//st.setInt(1, dni.trabajador,);
			st.execute();
			System.out.println("Trabajador eliminado correctamente");
			// JOPTIONPANEL NO SE MOSTRARA TIENES QUE RETORNAR UN MENSAJE
			
			JOptionPane.showConfirmDialog(null, "Trabajador eliminado correctamente");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "EROR AL BORRAR", "Error", JOptionPane.CANCEL_OPTION);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
	}
	

}
