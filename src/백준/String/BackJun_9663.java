package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* 시도 : 6회
* 시간 : 2시간 20분
* 성공 여부 : 성공
* 꼬였을때 어떻게 할지 고민하기 / 완탐을 하되 조건을 어떻게 추가하는지에 관해 / 메모리 초과
* */
public class BackJun_9663 {
    public static int[][] arr;
    public static int N, answer;
    public static boolean[] flag;
    public static int[] dx = {1,1,-1,-1,0,1,0,-1};
    public static int[] dy = {-1,1,1,-1,1,0,-1,0};
/*    public static int[] dx = {1,1,-1,-1};
    public static int[] dy = {-1,1,1,-1};*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long bT = System.currentTimeMillis();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        flag = new boolean[N];
        answer = 0;
        DFS(0);
        System.out.println(answer);
        long sT = System.currentTimeMillis();
        System.out.println((sT - bT)/1000);
    }

    public static void DFS(int x){
        if(x >= N){
            answer++;
            return;
        }
        for(int i=0; i<N; i++){
            if(checker(x,i)){
                arr[x][i] = 2;
                DFS(x+1);
                arr[x][i] = 0;
            }
        }
    }

    public static boolean checker(int X, int Y){
        for(int i=0; i<8; i++){
            int x = X + dx[i];
            int y = Y + dy[i];
            while(x < N && y < N && x >= 0 && y >= 0){
                if(arr[x][y] == 2){
                    return false;
                }
                x += dx[i];
                y += dy[i];
            }
        }
        return true;
    }
}
/*        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();*/