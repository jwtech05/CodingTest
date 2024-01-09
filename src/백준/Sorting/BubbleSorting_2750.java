package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSorting_2750 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] BS = new int[N];
        int tmp = 0;
        for(int i=0; i<N; i++){
            BS[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N-i-1; j++){
                if(BS[j] > BS[j+1]){
                    tmp = BS[j];
                    BS[j] = BS[j+1];
                    BS[j+1] = tmp;
                }
            }
        }
        for(int i = 0 ; i<N; i++){
            System.out.println(BS[i]);
        }
    }
}
