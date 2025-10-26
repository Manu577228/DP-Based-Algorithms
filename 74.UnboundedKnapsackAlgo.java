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

import java.io.*;
import java.util.*;

public class UnboundedKnapsack {

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize input arrays (weights, values) and capacity
        int[] weights = {2, 3, 4};   // weights of the items
        int[] values = {15, 20, 30}; // corresponding values
        int W = 7;                   // knapsack capacity
        int n = weights.length;      // total number of distinct items

        // Step 2: dp[w] will store the maximum value possible for capacity w
        int[] dp = new int[W + 1];

        // Step 3: keep[w] will store the index of the last item used to get dp[w]
        int[] keep = new int[W + 1];
        Arrays.fill(keep, -1); // initially, no item used

        // Step 4: Build the dp array (bottom-up dynamic programming)
        for (int w = 1; w <= W; w++) {      // for every sub-capacity
            for (int i = 0; i < n; i++) {   // try every item (unbounded usage)
                int wt = weights[i];        // current item weight
                int val = values[i];        // current item value

                if (wt <= w) {              // if the item fits
                    int candidate = dp[w - wt] + val; // value if we include this item
                    if (candidate > dp[w]) {          // if this improves our total
                        dp[w] = candidate;            // update best value
                        keep[w] = i;                  // record the item index
                    }
                }
            }
        }

        // Step 5: dp[W] now holds the maximum value for full capacity
        System.out.println("Maximum value: " + dp[W]);

        // Step 6: Reconstruct which items were chosen to achieve dp[W]
        List<Integer> resItems = new ArrayList<>();
        int cap = W;
        while (cap > 0 && keep[cap] != -1) {
            int idx = keep[cap];             // item chosen at capacity 'cap'
            resItems.add(idx);               // record item index
            cap -= weights[idx];             // reduce capacity accordingly
        }

        // Step 7: Convert item indices to (weight, value) pairs for readability
        List<String> chosenPairs = new ArrayList<>();
        for (int idx : resItems) {
            chosenPairs.add("(" + weights[idx] + ", " + values[idx] + ")");
        }
        System.out.println("Chosen items (weight, value) in selection order: " + chosenPairs);

        // Step 8: Print DP table (capacity -> max value)
        System.out.println("DP table (capacity -> max value):");
        for (int i = 0; i <= W; i++) {
            System.out.println(i + " -> " + dp[i]);
        }
    }
}
