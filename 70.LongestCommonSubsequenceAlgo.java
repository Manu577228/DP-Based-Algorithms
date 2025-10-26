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

import java.io.*;  // for BufferedReader, PrintWriter
import java.util.*; // for Arrays, etc.

public class Main {

    // Function to find Longest Common Subsequence
    static String[] lcs(String A, String B) {
        int n = A.length(); // length of string A
        int m = B.length(); // length of string B
        
        // 1. Create dp table with dimensions (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];
        
        // 2. Fill dp table using Bottom-Up DP
        for (int i = 1; i <= n; i++) {           // iterate through A
            for (int j = 1; j <= m; j++) {       // iterate through B
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // If characters match, take diagonal + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise take maximum of top or left cell
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // 3. Reconstruct one LCS by tracing back
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                // Same character → part of LCS
                sb.append(A.charAt(i - 1));
                i--;
                j--;
            } else {
                // Move in direction of larger dp value
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        
        sb.reverse(); // reverse to get correct LCS order
        
        // Return both length and LCS string
        return new String[]{String.valueOf(dp[n][m]), sb.toString()};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        // Example input
        String A = "AGGTAB"; // Input string A
        String B = "GXTXAYB"; // Input string B
        
        // Call LCS function
        String[] res = lcs(A, B);
        
        // Print results
        out.println("String A: " + A);
        out.println("String B: " + B);
        out.println("LCS length: " + res[0]);
        out.println("An LCS: " + res[1]);
        
        out.flush();
    }
}
