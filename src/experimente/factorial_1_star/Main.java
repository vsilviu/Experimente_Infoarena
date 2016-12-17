package experimente.factorial_1_star;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {

    private static int countZeroIn(int N) {
        int p = 0;
        int pow = 5;

        while (pow <= N) {
            p += N / pow;
            pow *= 5;
        }

        return p;
    }

    private static int binarySearch(int left, int right, int p) {
        if (left == right) {
            if (countZeroIn(5 * left) != p) {
                return -1;
            }
            return left * 5;
        } else if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;

        int N = 5 * middle;
        int zeroCount = countZeroIn(N);
        if (zeroCount == p) {
            return N;
        } else if (zeroCount > p) return binarySearch(left, middle - 1, p);
        else return binarySearch(middle + 1, right, p);
    }

    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(new FileInputStream("fact.in"));
        int p = reader.nextInt();
        int N;

        if (p == 0) {
            N = 1;
        } else {
            N = binarySearch(1, (int) Math.pow(10, 8), p);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("fact.out"));
        writer.write(String.valueOf(N));
        writer.close();
        reader.close();
    }
}
