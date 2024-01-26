package com.main.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entitys.arrays;
import com.main.Repository.IArrays;
import com.main.interfacesServicios.IBartenderServicio;

@Service
public class BartenderService implements IBartenderServicio {
	
	@Autowired
	IArrays arrayData;

    public List<Integer> procesar(int id, int q) {
        // Obtiene el arreglo del id proporcionado
        List<Integer> arregloA = obtenerArregloA(id);

        // Inicializar los arreglos B, Ai y respuesta 
        List<Integer> arregloB = new ArrayList<>();
        List<Integer> arregloAi = new ArrayList<>();
        List<Integer> respuesta = new ArrayList<>();
        
        // Iterar Q veces
        for (int i = 0; i < q; i++) {
            // Itera el arreglo A actual y distribuye los números en B y Ai
            for (int num : arregloA) {
                if (esDivisible(num, obtenerPrimo(i))) {
                    arregloB.add(num);
                } else {
                    arregloAi.add(num);
                }
            }

            // Actualiza el arreglo A para la próxima iteración
            arregloA = new ArrayList<>(arregloAi);


         // Ordena el arregloB de mayor a menor y agrega el arregloB al arreglo respuesta
            Collections.sort(arregloB, Collections.reverseOrder());
            respuesta.addAll(arregloB);

            
         // limpia los arreglos B y Ai para la siguiente iteración
            arregloB.clear();
            arregloAi.clear();
        }

        respuesta.addAll(arregloA);

        return respuesta;
        }

    private List<Integer> obtenerArregloA(int id) {
    	//Obtiene el campo input_array y lo convierte en arreglo
    	arrays array = arrayData.findById(id);
        List<Integer> arregloA = new ArrayList<>(canvierteArray(array.getInput_array()));
        return arregloA;
    }

    private boolean esDivisible(int num, int divisor) {
        return num % divisor == 0;
    }

    private int obtenerPrimo(int indice) {
        // obtiene el primo en la posición indicada
        // se parametriza el arreglo de primos
        int[] primos = {2, 3, 5, 7, 11, 13, 17};
        return primos[indice % primos.length];
    }
    private List<Integer> canvierteArray(String textoAConvertir) {
    	//Convierte el campo string a arreglo de numeros
    	String[] textoArray = textoAConvertir.split(",");
    	
    	List<Integer> Array = new ArrayList<>();
    	  for (String numStr : textoArray) {
    		  Array.add(Integer.parseInt(numStr));
          }
		return Array;
    	
    }
}