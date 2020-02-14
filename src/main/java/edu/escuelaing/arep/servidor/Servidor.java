
package edu.escuelaing.arep.servidor;

import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;
import edu.escuelaing.arep.Operations.*;
import spark.Request;
import spark.Response;



public class Servidor {

  public Servidor() {
    port(getPort());
    get("/hello", (req, res) -> "Hello Heroku");
    get("/numeros", (req, res) -> PaginaInicial(req, res));
    get("/resultado", (req, res) -> PaginaResultado(req, res));
   /**port(getPort());
   staticFiles.location("/pages");
   Gson json = new Gson();
   get("/calcular/:data", (req, res) -> {
      res.type("application/json");
      String resultado = Operation.CalcularPromedioDesviacion(req.params(":data"));
      System.out.println(resultado);
      res.status(200);
      return json.toJson(resultado);
   });*/

 }


public String PaginaInicial(Request rq, Response rs){
  String pagina = "<!DOCTYPE html>"
  + "<html>"
  + "<body>"
  + "<h1>PARCIAL 1</h1>"
  + "<h2>AREP 2020-1</h2>"
  + "<h3>Ingrese los datos:</h3>"
  + "<form action=\"/results\">"
  + "  Ingrese los números separados por espacio:<br>"
  + "  <input type=\"text\" name=\"num\" value=\"\">"
  + "  <br>"
  + "  <br> <br>"                  
  + "  <input type=\"submit\" value=\"Enviar\">"
  + "</form>"
  + "</body>"
  + "</html>";
  return pagina;
}

public static String PaginaResultado(Request req, Response res) {        
  String[] lista=req.queryParams("num").split("\\s+");    
  ArrayList<Float> listaNumeros = new ArrayList<Float>();    
  for(int a=0;a<lista.length;a++){
      listaNumeros.add(Float.parseFloat(lista[a]));
  }    
  String resultado = "{\"lista\":"+"\""+listaNumeros+"\""+","+",\"sumatoria\":"+"\""+Operations.Sumatoria(listaNumeros)+"}";       
  return resultado;
} 


 
 
 static int getPort() {
   if (System.getenv("PORT") != null) {
      return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; 
 }
 
}