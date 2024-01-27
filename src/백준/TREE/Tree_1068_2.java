package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_1068_2 {
    static ArrayList<ArrayList<Integer>> arr;
    static int stopper;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (next == -1) {
                root = i;
                continue;
            }
            arr.get(next).add(i);
        }
        st = new StringTokenizer(br.readLine());
        stopper = Integer.parseInt(st.nextToken());
        if (stopper != root) {
            DFS(root);
        }
        System.out.println(cnt);
    }

    public static void DFS(int num) {
        if (arr.get(num).size() == 0) {
            cnt++;
            return;
        }
        for (int x : arr.get(num)) {
            if (x != stopper && x != -2) {
                DFS(x);
            } else if (stopper == x) {
                if((arr.get(num).size()-1) == 0) cnt++;
            }
        }
    }
}
