package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


class Record {
    String number;
    String name;

    public Record(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Phonebook {

    public List<Record> phonebook = new ArrayList<>();

    public List<String> searchData = new ArrayList<>();


    public void read() {

        //String pathToFile = "C:\\java\\hyperskill.org\\!files\\small_directory.txt";
        String pathToFile = "C:\\java\\hyperskill.org\\!files\\directory.txt";
        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                phonebook.add(new Record(scanner.next(), scanner.nextLine().trim()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found" + pathToFile);
        }

    }

    public void readSearchData() {

        //String pathToFile = "C:\\java\\hyperskill.org\\!files\\small_find.txt";
        String pathToFile = "C:\\java\\hyperskill.org\\!files\\find.txt";
        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                searchData.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found" + pathToFile);
        }

    }

    public int linearSearch() {

        int found = 0;
        for (int i = 0; i < searchData.size(); i++) {

            for (int j = 0; j < phonebook.size(); j++) {
                if (phonebook.get(j).getName().contains(searchData.get(i))) {
                    found++;
                    break;
                }
            }
        }

        return found;
    }

    public void sort(long time) throws TimeoutException {
        long time1 = System.currentTimeMillis();

        for (int i = phonebook.size() - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (phonebook.get(j).getName().compareTo(phonebook.get(j + 1).getName()) > 0) {
                    Record temp = phonebook.get(j);
                    phonebook.set(j, phonebook.get(j + 1));
                    phonebook.set(j + 1, temp);
                }
            }
//            if ((System.currentTimeMillis() - time1) > time * 10) {
            if ((System.currentTimeMillis() - time1) > time) {
                throw new TimeoutException();
            }
        }
    }

    public int jumpSearch(String value) {

        if (phonebook.size() == 0) {
            return -1;
        }

        int curr = 1;
        int prev = 1;
        int last = phonebook.size();
        int step = (int) Math.floor(Math.sqrt(last));

        while (phonebook.get(curr - 1).getName().compareTo(value) < 0) { // <
            if (curr == last) {
                return -1;
            }

            prev = curr;
            curr = Math.min(curr + step, last);
        }

        while (phonebook.get(curr - 1).getName().compareTo(value) > 0) { // >
            curr--;

            if (curr <= prev) {
                return -1;
            }
        }

        if (phonebook.get(curr - 1).getName().compareTo(value) == 0) {
            return curr - 1;
        }

        return -1;
    }

    public int jumpSearch() {

        int found = 0;
        for (int i = 0; i < searchData.size(); i++) {

            if (jumpSearch(searchData.get(i)) != -1) {
                found++;
            }
        }

        return found;
    }


    private long min(long ms) {
        return (ms / 1000) / 60;
    }

    private long sec(long ms) {
        return (ms / 1000) % 60;
    }

    private long ms(long ms) {
        return ms % 1000;
    }


    public void quickSort(int low, int high) {
        if (phonebook.size() == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        String opora = phonebook.get(middle).getName();

        int i = low, j = high;
        while (i <= j) {
            while (phonebook.get(i).getName().compareTo(opora) < 0) { // <
                i++;
            }

            while (phonebook.get(j).getName().compareTo(opora) > 0) { // >
                j--;
            }

            if (i <= j) {
                Record temp = phonebook.get(i);
                phonebook.set(i, phonebook.get(j));
                phonebook.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }
    public void quickSort1() {
        quickSort(0, phonebook.size() - 1);
        int k = 0;
    }


    public int binarySearch(String value) {

        int left = 1;
        int right = phonebook.size();;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (phonebook.get(middle - 1).getName().compareTo(value) == 0) { // ==
                return middle;
            } else if (phonebook.get(middle - 1).getName().compareTo(value) > 1) { // >
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public int binarySearch() {

        int found = 0;
        for (int i = 0; i < searchData.size(); i++) {

            if (binarySearch(searchData.get(i)) != -1) {
                found++;
            }
        }

        return found;

    }

    public void test() {

        read();
        readSearchData();

        System.out.println("Start searching (linear search)...");

        long timeLinearSearch1 = System.currentTimeMillis();
        int found = linearSearch();
        long timeLinearSearch2 = System.currentTimeMillis();

        long time = timeLinearSearch2 - timeLinearSearch1;
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.", found, searchData.size(),
                min(time), sec(time), ms(time));


        System.out.println("\n");
        System.out.println("Start searching (bubble sort + jump search)...");

        long time1 = System.currentTimeMillis();
        boolean exc = false;
        try {
            sort(time);
        } catch (TimeoutException e) {
            exc = true;
        }
        long timeSort = System.currentTimeMillis() - time1;

        long time2 = System.currentTimeMillis();
        int found2 = 0;
        if (exc) {
            found2 = linearSearch();
        } else {
            found2 = jumpSearch();
        }
        long timeSearching = System.currentTimeMillis() - time2;
        long timeTotal = System.currentTimeMillis() - time1;

        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.", found2, searchData.size(),
                min(timeTotal), sec(timeTotal), ms(timeTotal));
        System.out.println();

        if (exc) {
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search",
                    min(timeSort), sec(timeSort), ms(timeSort));
        } else {
            System.out.printf("Sorting time: %d min. %d sec. %d ms.", min(timeSort), sec(timeSort), ms(timeSort));
        }
        System.out.println();
        System.out.printf("Searching time: %d min. %d sec. %d ms.", min(timeSearching), sec(timeSearching), ms(timeSearching));


        System.out.println("\n");
        System.out.println("Start searching (quick sort + binary search)...");
        long timeQuickSort1 = System.currentTimeMillis();
        quickSort1();
        long timeQuickSort2 = System.currentTimeMillis();

        long timeQuickSort = timeQuickSort2 - timeQuickSort1;

        found = binarySearch();
        long timeBinarySearch2 = System.currentTimeMillis();

        long timeBinarySearch = timeBinarySearch2 - timeQuickSort2;
        time = timeBinarySearch2 - timeQuickSort1;

        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.", found, searchData.size(),
                min(time), sec(time), ms(time));

        System.out.println();
        System.out.printf("Sorting time: %d min. %d sec. %d ms.", min(timeQuickSort), sec(timeQuickSort), ms(timeQuickSort));
        System.out.println();
        System.out.printf("Searching time: %d min. %d sec. %d ms.", min(timeBinarySearch), sec(timeBinarySearch), ms(timeBinarySearch));

    }

}

public class Main {

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();
        phonebook.test();

    }
}
