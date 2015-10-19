package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proveedor {
	
			// Variables de instancia
			@Id
			private int id;
			private String rubro;
			private String nombre;
			private String razon_social;
			private String cuit;
			private String direccion;
			private String telefono;
			private String email;
			
			// Métodos
			
			public Proveedor(){}
			
			public Proveedor(int id, String rubro, String nombre, String razon_social, String cuit, String direccion, String telefono, String email) {
				super();
				this.id = id;
				this.rubro = rubro;
				this.nombre = nombre;
				this.razon_social = razon_social;
				this.cuit = cuit;
				this.direccion = direccion;
				this.telefono = telefono;
				this.email = email;
				
			}
			
			public Proveedor(String rubro, String nombre, String razon_social, String cuit, String direccion, String telefono, String email) {
				super();
				this.rubro = rubro;
				this.nombre = nombre;
				this.razon_social = razon_social;
				this.cuit = cuit;
				this.direccion = direccion;
				this.telefono = telefono;
				this.email = email;
				
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getRubro() {
				return rubro;
			}

			public void setRubro(String rubro) {
				this.rubro = rubro;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getRazon_social() {
				return razon_social;
			}

			public void setRazon_social(String razon_social) {
				this.razon_social = razon_social;
			}

			public String getCuit() {
				return cuit;
			}

			public void setCuit(String cuit) {
				this.cuit = cuit;
			}

			public String getDireccion() {
				return direccion;
			}

			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			public String getTelefono() {
				return telefono;
			}

			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}
			
			
			
		
}
