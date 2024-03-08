package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sorting_12738 {
    static List<Integer> list = new ArrayList<>();
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        DP = new int[N];
        for (int i = 0; i < N; i++) {
            DP[i] = Integer.parseInt(st.nextToken());
        }
        list.add(DP[0]);
        int j = 0;
        for (int i = 1; i < N; i++) {
            if (DP[i] > list.get(j)) {
                list.add(DP[i]);
                j++;
            } else {
                int ans = binarySearch(0, j, DP[i]);
                list.set(ans, Math.min(list.get(ans), DP[i]));
            }
        }
        System.out.println(j + 1);
    }

    public static int binarySearch(int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}