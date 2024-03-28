package 백준.String;

import java.io.*;
import java.util.*;

public class BackJun_1325 {

    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visit;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);


        arr = new ArrayList<>();
        visit = new boolean[n + 1];
        cnt = new int[n + 1];

        int max = -1;

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            str = bf.readLine().split(" ");

            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);

            arr.get(s).add(e);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            dfs(i);
        }

        for (int i = 1; i <= n; i++) {
            if (max < cnt[i])
                max = cnt[i];
        }
        for (int i = 1; i <= n; i++) {
            if (max == cnt[i])
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();

    }

    public static void dfs(int n) {

        visit[n] = true; // 방문 처리

        for (int next : arr.get(n)) {
            // 해당 정점(사람)이 신뢰하는 사람 방문
            // for i 하면 시간초과남. 가급적 for each로

            if (visit[next])
                continue;
            // 이미 방문한건 패스
            cnt[next]++; // 방문 횟수 증가
            dfs(next); // 다음 정점 방문

        }

    }

}