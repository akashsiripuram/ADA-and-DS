import java.util.ArrayList;
import java.util.List;

public class GFG {
    static void dfs(List<Integer>[] adj, int V, List<Integer> vis, int i, int curr) {
        vis.set(curr, 1);
        for (int x : adj[curr]) {
            if (x != i) {
                if (vis.get(x) == 0) {
                    dfs(adj, V, vis, i, x);
                }
            }
        }
    }

    static void AP(List<Integer>[] adj, int V) {
        for (int i = 1; i <= V; i++) {
            int components = 0;
            List<Integer> vis = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                vis.add(0);
            }
            for (int j = 1; j <= V; j++) {
                if (j != i) {
                    if (vis.get(j) == 0) {
                        components++;
                        dfs(adj, V, vis, i, j);
                    }
                }
            }
            if (components > 1) {
                System.out.println(i);
            }
        }
    }

    static void addEdge(List<Integer>[] adj, int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(String[] args) {
        System.out.println("Articulation points in the graph ");
        int V = 5;
        List<Integer>[] adj1 = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj1[i] = new ArrayList<>();
        }
        addEdge(adj1, 1, 2);
        addEdge(adj1, 2, 3);
        addEdge(adj1, 1, 3);
        addEdge(adj1, 3, 4);
        addEdge(adj1, 4, 5);
        AP(adj1, V);
    }
}
