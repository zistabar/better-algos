import java.util.LinkedList;
import java.util.Queue;

public class GraphSearcher {

    /**
     *  When we want to visit every node
     */
    void searchDepthFirst(Node node) {
        if (node == null) {
            return;
        }
        visit(node);
        node.visited = true;

        for (Node neighbor : node.neighbors) {
            if (!neighbor.visited) {
                searchDepthFirst(neighbor);
            }
        }
    }

    /**
     *  When we want to find shortest path between two nodes
     */
    void searchBreadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        node.visited = true;

        while (!queue.isEmpty()) {
            node = queue.poll();

            visit(node);

            for (Node neighbor : node.neighbors) {
                if (!neighbor.visited) {
                    queue.offer(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    private void visit(Node root) {
        System.out.println(root.val);
    }
}
