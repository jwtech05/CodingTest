package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Path{

    int to;
    int dis;

    public Path(int to, int dis) {
        this.to = to;
        this.dis = dis;
    }
}

public class 다익스트라_백준_1854 {
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<ArrayList<Path>> arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];
        arr = new ArrayList<>();
        ans = new ArrayList<>();
        Queue<Path> queue = new LinkedList<>();
        for(int i=0; i<N+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<N+1; i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(s).add(new Path(e,v));
        }
        DFS(new Path(1,0), 0);
        for(int i=1; i < ans.size(); i++){
            ArrayList<Integer> everyDis = ans.get(i);
            Collections.sort(everyDis);
            System.out.println(everyDis.get(1));
        }
    }

    public static void DFS(Path path, int sum){
        int to = path.to;
        int dis = path.dis;
        ans.get(to).add(sum);
        for(Path x : arr.get(to)){
            DFS(x,sum+dis);
        }
    }
}
/*        int totalDis = 0;
        queue.offer(new Path(1,0));
        int cnt = 0;
        while (!queue.isEmpty()) {
            Path path = queue.poll();
            int to = path.to;
            int dis = path.dis;
            cnt += dis;
            for (Path x : arr.get(to)) {
                queue.offer(x);
            }
        }*/