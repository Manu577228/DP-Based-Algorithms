/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )
 ___ _                      _              _ 
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/ 
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio        */
/* -----------------------------------------------------------------------  */
/*    Online Compiler (Java): https://onecompiler.com/java                     */
/* -----------------------------------------------------------------------  */

import java.util.*;

public class Main {

    static int n;
    static int[] values;
    static ArrayList<Integer>[] adj;
    static int[] dpInclude;
    static int[] dpExclude;

    // Recursive DFS function to fill dp arrays
    static void dfs(int u, int parent) {
        int includeSum = values[u];   // If u is included, start with its value
        int excludeSum = 0;           // If u is excluded, start from 0

        // Visit all children of node u
        for (int v : adj[u]) {
            if (v == parent) continue;  // Avoid going back to parent
            dfs(v, u);                  // Post-order DFS

            // If u is included, children must be excluded
            includeSum += dpExclude[v];

            // If u is excluded, children can be included or excluded
            excludeSum += Math.max(dpInclude[v], dpExclude[v]);
        }

        dpInclude[u] = includeSum;
        dpExclude[u] = excludeSum;
    }

    public static void main(String[] args) {

        // Tree structure
        values = new int[]{3, 2, 1, 1, 5, 4, 6};
        n = values.length;

        // Adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}
        };

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        dpInclude = new int[n];
        dpExclude = new int[n];

        dfs(0, -1); // Run DFS from root node (0)

        int answer = Math.max(dpInclude[0], dpExclude[0]);

        System.out.println("Node : weight | dp_include | dp_exclude");
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d : %6d | %10d | %10d\n",
                i, values[i], dpInclude[i], dpExclude[i]);
        }

        System.out.println("\nMaximum weight of independent set on this tree: " + answer);
    }
}
