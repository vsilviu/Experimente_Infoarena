package experimente.biti_2_star;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static int n;
    private static int min_len;
    private static String sol = "";
    private static Scanner reader;
    private static BufferedWriter writer;

    private static boolean isValid(int i, int step, final String sol) {
        String lastNumber = sol.substring(step - n + 1, step) + i;
        return !sol.contains(lastNumber);
    }

    private static boolean back(int step, String sol) throws IOException {
        if (step == min_len) {
            writer.write(sol);
            return true;
        }
        for (int i = 0; i < 2; ++i) {
            if (isValid(i, step, sol)) {
                sol += i;
                if (back(step + 1, sol)) return true;
                sol = sol.substring(0, sol.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        reader = new Scanner(new FileInputStream("biti.in"));
        writer = new BufferedWriter(new FileWriter("biti.out"));

        n = reader.nextInt();
        min_len = (int) Math.pow(2, n) + n - 1;
        writer.write(String.valueOf(min_len) + "\n");

        for (int i = 0; i < n; ++i) {
            sol += "0";
        }
        back(n, sol);

        reader.close();
        writer.close();
    }
}
