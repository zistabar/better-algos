import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  We can use topological sort if we have a directed acyclic graph (DAG)
 */
public class TopologicalSort {

    int[] topologicalSort(int nodesCount, int[][] dependencyList) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < nodesCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] indegrees = new int[nodesCount];

        for (int[] dep : dependencyList) {
            int from = dep[1];
            int to = dep[0];

            adjacencyList.get(from).add(to);

            indegrees[to]++;
        }
        Queue<Integer> zeroIndegrees = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                zeroIndegrees.offer(i);
            }
        }
        int[] topologicalOrder = new int[nodesCount];
        int orderIdx = 1;

        while (!zeroIndegrees.isEmpty()) {
            int node = zeroIndegrees.poll();

            topologicalOrder[orderIdx++] = node;

            for (Integer neighbour : adjacencyList.get(node)) {
                indegrees[neighbour]--;

                if (indegrees[neighbour] == 0) {
                    zeroIndegrees.offer(neighbour);
                }
            }
        }
        for (int indegree : indegrees) {
            if (indegree != 0) {
                // there is a cycle
                return new int[]{};
            }
        }
        return topologicalOrder;
    }
}
