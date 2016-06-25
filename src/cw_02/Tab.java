package cw_02;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tab {
    public static void main(String[] args) { // main napisany własnoręcznie
/*        String home = System.getProperty ( "user.home" );
        File path = new File ( home + "/tab.txt" );*/
        File file = new File("tab.txt");

        List<Integer> list = readIntegerList(file);

        if (!list.isEmpty()) {
            writingSequence(list);
        } else {
            System.err.println("Empty list");
        }
    }


    private static void writingSequence(List<Integer> list) {
        List<Integer> indexes = new LinkedList<>();

        int max = list.get(0);
        indexes.add(0);

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
//            System.out.print(tmp);

            if (tmp > max) {
                max = tmp;
                indexes.clear();
                indexes.add(i);
            } else if (tmp == max) {
                indexes.add(i);
            }
        }

        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(", "))); // najpierw liste zamieniamy na streama, a potem mapuje na Stringa i łączy joinem

        System.out.println(max);
        //ctrl + w !!! ctrl + q

        System.out.println(indexes.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    private static List<Integer> readIntegerList(File path) {
        List<Integer> list = new LinkedList<>(); //jest szybsza jeśli mało "łazimy"
        try {
            Scanner sc = new Scanner(path);
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    list.add(sc.nextInt());
                } else {
                    System.err.println("Non-integer occurred");
                    sc.next();
                }
            }
        } catch (IOException e) {
            //e.printStackTrace ();
            System.err.println("IO Exception during read of file");
        }
        return list;
    }
}


/*CW_02_

TAB
Napisać program, który z pliku {user.home}/tab.txt  wczytuje liczby całkowite (liczby w pliku są rozdzielone dowolnymi białymi znakami)  i tworzy tablicę, zawierającą te liczby .
W tak zainicjowanej tablicy program znajduje wartość maksymalną oraz wszystkie indeksy w tablicy gdzie taka wartość się znajduje.
Program wypisuje na konsoli: 
w pierwszym wierszu - wszystkie elementy tablicy, rozdzielone spacjami
w drugim wierszu - wartość  maksymalną,
w trzecim wierszu - indeksy tablicy gdzie ta wartość się znajduje. 

Przykładowo, jeśli plik {user.home}/tab.txt zawiera:
1 5 5 3
-1 2 5 4
to na konsoli otrzymujemy:
1 5 5 3 -1 2 5 4 
5
1 2 6

W przypadku wystąpienia błędów (np. brak pliku, wadliwe dane) należy obsłużyć błąd -  wypisać na konsoli TYLKO trzy gwiazdki:

***
i zakończyć działanie programu.

Nazwa pliku, jego umiejscowienie i postać oraz postać wyniku na konsoli jest obowiązkowa. Rozwiązanie nie spełniające tych wymagań otrzymują 0 punktów.
Uwaga: proszę w żadnym razie nie linkować pliku jako zasobu do projektu Eclipse.

Uwagi dodatkowe: 
należy się przygotować na to, że w pliku jest dowolna ilość liczb,
wobec tego należy użyć klasy ArrayList do wczytywania danych, ale wymaganie stworzenia tablicy też jest obowiązkowe.
Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.
Klasę Main należy uzupełnić, tak, aby uzyskać właściwe rozwiązanie.
*/