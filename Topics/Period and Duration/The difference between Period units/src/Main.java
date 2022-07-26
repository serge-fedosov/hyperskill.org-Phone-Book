import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        List<Period> periods = createPeriodList(scanner);

        Period result = getSumMinusMin(periods); 

        System.out.println(result);
    }

    public static List<Period> createPeriodList(Scanner scanner) {
        List<Period> list = new ArrayList<>();
        list.add(Period.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        list.add(Period.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        list.add(Period.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        list.add(Period.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        list.add(Period.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

        return list;
    }

    private static Period getSumMinusMin(List<Period> periods) {

        Period sum = null;
        Period min = null;
        boolean first = true;
        for (var value : periods) {
            if (first) {
                sum = value;
                min = value;
                first = false;
            } else {
                sum = sum.plus(value);
                if (min.toTotalMonths() > value.toTotalMonths()) {
                    min = value;
                }
            }
        }

        sum = sum.minus(min);

        return sum;
    }
}