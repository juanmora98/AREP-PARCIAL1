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


}