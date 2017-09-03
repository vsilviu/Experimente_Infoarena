package experimente.biti_2_star;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Silviu on 9/3/17.
 */
public class MainOptimizedV2 {

    private static int n;
    private static int VERTEX_COUNT;
    private static int EDGE_COUNT;
    private static Stack<Integer> currPath;
    private static List<Integer> circuit;
    private static int[] edgeCount;
    private static int[][] adjacenceList;
    private static Map<Integer, Stack<Integer>> adjList;

    static {
        n = 3;
        VERTEX_COUNT = 2 << (n - 1);
        EDGE_COUNT = 2 << n;
        currPath = new Stack<>();
        currPath.add(0);
        circuit = new ArrayList<>();
        edgeCount = new int[VERTEX_COUNT];
        Arrays.fill(edgeCount, 2);
        adjacenceList = new int[EDGE_COUNT][2];
        int j = 0;
        for (int i = 0; i < VERTEX_COUNT; ++i) {
            adjacenceList[j][0] = i;
            adjacenceList[j][1] = 2 * (i % (VERTEX_COUNT >> 1));
            adjacenceList[j + 1][0] = i;
            adjacenceList[j + 1][1] = adjacenceList[j][1] + 1;
            j += 2;
        }
        adjList = new HashMap<>();
        for(int i = 0; i < VERTEX_COUNT; ++i) {
            int neighbourVertex = 2 * (i % (VERTEX_COUNT >> 1));
            Stack<Integer> crtStack = adjList.getOrDefault(i, new Stack<>());
            crtStack.push(neighbourVertex);
            crtStack.push(neighbourVertex + 1);
            adjList.put(i, crtStack);
        }
    }

    private static void eulerianPath() {
        int crtVertex = 0;

        while(!currPath.isEmpty()) {
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
    }

    private static void showAdjList() {
        IntStream.range(0, EDGE_COUNT).forEach(i -> {
            System.out.println(String.format("[%d, %d]", adjacenceList[i][0], adjacenceList[i][1]));
        });
    }

    public static void main(String[] args) {
        eulerianPath();
        int x = 2;
    }

}
