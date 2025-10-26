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
/* -----------------------------------------------------------------------  */

public class Knapsack {

    public static void main(String[] args) {

        // Values (profit) of items
        int[] values = {60, 100, 120};
        // Corresponding weights of items
        int[] weights = {10, 20, 30};
        // Maximum weight capacity of knapsack
        int W = 50;
        // Number of items
        int n = values.length;

        // Initialize DP table (n+1) x (W+1) with 0
        int[][] dp = new int[n+1][W+1];

        // Build the DP table in bottom-up manner
        for (int i = 1; i <= n; i++) { // Loop through items
            for (int w = 1; w <= W; w++) { // Loop through all capacities
                if (weights[i-1] <= w) { // If current item's weight <= current capacity
                    // Maximum of including or excluding the item
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]]);
                } else {
                    // Cannot include the item, take value from previous row
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        // Maximum value achievable with given weight
        System.out.println("Maximum value in knapsack = " + dp[n][W]);
    }
}
