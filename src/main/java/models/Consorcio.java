package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consorcio {
	
			// Variables de instancia
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			int clave;
			
			private String direccion;
			private String unidFun;
			private Double presupuesto;
			private Double fondo;

			
			// Métodos
			
			public Consorcio(){}
			
			public Consorcio(int clave, String direccion, String unidFun, Double presupuesto, Double fondo) {
				super();
				this.clave = clave;
				this.direccion = direccion;
				this.unidFun = unidFun;
				this.presupuesto = presupuesto;
				this.fondo = fondo;
				
			}
			
			public Consorcio(String direccion, String unidFun, Double presupuesto, Double fondo) {
				super();
				this.direccion = direccion;
				this.unidFun = unidFun;
				this.presupuesto = presupuesto;
				this.fondo = fondo;
				
			}

			public int getClave() {
				return clave;
			}

			public void setClave(int clave) {
				this.clave = clave;
			}

			public String getDireccion() {
				return direccion;
			}

			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			public String getUnidFun() {
				return unidFun;
			}

			public void setUnidFun(String unidFun) {
				this.unidFun = unidFun;
			}

			public Double getPresupuesto() {
				return presupuesto;
			}

			public void setPresupuesto(Double presupuesto) {
				this.presupuesto = presupuesto;
			}

			public Double getFondo() {
				return fondo;
			}

			public void setFondo(Double fondo) {
				this.fondo = fondo;
			}

			
			
}
