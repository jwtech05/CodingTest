package 백준.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* 소요 시간 : 1시간 26분
* 성공 여부 : 성공
* 실패 이유 : 시간 초과
* 시도 횟수 : 5회
* 실패 원인 : k의 모든 합이 100,000회 인데 비해, 고릴라의 정보 요구 개수가 b가 한번에 최대 100,000회 였다. 함정 문제였다.
* */
/*
* 공부 해야할 점 : priorityQueue => reverse.order
*
* */
public class Hash_22252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<String, PriorityQueue<Integer>> HM = new HashMap<>();
        long sum = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String gorilla = st.nextToken();
            int infoNum = Integer.parseInt(st.nextToken());
            if(M == 1){
                if(!HM.containsKey(gorilla)) HM.put(gorilla, new PriorityQueue<Integer>(Collections.reverseOrder()));
                //reversOrder 몰라서 검색했음
                //HM.put(gorilla, HM.getOrDefault(gorilla, new PriorityQueue<Integer>(Collections.reverseOrder())));
                for(int j=0; j<infoNum; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    HM.get(gorilla).add(num);
                }
                // PriorityQueue<Integer> pq = new PriorityQueue<>
            }else if(M == 2){
                if(!HM.containsKey(gorilla)) continue;
                for(int j=0; j<infoNum; j++){
                    if(!HM.get(gorilla).isEmpty()){
                        sum += HM.get(gorilla).poll();
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
