package dominio;

import java.util.Iterator;

import Exceptions.DivisionPorCeroException;
import Exceptions.FraccionNullException;

public class Calculadora {


    private Calculadora(){
        super();
    }

    public static Fraccion sumar(Fraccion fraccionUno, Fraccion fraccionDos){
        if (fraccionUno == null){
            throw new FraccionNullException("La fraccion uno no puede estar vacia");
        }
        if (fraccionDos == null){
            throw new FraccionNullException("La fraccion dos no puede estar vacia");
        }
        long numerador = fraccionUno.getNumerador() * fraccionDos.getDenominador() + fraccionUno.getDenominador() * fraccionDos.getNumerador();
        long denominador = fraccionUno.getDenominador() * fraccionDos.getDenominador();


        return simplificar(Fraccion.crear(numerador, denominador));

    }



    public static Fraccion restar(Fraccion fraccionUno, Fraccion fraccionDos){
        if (fraccionUno == null){
            throw new FraccionNullException("La fraccion uno no puede estar vacia");
        }
        if (fraccionDos == null){
            throw new FraccionNullException("La fraccion dos no puede estar vacia");
        }
        
        Fraccion NuevafraccionDos = Fraccion.crear( fraccionDos.getNumerador() * (-1)  , fraccionDos.getDenominador());


        return sumar(fraccionUno,NuevafraccionDos );

    }


    public static Fraccion multiplicar(Fraccion fraccionUno, Fraccion fraccionDos) {
        if (fraccionUno == null) {
            throw new FraccionNullException("La fracción uno no puede estar vacía");
        }

        if (fraccionDos == null) {
            throw new FraccionNullException("La fracción dos no puede estar vacía");
        }

        Fraccion Resultadonumerador = Fraccion.crear(0, 1);
        Fraccion numeradorFraccionDos = Fraccion.crear(fraccionDos.getNumerador(), 1);

        for (int i = 0; i < fraccionUno.getNumerador(); i++) {
            Resultadonumerador = sumar(Resultadonumerador, numeradorFraccionDos);
        }

        Fraccion ResultadoDenominador = Fraccion.crear(0, 1);
        Fraccion DenominadorFraccionDos = Fraccion.crear(fraccionDos.getDenominador(), 1);

        for (int i = 0; i < fraccionUno.getDenominador(); i++) {
            ResultadoDenominador = sumar(ResultadoDenominador, DenominadorFraccionDos);
        }

        long numerador = Resultadonumerador.getNumerador();
        long denominador = ResultadoDenominador.getNumerador();

        return Calculadora.simplificar(Fraccion.crear(numerador, denominador));
    }



    public static Fraccion dividir(Fraccion fraccionUno, Fraccion fraccionDos){
        if (fraccionUno == null){
            throw new FraccionNullException("La fraccion uno no puede estar vacia");
        }
        if (fraccionDos == null){
            throw new FraccionNullException("La fraccion dos no puede estar vacia");
        }
        
        Fraccion NuevafraccionDos = Fraccion.crear(  fraccionDos.getDenominador()   , fraccionDos.getNumerador() );

        

        return simplificar(Calculadora.multiplicar(fraccionUno, NuevafraccionDos));

    }








    public static Mixto sumar(Mixto mixtoUno, Mixto mixtoDos){
        Fraccion fraccionUno = Calculadora.convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = Calculadora.convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(sumar(fraccionUno, fraccionDos));



        return   convertirAMixto(resultado);

    }



    public static Mixto restar(Mixto mixtoUno, Mixto mixtoDos){
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(restar(fraccionUno, fraccionDos));



        return   convertirAMixto(resultado);

    }


    public static Mixto multiplicar(Mixto mixtoUno, Mixto mixtoDos){
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(multiplicar(fraccionUno, fraccionDos));



        return   convertirAMixto(resultado);

    }

    public static Mixto dividir(Mixto mixtoUno, Mixto mixtoDos){
        Fraccion fraccionUno = convertirAFraccion(mixtoUno);
        Fraccion fraccionDos = convertirAFraccion(mixtoDos);

        Fraccion resultado = simplificar(dividir(fraccionUno, fraccionDos));



        return   convertirAMixto(resultado);

    }





    public static Fraccion simplificar(Fraccion fraccion){
        long mcd = calcularMCD(fraccion.getNumerador(), fraccion.getDenominador());

        long numerador= fraccion.getNumerador() / mcd;
        long denominador = fraccion.getDenominador() / mcd;



        return Fraccion.crear(numerador,denominador);

    }


    public static Fraccion amplificar(Fraccion fraccion, long amplificador){
        if (fraccion == null){
            throw new FraccionNullException("La fraccion no puede estar vacia");
        }
        if (amplificador == 0){
            throw new DivisionPorCeroException("El amplificador no puede estar vacio");
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
        if (fraccion == null){
            throw new FraccionNullException("La fraccion no puede estar vacia");
        }
        return calcularMCD(fraccion.getNumerador(), fraccion.getDenominador()) == 1;
    }




    public static boolean esPropia(Fraccion fraccion){
        if (fraccion == null){
            throw new FraccionNullException("La fraccion no puede estar vacia");
        }
        return fraccion.getDenominador() > fraccion.getNumerador();

    }



    public static Mixto convertirAMixto(Fraccion fraccion){
        if (fraccion == null){
            throw new FraccionNullException("La fraccion no puede estar vacia");
        }
        Fraccion fraccionSimplificada = simplificar(fraccion);


        long parteEntera = fraccionSimplificada.getNumerador()/ fraccionSimplificada.getDenominador();
        long numerador = fraccionSimplificada.getNumerador() - (parteEntera* fraccionSimplificada.getDenominador());
        long denominador = (fraccionSimplificada.getDenominador());

        return Mixto.crear(parteEntera ,numerador, denominador);
    }




    public static Fraccion convertirAFraccion(Mixto mixto) {
        if (mixto == null){
            throw new FraccionNullException("El mixto no puede estar vacio");
        }
        long numerador = (mixto.getParteEntera()* mixto.getDenominador()) + mixto.getNumerador();
        long denominador = (mixto.getDenominador());

        return simplificar(Fraccion.crear(numerador, denominador));
    }

}