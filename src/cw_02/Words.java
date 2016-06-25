package cw_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Words {
    public static void main(String[] args) {

        File file = new File("textforwords.txt");

        List<String> stringList = readToList(file);
        List<String> setList = removeDuplicates(stringList);

        Map<String, Integer> entries = countEntries(stringList);

        System.out.println(stringList.stream().collect(Collectors.joining(" ")));
        System.out.println(setList.stream().collect(Collectors.joining(" ")));
/*
        for (String key : entries.keySet()) {
            System.out.println(key + " " + entries.get(key));
        }

        for (Map.Entry<String, Integer> entry : entries.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        // key[value], key[value], ...

        System.out.println(entries.entrySet().stream().map(
                e -> e.getKey() + "[" + e.getValue() + "]"
        ).collect(Collectors.joining(", ")));

    }

    private static Map<String, Integer> countEntries(List<String> list) {
        Map<String, Integer> tmp = new HashMap<>();

        for (String s : list) {
            if (!tmp.containsKey(s)) {
                tmp.put(s, 1);
            } else {
                tmp.put(s, tmp.get(s) + 1);
            }
        }
        return tmp;
    }


    private static List<String> removeDuplicates(List<String> list) {
        List<String> tmp = new LinkedList<>();
        for (String s : list) {
            if (!tmp.contains(s)) {
                tmp.add(s);
            }
        }
        return tmp;
    }


    private static List<String> readToList(File file) {
        List<String> stringList = new LinkedList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String word = sc.next();
                stringList.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ! #1");
        }
        return stringList;
    }
}

/*    private static Set<String> readWords(File file) {
        Set<String> stringSet = new LinkedHashSet<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String word = sc.next();

                stringSet.add(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found! #1");
        }
        return stringSet;
    }
}*/