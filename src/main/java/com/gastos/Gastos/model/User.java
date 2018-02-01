package com.gastos.Gastos.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User extends ParentEntity{

	private static final long serialVersionUID = -2581254318504274315L;

	@Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
	
	@Column(name = "apellido1", nullable = true, length = 255)	
	private String apellido1;
	
	@Column(name = "apellido2", nullable = true, length = 255)
    private String apellido2;
	
	@Column(name = "telefono", nullable = true, length = 30)
    private String telefono;
	
	@Column(name = "direccion", nullable = true, length = 150)
    private String direccion;

    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
