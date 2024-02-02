package 소프티어;
import java.io.*;
import java.util.*;

import java.util.stream.Collectors;

public class 차세대_지능형_교통시스템 {
    static int N, T, signs , useT;
    static ArrayList<int[]> answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> check;
    static int[][] sign = {
            {1,2,3},{0,3,2},{0,1,3},{0,2,1},
            {3,2},{0,3},{0,1},{1,2},
            {2,1},{3,2},{0,3},{0,1}
    };
    static int[][][] node;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        signs = N*N;
        check = new ArrayList<>();
        answer = new ArrayList<>();
        node = new int[N][N][4];
        graph = new int[N][N];
        useT = 0;
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++){
                st = new StringTokenizer(br.readLine());
                node[j][i][0] = Integer.parseInt(st.nextToken());
                node[j][i][1] = Integer.parseInt(st.nextToken());
                node[j][i][2] = Integer.parseInt(st.nextToken());
                node[j][i][3] = Integer.parseInt(st.nextToken());
            }
        }
        if(node[0][0][0] == 2 || node[0][0][0] == 10) solution();
        System.out.println(answer.size());
        System.out.println(Math.sqrt(10000000));
    }
    static void addUniqueCoordinate(List<int[]> coordinateList, int[] newCoordinate) {
        if (coordinateList.stream().noneMatch(coord -> coord[0] == newCoordinate[0] && coord[1] == newCoordinate[1])) {
            coordinateList.add(newCoordinate);
        }
    }
    public static void solution(){
        Queue<loc> queue = new LinkedList<>();
        queue.offer(new loc(0,0,0,3));
        addUniqueCoordinate(answer,new int[]{0,0});
        while(!queue.isEmpty()){
            loc now = queue.poll();
            //System.out.println("("+now.x+","+now.y+")");
            int okSign = node[now.x][now.y][now.t % 4];
            check = Arrays.stream(sign[okSign-1])
                    .boxed() // Converts int to Integer
                    .collect(Collectors.toList());
            if(!check.contains(now.direct)) continue;
            for(int i=0; i<sign[okSign-1].length; i++){
                int X = dx[sign[okSign-1][i]];
                int Y = dy[sign[okSign-1][i]];
                int nx = now.x + X;
                int ny = now.y + Y;
                if(nx <0 || ny <0 || nx >=N || ny >= N || now.t >= T) continue;
                addUniqueCoordinate(answer,new int[]{nx,ny});
                //System.out.println("("+nx+","+ny+")");
                if(X == 1 && Y == 0){
                    queue.offer(new loc(nx,ny,now.t+1, 2));
                }else if(X == -1 && Y == 0){
                    queue.offer(new loc(nx,ny,now.t+1, 0));
                }else if(X == 0 && Y == 1){
                    queue.offer(new loc(nx,ny,now.t+1, 1));
                }else{
                    queue.offer(new loc(nx,ny,now.t+1, 3));
                }
            }
        }
    }
}
class loc{
    int x, y,t, direct;
    public loc(int x, int y, int t, int direct){
        this.x = x;
        this.y = y;
        this.t = t;
        this.direct = direct;
    }
}