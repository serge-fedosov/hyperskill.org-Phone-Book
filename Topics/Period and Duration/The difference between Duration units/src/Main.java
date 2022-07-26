import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Duration> durations = createDurationList(scanner);

        Duration result = getMaxMinusAvg(durations);

        System.out.println(result);
    }

    public static List<Duration> createDurationList(Scanner scanner) {
        List<Duration> list = new ArrayList<>();
        list.add(Duration.of(scanner.nextInt(), ChronoUnit.DAYS));
        list.add(Duration.of(scanner.nextInt(), ChronoUnit.HOURS));
        list.add(Duration.of(scanner.nextInt(), ChronoUnit.MINUTES));
        list.add(Duration.of(scanner.nextInt(), ChronoUnit.MINUTES));
        list.add(Duration.of(scanner.nextInt(), ChronoUnit.SECONDS));

        return list;
    }

    public static Duration getMaxMinusAvg(List<Duration> durations) {
        Duration sum = null;
        Duration max = null;
        boolean first = true;
        for (var value : durations) {
            if (first) {
                sum = value;
                max = value;
                first = false;
            } else {
                sum = sum.plus(value);
                if (max.getSeconds() < value.getSeconds()) {
                    max = value;
                }
            }
        }

        return max.minus(sum.dividedBy(durations.size()));
    }
}