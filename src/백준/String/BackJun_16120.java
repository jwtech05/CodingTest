package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시도 : 1회
 * 시간 : 42분
 * 성공 여부 : 보류
 * */
public class BackJun_16120 {
    static boolean flag;
    static StringBuilder sb;
    static String standard;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        standard = br.readLine();
        sb = new StringBuilder();
        len = standard.length();
        flag = false;
        DFS("P", 4);

        if(flag) System.out.println("PPAP");
        else System.out.println("NP");
    }

    public static void DFS(String str, int N){
        if(N >= len){
            if(str.equals(standard)){
                flag = true;
            }
            return;
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'P') {
                String front = str.substring(0, i);
                String back = str.substring(i + 1);
                sb.append(front).append("PPAP").append(back);
                String nStr = sb.toString();
                sb.setLength(0);
                DFS(nStr, nStr.length());
            }
        }

    }
}
