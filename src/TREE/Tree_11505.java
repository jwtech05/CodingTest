package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tree_11505 {
    static long[] tree;
    static int MOD;
    public static void update(int start, long end){
        tree[start] = end;
        while(start > 1){
            start = start/2;
            tree[start] = tree[start*2] % MOD * tree[start * 2 + 1] % MOD;
        }
    }
    public static long multipleNum(int start, int end){
        long multi = 1;
        while(start <= end) {
            if (start % 2 == 1) {
                multi = multi * tree[start] % MOD;
                start++;
            }
            if (end % 2 == 0) {
                multi = multi * tree[end] % MOD;
                end--;
            }
            start = start / 2;
            end = end / 2;
        }
        return multi;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int height = 0;
        MOD = 1000000007;
        while (Math.pow(2, height) < N) {
            height++;
        }
        int size = (int) Math.pow(2, height + 1);
        int halfSize = size / 2 - 1;
        tree = new long[size+1];
        Arrays.fill(tree,1);
        for(int i= halfSize+1; i <= halfSize+N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        for(int i = halfSize; i>0; i--){
            tree[i] = tree[i*2] * tree[i*2+1] % MOD;
        }
        for(int i=0; i< M+K; i++){
            st = new StringTokenizer(br.readLine());
            int kind = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if(kind == 1){
                start = start + halfSize;
                update(start, end);
            }else if(kind == 2){
                start = start + halfSize;
                end = end + halfSize;
                System.out.println(multipleNum(start, (int) end));
            }else {
                return;
            }
        }
    }

}
