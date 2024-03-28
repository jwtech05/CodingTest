package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 시도 : 1회
 * 시간 : 1시간 15분
 * 성공 여부 : 실패
 * 시간초과
 * */
public class BackJun_1655 {
    public static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(binary(arr.size(), num), num);
            int middle = arr.size() / 2;
            if(arr.size() % 2 == 0 && middle > 0){
                System.out.println(arr.get(middle-1));
            }else{
                System.out.println(arr.get(middle));
            }
        }
    }

    public static int binary(int num, int compare){
        int start = 0;
        int end = num;
        while(start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) > compare) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
/*            for(int j=0; j<arr.size(); j++){
                System.out.print(arr.get(i)+" ");
            }*/