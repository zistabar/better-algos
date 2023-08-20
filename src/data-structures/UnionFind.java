/*
    Time:
        - w/ path compression and union by size:
            - amortized: O(α(N)) → O(1) per query
            - worst case: O(log(N)) (also w/o optimizations)
    Space: O(N)
 */
public class UnionFind {

    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return false;
        }
        if (size[parentA] < size[parentB]) {
           parent[parentA] = parentB;
           size[parentB] += size[parentA];
        } else {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
        return true;
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
