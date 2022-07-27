import java.time.temporal.ChronoField;
import java.util.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Instant> instantList = createInstantList(scanner);

        long result = getMaxMinusMin(instantList); 

        System.out.println(result);
    }  

    public static List<Instant> createInstantList(Scanner scanner) {
        List<Instant> instantList = new ArrayList<>();
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));
        instantList.add(Instant.parse(scanner.nextLine()));

        return instantList;
    }

    private static long getMaxMinusMin(List<Instant> instantList) {
        Instant minUnit = null;
        Instant maxUnit = null;

        boolean first = true;
        for (var unit : instantList) {
            if (first) {
                minUnit = unit;
                maxUnit = unit;
                first = false;
            } else {
                if (unit.isBefore(minUnit)) {
                    minUnit = unit;
                }

                if (unit.isAfter(maxUnit)) {
                    maxUnit = unit;
                }
            }
        }

        return maxUnit.getLong(ChronoField.INSTANT_SECONDS) - minUnit.getLong(ChronoField.INSTANT_SECONDS);


    }
}