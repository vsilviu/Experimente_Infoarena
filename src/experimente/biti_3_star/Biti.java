package experimente.biti_3_star;

import java.util.Arrays;

import static java.lang.System.out;


public class Biti {

    private static int n = 3;
    private static int min_len = (int) Math.pow(2, n) + n - 1;
    private static Integer[] sol = new Integer[100];
    private static boolean[] visited = new boolean[100];

    private static void print() {
        Arrays.stream(sol).filter(e -> e != null).forEach(out::print);
        out.println();
    }

    private static boolean isOptimal(int step) {
        if (step < n) return true;
        int lastNumber = getNumberFromIndex(step);
        if (visited[lastNumber]) {
//            System.out.print("Found a bad solution: ");
//            print();
            return false;
        }
        visited[lastNumber] = true;
        return true;
    }

    private static int getNumberFromIndex(int index) {
        int lastNumber = 0;
        for (int j = index; j >= index - n + 1; --j) {
            lastNumber += sol[j] * (int) Math.pow(2, index - j);
        }
//        System.out.println(lastNumber);
        return lastNumber;
    }

    private static void back(int step) {

            for (int i = 0; i < 2; ++i) {
                sol[step] = i;
                if (step <= min_len && isOptimal(step)) {
                    print();
                }
                back(step + 1);
            }

    }

    public static void main(String[] args) {
        visited[0] = true;
        back(0);
    }

}
