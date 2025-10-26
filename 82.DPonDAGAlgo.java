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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio       */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

public class DPonDAG {
    public static void main(String[] args) throws IOException {
        
        // Step 1: Setup Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Step 2: Create adjacency list
        int n = 6; // number of vertices
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3},
            {2, 3}, {2, 4}, {3, 5}, {4, 5}
        };

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) graph.get(e[0]).add(e[1]);

        // Step 3: Compute in-degree for topological sort
        int[] indeg = new int[n];
        for (int[] e : edges) indeg[e[1]]++;

        // Step 4: Perform topological sort (Kahn’s algorithm)
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int nei : graph.get(node)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.offer(nei);
            }
        }

        // Step 5: Initialize DP array
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE / 2);

        // Step 6: DP on topological order
        for (int node : topo) {
            if (dp[node] == Integer.MIN_VALUE / 2) dp[node] = 0; // sources
            for (int nei : graph.get(node)) {
                dp[nei] = Math.max(dp[nei], dp[node] + 1);
            }
        }

        // Step 7: Print results
        pw.println("Topological Order: " + topo);
        pw.print("Longest Path Length from Each Node: [");
        for (int i = 0; i < n; i++) {
            pw.print(dp[i]);
            if (i != n - 1) pw.print(", ");
        }
        pw.println("]");
        pw.println("Overall Longest Path Length: " + Arrays.stream(dp).max().getAsInt());

        pw.flush();
    }
}
