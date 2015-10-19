Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});

$(document).ready(function(){
	
	$('#datePicker').val(new Date().toDateInputValue());
	
	$('#formularioLogin').submit(function(){
		
		if($('#user').val().length < 1){
			$('#llenarUser').text("[Ingrese nombre de usuario]");
			return false;
		} else {
			$('#llenarUser').text("");
		}
		
		if($('#pwd').val().length < 1){
			$('#llenarPass').text("[Ingrese contraseña]");
			return false;
		} else {
			$('#llenarPass').text("");
		}
		
	}); /////// FIN FORMULARIO LOGIN ///////
		
	$('#formularioMensaje').submit(function(){
		
		if($('#nombreMje').val().length < 1){
			$('#llenarNombre').text("[Ingrese su nombre]");
			return false;
		} else {
			$('#llenarNombre').text("");
			var a = 1;
		}
		
		if($('#mailMje').val().length < 1){
			$('#llenarMail').text("[Ingrese su mail]");
			return false;
		} else {
			$('#llenarMail').text("");
			a++;
		}
		
		if($('#asuntoMje').val().length < 1){
			$('#llenarAsunto').text("[Ingrese el Asunto del Mensaje]");
			return false;
		} else {
			$('#llenarAsunto').text("");
			a++;
		}
		
		if($('#mensajeMje').val().length < 1){
			$('#llenarMensaje').text("[Ingrese el contenido del mensaje]");
			return false;
		} else {
			$('#llenarMensaje').text("");
			a++;
		}
		
		if (a == 4){
			alert("El mensaje ha sido enviado. Recibira una respuesta a la brevedad. ¡Muchas gracias!");
		}
		
	}); /////// FIN FORMULARIO MENSAJE ///////
	
	$('#formUser').submit(function(){
		
		if($('#userNU').val().length < 1){
			$('#llenarUser').text("[Ingrese username]");
			return false;
		} else {
			$('#llenarUser').text("");
			var u = 1;
		}
		
		if($('#passNU').val().length < 1){
			$('#llenarPWD').text("[Ingrese un password]");
			return false;
		} else {
			$('#llenarPWD').text("");
			u++;
		}
		
		if($('#nomNU').val().length < 1){
			$('#llenarNom').text("[Ingrese el Nombre]");
			return false;
		} else {
			$('#llenarNom').text("");
			u++;
		}
		
		if($('#apeNU').val().length < 1){
			$('#llenarApe').text("[Ingrese el Apellido]");
			return false;
		} else {
			$('#llenarApe').text("");
			u++;
		}
		
		if($('#dniNU').val().length < 1){
			$('#llenarDNI').text("[Ingrese el DNI]");
			return false;
		} else {
			$('#llenarDNI').text("");
			u++;
		}
		
		if($('#emaNU').val().length < 1){
			$('#llenarMail').text("[Ingrese el mail]");
			return false;
		} else {
			$('#llenarMail').text("");
			u++;
		}
		
		if($('#edaNU').val().length < 1){
			$('#llenarEdad').text("[Ingrese la edad]");
			return false;
		} else {
			$('#llenarEdad').text("");
			u++;
		}
		
		if($('#cateNU').val().length < 1){
			$('#llenarCate').text("[Seleccione una categoría: A, B o C]");
			return false;
		} else {
			$('#llenarCate').text("");
			u++;
		}
		
		if (u == 8){
			alert("Se ha generado un nuevo usuario");
		}
		
	}); /////// FIN FORMULARIO USUARIO ///////
	
	$('#formProv').submit(function(){
		
		if($('#rubroNP').val().length < 1){
			$('#llenarRubro').text("[Ingrese el Rubro]");
			return false;
		} else {
			$('#llenarRubro').text("");
			var p = 1;
		}
		
		if($('#nomNP').val().length < 1){
			$('#llenarNom').text("[Ingrese el Nombre]");
			return false;
		} else {
			$('#llenarNom').text("");
			p++;
		}
		
		if($('#razNP').val().length < 1){
			$('#llenarRZ').text("[Ingrese la Razon Social]");
			return false;
		} else {
			$('#llenarRZ').text("");
			p++;
		}
		
		if($('#ctNP').val().length < 1){
			$('#llenarCuit').text("[Ingrese el CUIT]");
			return false;
		} else {
			$('#llenarCuit').text("");
			p++;
		}
		
		if($('#direNP').val().length < 1){
			$('#llenarDir').text("[Ingrese la Dirección]");
			return false;
		} else {
			$('#llenarDir').text("");
			p++;
		}
		
		if($('#telNP').val().length < 1){
			$('#llenarTel').text("[Ingrese el teléfono]");
			return false;
		} else {
			$('#llenarTel').text("");
			p++;
		}
		
		if($('#emaNP').val().length < 1){
			$('#llenarMai').text("[Ingrese el mail]");
			return false;
		} else {
			$('#llenarMai').text("");
			p++;
		}
		
		if (p == 7){
			alert("Se ha generado un nuevo proveedor");
		}
		
	}); /////// FIN FORMULARIO PROVEEDOR ///////
	
	$('#formCons').submit(function(){
		
		if($('#dirNC').val().length < 1){
			$('#llenarDir').text("[Ingrese la dirección]");
			return false;
		} else {
			$('#llenarDir').text("");
			var c = 1;
		}
		
		if($('#cuNC').val().length < 1){
			$('#llenarCU').text("[Ingrese la cantidad de Unidades]");
			return false;
		} else {
			$('#llenarCU').text("");
			c++;
		}
		
		if($('#presNC').val().length < 1){
			$('#llenarPres').text("[Ingrese el Presupuesto]");
			return false;
		} else {
			$('#llenarPres').text("");
			c++;
		}
		
		if($('#fondNC').val().length < 1){
			$('#llenarFond').text("[Ingrese el Fondo]");
			return false;
		} else {
			$('#llenarFond').text("");
			c++;
		}
		
		if (c == 4){
			alert("Se ha generado un consorcio");
		}
		
	}); /////// FIN FORMULARIO CONSORCIO ///////
	
	$('#formGasto').submit(function(){
		
		if($('#remNG').val().length < 1){
			$('#llenarRem').text("[Ingrese el número de Remito]");
			return false;
		} else {
			$('#llenarRem').text("");
			g = 1;
		}
		
		if($('#impNG').val().length < 1){
			$('#llenarImp').text("[Ingrese el Importe]");
			return false;
		} else {
			$('#llenarImp').text("");
			g++;
		}
		
		if($('#detaNG').val().length < 1){
			$('#llenarDate').text("[Ingrese el detalle]");
			return false;
		} else {
			$('#llenarDate').text("");
			g++;
		}
		
		if (g == 3){
			alert("Se ha generado un gasto");
		} else {
			return false;
		}
		
	}); /////// FIN FORMULARIO GASTOS ///////
	
	$('#prueba').click(function(){
		var text = $('#fecNG').val();
		alert(text);
	});
	
	$('#enviarMail').click(function(){
		
		var valor = $('#enviarMail').val();
		alert(valor);
		
	});
});



