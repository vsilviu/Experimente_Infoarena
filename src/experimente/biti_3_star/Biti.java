package experimente.biti_3_star;

import static java.lang.System.out;


public class Biti {

    private static int n = 4;
    private static int min_len = (int) Math.pow(2, n) + n - 1;
//    private static Integer[] sol = new Integer[100];
    private static String sol = "";

    private static void print() {
        System.out.print(sol);
        out.println();
    }

    private static boolean isValid(int i, int step) {
        //check for a valid step
        if (step <= n - 1) return true;
        //get the last number
        String lastNumber = sol.substring(step - n + 1, step) + i;
        //sol is valid if it does not contain last number
        return !sol.contains(lastNumber);
    }

    private static boolean back(int step) {

        if (step == min_len - 1) {
            print();
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (isValid(i, step)) {
                sol = sol + i;
                if (back(step + 1)) {
                    return true;
                }
                sol = sol.substring(0, sol.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        back(0);
    }

}
