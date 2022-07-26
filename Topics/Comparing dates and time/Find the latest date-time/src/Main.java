import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LocalDateTime latestDateTime = null;
        for (int i = 0; i < n; i++) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
            if (i == 0 || latestDateTime.compareTo(dateTime) < 0) {
                latestDateTime = dateTime;
            }
        }

        System.out.println(latestDateTime);
    }
}