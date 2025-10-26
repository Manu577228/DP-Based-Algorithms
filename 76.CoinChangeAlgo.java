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

public class Main {

    // ---------------- Variant 1: Count total number of combinations ----------------
    static int[] coinChangeCount(int[] coins, int amount) {
        int[] ways = new int[amount + 1];   // ways[i] = number of combinations to make i
        ways[0] = 1;                        // Base case: one way to make 0 — choose nothing

        // For each coin, we add combinations that include it
        for (int c : coins) {
            for (int s = c; s <= amount; s++) {
                ways[s] += ways[s - c];     // Add ways using coin 'c'
            }
        }
        return ways; // Return the entire DP table for display
    }

    // ---------------- Variant 2: Minimum coins to make amount ----------------
    static int[] coinChangeMin(int[] coins, int amount) {
        int INF = (int)1e9;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0; // Base case: 0 coins for amount 0

        // For each coin, update dp[s] = min(dp[s], dp[s-c]+1)
        for (int c : coins) {
            for (int s = c; s <= amount; s++) {
                if (dp[s - c] + 1 < dp[s]) {
                    dp[s] = dp[s - c] + 1;
                }
            }
        }
        return dp; // Return full DP table for display
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] coins = {1, 2, 5};
        int amount = 11;

        // 1️⃣ Count number of ways (combinations)
        int[] countTable = coinChangeCount(coins, amount);
        int countResult = countTable[amount];

        // 2️⃣ Minimum coins needed
        int[] minTable = coinChangeMin(coins, amount);
        int minResult = (minTable[amount] >= 1e9) ? -1 : minTable[amount];

        out.println("Coins: " + Arrays.toString(coins));
        out.println("Target amount: " + amount);

        // ------------------ Count combinations output ------------------
        out.println("\n1) Number of ways (combinations) to make amount: " + countResult);
        out.println("DP table for count (index = sum -> ways):");
        for (int i = 0; i <= amount; i++) {
            out.printf("%2d -> %d\n", i, countTable[i]);
        }

        // ------------------ Minimum coins output ------------------
        out.println("\n2) Minimum coins required to make amount: " + minResult);
        out.println("DP table for min coins (index = sum -> min coins or INF):");
        for (int i = 0; i <= amount; i++) {
            String val = (minTable[i] >= 1e9) ? "INF" : String.valueOf(minTable[i]);
            out.printf("%2d -> %s\n", i, val);
        }

        out.flush();
    }
}
