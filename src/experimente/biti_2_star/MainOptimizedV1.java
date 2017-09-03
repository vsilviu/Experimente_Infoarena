package experimente.biti_2_star;

import java.util.Stack;
import java.util.stream.IntStream;

public class MainOptimizedV1 {

    /**
     * The order of DeBrujin Graph with 2 symbols
     */
    private static int n = 13;
    private static boolean[] visited = new boolean[2 << n];
    private static Stack<Integer> sol = new Stack<>();

    /**
     * Test that vertices are generated correctly for given n.
     * An example of generation is given in observations file.
     */
    private static void verifyVerticesGeneration() {
        System.out.println("################");
        System.out.println();
        IntStream
                .range(0, (int) Math.pow(2, n))
                .forEach(i -> {
                    int x = i;
                    int y = 2 * (i % (int) Math.pow(2, n - 1));
                    System.out.println(String.format("Vertices for index %d are [(%d,%d),(%d,%d)]", i, x, y, x, y + 1));
                });
        System.out.println();
        System.out.println("################");
    }

    static {
        sol.push(0);
        visited[0] = true;
    }

    private static boolean back(int x) {
        //if final solution return true
        if (sol.size() >= 2 << (n - 1)) {
            sol.forEach(s -> System.out.print(Integer.toString(s, 2) + " "));
            return true;
        }
        int y = 2 * (x % (int) Math.pow(2, n - 1));
        for (int i = y; i <= y + 1; ++i) {
            //if is valid
            int rightSideOfX = ((2 << (n - 2)) - 1) & x;
            int leftSideOfI = i >> 1;
            if (rightSideOfX == leftSideOfI && !visited[i]) {
                sol.push(i);
                visited[i] = true;
                if (back(i)) {
                    return true;
                }
                //revert changes
                sol.pop();
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        back(0);
    }

}
