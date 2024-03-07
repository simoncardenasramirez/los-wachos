package dominio;

public class Prueba {
    public static void main(String[] args) {
        Fraccion fracionUno = Fraccion.crear(7,4);
        Fraccion fracionDos = Fraccion.crear(-1,-2);
        Mixto mixto =  Mixto.crear(1,3,4);
        System.out.println(Calculadora.restar(fracionUno,fracionDos));
        System.out.println(Calculadora.convertirAFraccion(mixto).toString());
        System.out.println(Calculadora.amplificar(fracionUno,5));

    }
}