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
        n = 3; //sol is 0 1 2 5 3 7 6 4 => hamiltonian path
        VERTEX_COUNT = 2 << (n - 1);
        EDGE_COUNT = 2 << n;
        currPath = new Stack<>();
        currPath.push(0);
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

    //*************************************************************************

    static private ArrayList<Integer>[] adj;

    // A recursive function used by topologicalSort
    static void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        for (Integer integer : adj[v]) {
            i = integer;
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    static void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[VERTEX_COUNT];
        adj = new ArrayList[VERTEX_COUNT];
        for(int i = 0; i < VERTEX_COUNT; ++i) {
            adj[i] = new ArrayList<>();
        }

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < VERTEX_COUNT; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
    //*************************************************************************

    /** asdasdasdasdasd **/

    private static void hamiltonianPath() {
        //sol is 0 1 2 5 3 7 6 4 => hamiltonian path

        System.out.print("0 -> 1 -> ");
        int crtVertex = 1;
        boolean maxWasTouched = false;

        while(crtVertex != 0) {
            if(crtVertex == VERTEX_COUNT - 1) maxWasTouched = true;
            boolean lastDigitIsZero = (adjacenceList[crtVertex][0] & 1) == 0;
            if(maxWasTouched) {
                if(lastDigitIsZero) {
                    crtVertex = adjacenceList[crtVertex][0];
                } else {
                    crtVertex = adjacenceList[crtVertex][1];
                }
            } else {
                if(lastDigitIsZero) {
                    crtVertex = adjacenceList[crtVertex][1];
                } else {
                    crtVertex = adjacenceList[crtVertex][0];
                }
            }
            System.out.print(crtVertex + " -> ");
        }

    }

    private static void hamiltonianPath2() {

        System.out.print("000 -> ");

        int crtVertex = 1;
        boolean maxWasTouched = false;

        while(crtVertex != 0) {

            System.out.print(Integer.toBinaryString(crtVertex) + " -> ");

            if(crtVertex == VERTEX_COUNT - 1) {
                maxWasTouched = true;
            }

            int n1 = adjList.get(crtVertex).pop();
            int n2 = adjList.get(crtVertex).pop();

            boolean n1LastDigitIsZero = (n1 & 1) == 0;

            if(maxWasTouched) {
                crtVertex = n1LastDigitIsZero ? n1 : n2;
            } else {
                crtVertex = n1LastDigitIsZero ? n2 : n1;
            }
        }

    }

    /** asdasdasdasdasd **/


    private static void showAdjList() {
        IntStream.range(0, EDGE_COUNT).forEach(i -> {
            System.out.println(String.format("[%d, %d]", adjacenceList[i][0], adjacenceList[i][1]));
        });
    }

    private static void printSol() {
        for (int i=circuit.size()-1; i>=0; i--) {
            System.out.print(circuit.get(i) + " ");
            if(i > 0) {
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) {
//        showAdjList();
        //eulerianPath();
        //printSol();
//        topologicalSort();
        hamiltonianPath2();
    }

}
