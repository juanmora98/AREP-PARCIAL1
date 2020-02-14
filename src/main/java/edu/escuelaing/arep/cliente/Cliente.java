package edu.escuelaing.arep.cliente;
import java.io.*;
import java.net.*;


public class Cliente {
    
    public static void main(String[] args) throws Exception {

        URL url1 = new URL("https://murmuring-taiga-33927.herokuapp.com/numeros");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
        

        //json respuesta
        URL url2 = new URL("https://murmuring-taiga-33927.herokuapp.com/resultado?num=1+2+3+43+4");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
       }
}