package experimente.cifra_1_star;

/**
 * Created by vlasceanusilviu on 12/5/16.
 */
public class Cifra {

    private static int[][] digits = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {2, 4, 8, 6},
            {3, 9, 7, 1},
            {4, 6, 4, 6},
            {5, 5, 5, 5},
            {6, 6, 6, 6},
            {7, 9, 3, 1},
            {8, 4, 2, 6},
            {9, 1, 9, 1}};

    private static int[][] partialSums = new int[10][10];

    public static void main(String[] args) {

        initPartialSums();


        for (int n = 0; n <= 100; ++n) {
            int lastDigit = n % 10;
            int preLastDigit = n / 10 % 10;
            int result = 0;

            for (int i = 1; i <= 9; ++i) {

                if (i <= lastDigit) {
                    if (i == 2 || i == 3 || i == 5 || i == 7 || i == 8) {
                        result = (result + partialSums[i][preLastDigit % 2]) % 10;
                    } else if (i == 4 || i == 6) {
                        result = (result + partialSums[i][preLastDigit % 5]) % 10;
                    } else if (i == 1) {
                        result = (result + preLastDigit + 1) % 10;
                    } else {
                        result = (result + 10 - preLastDigit - 1) % 10;
                    }
                } else if (preLastDigit != 0) {
                    if (i == 2 || i == 3 || i == 5 || i == 7 || i == 8) {
                        result = (result + partialSums[i][(preLastDigit - 1) % 2]) % 10;
                    } else if (i == 4 || i == 6) {
                        result = (result + partialSums[i][(preLastDigit - 1) % 5]) % 10;
                    } else if (i == 1) {
                        result = (result + preLastDigit) % 10;
                    } else {
                        result = (result + 10 - preLastDigit) % 10;
                    }
                }

            }

            int s = 0;

            for (int i = 1; i <= n; ++i) {
                s = (s + digits[i % 10][(i - 1) % 4]) % 10;
            }

            System.out.println("Metoda clasica: n = " + n + " => s = " + s);
            System.out.println("Metoda custom: n = " + n + " => result = " + result);
            System.out.println("************");
        }
    }

    private static void initPartialSums() {
        partialSums[2][0] = 4;
        partialSums[2][1] = 0;

        partialSums[3][0] = 7;
        partialSums[3][1] = 0;

        partialSums[4][0] = 6;
        partialSums[4][1] = 2;
        partialSums[4][2] = 8;
        partialSums[4][3] = 4;
        partialSums[4][4] = 0;

        partialSums[5][0] = 5;
        partialSums[5][1] = 0;

        partialSums[6][0] = 6;
        partialSums[6][1] = 2;
        partialSums[6][2] = 8;
        partialSums[6][3] = 4;
        partialSums[6][4] = 0;

        partialSums[7][0] = 3;
        partialSums[7][1] = 0;

        partialSums[8][0] = 6;
        partialSums[8][1] = 0;
    }

}
