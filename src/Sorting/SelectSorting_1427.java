package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectSorting_1427 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] A = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }
        for(int i=0; i<str.length(); i++){
            int tmp = i;
            for(int j = i+1; j <str.length(); j++){
                if (A[tmp] < A[j]) {
                    tmp = j;
                }
            }
            if(A[i] < A[tmp]){
                int temp = A[i];
                A[i] = A[tmp];
                A[tmp] = temp;
            }

        }
        for(int i = 0; i< str.length(); i++){
            System.out.print(A[i]);
        }
    }
}