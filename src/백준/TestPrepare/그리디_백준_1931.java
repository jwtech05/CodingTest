package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class TimeTable implements Comparable<TimeTable>{
    int start;
    int end;
    public TimeTable(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TimeTable o) {
        if(this.end == o.end){
            return this.start-o.start;
        }
        return this.end - o.end;
    }
}

public class 그리디_백준_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st;
        ArrayList<TimeTable> pq = new ArrayList<>();
        for(int i=0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new TimeTable(s,e));
        }
        Collections.sort(pq);
        int beforeEnd = 0;
        for(TimeTable x : pq){
            if(x.start >= beforeEnd){
                cnt++;
                beforeEnd = x.end;
            }
        }
        System.out.println(cnt);
    }
}
