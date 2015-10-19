/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Result;
import ninja.Results;
import ninja.jpa.UnitOfWork;
import ninja.params.Param;
import ninja.params.PathParam;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.mail.EmailException;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import models.Consorcio;
import models.Gasto;
import models.Mensaje;
import models.Proveedor;
import models.User;
import ninja.Context;


@Singleton
public class ApplicationController {
	
	String usuarioActual;
	
	@Inject 
	Provider<EntityManager> entityManagerProvider;
	
	@Inject
    

   
	public Result index() {

        return Results.html();

    }
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }
    
    public static class SimplePojo {

        public String content;
        
    }

    @UnitOfWork 
	public Result HOME(@Param("user") String username, @Param("pass") String password){
		
		Result resultado = Results.html();
    	
		if (usuarioActual == null) {
		
			EntityManager entityManager = entityManagerProvider.get();
			
	    	Query log = entityManager.createQuery("SELECT x FROM User x where username='"+username+"'"); 
	    	List<User> resultList = (List<User>) log.getResultList();
	    	List<User> usrs = resultList;
	    	
	    	User usuario;
	    	usuario = usrs.get(0);
	    	
		    	String pass = usuario.getPass();
		    
		    if(pass.equals(password)){
		    	
		    	usuarioActual = username;
		    	resultado.render("usuario", usuarioActual);
		    	resultado.template("views/ApplicationController/home.ftl.html");
	    	
		    } else {
	    	
		    	resultado.template("views/ApplicationController/index.ftl.html");
		
		    }
	    
		} else {
	    
			resultado.render("usuario", usuarioActual);
	    	resultado.template("views/ApplicationController/home.ftl.html");
	    
		}
		
	    return resultado;
	}
    
    @UnitOfWork 
    public Result adm_usuarios(){
    	
    	Result r = Results.html();
    	
    	EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM User x");
    	List<User> resultList = (List<User>) q.getResultList();
    	List<User> u = resultList;
    	
    	r.render("usuarios", u);
    	
    	r.render("usuario", usuarioActual);
	
		return r;
	}
    
	@UnitOfWork 
	public Result adm_proveedores(){
		
		Result resultado = Results.html();
    	
    	EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM Proveedor x");
    	List<Proveedor> resultList = (List<Proveedor>) q.getResultList();
    	List<Proveedor> p = resultList;
    	
    	resultado.render("proveedores", p);
    	
    	resultado.render("usuario", usuarioActual);
    	
    	resultado.template("views/ApplicationController/adm_proveedores.ftl.html");
    	
    	return resultado;
	}
			
	@UnitOfWork 
	public Result adm_gastos(){
		
		Result resultado = Results.html();
    	
    	EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	Query w = entityManager.createQuery("SELECT x FROM Proveedor x");
    	List<Proveedor> resultList2 = (List<Proveedor>) w.getResultList();
    	List<Proveedor> p = resultList2;
    	
    	resultado.render("proveedores", p);
    	
    	Query e = entityManager.createQuery("SELECT x FROM Gasto x");
    	List<Gasto> resultList3 = (List<Gasto>) e.getResultList();
    	List<Gasto> g = resultList3;
    	
    	resultado.render("gastos", g);
   	
    	resultado.render("usuario", usuarioActual);
    	
    	resultado.template("views/ApplicationController/adm_gastos.ftl.html");
    		
		return resultado;
	}
	
	@UnitOfWork 
	public Result adm_consorcios(){
		
		Result resultado = Results.html();
    	
    	EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	resultado.render("usuario", usuarioActual);
    	
    	resultado.template("views/ApplicationController/adm_consorcios.ftl.html");
    	
		return resultado;
	}
	
	@UnitOfWork 
	public Result usr_NuevoGasto(){
		
		Result resultado = Results.html();
    	
    	EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	Query w = entityManager.createQuery("SELECT x FROM Proveedor x");
    	List<Proveedor> resultList2 = (List<Proveedor>) w.getResultList();
    	List<Proveedor> p = resultList2;
    	
    	resultado.render("proveedores", p);
    	
    	Query e = entityManager.createQuery("SELECT x FROM Gasto x");
    	List<Gasto> resultList3 = (List<Gasto>) e.getResultList();
    	List<Gasto> g = resultList3;
    	
    	resultado.render("gastos", g);
   	
    	resultado.render("usuario", usuarioActual);
    	resultado.template("views/ApplicationController/usr_NuevoGasto.ftl.html");
    		
		return resultado;
	}
	
	@UnitOfWork 
	public Result usr_gastos(
			@Param("selectCons") String cons,
			@Param("selectProv") String prov){
		
		Result resultado = Results.html();
		
		EntityManager entityManager = entityManagerProvider.get();
		
		String consulta;
		
		if (cons == null){
			
			if(prov == null){
		
		    	consulta = "SELECT x FROM Gasto x";
		    	
			} else if(prov.equals("*")) {
			
				consulta = "SELECT x FROM Gasto x";
		
				} else {
					
					consulta = "SELECT x FROM Gasto x where proveedor='"+prov+"'";
				}
			} else if(cons.equals("*")){
				
				consulta = "SELECT x FROM Gasto x";
				
			} else {
				
				consulta = "SELECT x FROM Gasto x where consorcio='"+cons+"'";
		}
		
		Query e = entityManager.createQuery(consulta); 
    	List<Gasto> resultList3 = (List<Gasto>) e.getResultList();
    	List<Gasto> g = resultList3;
    	
    	resultado.render("gastos", g);
		
		Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	Query w = entityManager.createQuery("SELECT x FROM Proveedor x"); 
    	List<Proveedor> resultList2 = (List<Proveedor>) w.getResultList();
    	List<Proveedor> p = resultList2;
    	
    	resultado.render("proveedores", p);
		
		resultado.render("usuario", usuarioActual);
    	resultado.template("views/ApplicationController/usr_gastos.ftl.html");
    		
		return resultado;
	
	}
	
	@UnitOfWork 
	public Result usr_mensajes(){
		
		Result resultado = Results.html();
		
		EntityManager entityManager = entityManagerProvider.get();
		
    	Query q = entityManager.createQuery("SELECT x FROM Mensaje x");
    	List<Mensaje> resultList = (List<Mensaje>) q.getResultList();
    	List<Mensaje> m = resultList;
    	
    	resultado.render("mensajes", m);
    	
    	resultado.render("usuario", usuarioActual);
    	resultado.template("views/ApplicationController/usr_mensajes.ftl.html");
    	
		return resultado;
	
	}
	
	@Transactional
	public Result NuevoMensaje(
			@Param("nombreMje") String nombre,
			@Param("mailMje") String email,
			@Param("asuntoMje") String asunto,
			@Param("mensajeMje") String mensaje){
		
		Result resultado = Results.html();
    	
		EntityManager entityManager = entityManagerProvider.get();
		
		Mensaje mjeN;
		
		mjeN = new Mensaje(nombre, email, asunto, mensaje);
	
		entityManager.persist(mjeN);
		
		resultado.template("views/ApplicationController/index.ftl.html");
		
		return resultado;

	}
	
			
	@Transactional
	public Result NuevoConsorcio(
			@Param("direccionNC") String dire,
			@Param("cantUniNC") String cuf,
			@Param("presupNC") String presup,
			@Param("fondoNC") String fondo){

		
		Result resultado = Results.html();

		if (dire.equals("") || cuf.equals("") || presup.equals("") || fondo.equals("")){ 
			
			EntityManager entityManager = entityManagerProvider.get();
			
			Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
			List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
			List<Consorcio> c = resultList;
			
			// NO DEVUELVE EMAIL Y CATEGORIA!!! -> PARA CORREGIR
			
			resultado.render("consorcios", c);
			
			resultado.render("usuario", usuarioActual);
			resultado.template("views/ApplicationController/adm_consorcios.ftl.html");
					
			return resultado;
			
		} else {
		
			EntityManager entityManager = entityManagerProvider.get();
		
			Consorcio consorcioN;
		
			Double presupuesto = Double.parseDouble(presup);
			Double fondoActual = Double.parseDouble(fondo);
			
			consorcioN = new Consorcio(dire, cuf, presupuesto, fondoActual);
		
			entityManager.persist(consorcioN);
			
			// CARGA TABLE USUARIOS
			
			Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
			List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
			List<Consorcio> u = resultList;
    	
			resultado.render("consorcios", u);
			
			// FIN CARGA TABLA USUARIOS
					
			resultado.render("usuario", usuarioActual);
			resultado.template("views/ApplicationController/adm_consorcios.ftl.html");
					
			return resultado;
		}

	}
	
	@Transactional
	public Result NuevoUser(
			@Param("usernameNU") String user,
			@Param("passNU") String pas,
			@Param("nombreNU") String nom,
			@Param("apellidoNU") String ape,
			@Param("dniNU") int dni,
			@Param("emailNU") String mai,
			@Param("edadNU") int eda,
			@Param("cateNU") String cate){

		
		Result resultado = Results.html();
		
		EntityManager entityManager = entityManagerProvider.get();
	
		User usuario;
	
		usuario = new User(user, pas, nom, ape, dni, mai, eda, cate);
	
		entityManager.persist(usuario);
		
		// CARGA TABLE USUARIOS
		
		Query q = entityManager.createQuery("SELECT x FROM User x");
		List<User> resultList = (List<User>) q.getResultList();
		List<User> u = resultList;
	
		resultado.render("usuarios", u);
		
		// FIN CARGA TABLA USUARIOS
		
		resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/adm_usuarios.ftl.html");
				
		return resultado;


	}
	
	@Transactional
	public Result NuevoProv(
			@Param("rubroNP") String rubro,
			@Param("nombreNP") String nom,
			@Param("rzNP") String rz,
			@Param("cuitNP") String cuit,
			@Param("direccionNP") String dire,
			@Param("telefonoNP") String tel,
			@Param("emailNP") String ema){

		
		Result resultado = Results.html();

		EntityManager entityManager = entityManagerProvider.get();
	
		Proveedor proveedorN;
	
		proveedorN = new Proveedor(rubro, nom, rz, cuit, dire, tel, ema);
	
		entityManager.persist(proveedorN);
		
		// CARGA TABLE PROVEEDORES
		
		Query q = entityManager.createQuery("SELECT x FROM Proveedor x");
		List<Proveedor> resultList = (List<Proveedor>) q.getResultList();
		List<Proveedor> p = resultList;
	
		resultado.render("proveedores", p);
		
		// FIN CARGA TABLA PROVEEDORES
		
		resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/adm_proveedores.ftl.html");
		
		return resultado;
	}
   
	@Transactional
	public Result NuevoGastoADM(
			@Param("fechaNG") String fecha,
			@Param("remitoNG") String rem,
			@Param("consorcioNG") String cons,
			@Param("proveedorNG") String prov,
			@Param("impNG") double imp,
			@Param("DetalleNG") String deta){
	 
		
		Result resultado = Results.html();
		
//		Date fechaCarga;
//		
//		// PRUEBA DE SEPARAR STRING
//		
//		int dia;
//		int mes;
//		int anio;
//	   
//		int inicio = 0;
//		int fin = fecha.indexOf("-");
//		
//		anio = Integer.parseInt(fecha.substring(inicio, fin)); // - 1900;
//		
//		inicio = fin;
//		fin = fecha.indexOf("-", ++inicio);
//		
//		mes= Integer.parseInt(fecha.substring(inicio, fin));
//		
//		inicio = fin;
//		
//		dia = Integer.parseInt(fecha.substring(inicio)) - 693952;
//		
//		fechaCarga = new Date(anio,mes,dia); //	f.getTime();
//		
//		// FIN PRUEBA
		
		Calendar c1 = Calendar.getInstance();
		int dia = c1.get(Calendar.DATE);
		int mes = c1.get(Calendar.MONTH);
		int anio = c1.get(Calendar.YEAR)-1900;
		
		Date fechaCarga;
		fechaCarga = new Date(anio, mes, dia);
		
		EntityManager entityManager = entityManagerProvider.get();
	
		Gasto gastoN;
		
		gastoN = new Gasto(fechaCarga, rem, cons, prov, imp, deta);
	
		entityManager.persist(gastoN);
		
		// FIN CARGA NUEVO GASTO
		
		Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	Query w = entityManager.createQuery("SELECT x FROM Proveedor x");
    	List<Proveedor> resultList2 = (List<Proveedor>) w.getResultList();
    	List<Proveedor> p = resultList2;
    	
    	resultado.render("proveedores", p);
    	
    	Query e = entityManager.createQuery("SELECT x FROM Gasto x");
    	List<Gasto> resultList3 = (List<Gasto>) e.getResultList();
    	List<Gasto> g = resultList3;
    	
    	resultado.render("gastos", g);
   	
    	resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/adm_gastos.ftl.html");
		
		return resultado;

	}
	
	@Transactional
	public Result NuevoGastoUSR(
			@Param("fechaNG") String fecha,
			@Param("remitoNG") String rem,
			@Param("consorcioNG") String cons,
			@Param("proveedorNG") String prov,
			@Param("impNG") double imp,
			@Param("DetalleNG") String deta){
	 
		
		Result resultado = Results.html();
		
		Calendar c1 = Calendar.getInstance();
		int dia = c1.get(Calendar.DATE);
		int mes = c1.get(Calendar.MONTH);
		int anio = c1.get(Calendar.YEAR)-1900;
		
		Date fechaCarga;
		fechaCarga = new Date(anio, mes, dia);
		
		EntityManager entityManager = entityManagerProvider.get();
	
		Gasto gastoN;
		
		gastoN = new Gasto(fechaCarga, rem, cons, prov, imp, deta);
	
		entityManager.persist(gastoN);
		
		// FIN CARGA NUEVO GASTO
		
		Query q = entityManager.createQuery("SELECT x FROM Consorcio x");
    	List<Consorcio> resultList = (List<Consorcio>) q.getResultList();
    	List<Consorcio> c = resultList;
    	
    	resultado.render("consorcios", c);
    	
    	Query w = entityManager.createQuery("SELECT x FROM Proveedor x");
    	List<Proveedor> resultList2 = (List<Proveedor>) w.getResultList();
    	List<Proveedor> p = resultList2;
    	
    	resultado.render("proveedores", p);
    	
    	Query e = entityManager.createQuery("SELECT x FROM Gasto x");
    	List<Gasto> resultList3 = (List<Gasto>) e.getResultList();
    	List<Gasto> g = resultList3;
    	
    	resultado.render("gastos", g);
   	
    	resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/usr_NuevoGasto.ftl.html");
		
		return resultado;

	}
	
    public Result volverHome(Context contexto){
    	
    	Result resultado = Results.html();
    	usuarioActual = null;
    	resultado.template("views/ApplicationController/index.ftl.html");
    	
    	return resultado;
    }
    
    public Result adm_home(Context contexto){
		
		Result resultado = Results.html();
    	
		resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/adm_home.ftl.html");
    	    
	    return resultado;
	}
	
    public Result usr_home(Context contexto){
		
		Result resultado = Results.html();
    	
		resultado.render("usuario", usuarioActual);
		resultado.template("views/ApplicationController/usr_home.ftl.html");
    	    
	    return resultado;
	}
    

}
