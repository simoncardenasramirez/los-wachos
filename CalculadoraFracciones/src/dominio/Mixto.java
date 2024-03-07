package dominio;

public class Mixto extends Fraccion {

    private long parteEntera;

    protected Mixto(long parteEntera, long numerador, long denominador) {
        super(numerador, denominador);
        setParteEntera(parteEntera);
    }

    public static Mixto crear(long parteEntera, long numerador, long denominador){
        return new Mixto(parteEntera, numerador, denominador);
    }

    public long getParteEntera() {
        return parteEntera;
    }

    public void setParteEntera(long parteEntera) {
        this.parteEntera = parteEntera;
    }
    @Override
    public String toString() {
        return getParteEntera() + "->" + super.toString();
    }
}