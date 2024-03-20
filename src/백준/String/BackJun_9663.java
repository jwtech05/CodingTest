package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* 시도 : 2회
* 시간 : 1시간 50분
* 성공 여부 : 실패
* 꼬였을때 어떻게 할지 고민하기 / 완탐을 하되 조건을 어떻게 추가하는지에 관해 / 메모리 초과
* */
public class BackJun_9663 {
    public static int[][] arr;
    public static int N, answer;
    public static int[] dx = {1,1,-1,-1,0,1,0,-1};
    public static int[] dy = {-1,1,1,-1,1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = 0;
        DFS(0,0,0);
        System.out.println(answer);
    }

    public static void DFS(int x, int y, int cnt){
        if(cnt >= N){
            answer++;
            return;
        }
        for(int i=x; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 0){
                    int[][] beforeArr = beforeChecker(arr);
                    if(checker(i,j)) {
                        arr[i][j] = 2;
                        DFS(i+1,j+1,cnt + 1);
                        afterChecker(beforeArr);
                    }else{
                        afterChecker(beforeArr);
                    }
                }
            }
        }
    }

    public static int[][] beforeChecker(int[][] arr){
        int[][] backArr = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                backArr[i][j] = arr[i][j];
            }
        }
        return backArr;
    }

    public static void afterChecker(int[][] beforeChecker){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = beforeChecker[i][j];
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
                arr[x][y] = 1;
                x += dx[i];
                y += dy[i];
            }
        }
        return true;
    }
}
