package edu.escuelaing.arep.Operations;

import java.util.ArrayList;

public class Operations{

    public static float Sumatoria(ArrayList<Float> lista){
        float resultado = 0;
        for(float a : lista){
            resultado += a;
        }

        return resultado;

    }


    public static <T extends Comparable<T>> ArrayList<T> MergeSort(ArrayList<T> listaDatos){
        if (listaDatos.size() < 2){
            return listaDatos;
        }
        ArrayList<T> izquierda = new ArrayList<T>();
        ArrayList<T> derecha = new ArrayList<T>();
        izquierda = (ArrayList<T>) listaDatos.subList(0, listaDatos.size()/2);
        derecha = (ArrayList<T>) listaDatos.subList(listaDatos.size() - listaDatos.size()/2,listaDatos.size());
        ArrayList<T> a = new ArrayList<T>();
        a = Pegar(izquierda,derecha);
        return a;
    }

    public static <T extends Comparable<T>> ArrayList<T> Pegar(ArrayList<T> izq, ArrayList<T> der){

        ArrayList<T> resultado = new ArrayList<T>();
        int contIzq = 0, contDer = 0;
        while(contIzq < izq.size() && contDer < der.size()){
            if(izq.get(contIzq).compareTo(der.get(contDer)) <=0){
                resultado.add(izq.get(contIzq));
                contIzq++;
            }
            else{
                resultado.add(der.get(contDer));
                contDer++;
            }
        }
        return resultado;
    }

}