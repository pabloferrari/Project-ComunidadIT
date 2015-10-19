package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
			// Variables de instancia
			@Id
			int id_user;
			private String username;
			private String pass;
			private String nombre;
			private String apellido;
			private int dni;
			private String mail;
			private int edad;
			private String categoria;
			
			// Métodos
			
			public User(){}
			
			public User(int id_user, String username, String pass, String nombre, String apellido, int dni, String mail, int edad, String categoria) {
				super();
				this.id_user = id_user;
				this.username = username;
				this.pass = pass;
				this.nombre = nombre;
				this.apellido = apellido;
				this.dni = dni;
				this.mail = mail;
				this.edad = edad;
				this.categoria = categoria;
				
			}
			
			public User(String username, String pass, String nombre, String apellido, int dni, String mail, int edad, String categoria) {
				super();
				this.username = username;
				this.pass = pass;
				this.nombre = nombre;
				this.apellido = apellido;
				this.dni = dni;
				this.mail = mail;
				this.edad = edad;
				this.categoria = categoria;
				
			}
			
			public int getId_user(){
				return id_user;
			}
		
			public void setId_user(int id_user){
				this.id_user = id_user;
			}
			
			public String getUsername(){
				return username;
			}
		
			public void setUsername(String username){
				this.username = username;
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
			
			public int getDni(){
				return dni;
			}
		
			public void setDni(int dni){
				this.dni = dni;
			}
			
			public String getMail(){
				return mail;
			}
		
			public void setMail(String mail){
				this.mail = mail;
			}
			
			public int getEdad(){
				return edad;
			}
		
			public void setEdad(int edad){
				this.edad = edad;
			}
			
			public String getCategoria(){
				return categoria;
			}
		
			public void setCategoria(String categoria){
				this.categoria = categoria;
			}
			
			
		
}
