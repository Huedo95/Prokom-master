package persistenciaServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Trabajador;

public class ModificarTrabajador {
	private AccesoDB acceso;
	
	public  ModificarTrabajador() {
		this.acceso = new AccesoDB();
	}

	public void modifTrabajador(Trabajador trabajador) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			System.out.println("Intentando conectar");

			con = acceso.conectar();
			System.out.println("Conectado");
			//int id = new ObtenerID().obtenerID(trabajador);

			st = con.prepareStatement("update TRABAJADORES set nombre = ?, APELLIDO1 = ?, APELLIDO2 = ?, DOMICILIO  = ?,"
					+ " DOMICILIOSOCIAL = ?, NACIONALIDAD = ?, PAIS = ?, MUNICIPIO = ?, CODIGOPOSTAL = ?, NUMSEGURIDADSOCIAL = ?"
					+ " where DNI = ?");
			st.setString(1, trabajador.getNombre());
			st.setString(2, trabajador.getApellido1());
			st.setString(3, trabajador.getApellido2());
			st.setString(4, trabajador.getDomicilio());
			st.setString(5, trabajador.getDomicilioSocial());
			st.setString(6, trabajador.getNacionalidad());
			st.setString(7, trabajador.getPais());
			st.setString(8, trabajador.getMunicipio());
			st.setInt(9, trabajador.getCodigoPostal());
			st.setInt(10, trabajador.getNumeroSeguridad());
			st.setString(11, trabajador.getDni());

			st.execute();
			System.out.println("Trabajador modificados");
			
			JOptionPane.showConfirmDialog(null, "Trabajador guardado correctamente");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
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
//		PreparedStatement st = null;
//		Connection con = null;
//		try {
//
//			con = acceso.conectar();
//			System.out.println("Conectado");
//			//int id = new ObtenerID().obtenerID(trabajador);
////					"UPDATE TRABAJADORES SET NOMBRE = ?, SET APELLIDO1 = ?, SET APELLIDO2 = ?"
////					+ ", SET DOMICILIO = ?, SET DOMICILIOSOCIAL = ?, SET NACIONALIDAD = ?, SET PAIS = ?"
////					+ ", SET MUNICIPIO = ?, SET CODIGOPOSTAL = ?, SET NUMSEGURIDADSOCIAL = ? WHERE DNI = ?
//			
//
//			st = con.prepareStatement("UPDATE TRABAJADORES\n" + 
//					"			SET\n" + 
//					"			NOMBRE = ?,\n" + 
//					"			APELLIDO1 = ?,\n" + 
//					"			APELLIDO2 = ?,\n" + 
//					"			DOMICILIO = ?,\n" + 
//					"			DOMICILIOSOCIAL = ?,\n" + 
//					"			NACIONALIDAD = ?,\n" + 
//					"			PAIS = ?,\n" + 
//					"			MUNICIPIO = ?\n" + 
//					"			CODIGOPOSTAL = ?,\n" + 
//					"			NUMSEGURIDADSOCIAL = ?\n" + 
//					"			WHERE  DNI = ?");
//			st.setString(1, trabajador.getDni());
//			st.setString(2, trabajador.getNombre());
//			st.setString(3, trabajador.getApellido1());
//			st.setString(4, trabajador.getApellido2());
//			st.setString(5, trabajador.getDomicilio());
//			st.setString(6, trabajador.getDomicilioSocial());
//			st.setString(7, trabajador.getNacionalidad());
//			st.setString(8, trabajador.getPais());
//			st.setString(9, trabajador.getMunicipio());
//			st.setInt(10, trabajador.getCodigoPostal());
//			st.setInt(11, trabajador.getNumeroSeguridad());
//			//sm.setInt(12, id);
//			
//			
//			
//		System.out.println("Se modifico el trabajador");
//		} catch (SQLException ex) {
//			System.out.println(ex);
//			JOptionPane.showMessageDialog(null, "Error");
//		} catch (ClassNotFoundException er) {
//			er.printStackTrace();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
//		} finally {
//			try {
//				if (st != null) {
//					st.close();
//				}
//				if (con != null) {
//					acceso.desconectar(con);
//				}
//			} catch (SQLException e) {
//				System.out.println("No se pudo cerrar");
//			}
//		}
//	}
	}
}
