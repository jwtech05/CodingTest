package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCS_백준_9251 {
    static char[] first;
    static char[] second;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        first = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        second = st.nextToken().toCharArray();

        dp = new Integer[first.length][second.length];

        System.out.print(LCS(first.length - 1, second.length - 1));

    }

    public static int LCS(int x, int y) {

        if (x == -1 || y == -1) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (first[x] == second[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return dp[x][y];
    }

}
