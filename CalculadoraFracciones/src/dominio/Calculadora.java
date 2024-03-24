package dominio;

import exceptions.AmplificadorCeroException;
import exceptions.DivisionPorCeroException;
import exceptions.FraccionNullException;

public class Calculadora {


    private Calculadora(){
        super();
    }
    
   
    public static void verificarFraccionNula (Fraccion fraccion, String mensaje) {
    	
    	if (fraccion== null){
            throw new FraccionNullException(mensaje);
        }  	
    	
    }
    
    
    public static Fraccion sumar(Fraccion fraccionUno, Fraccion fraccionDos){
    	
        verificarFraccionNula(fraccionUno, "La fraccion uno no puede estar vacia al hacer la operacion sumar");
        verificarFraccionNula(fraccionDos, "La fraccion dos no puede estar vacia al hacer la operacion sumar");
        
        long numerador = fraccionUno.getNumerador() * fraccionDos.getDenominador() + fraccionUno.getDenominador() * fraccionDos.getNumerador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getDenominador();
        
        return simplificar(Fraccion.crear(numerador, denominador));
    }

    
    public static Fraccion restar(Fraccion fraccionUno, Fraccion fraccionDos){
    	
    	verificarFraccionNula(fraccionUno, "La fraccion uno no puede estar vacia al hacer la operacion restar");
        verificarFraccionNula(fraccionDos, "La fraccion dos no puede estar vacia al hacer la operacion restar");
           
        Fraccion nuevafraccionDos = Fraccion.crear( fraccionDos.getNumerador() * (-1)  , fraccionDos.getDenominador());
        
        return sumar(fraccionUno,nuevafraccionDos );
    }
    

    public static Fraccion multiplicar(Fraccion fraccionUno, Fraccion fraccionDos) {
        
    	verificarFraccionNula(fraccionUno, "La fraccion uno no puede estar vacia al hacer la operacion multiplicar");
        verificarFraccionNula(fraccionDos, "La fraccion dos no puede estar vacia al hacer la operacion multiplicar");
           
        long numeradorResultado = fraccionUno.getNumerador() * fraccionDos.getNumerador();
        long denominadorResultado = fraccionUno.getDenominador() * fraccionDos.getDenominador();
        
        Fraccion resultado = Fraccion.crear(numeradorResultado, denominadorResultado);
        
        return Calculadora.simplificar(resultado);
    }
    

    
    public static Fraccion dividir(Fraccion fraccionUno, Fraccion fraccionDos){
    	
    	verificarFraccionNula(fraccionUno, "La fraccion uno no puede estar vacia al hacer la operacion dividir");
        verificarFraccionNula(fraccionDos, "La fraccion dos no puede estar vacia al hacer la operacion dividir");
        
        if(fraccionDos.getNumerador() == 0) {
        	throw new DivisionPorCeroException("El numerador de la fraccion dos no puede ser cero al hacer la operacion dividir");
        }
           
        Fraccion nuevaFraccionDos = Fraccion.crear(  fraccionDos.getDenominador()   , fraccionDos.getNumerador() );

        return simplificar(Calculadora.multiplicar(fraccionUno, nuevaFraccionDos));
    }


    public static Mixto sumar(Mixto mixtoUno, Mixto mixtoDos){
    	
    	verificarFraccionNula(mixtoUno, "La fraccion mixta uno no puede estar vacia al hacer la operacion sumar");
        verificarFraccionNula(mixtoDos, "La fraccion mixta dos no puede estar vacia al hacer la operacion sumar");
    	
        Fraccion fraccionUno = Calculadora.convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = Calculadora.convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(sumar(fraccionUno, fraccionDos));
        
        return   convertirAMixto(resultado);
    }


    public static Mixto restar(Mixto mixtoUno, Mixto mixtoDos){
    	
    	verificarFraccionNula(mixtoUno, "La fraccion mixta uno no puede estar vacia al hacer la operacion restar");
        verificarFraccionNula(mixtoDos, "La fraccion mixta dos no puede estar vacia al hacer la operacion restar");
    	
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(restar(fraccionUno, fraccionDos));

        return   convertirAMixto(resultado);
    }

    
    public static Mixto multiplicar(Mixto mixtoUno, Mixto mixtoDos){
    	
    	verificarFraccionNula(mixtoUno, "La fraccion mixta uno no puede estar vacia al hacer la operacion multiplicar");
        verificarFraccionNula(mixtoDos, "La fraccion mixta dos no puede estar vacia al hacer la operacion multiplicar");
    	
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(multiplicar(fraccionUno, fraccionDos));
        
        return   convertirAMixto(resultado);
    }

    
    public static Mixto dividir(Mixto mixtoUno, Mixto mixtoDos){
    	
    	verificarFraccionNula(mixtoUno, "La fraccion mixta uno no puede estar vacia al hacer la operacion dividir");
        verificarFraccionNula(mixtoDos, "La fraccion mixta dos no puede estar vacia al hacer la operacion dividir");
        
        if (mixtoDos.getParteEntera() == 0 && mixtoDos.getNumerador() == 0) {
        	throw new DivisionPorCeroException("La parte entera y el numerador de la fraccion mixta dos no pueden ser cero al hacer la operacion dividir");
        }
    	
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(dividir(fraccionUno, fraccionDos));

        return   convertirAMixto(resultado);
    }
    
    
    public static Fraccion simplificar(Fraccion fraccion){
    	
    	verificarFraccionNula(fraccion, "La fraccion no puede estar vacia al hacer la operacion simplificar");
    	
        long mcd = calcularMCD(fraccion.getNumerador(), fraccion.getDenominador());

        long numerador= fraccion.getNumerador() / mcd;
        long denominador = fraccion.getDenominador() / mcd;
        
        return Fraccion.crear(numerador,denominador);
    }


    public static Fraccion amplificar(Fraccion fraccion, long amplificador){
    	
    	verificarFraccionNula(fraccion, "La fraccion no puede estar vacia al hacer la operacion amplificar");
         
        if (amplificador == 0){
            throw new AmplificadorCeroException("El amplificador no puede ser cero");
        }

        long numerador= fraccion.getNumerador() * amplificador;
        long denominador = fraccion.getDenominador() * amplificador;

        return Fraccion.crear(numerador,denominador);
    }


    public static long calcularMCD(long numeroUno, long numeroDos) {
    	
        while (numeroDos != 0) {
            long temp = numeroDos;
            numeroDos = numeroUno % numeroDos;
            numeroUno = temp;
        }

        return numeroUno;
    }


    public static boolean esIrreductible(Fraccion fraccion) {
    	
    	verificarFraccionNula(fraccion, "La fraccion no puede estar vacia para verificar si es Irreductible");
    	
        return calcularMCD(fraccion.getNumerador(), fraccion.getDenominador()) == 1;
    }


    public static boolean esPropia(Fraccion fraccion){
    	
    	verificarFraccionNula(fraccion, "La fraccion no puede estar vacia para verificar si es propia");
    	
        return fraccion.getDenominador() > fraccion.getNumerador();

    }


    public static Mixto convertirAMixto(Fraccion fraccion){
    	
    	verificarFraccionNula(fraccion, "La fraccion  no puede estar vacia para convertirla a una fraccion mixta");
    	
        Fraccion fraccionSimplificada = simplificar(fraccion);

        long parteEntera = fraccionSimplificada.getNumerador()/ fraccionSimplificada.getDenominador();
        long numerador = fraccionSimplificada.getNumerador() - (parteEntera* fraccionSimplificada.getDenominador());
        long denominador = (fraccionSimplificada.getDenominador());

        return Mixto.crear(parteEntera ,numerador, denominador);
    }


    public static Fraccion convertirAFraccion(Mixto mixto) {
    	
    	verificarFraccionNula(mixto, "La fraccion  no puede estar vacia para convertirla a una fraccion");
       
        long numerador = (mixto.getParteEntera()* mixto.getDenominador()) + mixto.getNumerador();
        long denominador = (mixto.getDenominador());

        return simplificar(Fraccion.crear(numerador, denominador));
    }

}