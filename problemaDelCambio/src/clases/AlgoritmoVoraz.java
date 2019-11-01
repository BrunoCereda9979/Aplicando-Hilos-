/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Alejandro
 */
public class AlgoritmoVoraz extends Thread {
    private final Contenedor miContenedor; //Contenedor con el algoritmo voraz
    private final int objetivoFinal; //Es el valor del cambio total al que se quiere llegar
    private final int tiposDeMonedas  [] = new int[4]; //Array con todos los tipos de monedas
    private String solucionFinal = "";
    
    //Metodo Constructor
    public AlgoritmoVoraz (Contenedor contenedor, int objetivo, int valoresMonedas[]) {
        this.miContenedor = contenedor;
        this.objetivoFinal = objetivo;
        this.tiposDeMonedas[0] = valoresMonedas[0];
        this.tiposDeMonedas[1] = valoresMonedas[1];
        this.tiposDeMonedas[2] = valoresMonedas[2];
        this.tiposDeMonedas[3] = valoresMonedas[3];
    }
    
    @Override
    public void run () {
        long tiempoInicio = System.currentTimeMillis();
        
        try {
            this.solucionFinal = miContenedor.algoritmoVoraz(objetivoFinal, tiposDeMonedas);
        } 
        catch (Exception e) {
            System.out.println("Error de ejecucion " + e.getMessage());
        }
        
        System.out.println("La solucion del algoritmo voraz es:");
        System.out.println(solucionFinal);
        
        long tiempoFinalizacion = System.currentTimeMillis();
        
        System.out.println("El voraz tardó " + (tiempoFinalizacion - tiempoInicio) + " ms\n");
    }
    
    public String getResultado () {
        return solucionFinal;
    }
}
