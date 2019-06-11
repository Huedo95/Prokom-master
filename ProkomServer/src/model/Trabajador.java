package model;

import java.io.Serializable;

public class Trabajador implements Serializable{
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String Domicilio;
	private String domicilioSocial;
	private String nacionalidad;
	private String pais;
	private String Municipio;
	private int codigoPostal;
	private int numeroSeguridad;
	
	
	public Trabajador(String dni, String nombre, String apellido1, String apellido2, String domicilio,
			String domicilioSocial, String nacionalidad, String pais, String municipio, int codigoPostal,
			int numeroSeguridad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		Domicilio = domicilio;
		this.domicilioSocial = domicilioSocial;
		this.nacionalidad = nacionalidad;
		this.pais = pais;
		Municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.numeroSeguridad = numeroSeguridad;
	}
	public Trabajador() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public String getDomicilioSocial() {
		return domicilioSocial;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getPais() {
		return pais;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public int getNumeroSeguridad() {
		return numeroSeguridad;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	public void setDomicilioSocial(String domicilioSocial) {
		this.domicilioSocial = domicilioSocial;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public void setNumeroSeguridad(int numeroSeguridad) {
		this.numeroSeguridad = numeroSeguridad;
	}
	@Override
	public String toString() {
		return "trabajador [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", Domicilio=" + Domicilio + ", domicilioSocial=" + domicilioSocial + ", nacionalidad=" + nacionalidad
				+ ", pais=" + pais + ", Municipio=" + Municipio + ", codigoPostal=" + codigoPostal
				+ ", numeroSeguridad=" + numeroSeguridad + "]";
	}

	
	
	

}
