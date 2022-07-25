package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> phonebook = new ArrayList<>();
        List<String> find = new ArrayList<>();

        //String pathToFile = "C:\\java\\hyperskill.org\\!files\\small_directory.txt";
        String pathToFile = "C:\\java\\hyperskill.org\\!files\\directory.txt";
        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                phonebook.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found" + pathToFile);
        }

        //String pathToFile2 = "C:\\java\\hyperskill.org\\!files\\small_find.txt";
        String pathToFile2 = "C:\\java\\hyperskill.org\\!files\\find.txt";
        File file2 = new File(pathToFile2);
        try (Scanner scanner2 = new Scanner(file2)) {
            while (scanner2.hasNext()) {
                find.add(scanner2.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found" + pathToFile2);
        }


        System.out.println("Start searching...");

        long time1 = System.currentTimeMillis();

        int found = 0;
        for (int i = 0; i < find.size(); i++) {

            for (int j = 0; j < phonebook.size(); j++) {
                if (phonebook.get(j).contains(find.get(i))) {
                    found++;
                    break;
                }
            }
        }

        long time2 = System.currentTimeMillis();
        long ms = time2 - time1;
        long sec = ms / 1000;
        long min = sec / 60;
        sec = sec - min * 60;
        ms = ms - (min * 60 + sec) * 1000;

        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.", found, find.size(), min, sec, ms);

    }
}
