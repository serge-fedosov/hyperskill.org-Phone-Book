import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s");

        LocalDate date = LocalDate.parse(array[0]);
        date = date.plusDays(Integer.parseInt(array[1]));

        if (date.getDayOfMonth() == 1 && date.getMonthValue() == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}