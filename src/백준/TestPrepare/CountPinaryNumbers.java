package 백준.TestPrepare;

public class CountPinaryNumbers {
    public static void main(String[] args) {
        int n = 90;  // 90자리 이친수의 개수를 계산

        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 1;
        }

        // 동적 계획법을 통한 이친수의 개수 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("90자리 이친수의 개수: " + dp[n]);
    }
}
