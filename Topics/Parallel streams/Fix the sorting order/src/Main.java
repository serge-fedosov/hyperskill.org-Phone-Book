import java.util.Arrays;
import java.util.Scanner;

class ParallelMapping {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Arrays.stream(SCANNER.nextLine().split("\\s+"))
                .parallel()
                .map(Integer::parseInt)
                .sorted()
                .map(n -> n * 2)
                .forEachOrdered(System.out::println);
    }
}