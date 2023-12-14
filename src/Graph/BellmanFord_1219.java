package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Road{
    int start;
    int end;
    int price;
    Road(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}

public class BellmanFord_1219 {
    static long distance[], cityMoney[];
    static Road roads[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Road>> arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        roads = new Road[M];
        distance = new long[N];
        cityMoney = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads[i] = new Road(s,e,c);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[sCity] = cityMoney[sCity];

        for(int i=0; i<=N+100; i++){
            for(int j=0; j< M; j++){
                int sta = roads[j].start;
                int en = roads[j].end;
                int pri = roads[j].price;
                if(distance[sta] == Long.MIN_VALUE) continue;
                else if(distance[sta] == Long.MAX_VALUE) distance[en] =Long.MAX_VALUE;
                else if(distance[en] < distance[sta]+ cityMoney[en] - pri){
                    distance[en] = distance[sta]+ cityMoney[en] - pri;
                    if(i >= N-1) distance[en] = Long.MAX_VALUE;
                }
            }
        }
        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }
}
