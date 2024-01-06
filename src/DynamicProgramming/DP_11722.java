package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //첫번째 배열 길이
        int m = Integer.parseInt(st.nextToken());  //두번째 배열 길이
        int [] arr = new int[n+m];  //정렬할 배열 초기화

        st = new StringTokenizer(br.readLine());  //첫번째 배열

        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); //두번째 배열

        for (int i = 0; i < m; i++) {
            arr[i+n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //정렬

        StringBuilder sb = new StringBuilder();

        for(int r : arr) {
            sb.append(r+" ");

        }
        System.out.println(sb);

    }

}
