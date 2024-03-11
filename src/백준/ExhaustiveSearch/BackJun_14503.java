package 백준.ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 시도 : 2회
 * 채점 결과 : 실패
 * 소요 시간 : 1시간 40분
 * */
class cNode{
    int nn;
    int mm;
    int dd;
    cNode(int nn, int mm, int dd){
        this.nn = nn;
        this.mm = mm;
        this.dd = dd;
    }
}

public class BackJun_14503 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nn = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int dd = Integer.parseInt(st.nextToken());
        Queue<cNode> queue = new LinkedList<>();
        queue.offer(new cNode(nn, mm, dd));
        int[][] arr = new int[N][M];
        boolean[][] check = new boolean[N][M];
        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i= 0; i<N; i++){
            for(int j= 0; j<M; j++) {
                if(arr[i][j] == 1) check[i][j] = true;
            }
        }
        boolean flag = false;
        while(!queue.isEmpty() && !flag) {
            cNode start = queue.poll();
            int x = start.nn;
            int y = start.mm;
            int direct = start.dd;
            //현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (!check[x][y]) {
                check[x][y] = true;
                System.out.print("("+x+","+y+","+direct+")");
            }
            if(x- 1 < 0 && y-1 <0 && x +1 >= N && y+1 >= M) {
                flag = true;
                continue;
            }
            //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (check[x + dx[0]][y + dy[0]] && check[x + dx[1]][y + dy[1]] && check[x + dx[2]][y + dy[2]] && check[x + dx[3]][y + dy[3]]) {
                //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (arr[x + (dx[direct] * -1)][y + (dy[direct]* -1)] == 1) {
                    flag = true;
                } else { //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    queue.offer(new cNode(x + (dx[direct] * -1), y + (dy[direct]* -1), direct));
                }
            } else { //현재 칸의 주변 4칸 중 청소되지 않은 칸이 있는 경우
                //반시계 방향으로 90도 회전한다.
                if(direct == 0) direct = 4;
                direct = (direct - 1) % 4;
                //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한 칸 전진한다.
                if (x+dx[direct] < N && y+dy[direct] < M && !check[x + dx[direct]][y + dy[direct]]) {
                    queue.offer(new cNode(x + dx[direct], y + dy[direct], direct));
                } else {
                    queue.offer(new cNode(x, y, direct));
                }
            }
        }
        int answer = 0;
        for(int i= 0; i<N; i++){
            for(int j= 0; j<M; j++) {
                if(check[i][j] && arr[i][j] == 0) answer++;
            }
        }
        System.out.println(answer);
    }
}
