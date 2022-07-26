import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s");

        LocalDate date = LocalDate.parse(array[0]);
        LocalDate date2 = LocalDate.parse(array[1]);
        LocalDate date3 = LocalDate.parse(array[2]);

        if (date2.isEqual(date3)) {
            System.out.println(false);
            return;
        }

        if (date.compareTo(date2) > 0 && date.compareTo(date3) < 0 || date.compareTo(date3) > 0 && date.compareTo(date2) < 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}