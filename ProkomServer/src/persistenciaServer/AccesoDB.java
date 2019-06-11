package persistenciaServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class AccesoDB {

	private String url;
	private String driver;

	public AccesoDB() {
		this.url = "jdbc:sqlite:dbSQLite/Prokom.db";
		this.driver = "org.sqlite.JDBC";
	}

	public Connection conectar() throws ClassNotFoundException, SQLException {

		// Activamos las foreign keys de nuestra base de datos.
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, config.toProperties());
		return con;
	}

	public void desconectar(Connection con) throws SQLException {
		con.close();

	}
}


