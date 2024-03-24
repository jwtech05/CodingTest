package 백준.ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 시도 : 1회
 * 채점 결과 : 성공
 * 소요 시간 : 1시간 30분
 * */
class chNode{
    int nn;
    int mm;
    chNode(int nn, int mm){
        this.nn = nn;
        this.mm = mm;
    }
}
public class BackJun_15686 {
    static int M, answer;
    static int[] numbers;
    static int[][] distance;
    static ArrayList<chNode> chicken, home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    home.add(new chNode(i,j));
                }else if(arr[i][j] == 2){
                    chicken.add(new chNode(i,j));
                }
            }
        }
        distance = new int[home.size()][chicken.size()];
        numbers = new int[M];
        for(int i=0; i<home.size(); i++){
            for(int j=0; j<chicken.size(); j++){
                distance[i][j] = Math.abs(home.get(i).nn - chicken.get(j).nn) + Math.abs(home.get(i).mm - chicken.get(j).mm);
            }
        }
        answer = Integer.MAX_VALUE;
        DFS(0,0);

        System.out.println(answer);
    }

    public static void DFS(int num, int cnt){
        if(cnt == M){
            answer = Math.min(answer, calculate());
            return;
        }
        for(int i=num; i<chicken.size(); i++){
            numbers[cnt] = i;
            DFS(i+1, cnt+1);
        }
    }

    private static int calculate() {
        int sum = 0;
        for(int i=0; i<home.size(); i++){
            int minD = Integer.MAX_VALUE;
            for(int j=0; j<numbers.length; j++){
                minD = Math.min(minD, distance[i][numbers[j]]);
            }
            sum += minD;
        }
        return sum;
    }
}
