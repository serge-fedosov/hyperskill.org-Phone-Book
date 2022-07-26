import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalTime time = LocalTime.parse("20:00");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] store = scanner.nextLine().split("\\s");
            LocalTime timeClose = LocalTime.parse(store[1]);
            if (time.isBefore(timeClose)) {
                System.out.println(store[0]);
            }
        }
    }
}