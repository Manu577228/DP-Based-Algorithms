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

    // Function to find the length of Longest Increasing Subsequence
    static int longestIncreasingSubsequence(int[] arr) {

        // Step 1: Find length of the array
        int n = arr.length;

        // Step 2: Create a DP array initialized with 1
        // Each element is an increasing subsequence of length 1 by default
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        // Step 3: Build the dp array using nested loops
        for (int i = 1; i < n; i++) {            // For each element
            for (int j = 0; j < i; j++) {        // Check all previous elements
                if (arr[i] > arr[j]) {           // If current element > previous
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // Extend the LIS length
                }
            }
        }

        // Step 4: Find the maximum LIS length
        int maxLen = 0;
        for (int len : dp) {
            if (len > maxLen)
                maxLen = len;
        }

        // Step 5: Return the result
        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        // Fast Input/Output setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Example input array
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        // Function Call
        int result = longestIncreasingSubsequence(arr);

        // Output result
        pw.println("Length of Longest Increasing Subsequence is: " + result);
        pw.flush();
    }
}
