package cw_02;

import java.io.*;

public class Create {

    public static void main(String[] args) throws IOException {
        File file = new File("tab.txt");

        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.err.println("Cannot create file");
                return;
            }
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String writings = wypiszWymaluj();
        bw.write(writings);
        bw.flush();
        bw.close(); // close robi flusha przed zamknięciem, więc nie musze go pisać

        System.out.println(writings);
    }

    private static String wypiszWymaluj() {
        String s = "";
        int n = (int) (Math.random() * 100 + 1);
        for (int i = 0; i <= n; i++) {
            s += (((int) (Math.random() * 100) + " "));
        }
        return s;
    }

}