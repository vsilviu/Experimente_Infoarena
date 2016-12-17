package experimente.fractal_1_star;

import java.io.*;
import java.util.Scanner;

class Main {

    private static final int[][] matrix = {{0, 1}, {3, 2}};

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new FileInputStream("fractal.in"));

        int k = reader.nextInt();
        int x = reader.nextInt();
        int y = reader.nextInt();

        System.out.println(k + " " + x + " " + y);

        BufferedWriter writer = new BufferedWriter(new FileWriter("fractal.out"));
        writer.write(String.valueOf(findLength(k, x, y)));
        writer.close();
        reader.close();
    }

    private static int findLength(int k, int x, int y) {

        if (k == 1) return matrix[x - 1][y - 1];

        int halfGridLength = powOfTwo(k - 1);
        int quadrant = matrix[x / (halfGridLength + 1)][y / (halfGridLength + 1)];

        switch (quadrant) {
            case 0:
                return findLength(k - 1, y, x);

            case 1:
                return powOfTwo(2 * k - 2) + findLength(k - 1, x, y - halfGridLength);

            case 2:
                return 2 * powOfTwo(2 * k - 2) + findLength(k - 1, x - halfGridLength, y - halfGridLength);

            default:
                return 3 * powOfTwo(2 * k - 2) + findLength(k - 1, halfGridLength - y + 1, 2 * halfGridLength - x + 1);
        }
    }

    private static int powOfTwo(int k) {
        return (int) Math.pow(2, k);
    }


}
