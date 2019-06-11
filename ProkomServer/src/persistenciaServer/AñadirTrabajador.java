package persistenciaServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Trabajador;

public class AñadirTrabajador {
	private AccesoDB acceso;

	public  AñadirTrabajador() {
		this.acceso = new AccesoDB();
	}
	public void añadirTrabajador(Trabajador	trabajador) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			System.out.println("Intentando conectar");

			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.prepareStatement("INSERT INTO TRABAJADORES (DNI, NOMBRE, APELLIDO1, APELLIDO2, DOMICILIO, "
					+ "DOMICILIOSOCIAL, NACIONALIDAD, PAIS, MUNICIPIO, CODIGOPOSTAL, NUMSEGURIDADSOCIAL) values (?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, trabajador.getDni());
			st.setString(2, trabajador.getNombre());
			st.setString(3, trabajador.getApellido1());
			st.setString(4, trabajador.getApellido2());
			st.setString(5, trabajador.getDomicilio());
			st.setString(6, trabajador.getDomicilioSocial());
			st.setString(7, trabajador.getNacionalidad());
			st.setString(8, trabajador.getPais());
			st.setString(9, trabajador.getMunicipio());
			st.setInt(10, trabajador.getCodigoPostal());
			st.setInt(11, trabajador.getNumeroSeguridad());
			st.execute();
			System.out.println("Trabajador guardado");
			
			JOptionPane.showConfirmDialog(null, "Trabajador guardado correctamente");
		} catch (SQLException ex) {
			System.out.println("El trabajador ya existente");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se rellenan todos los campos", "Error",
					JOptionPane.CANCEL_OPTION);
		} finally {

			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar el servidor");
			}
		}

	}

}
