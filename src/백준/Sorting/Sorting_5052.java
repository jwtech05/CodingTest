package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 1차 시도 : 실패
* 소요 시간 : 2시간 5분
* 실패 원인 :
*
* */
public class Sorting_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[][] arr;
        int[][] checkArr;
        for(int i = 0; i<tc; i++){
            String answer = "YES";
            arr = new int[10001][10];
            checkArr = new int[10][10];
            for (int j = 0; j < arr.length; j++) {
                Arrays.fill(arr[j], -1);
            }
            int ec = Integer.parseInt(br.readLine());
            for(int j=0; j<ec; j++){
                String num = br.readLine();
                for(int k=0; k< num.length(); k++){
                    arr[j][k] = num.charAt(k)-'0';
                }
            }
            for(int j=0; j<10; j++){
                for(int k=0; k<ec; k++){
                    if(arr[k][j] != -1) checkArr[j][arr[k][j]]++;
                }
            }
            for(int j=0; j<ec; j++){
                boolean flag = false;
                for(int k=0; k<arr[ec].length; k++){
                    if(arr[j][k] == -1) continue;
                    //하나라도 1이 있으면 일관성이 있는 것
                    if(checkArr[k][arr[j][k]] == 1){
                        flag = true;
                    }
                }
                if(!flag){
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
