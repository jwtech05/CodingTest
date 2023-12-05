package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreathFirstSearch_2178 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] check;
    static int N;
    static int M;
    static int[][] A;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        check = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            //st = new StringTokenizer(br.readLine());
            //String line = st.nextToken();
            for(int j=0; j<M; j++){
                //A[i][j] = Integer.parseInt(line.substring(j,j+1));
                A[i][j] = str.charAt(j);
            }
        }

        BFS(0,0);
        System.out.print(A[N-1][M-1]);
    }

    static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,b});
        A[a][b] = 1;
        check[a][b] = true;
        while(!queue.isEmpty()){
            int[] B = queue.poll();
            for(int i=0; i<4; i++){
                int x = B[0] + dx[i];
                int y = B[1] + dy[i];
                if(x >= 0 && y >= 0 && N > x && M > y){
                    if(A[x][y] != 0 && !check[x][y]){
                        check[x][y] = true;
                        A[x][y] = A[B[0]][B[1]] + 1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
