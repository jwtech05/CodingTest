package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class graph_1707_2 {
    //인접리스트 담을 어레이리스트 메모리 할당
    static ArrayList<Integer>[] A;
    // 체크할 메모리 할당
    static int[] check;
    //이미 왔다간 곳인지 체크할 메모리 할당
    static boolean[] visited;
    // 짝수 인지 홀수 인지 판단하는 메모리 할당
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //몇번 반복될지 값 주기
        int N = Integer.parseInt(br.readLine());
        //받은 값 만큼 반복문
        for(int t = 0; t < N; t++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for(int i = 1; i<=V; i++){
                //인덱스마다 ArrayList 할당
                A[i] = new ArrayList<Integer>();
            }

            for (int i=0; i<E; i++) {
                s = br.readLine().split(" ");
                int Start = Integer.parseInt(s[0]);
                int End = Integer.parseInt(s[1]);
                A[Start].add(End);
                A[End].add(Start);
            }

            for(int i = 1; i<= V; i++){
                //IsEven이 true 값이면 실행
                if(IsEven) DFS(i);
                else break;
            }
            if(IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void DFS(int node) {
        //값에 방문했으니 true 값으로 변환
        visited[node] = true;
        //인접리스트 인덱스에 있는 어레이리스트의 요소 값 순회
        for (int i : A[node]){
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if(check[node] == check[i]) {
                IsEven = false;
            }
        }
    }
}
