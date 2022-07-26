import java.time.LocalTime;
import java.util.Scanner;

class Main {

    private static boolean inRange(LocalTime time, LocalTime timeMin, LocalTime timeMax) {
        if (time.compareTo(timeMin) >= 0 && time.compareTo(timeMax) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range1 = scanner.nextLine().split("\\s");
        String[] range2 = scanner.nextLine().split("\\s");

        LocalTime time1Min = LocalTime.parse(range1[0]);
        LocalTime time1Max = LocalTime.parse(range1[1]);

        LocalTime time2Min = LocalTime.parse(range2[0]);
        LocalTime time2Max = LocalTime.parse(range2[1]);

        if (inRange(time1Min, time2Min, time2Max) || inRange(time1Max, time2Min, time2Max) ||
                inRange(time2Min, time1Min, time1Max) || inRange(time2Max, time1Min, time1Max)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}