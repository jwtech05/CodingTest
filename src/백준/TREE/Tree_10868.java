package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tree_10868 {
    static long[] tree;
    public static long minNum(int start, int end){
        long min = Long.MAX_VALUE;
        while(start <= end) {
            if (start % 2 == 1) {
                min = Math.min(tree[start], min);
                start++;
            }
            if (end % 2 == 0) {
                min = Math.min(tree[end], min);
                end--;
            }
            start = start / 2;
            end = end / 2;
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int height = 0;
        while(Math.pow(2,height) < N){
            height++;
        }
        int size = (int) Math.pow(2, height+1);
        tree = new long[size+1];
        Arrays.fill(tree, Long.MAX_VALUE);
        for(int i = size/2; i < size/2+N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        for(int i = size/2 - 1; i> 0; i--){
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start = start + ((size/2)-1);
            end = end + ((size/2)-1);
            System.out.println(minNum(start,end));
        }
    }
}
