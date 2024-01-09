package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class lEdge implements Comparable<lEdge>{
    int start, end, price;
    lEdge(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
    public int compareTo(lEdge o){
        if(this.price > o.price ) return 1;
        return -1;
    }

}
public class MinimumSpanningTree_1414 {
    static PriorityQueue<lEdge> pq;
    static int cnt;
    static int[] unionFind;

    public static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            cnt++;
            unionFind[y] = x;
            return true;
        }
        return false;
    }
    public static int find(int num){
        if(unionFind[num] == num){
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int allLine = 0;
        pq = new PriorityQueue<>();
        cnt = 0;
        unionFind = new int[N+1];
        for(int i=0; i<=N; i++){
            unionFind[i] = i;
        }
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for(int j=1; j<=a.length(); j++) {
                char b = a.charAt(j-1);
                int number;
                if (b >= 'a' && b <= 'z') {
                    number = b - 'a' + 1;
                } else if (b >= 'A' && b <= 'Z') {
                    number = b - 'A' + 27;
                } else {
                    number = b - 48;
                }
                arr[i][j] = number;
                allLine += number;
                if(number != 0) {
                    pq.add(new lEdge(i, j, number));
                }
            }
        }
        int sum = 0;
        while(cnt <= N-1 && !pq.isEmpty()){
            lEdge now = pq.poll();
            if(union(now.start, now.end)){
                sum += now.price;
            }
        }
        if(N-1 == cnt) {
            System.out.println(allLine - sum);
        }else{
            System.out.println(-1);
        }
    }

}
