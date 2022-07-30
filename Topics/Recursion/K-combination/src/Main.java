import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void makeCombi(ArrayDeque<ArrayDeque<Integer>> ans, ArrayDeque<Integer> tmp, int n, int left, int k) {
        if (k == 0) {
            ans.push(tmp);
            return;
        }

        for (int i = left; i <= n; ++i) {
            tmp.push(i);
            makeCombi(ans, tmp, n, i + 1, k - 1);
            tmp.pop();
        }
    }

    public static int comb(int n, int k) {
        ArrayDeque<ArrayDeque<Integer>> ans = new ArrayDeque<>();
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        makeCombi(ans, tmp, n, 1, k);
        return ans.size();
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        System.out.println(comb(n, k));
    }
}