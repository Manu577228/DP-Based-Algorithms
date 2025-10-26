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

public class Main {

    // Function to calculate the maximum profit obtainable by cutting a rod
    // of length n using Bottom-Up Dynamic Programming.
    public static int rodCutting(int[] prices, int n) {

        // Step 1: Create a DP array to store max profit for each rod length
        int[] dp = new int[n + 1]; // dp[i] = max profit for rod length i

        // Step 2: Fill the dp array iteratively
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE; // Initialize max profit for current length

            // Step 3: Try all possible cuts for the current rod length i
            for (int j = 0; j < i; j++) {
                // If we cut at length (j+1), remaining length = i - (j+1)
                maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
            }

            // Step 4: Store the maximum value found for length i
            dp[i] = maxVal;
        }

        // Step 5: dp[n] will hold the result for full rod length
        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        // Fast Input/Output for Competitive Programming
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // ---------- Example Input ----------
        int[] prices = {2, 5, 7, 8}; // Prices for lengths 1, 2, 3, 4
        int n = 4; // Total rod length

        // Function call
        int maxProfit = rodCutting(prices, n);

        // ---------- Output ----------
        out.println("Maximum Obtainable Profit: " + maxProfit);
        out.flush();
    }
}
