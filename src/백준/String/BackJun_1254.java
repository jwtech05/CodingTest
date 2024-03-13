package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJun_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String origin = br.readLine();
        for(int i=origin.length()-1; i>= 0; i--){
            sb.append(origin.charAt(i));
        }
        String reverse = sb.toString();
    }
}
