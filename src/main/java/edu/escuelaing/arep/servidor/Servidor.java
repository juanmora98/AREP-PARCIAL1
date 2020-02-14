
package edu.escuelaing.arep.servidor;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;

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
  + "<h1>PARCIAL 1 AREP 2020-1</h1>"
  + "<h2>Ingrese los datos separados por espacio:</h2>"
  + "<form action=\"/resultado\">"
  + "  <input type=\"text\" name=\"num\" value=\"\">"
  + "  <br>"
  + "  <br> <br>"                  
  + "  <input type=\"submit\" value=\"Enviar\">"
  + "</form>"
  + "</body>"
  + "</html>";
  return pagina;
}

public static ArrayList<String> PaginaResultado(Request req, Response res) {        
  ArrayList<String> lista = new ArrayList<String>();
  lista.addAll(Arrays.asList(req.queryParams("num").split("\\s+")));   
  return lista;
  /** 
  ArrayList<Float> listaNumeros = new ArrayList<Float>();    
  for(int a=0;a< lista.size();a++){
    try{
      listaNumeros.add(Float.parseFloat(lista.get(a)));
    }
    catch(Exception e){
      System.out.print("Uno de los datos no es un numero");
    }
      
  }    
  String resultado = "{\"listaNumeros\":"+"\""+listaNumeros+"\""+",\"sumatoria\":"+"\""+Operations.Sumatoria(listaNumeros)+"\"," + "\"lista ordenada\":"+Operations.MergeSort(lista)+"}";
  return resultado;
  */
} 


 
 
 static int getPort() {
   if (System.getenv("PORT") != null) {
      return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; 
 }
 
}