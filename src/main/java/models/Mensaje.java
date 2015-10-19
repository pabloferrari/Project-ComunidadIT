package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mensaje {
	
			// Variables de instancia
			@Id
			int id;
			private String nombre;
			private String email;
			private String asunto;
			private String mensaje;
			
			// Métodos
			
			public Mensaje(){}
			
			public Mensaje(int id, String nombre, String email, String asunto, String mensaje) {
				super();
				this.id = id;
				this.nombre = nombre;
				this.email = email;
				this.asunto = asunto;
				this.mensaje = mensaje;
				
			}
			
			public Mensaje(String nombre, String email, String asunto, String mensaje) {
				super();
				
				this.nombre = nombre;
				this.email = email;
				this.asunto = asunto;
				this.mensaje = mensaje;
				
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getAsunto() {
				return asunto;
			}

			public void setAsunto(String asunto) {
				this.asunto = asunto;
			}

			public String getMensaje() {
				return mensaje;
			}

			public void setMensaje(String mensaje) {
				this.mensaje = mensaje;
			}
			
			
			
}
