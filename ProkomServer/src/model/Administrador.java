package model;

import java.io.Serializable;

public class Administrador implements Serializable{
	private String usuario;
	private String password;
	
	
	public Administrador(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrador [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	

}
