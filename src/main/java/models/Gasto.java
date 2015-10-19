package models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gasto {
	
			// Variables de instancia
			@Id
			int id_gasto;
			private Date fecha;
			private String nroRemito;
			private String consorcio;
			private String proveedor;
			private double importe;
			private String detalle;
			
			// Métodos
			
			public Gasto(){}
			
			public Gasto(int id_gasto, Date fecha, String nroRemito, String consorcio, String proveedor, double importe, String detalle) {
				super();
				this.id_gasto = id_gasto;
				this.fecha = fecha;
				this.nroRemito = nroRemito;
				this.consorcio = consorcio;
				this.proveedor = proveedor;
				this.importe = importe;
				this.detalle = detalle;
				
			}
			
			public Gasto(Date fecha, String nroRemito, String consorcio, String proveedor, double importe, String detalle) {
				super();
				this.fecha = fecha;
				this.nroRemito = nroRemito;
				this.consorcio = consorcio;
				this.proveedor = proveedor;
				this.importe = importe;
				this.detalle = detalle;
				
			}

			public int getId_gasto() {
				return id_gasto;
			}

			public void setId_gasto(int id_gasto) {
				this.id_gasto = id_gasto;
			}

			public Date getFecha() {
				return fecha;
			}

			public void setFecha(Date fecha) {
				this.fecha = fecha;
			}

			public String getNroRemito() {
				return nroRemito;
			}

			public void setNroRemito(String nroRemito) {
				this.nroRemito = nroRemito;
			}

			public String getConsorcio() {
				return consorcio;
			}

			public void setConsorcio(String Consorcio) {
				this.consorcio = consorcio;
			}

			public String getProveedor() {
				return proveedor;
			}

			public void setClProv(String proveedor) {
				this.proveedor = proveedor;
			}

			public double getImporte() {
				return importe;
			}

			public void setImporte(double importe) {
				this.importe = importe;
			}

			public String getDetalle() {
				return detalle;
			}

			public void setDetalle(String detalle) {
				this.detalle = detalle;
			}

			
			
}
