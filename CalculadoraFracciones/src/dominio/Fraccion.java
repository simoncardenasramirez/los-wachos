package dominio;

import exceptions.DivisionPorCeroException;

public class Fraccion {

    private long numerador;
    private long denominador;

    protected Fraccion(long numerador, long denominador) {
        setNumerador(numerador);
        setDenominador(denominador);
    }

    public static Fraccion crear(long numerador, long denominador){
        return new Fraccion(numerador,denominador);
    }

    public long getNumerador() {
        return numerador;
    }

    public long getDenominador() {
        return denominador;
    }

    private void setNumerador(long numerador) {

        this.numerador = numerador;
    }

    private void setDenominador(long denominador) {
        if(denominador == 0){
            throw new DivisionPorCeroException("No es posible tener un denominador = 0");
        }
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return getNumerador() + "/" + getDenominador();
    }
}