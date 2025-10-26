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

import java.io.*;
import java.util.*;

public class Main {

    static int[] digits; // stores digits of N
    static int K;
    static HashMap<String, Long> dp = new HashMap<>();

    // Recursive DP function
    static long dfs(int pos, int tight, int currSum) {
        // Base case: if all digits are processed
        if (pos == digits.length) {
            // if sum of digits <= K, count this number
            return currSum <= K ? 1 : 0;
        }

        // create unique key for memoization
        String key = pos + "|" + tight + "|" + currSum;
        if (dp.containsKey(key)) return dp.get(key);

        // determine max digit to place at this position
        int limit = (tight == 1) ? digits[pos] : 9;
        long total = 0;

        // try placing digits from 0 to limit
        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            total += dfs(pos + 1, newTight, currSum + d);
        }

        dp.put(key, total);
        return total;
    }

    static long countNumbersWithSumLimit(long n, int k) {
        // Convert n into list of digits
        String s = Long.toString(n);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        K = k;
        dp.clear();
        return dfs(0, 1, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long N = 123; // Example input
        int K = 5;

        long ans = countNumbersWithSumLimit(N, K);
        out.println(ans); // Expected Output: 81
        out.flush();
    }
}
