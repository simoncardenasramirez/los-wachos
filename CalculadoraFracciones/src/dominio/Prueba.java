package dominio;



public class Prueba {
    public static void main(String[] args) {
    	
        Fraccion fraccionUno = Fraccion.crear(2, 3);
        Fraccion fraccionDos = Fraccion.crear(7,2);
        
        Mixto fraccionMixtaUno = Mixto.crear(2, 3, 7);
        Mixto fraccionMixtaDos = Mixto.crear(8, 5, 7);
      
        	
        // fraccion 
        System.out.println("fraccion");
        System.out.println(Calculadora.sumar(fraccionUno, fraccionDos));
        System.out.println(Calculadora.restar(fraccionUno, fraccionDos));
        System.out.println(Calculadora.multiplicar(fraccionUno, fraccionDos));
        System.out.println(Calculadora.dividir(fraccionUno, fraccionDos));
        
        // fraccio mixta
        System.out.println("fraccion mixta ");
        System.out.println(Calculadora.sumar(fraccionMixtaUno, fraccionMixtaDos));
        System.out.println(Calculadora.restar(fraccionMixtaUno, fraccionMixtaDos));
        System.out.println(Calculadora.multiplicar(fraccionMixtaUno, fraccionMixtaDos));
        System.out.println(Calculadora.dividir(fraccionMixtaUno, fraccionMixtaDos));
               
    }
}