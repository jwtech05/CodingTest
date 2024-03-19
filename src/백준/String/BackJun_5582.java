package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * 시도 :1회 / 2회
 * 시간 : 21분 / 25분 / 1시간 13분 / 1시가 43분
 * 성공 여부 : 실패 / 실패 / 실패 / 성공
 * 원인 : 메모리 초과 / 시간초과 / 결국에는 동적 프로그래밍 이용해서 풀었다...
 * // 4000 * 4000이 아닌가?
* */
public class BackJun_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int[][] arr = new int[first.length()+1][second.length()+1];
        int answer = 0;
        for(int i=1; i < arr.length; i++){
            for(int j=1; j< arr[i].length; j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
            }
        }
        for(int i=1; i < arr.length; i++){
            for(int j=1; j< arr[i].length; j++){
                answer = Math.max(answer, arr[i][j]);
            }
        }
/*
        int answer = 0;
        for(int i=0; i < second.length(); i++){
            for(int j=i+1; j<= second.length(); j++){
                String partStr = second.substring(i,j);
                if(arr.contains(partStr)){
                    answer = Math.max(answer, partStr.length());
                }
            }
        }
*/

        System.out.println(answer);
    }
}
