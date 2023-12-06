package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UnionFInd_1976 {
    static ArrayList<ArrayList<Integer>> road;
    static int[] unionFind;
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if (x != y) {
            if (x < y) {
                unionFind[y] = x;
            } else {
                unionFind[x] = y;
            }
        }
    }

    public static int find(int num){
        if(unionFind[num] == num){
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine())+1;
        int planedCity = Integer.parseInt(br.readLine());
        unionFind = new int[city];
        for(int i=0 ; i<city; i++){
            unionFind[i] = i;
        }
        road = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i <city; i++){
            road.add(new ArrayList<Integer>());
        }
        for(int i=1; i<city; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j< city; j++){
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i,j);
                }
            }
        }
        int[] planed = new int[planedCity];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< planedCity; i++){
            planed[i] = Integer.parseInt(st.nextToken());
        }
        String answer = "YES";
        for(int i=0; i< planedCity-1; i++){
            if(unionFind[planed[i]] != unionFind[planed[i+1]]){
                answer = "NO";
            }
        }
        System.out.println(answer);
    }
}
