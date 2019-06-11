package model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Administrador implements Serializable{
	private final StringProperty  usuario;
	private final StringProperty  password;
	
	public Administrador() {
		this(null, null);
	}
	public Administrador(String usuario, String password) {
		super();
		this.usuario = new SimpleStringProperty (usuario);
		this.password = new SimpleStringProperty(password);
	}
	public String getUsuario() {
		return usuario.get();
	}

	public String getPasword() {
		return password.get();
	}
	
	public void setUsuario(String dni) {
        this.usuario.set(dni);
    }
	public void setPassword(String nombre) {
        this.password.set(nombre);
    }
	
	public StringProperty usuarioProperty() {
        return usuario;
    }
	public StringProperty passwordProperty() {
        return password;
    }
	@Override
	public String toString() {
		return "Administrador [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	

}
