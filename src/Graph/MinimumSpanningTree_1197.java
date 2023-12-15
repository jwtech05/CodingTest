package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class sNode implements Comparable<sNode>{
    int start,end,price;
    sNode(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
    public int compareTo(sNode o){
        if (this.price > o.price) return 1;
        else return -1;
    }
}
public class MinimumSpanningTree_1197 {
    static sNode[] sNodes;
    static int[] unionFind;
    static int cnt;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        sNodes = new sNode[E];
        unionFind = new int[V+1];
        cnt = 0;
        for(int i=0; i<=V; i++){
            unionFind[i] = i;
        }
        for(int i=0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            sNodes[i] = new sNode(s,e,p);
        }
        Arrays.sort(sNodes);
        int sum = 0;
        for(int i=0; i<E; i++){
            if(cnt == V-1){
                break;
            }
            if(union(sNodes[i].start,sNodes[i].end)){
                sum += sNodes[i].price;
            }
        }
        System.out.println(sum);
    }
}
