
package edu.escuelaing.arep.servidor;

import static spark.Spark.*;
import com.google.gson.Gson;


public class Servidor {

  public Servidor() {
    System.out.println( "Hello World!" );
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
 
 static int getPort() {
   if (System.getenv("PORT") != null) {
      return Integer.parseInt(System.getenv("PORT"));
    }
    return 4567; 
 }
 
}