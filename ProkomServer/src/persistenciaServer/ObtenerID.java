package persistenciaServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Trabajador;

public class ObtenerID {
	//CLASE QUE EN PRINCIPIO NO SE VA A UTILIZAR ASI QUE SE MANTIENE INACTIVA
	private AccesoDB acceso;

	public int obtenerID(Trabajador tra) {

	int id = 0;
	Connection con = null;
	PreparedStatement sm = null;

	try {
		con = acceso.conectar();
		System.out.println("Conectado");

		sm = con.prepareStatement("select ID_T from TRABAJADORES  where DNI = ?");
		sm.setString(1, tra.getDni());
		ResultSet rs = sm.executeQuery();

		id = rs.getInt(1);

	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error");
	} catch (ClassNotFoundException er) {
		er.printStackTrace();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	} finally {
		try {
			if (sm != null) {
				sm.close();
			}
			if (con != null) {
				acceso.desconectar(con);
			}
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar");
		}
	}

	return id;
	}

}
