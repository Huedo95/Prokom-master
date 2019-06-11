package model;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TrabajadorSceneBuilder implements Serializable{
	
	private final StringProperty  dni;
	private final StringProperty  nombre;
	private final StringProperty  apellido1;
	private final StringProperty  apellido2;
	private final StringProperty  domicilio;
	private final StringProperty  domicilioSocial;
	private final StringProperty  nacionalidad;
	private final StringProperty  pais;
	private final StringProperty  municipio;
	private final IntegerProperty  codigoPostal;
	private final IntegerProperty  numeroSeguridad;
	
	public TrabajadorSceneBuilder() {
		this(null, null, null, null, null, null, null, null, null, 0, 0);	
		}
	
	public TrabajadorSceneBuilder(String dni, String nombre, String apellido1, String apellido2,
			String domicilio, String domicilioSocial, String nacionalidad, String pais,
			String municipio, int codigoPostal, int numeroSeguridad) {
		super();
		this.dni = new SimpleStringProperty (dni);
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido1 = new SimpleStringProperty(apellido1);
		this.apellido2 = new SimpleStringProperty(apellido2);
		this.domicilio = new SimpleStringProperty(domicilio);
		this.domicilioSocial = new SimpleStringProperty(domicilioSocial);
		this.nacionalidad = new SimpleStringProperty(nacionalidad);
		this.pais = new SimpleStringProperty(pais);
		this.municipio = new SimpleStringProperty(municipio);
		this.codigoPostal = new SimpleIntegerProperty(codigoPostal);
		this.numeroSeguridad = new SimpleIntegerProperty(numeroSeguridad);
	}
	
	
	
	public String getDni() {
		return dni.get();
	}
	public String getApellido1() {
		return apellido1.get();
	}
	public String getApellido2() {
		return apellido2.get();
	}
	public String getNombre() {
		return nombre.get();
	}
	public String getDomicilio() {
		return domicilio.get();
	}
	public String getDomicilioSocial() {
		return domicilioSocial.get();
	}
	public String getNacionalidad() {
		return nacionalidad.get();
	}
	public String getPais() {
		return pais.get();
	}
	public String getMunicipio() {
		return municipio.get();
	}
	public int getCodigoPostal() {
		return codigoPostal.get();
	}
	public int getNumeroSeguridad() {
		return numeroSeguridad.get();
	}
	
	
	public void setDni(String dni) {
        this.dni.set(dni);
    }
	public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
	public void setApellido1(String apellido1) {
	        this.apellido1.set(apellido1);
	} 
	public void setApellido2(String apellido2) {
	        this.apellido2.set(apellido2);
	}
	public void setDomicilio(String domicilio) {
	        this.domicilio.set(domicilio);
	}
	public void setDomicilioSocial(String domicilioSocial) {
	        this.domicilioSocial.set(domicilioSocial);
	}
	public void setNacionalidad(String nacionalidad) {
	        this.nacionalidad.set(nacionalidad);
	}
	public void setPais(String pais) {
	        this.pais.set(pais);
	}
	public void setMunicipio(String municipio) {
        this.municipio.set(municipio);
    }
	public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal.set(codigoPostal);
	}
	public void setNumeroSeguridad(int numeroSeguridad) {
	        this.numeroSeguridad.set(numeroSeguridad);
	}
	

	public StringProperty dniProperty() {
	        return dni;
	}
	public StringProperty nombreProperty() {
	        return nombre;
	}
	public StringProperty apellido1Property() {
	        return apellido1;
	}
	public StringProperty apellido2Property() {
	        return apellido2;
	}
	 
	@Override
	public String toString() {
		return "Trabajador [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", Domicilio=" + domicilio + ", domicilioSocial=" + domicilioSocial + ", nacionalidad=" + nacionalidad
				+ ", pais=" + pais + ", Municipio=" + municipio + ", codigoPostal=" + codigoPostal
				+ ", numeroSeguridad=" + numeroSeguridad + "]";
	}

	
	
	

}
