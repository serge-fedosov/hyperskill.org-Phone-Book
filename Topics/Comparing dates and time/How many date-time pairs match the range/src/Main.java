import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime dateTime1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime dateTime2 = LocalDateTime.parse(scanner.nextLine());
        if (dateTime1.compareTo(dateTime2) > 0) {
            LocalDateTime tempDateTime = dateTime1;
            dateTime1 = dateTime2;
            dateTime2 = tempDateTime;
        }

        int n = Integer.parseInt(scanner.nextLine());

        int inRange = 0;
        for (int i = 0; i < n; i++) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());

            if (dateTime.compareTo(dateTime1) >= 0 && dateTime.compareTo(dateTime2) < 0) {
                inRange++;
            }
        }

        System.out.println(inRange);
    }
}