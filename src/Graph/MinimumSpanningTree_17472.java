package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class mEdge implements Comparable<mEdge>{
    int start, end, price;

    mEdge(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public int compareTo(mEdge o){
        if(this.price > o.price){
            return 1;
        }
        return -1;
    }
}
public class MinimumSpanningTree_17472 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean sFlag, eFlag;
    static int N, M;
    static boolean[][] visited;
    static int[][] arr;
    static int isNum, cnt, answer;
    static PriorityQueue<mEdge> pq;
    static int[] unionFind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=0; M=0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        answer = 0;
        cnt = 0;
        visited = new boolean[N+1][M+1];
        pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            if(str != null) {
                st = new StringTokenizer(str);
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        isNum = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(arr[i][j] != 0 && !visited[i][j]){
                    BFS(i,j);
                    isNum++;
                }
            }
        }
        WLADDER();
        HLADDER();
        unionFind = new int[isNum];
        for(int i=0; i<isNum; i++){
            unionFind[i] = i;
        }

        while (isNum - 2 >= cnt && !pq.isEmpty()) {
            mEdge now = pq.poll();
            if (union(now.start, now.end)) {
                answer += now.price;
                cnt++;
            }
        }
        if(isNum - 2 == cnt) {
            System.out.println(answer);
        }else{
            System.out.println("-1");
        }
    }


    public static void WLADDER(){
        for(int i=1; i<=N; i++){
            sFlag = false;
            eFlag = false;
            int start = 0;
            int end = 0;
            int[] startArr = new int[0];
            int[] endArr = new int[0];
            for(int j=1; j<=M; j++){
                if(arr[i][j] != 0){
                    if(!sFlag || start == arr[i][j]){
                        sFlag = true;
                        start = arr[i][j];
                        startArr = new int[]{i,j};
                    }else if(!eFlag){
                        eFlag = true;
                        end = arr[i][j];
                        endArr = new int[]{i,j};
                    }
                }
                if(sFlag && eFlag){
                    int s = start;
                    int e = end;
                    int p = endArr[1] - startArr[1] - 1;
                    if(p > 1) {
                        pq.add(new mEdge(s, e, p));
                    }
                    sFlag = true;
                    eFlag = false;
                    start = end;
                    end = 0;
                    startArr = endArr;
                    endArr = new int[0];
                }
            }
        }
    }
    public static void HLADDER(){
        for(int j=1; j<=M; j++){
            sFlag = false;
            eFlag = false;
            int start = 0;
            int end = 0;
            int[] startArr = new int[0];
            int[] endArr = new int[0];
            for(int i=1; i<=N; i++){
                if(arr[i][j] != 0){
                    if(!sFlag || start == arr[i][j]){
                        sFlag = true;
                        start = arr[i][j];
                        startArr = new int[]{i,j};
                    }else if(!eFlag){
                        eFlag = true;
                        end = arr[i][j];
                        endArr = new int[]{i,j};
                    }
                }
                if(sFlag && eFlag){
                    int s = start;
                    int e = end;
                    int p = endArr[0] - startArr[0] - 1;
                    if(p > 1) {
                        pq.add(new mEdge(s, e, p));
                    }
                    sFlag = true;
                    eFlag = false;
                    start = end;
                    end = 0;
                    startArr = endArr;
                    endArr = new int[0];
                }
            }
        }
    }
    public static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,b});
        arr[a][b] = isNum;
        visited[a][b] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i=0; i<4; i++){
                int rx = x + dx[i];
                int ry = y + dy[i];
                if(rx > 0 && rx <= N && ry > 0 && ry <= M && !visited[rx][ry] && arr[rx][ry] != 0){
                    arr[rx][ry] = isNum;
                    visited[rx][ry] = true;
                    queue.offer(new int[]{rx,ry});
                }
            }
        }
    }
    public static int find(int num){
        if(unionFind[num] == num){
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }
    public static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            unionFind[y] = x;
            return true;
        }
        return false;
    }
}
