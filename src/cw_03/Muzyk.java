package cw_03;

public abstract class Muzyk {

    private String nazwisko;
    private double czas;

    protected Muzyk(String nazwisko, double czas) {
        this.nazwisko = nazwisko;
        this.czas = czas;
    }

    public String nazwisko() {
        return nazwisko;
    }

    public double czas() {
        return czas;
    }

    public abstract String instrument();

    public abstract double stawka();

    public static Muzyk maxHonorarium(Muzyk[] muzycy) {
        Muzyk tmp = muzycy[0];
        for(Muzyk m: muzycy){
            if(tmp.stawka() < m.stawka()){
                tmp = m;
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        return nazwisko + ", " + stawka() + ", " + czas;
    }
}
