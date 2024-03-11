package 백준.ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
* 시도 : 2회
* 채점 결과 : 성공
* 소요 시간 : 1시간 6분
* */
class vNode{
    int nn;
    int mm;
    public vNode(int nn, int mm){
        this.nn = nn;
        this.mm = mm;
    }
}

public class BackJun_14502 {
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            if (arr[k][l] == 0) {
                                arr[k][l] = 1;
                                for (int m = 0; m < N; m++) {
                                    for (int n = 0; n < M; n++) {
                                        if (arr[m][n] == 0) {
                                            arr[m][n] = 1;
                                            int safeCnt = infection(arr);
                                            answer = Math.max(answer, safeCnt);
                                            arr[m][n] = 0;
                                        }
                                    }
                                }
                                arr[k][l] = 0;
                            }
                        }
                    }
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(answer);
    }

    public static int infection(int[][] infectArr){

        int[][] preArr = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                preArr[i][j] = infectArr[i][j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(preArr[i][j] == 2){
                    BFS(preArr, i, j);
                }
            }
        }

        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(preArr[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    public static void BFS(int[][] infectedArr, int i, int j){
        Queue<vNode> queue = new LinkedList<>();
        queue.offer(new vNode(i,j));
        while(!queue.isEmpty()){
            vNode start = queue.poll();
            int x = start.nn;
            int y = start.mm;
            for(int k=0; k<4; k++){
                int nx = x+ dx[k];
                int ny = y+ dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && infectedArr[nx][ny] == 0){
                    infectedArr[nx][ny] = 2;
                    queue.offer(new vNode(nx, ny));
                }
            }
        }
    }
}
