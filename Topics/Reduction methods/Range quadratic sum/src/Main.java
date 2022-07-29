import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return IntStream.range(fromIncl, toExcl)
                .reduce(0, (sum, n) -> sum + n * n);
    }
}