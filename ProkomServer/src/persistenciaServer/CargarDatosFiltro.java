package persistenciaServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Trabajador;

public class CargarDatosFiltro {
private AccesoDB acceso;

	
	public  CargarDatosFiltro() {
		this.acceso = new AccesoDB();
	}
	public ArrayList<Trabajador> cargarTrabajadorFiltrado(String consulta) {

		ArrayList<Trabajador> trabajador = new ArrayList<Trabajador>();
		Trabajador trabj;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		

		try {
			
			
			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				trabj = new Trabajador(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10), rs.getInt(11), rs.getInt(12));
				trabajador.add(trabj);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return trabajador;
	}

}
