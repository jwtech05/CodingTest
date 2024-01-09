package 인프런.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class fly {
    int end, cost;

    public fly(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

}
//백트래킹 사용하는 문제
public class Graph_최소비행료 {
    static ArrayList<ArrayList<fly>> flys;
    static int cg;
    static boolean[] arrive;
    static int goal;
    static int result;
    static int answer;
    public int solution(int n, int[][] flights, int s, int e, int k) {
        answer = 1000001;
        cg = k;
        goal = e;
        flys = new ArrayList<>();
        result = 0;
        arrive = new boolean[n];
        for (int i = 0; i < n; i++) {
            flys.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int go = flight[0];
            int arrive = flight[1];
            int cost = flight[2];
            flys.get(go).add(new fly(arrive, cost));
        }
        DFS(s, 0);
        if(answer == 1000001){
            answer = -1;
        }
        return answer;
    }

    public static void DFS(int start, int cnt){
        if(cnt > cg){
            return;
        }
        for(fly x : flys.get(start)){
            result += x.cost;
            if(x.end == goal){
                answer = Math.min(result, answer);
            }
            cnt++;
            DFS(x.end, cnt);
            result -= x.cost;
            cnt--;
        }
    }
    public static void main(String[] args){
        Graph_최소비행료 T = new Graph_최소비행료();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}