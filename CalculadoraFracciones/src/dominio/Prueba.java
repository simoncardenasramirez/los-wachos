package dominio;



public class Prueba {
    public static void main(String[] args) {
    	
        Fraccion fracionUno = Fraccion.crear(2, 3);
        Fraccion fracionDos = Fraccion.crear(7,2);
      
       System.out.println(Calculadora.multiplicar(fracionUno, fracionDos));
        
    }
}