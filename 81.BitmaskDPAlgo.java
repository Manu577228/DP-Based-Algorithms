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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio      */
/* -----------------------------------------------------------------------  */

import java.util.*;

public class BitmaskDP {
    public static void main(String[] args) {
        int n = 3;  // Number of people/tasks

        // Cost matrix
        int[][] cost = {
            {9, 2, 7},  // Costs for person 0
            {6, 4, 3},  // Costs for person 1
            {5, 8, 1}   // Costs for person 2
        };

        // DP array for 2^n subsets, initialized to large value
        int size = 1 << n;
        int[] dp = new int[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no tasks assigned

        // Iterate over all subsets of tasks
        for (int mask = 0; mask < size; mask++) {
            int x = Integer.bitCount(mask); // Number of tasks already assigned

            // Try assigning an unassigned task 'j' to person 'x'
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) { // If task j is not assigned yet
                    dp[mask | (1 << j)] = Math.min(dp[mask | (1 << j)], dp[mask] + cost[x][j]);
                }
            }
        }

        // Final answer: minimum cost for all tasks assigned
        System.out.println(dp[size - 1]);
    }
}
