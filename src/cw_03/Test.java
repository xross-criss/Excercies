package cw_03;

public class Test {
    public static void main(String[] args) {

        Muzyk[] muzycy = {new Pianista("Jan", 1.5),     // Imię, czas wystąpienia (w godz.)
                new Flecista("Adam", 1),
                new Perkusista("Sebastian", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.nazwisko() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));        // muzyk otrzymujący najwyższe honorarium

    }
}
