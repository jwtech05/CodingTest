package 백준.fiveJuCha;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
/*
 * 시도 : 1회
 * 시간 : 4시간 30분
 * 성공 여부 : 성공
 * */
public class BackJun_2212 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensor = Integer.parseInt(br.readLine());
        int converter = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[sensor];
        for(int i=0; i<sensor; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] diff = new int[sensor-1];
        for(int i=0; i<sensor-1; i++) {
            diff[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(diff);
        int sum = 0;
        for(int i=0; i<diff.length-(converter-1); i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}