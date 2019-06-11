package persistenciaServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Administrador;

public class ComprobarLogin {
	
	private AccesoDB acceso;

	public  ComprobarLogin() {
		this.acceso = new AccesoDB();
	}
	public boolean comprobar(Administrador admin) {
		boolean resultado = false;
		PreparedStatement st = null;
		Connection con = null;
		try {

			con = acceso.conectar();
			System.out.println("Conectado");
			String ausario = admin.getUsuario();
			String password = admin.getPassword();

			// ADMIN OBJ ADMINISTRADOR TABLE CAMPOS USUARIO Y PASSWORD
			
			//METODO A COMPROBAR
			st = con.prepareStatement("SELECT admin FROM administrador U WHERE usuario='"
		            + ausario + "' AND contrasena='" + password + "'");
			st.execute();
			JOptionPane.showConfirmDialog(null, "Trabajador eliminado correctamente", "Mensaje de confirmación",
					JOptionPane.CLOSED_OPTION);
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
	    return resultado;

	}

}
