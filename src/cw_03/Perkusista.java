package cw_03;

public class Perkusista extends Muzyk {

    public Perkusista(String nazwisko, double czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() {
        return "perkusja";
    }

    @Override
    public double stawka() {
        return 200;
    }

}
