package 소프티어;

import java.io.*;
import java.util.*;

public class 동계_테스트_시점_예측 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int H, W, cnt;
    static int[][] map;
    static int[][] visited;
    static int answer;
    static Queue<pos> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        answer = 0;
        solution();
        System.out.print(answer);
    }

    public static void solution(){
        while(true){
            cnt = 0;
            visited = new int[H][W];

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] == 1) cnt++;
                }
            }

            if(cnt == 0) break;
            else bfs();

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(visited[i][j] >= 2){
                        map[i][j] = 0;
                    }
                }
            }
            answer++;
        }
    }

    public static void bfs(){

        queue = new LinkedList<>();
        queue.offer(new pos(0,0));
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            pos next = queue.poll();
            for(int i=0; i<4; i++){
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(map[nx][ny] == 1){
                    visited[nx][ny]++;
                }else if(map[nx][ny] == 0 && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    queue.offer(new pos(nx,ny));
                }
            }
        }
    }
}
class pos{
    int x, y;
    public pos (int x, int y){
        this.x = x;
        this.y = y;
    }
}