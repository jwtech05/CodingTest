package DataStructure;

import java.util.Scanner;

public class ArrangementList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] a = new char[n];
        a = s.toCharArray();
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(String.valueOf(a[i]));
        }
        System.out.println(sum);
    }
}
