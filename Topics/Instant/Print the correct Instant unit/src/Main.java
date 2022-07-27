import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        subtractFromEpoch(scanner.nextInt(), scanner.next());
    } 

    public static void subtractFromEpoch(int days, String zone) {
        Instant epoch = Instant.EPOCH;
        epoch = epoch.minus(Period.ofDays(days));
        System.out.println(epoch.atZone(ZoneId.of(zone)));
    }
}