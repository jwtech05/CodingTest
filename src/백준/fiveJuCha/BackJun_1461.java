package 백준.fiveJuCha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 시도 : 2회
 * 시간 : 40분
 * 성공 여부 : 성공
 * 구해야 하는 본질에 집중하자
 * */
public class BackJun_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bookNum = Integer.parseInt(st.nextToken());
        int liftNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> plusArr = new PriorityQueue<>((o1,o2) -> o2 - o1);
        PriorityQueue<Integer> minusArr = new PriorityQueue<>((o1,o2) -> o2 - o1);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<bookNum; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > 0){
                plusArr.offer(num);
            }else if(num < 0){
                minusArr.offer(Math.abs(num));
            }
        }
        int count = liftNum;
        while(!plusArr.isEmpty()){
            if(count == 0) count = liftNum;
            int num = plusArr.poll();
            if(count == liftNum) {
                arr.add(num);
            }
            count--;
        }
        count = liftNum;
        while(!minusArr.isEmpty()){
            if(count == 0) count = liftNum;
            int num = minusArr.poll();
            if(count == liftNum) {
                arr.add(num);
            }
            count--;
        }
        Collections.sort(arr);
        int answer = 0;
        for(int i=0; i<arr.size(); i++){
            if(i == arr.size()-1) answer += arr.get(i);
            else answer += (arr.get(i) * 2);
            //System.out.println(arr.get(i));
        }

        System.out.println(answer);
    }
}
