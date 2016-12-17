package experimente.sume_1_star;

import java.util.Arrays;

/**
 * Created by vlasceanusilviu on 12/11/16.
 */
public class Main {

    public static void main(String[] args) {

        doStuff();
    }

    private static void findP() {
        int p = 15;
        int n = 2;

        while (n * (n - 1) < 2 * p) {
            ++n;
        }

        if (n * (n - 1) == 2 * p) {
            System.out.println("n = " + n);
        }
    }

    private static void doStuff() {
        int[] vector = {5, 7, 15, 10, 8, 8, 16, 11, 9, 18, 13, 11, 21, 19, 14};
        Arrays.sort(vector);

        int firstElem = vector[0];
        int secondElem = vector[1];
        int thirdElem = vector[2];

        vector = Arrays.stream(vector).map(elem -> elem - firstElem).toArray();

        for (int elem : vector) {
            System.out.print(elem + " ");
        }
        System.out.println();

        vector = Arrays.stream(vector).map(elem -> elem - secondElem).toArray();
        for (int elem : vector) {
            System.out.print(elem + " ");
        }
        System.out.println();

        vector = Arrays.stream(vector).map(elem -> elem - thirdElem).toArray();
        for (int elem : vector) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}
