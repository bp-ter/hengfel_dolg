/*
* File: Store.java
* Author: Berta Péter
* Copyright: 2025, Berta Péter
* Group: Szoft II-2-N
* Date: 2025-04-09
* Github: https://github.com/bp-ter/
* Licenc: MIT
*/

package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    public static void saveResults(String results) {
        try {
            trySaveResults(results);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void trySaveResults(String results) throws IOException {
        File file = new File("results.txt");

        boolean isFileEmpty = !file.exists() || file.length() == 0;

        FileWriter fw = new FileWriter(file, true);

        if (isFileEmpty) {
            fw.write("area\n");
        }

        fw.write(results+"\n");
        fw.close();
    }

    public static ArrayList<Result> loadResults() {
        try {
            return tryLoadResults();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Result> tryLoadResults() throws FileNotFoundException {
        File file = new File("results.txt");
        Scanner sc = new Scanner(file);

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        ArrayList<Result> results = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            String area = parts[1];
            Result result = new Result(area);
            results.add(result);
        }
        sc.close();
        return results;
    }
}
