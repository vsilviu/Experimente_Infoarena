package experimente.biti_2_star;

import java.util.*;

/**
 * Created by Silviu on 9/3/17.
 */
public class MainOptimizedV2 {

    private static int n;
    private static int VERTEX_COUNT;
    private static Stack<Integer> currPath;
    private static List<Integer> circuit;
    private static int[] edgeCount;
    private static Map<Integer, Stack<Integer>> adjList;
    private static StringBuilder solution = new StringBuilder();
    private static boolean[] visited;

    static {
        init();
    }

    private static void init() {
        n = 4;
        VERTEX_COUNT = 2 << (n - 1);
        currPath = new Stack<>();
        currPath.push(0);
        circuit = new ArrayList<>();
        edgeCount = new int[VERTEX_COUNT];
        Arrays.fill(edgeCount, 2);
        adjList = new HashMap<>();
        for (int i = 0; i < VERTEX_COUNT; ++i) {
            int neighbourVertex = 2 * (i % (VERTEX_COUNT >> 1));
            Stack<Integer> crtStack = adjList.getOrDefault(i, new Stack<>());
            crtStack.push(neighbourVertex);
            crtStack.push(neighbourVertex + 1);
            adjList.put(i, crtStack);
        }
        visited = new boolean[VERTEX_COUNT];
    }

    private static void eulerianPath() {
        int crtVertex = 0;

        while (!currPath.isEmpty()) {
            if (edgeCount[crtVertex] > 0) {
                currPath.push(crtVertex);
                int nextVertex = adjList.get(crtVertex).pop();
                edgeCount[crtVertex]--;
                crtVertex = nextVertex;
            } else {
                circuit.add(crtVertex);
                crtVertex = currPath.pop();
            }
        }

        printEulerianCycle();
    }

    private static void deBrujinSequenceGenerator() {
        int n0, n1;
        int crtVertex = 0;

        while (!currPath.isEmpty()) {
            n0 = 2 * (crtVertex % (VERTEX_COUNT >> 1));
            n1 = n0 + 1;
            if (visited[n0] && visited[n1]) {
                solution.append(crtVertex & 1);
                crtVertex = currPath.pop();
            } else {
                currPath.push(crtVertex);
                if (!visited[n0]) {
                    crtVertex = n0;
                    visited[n0] = true;
                } else {
                    crtVertex = n1;
                    visited[n1] = true;
                }
            }
        }

        printDeBrujinSequence();
    }

    private static void printEulerianCycle() {
        for (int i = circuit.size() - 1; i >= 0; i--) {
            System.out.print(circuit.get(i) + " ");
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    private static void printDeBrujinSequence() {
        for (int i = 0; i < n - 2; ++i) {
            System.out.print(0);
        }
        System.out.print(solution.reverse());
    }

    public static void main(String[] args) {
        eulerianPath();
        init();
        deBrujinSequenceGenerator();
    }

}
