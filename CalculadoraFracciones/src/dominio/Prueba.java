package dominio;

import java.util.concurrent.CopyOnWriteArrayList;

public class Prueba {
    public static void main(String[] args) {
    	
        Fraccion fracionUno = Fraccion.crear(1,7);
        Fraccion fracionDos = Fraccion.crear(1,8);
        Mixto mixto =  Mixto.crear(1,3,4);
      //  System.out.println(Calculadora.restar(fracionUno,fracionDos));
        System.out.println(Calculadora.multiplicar(fracionUno, fracionDos));
        System.out.println(Calculadora.sumar(fracionUno, fracionDos));
      //  System.out.println(Calculadora.convertirAFraccion(mixto).toString());
      //  System.out.println(Calculadora.amplificar(fracionUno,5));
        
     //   System.out.println(Calculadora.dividir(fracionUno, fracionDos));
        
        
        

    }
}