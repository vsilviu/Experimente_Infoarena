package experimente.biti_2_star;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    private static Scanner reader;
    private static BufferedWriter writer;


    private static String deBrujinSequenceGenerator(int n) {
        if (n == 0) {
            return "01";
        }

        int VERTEX_COUNT = 2 << (n - 1);
        StringBuilder solution = new StringBuilder();
        boolean[] visited = new boolean[VERTEX_COUNT];
        Stack<Integer> currPath = new Stack<>();
        currPath.push(0);

        int n0, n1;
        int crtVertex = 0;

        while (!currPath.isEmpty()) {
            n0 = 2 * (crtVertex % (VERTEX_COUNT >> 1));
            n1 = n0 + 1;
            if (!visited[n0] || !visited[n1]) {
                currPath.push(crtVertex);
                if (!visited[n0]) {
                    crtVertex = n0;
                    visited[n0] = true;
                } else {
                    crtVertex = n1;
                    visited[n1] = true;
                }
            } else {
                solution.append(crtVertex & 1);
                crtVertex = currPath.pop();
            }
        }

        StringBuilder zero = new StringBuilder();

        for(int i = 0; i < n - 1; ++i) {
            zero.append(0);
        }

        return zero.append(solution.reverse()).toString();
    }


    public static void main(String[] args) throws IOException {
        reader = new Scanner(new FileInputStream("biti.in"));
        writer = new BufferedWriter(new FileWriter("biti.out"));

        int n = reader.nextInt();
        int minLen = (2 << (n - 1)) + n - 1;
        writer.write(String.valueOf(minLen) + "\n");
        writer.write(deBrujinSequenceGenerator(n));

        reader.close();
        writer.close();
    }
}
