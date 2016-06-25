package cw_03;

public class Flecista extends Muzyk {

    public Flecista(String nazwisko, int czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() {
        return "flet";
    }

    @Override
    public double stawka() {
        return 300;
    }

}
