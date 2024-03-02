package 백준.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
* 소요 시간 : 1시간 10분
* 성공 여부 : 성공
* 시도 횟수 : 1번
* 시간 소유 이유 : 중복 규칙 찾는데 40분 소요;;
* */

public class Hash_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int num = Integer.parseInt(br.readLine());
            HashMap<String, Integer> HM = new HashMap<>();
            for(int j = 0; j< num; j++){
                String [] arr = new String[2];
                st = new StringTokenizer(br.readLine());
                arr[0] = st.nextToken();
                arr[1] = st.nextToken();
                HM.put(arr[1], HM.getOrDefault(arr[1], 0) + 1);
            }
            int sum = 1;
            for(int x : HM.values()){
                sum *= (x+1);
            }
            sum = sum - 1;
            System.out.println(sum);
        }
    }
}
