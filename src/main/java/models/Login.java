package models;

import javax.persistence.Entity;

//		@Entity
public class Login {
	
			// Variables de instancia
	
			private String id_user;
			private String pass;
			private String nombre;
			private String apellido;
			private Long dni;
			private String mail;
			private Long edad;
			private String categoria;
			
			// Métodos
			
			public Login(){}
			
			public Login(String id_user, String pass, String nombre, String apellido, Long dni, String mail, Long edad, String categoria) {
				super();
				this.id_user = id_user;
				this.pass = pass;
				this.nombre = nombre;
				this.apellido = apellido;
				this.dni = dni;
				this.mail = mail;
				this.edad = edad;
				this.categoria = categoria;
				
			}
			
			public String getId_user(){
				return id_user;
			}
		
			public void setId_user(String id_user){
				this.id_user = id_user;
			}
			
			public String getPass(){
				return pass;
			}
		
			public void setPass(String pass){
				this.pass = pass;
			}
			
			public String getNombre(){
				return nombre;
			}
		
			public void setNombre(String nombre){
				this.nombre = nombre;
			}
			
			public String getApellido(){
				return apellido;
			}
		
			public void setApellido(String apellido){
				this.apellido = apellido;
			}
			
			public Long getDni(){
				return dni;
			}
		
			public void setDni(Long dni){
				this.dni = dni;
			}
			
			public String getMail(){
				return mail;
			}
		
			public void setMail(String mail){
				this.mail = mail;
			}
			
			public Long getEdad(){
				return edad;
			}
		
			public void setEdad(Long edad){
				this.edad = edad;
			}
			
			public String getCategoria(){
				return categoria;
			}
		
			public void setCategoria(String categoria){
				this.categoria = categoria;
			}
			
			
		
}
