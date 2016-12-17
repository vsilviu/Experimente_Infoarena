package experimente.cifra_1_star;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {

    private static int[] partialSums = new int[100];

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
            {9, 1, 9, 1},
    };

    private static void initPartialSums() {
        for (int i = 1; i <= 99; ++i) {
            partialSums[i] = (partialSums[i - 1] + digits[i % 10][(i - 1) % 4]) % 10;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new FileInputStream("cifra.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("cifra.out"));

        int lastDigit;
        int preLastDigit;
        int result;
        String n;

        initPartialSums();

        int T = reader.nextInt();

        for (; T > 0; --T) {
            n = reader.next();

            lastDigit = n.charAt(n.length() - 1) - '0';
            preLastDigit = n.length() >= 2 ? n.charAt(n.length() - 2) - '0' : 0;
            result = partialSums[preLastDigit * 10 + lastDigit];

            writer.write(String.valueOf(result) + "\n");
        }

        reader.close();
        writer.close();
    }

}
