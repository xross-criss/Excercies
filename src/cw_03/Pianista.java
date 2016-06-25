package cw_03;

public class Pianista extends Muzyk {

    public Pianista(String nazwisko, double czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() {
        return "pianino";
    }

    @Override
    public double stawka() {
        return 500;
    }

}
