/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Bruno
 */
public class Contenedor {

/*///////////////////////////////////////////////// ALGORITMO VORAZ ////////////////////////////////////////////*/
    synchronized public String algoritmoVoraz(int objetivoFinal, int[] tiposDeMonedas) {

        ordenarVector(tiposDeMonedas); //Ordeno el vector de menor a mayor

        String solucionFinal = ""; //Asi muestro la solucion por pantalla
        int solucionLocal = 0;
        int mayorPosibilidad;

        while (solucionLocal != objetivoFinal) {
            mayorPosibilidad = tiposDeMonedas.length - 1; //Al ser voraz selecciono la MAYOR solucion posible

            while (mayorPosibilidad >= 0) {

                if (solucionLocal + tiposDeMonedas[mayorPosibilidad] <= objetivoFinal) {
                    solucionLocal += tiposDeMonedas[mayorPosibilidad];
                    solucionFinal += "Una moneda de " + tiposDeMonedas[mayorPosibilidad] + "\n";
                } 
                else { //Si mi opcion mayor ya sobrepaso el valor del objetivo
                    mayorPosibilidad = mayorPosibilidad - 1; //Selecciono la siguiente moneda mas chica
                }
            }
        }
        
        return solucionFinal;
    }

/*//////////////////////////////////////////////// FUERZA BRUTA ///////////////////////////////////////////*/
    synchronized public String fuerzaBruta(int objetivo, int[] tiposDeMonedas) {

        int cambio;
        int nuevoCambio;
        String solucionFinal = null;

        ordenarVector(tiposDeMonedas); //Ordeno el arreglo de menor a mayor

        if (objetivo >= tiposDeMonedas[3]) { //Pruebo con el tipo de moneda mas alto
            cambio = (objetivo / tiposDeMonedas[3]);
            nuevoCambio = objetivo % tiposDeMonedas[3];
            solucionFinal = "Se necesitan " + cambio + " monedas de " + tiposDeMonedas[3] + "\n";

            if (nuevoCambio != 0) { //Si todavia se puede seguir dividiendo
                if (nuevoCambio >= tiposDeMonedas[2]) { //Pruebo con el segundo tipo de moneda mas alto
                    cambio = nuevoCambio / tiposDeMonedas[2];
                    solucionFinal += "Se necesitan " + cambio + " monedas de " + tiposDeMonedas[2] + "\n";
                } 
                else if (nuevoCambio >= tiposDeMonedas[1]) {
                    cambio = nuevoCambio / tiposDeMonedas[1];
                    solucionFinal += "Se necesitan " + cambio + " monedas de " + tiposDeMonedas[1] + "\n";
                } 
                else if (nuevoCambio >= tiposDeMonedas[0]) {
                    cambio = nuevoCambio / tiposDeMonedas[0];
                    solucionFinal += "Se necesitan " + cambio + " monedas de " + tiposDeMonedas[0] + "\n";
                }
            }
        }
        
        return solucionFinal;
    }

    //Metodo para ordenar el array de monedas (Algoritmo de Ordenamiento Burbuja)
    public int[] ordenarVector(int[] vectorMonedas) {
        int menorMoneda;

        for (int i = 0; i < vectorMonedas.length; i++) {
            for (int j = 0; j < vectorMonedas.length - i - 1; j++) {
                if (vectorMonedas[j] > vectorMonedas[j + 1]) {
                    int tmp = vectorMonedas[j + 1];
                    vectorMonedas[j + 1] = vectorMonedas[j];
                    vectorMonedas[j] = tmp;
                }
            }
        }
        return vectorMonedas;
    }

    //Metodo para buscar el tipo de moneda mas grande (Algoritmo de Busqueda)
    public int mayorTipoDeMoneda(int[] arrayMonedas) {
        int mayorMoneda = arrayMonedas[0];

        for (int i = 0; i < arrayMonedas.length; i++) {
            if (arrayMonedas[i] > mayorMoneda) {
                mayorMoneda = arrayMonedas[i];
            }
        }
        
        return mayorMoneda;
    }
}
