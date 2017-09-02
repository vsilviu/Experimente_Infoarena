package experimente.biti_2_star;

import java.util.stream.IntStream;

import static java.lang.System.out;


public class Biti {

    private static int n = 12;
    private static int min_len = (int) Math.pow(2, n) + n - 1;
    private static String sol = "";

    private static void print() {
        System.out.println(min_len);
        System.out.print(sol);
        out.println();
    }

    private static boolean isValid(int i, int step) {
        String lastNumber = sol.substring(step - n + 1, step) + i;
        return !sol.contains(lastNumber);
    }

    private static boolean back(int step) {
        if (step == min_len) {
            print();
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (isValid(i, step)) {
                sol += i;
                if (back(step + 1)) {
                    return true;
                }
                sol = sol.substring(0, sol.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, n).forEach(i -> sol += "0");
        back(n);
    }

}
