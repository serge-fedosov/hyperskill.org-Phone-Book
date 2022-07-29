import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        return codes.stream()
                .dropWhile(s -> s.compareTo("#0000") > 0)
                .takeWhile(s -> s.compareTo("#FFFF") < 0)
                .filter(s -> !s.equals("#0000"))
                .toList();
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}