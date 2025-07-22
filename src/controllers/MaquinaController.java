package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Maquina;

import models.Maquina;

public class MaquinaController {

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquina, int umbral){
        Stack<Maquina> pila = new Stack<>();
        for (Maquina m : maquina){
            if ( m.getSubred()> umbral){
                pila.push(m);
            }
        }
        return pila;
    }

    public TreeSet<Maquina> ordenarPorSubred(Stack<Maquina> pila){
        return new TreeSet<>(pila.stream())
        

    }

    public TreeMap<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas){
        TreeMap<Integer , Queue<Maquina>> mapa = new TreeMap<>();
        for (Maquina m : maquinas){
            int riesgo = m.getRiesgo();
            mapa.putIfAbsent(riesgo, new LinkedList<>());
            mapa.get(riesgo).add(m);

        }
        return mapa;
    }

    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa){
        int maxRiesgo = -1;
        int maxCantidad = -1;
        
        for ( Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()){
            int riesgo = entry.getKey();
            int cantidad = entry.getValue().size();

            if ( cantidad > maxCantidad || ( cantidad == maxCantidad && riesgo  > maxRiesgo)){
                maxCantidad = cantidad;
                maxRiesgo = riesgo;


            }

        }
        Stack<Maquina> pila = new Stack<>();
        Queue<Maquina> grupo = new mapa.get(maxRiesgo);


        for (Maquina m : grupo){
            pila.push(m);
        }
        return pila;



    }




    
    
    
}
