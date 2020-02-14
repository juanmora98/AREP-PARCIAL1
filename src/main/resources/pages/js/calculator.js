calculator = (function () {
    
    var datosGenerales;

    return {

        obtenerDatos: function () {           
            calculator.setDatos();
            calculadora.getResultados(datosGenerales, calculator.mostrarRespuestas);
            
        },


        setDatos: function () {
            datosGenerales = document.getElementById("data").value;
            
        },

        mostrarRespuestas: function (result) {
            var datos = JSON.parse(result);
            $("#Promedio").empty();
            $("#Desviacion").empty();
            $("#Promedio").append("Promedio : " +datos.Promedio);
            $("#Desviacion").append("Desviacion : "+datos.Desviacion);  
            
        }
    
    };  

})();

calculadora = (function () {

    return {      
        getResultados: function (datas, callback) {
            $.get( '/calcular/'+datas, function( data ) {
        	    callback(data);
        		});
        	
        }
    };

})();