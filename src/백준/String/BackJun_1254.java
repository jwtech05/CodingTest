package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 시도 : 2회
* 시간 : 59분
* 성공 여부 : 보류
* */
public class BackJun_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String origin = br.readLine();
        for(int i=origin.length()-1; i>= 0; i--){
            sb.append(origin.charAt(i));
        }
        String reverse = sb.toString();
        int same = 0;
        for(int i=0; i<origin.length(); i++){
            for(int j=i+1; j<=origin.length(); j++){
                String realOg = origin.substring(i,j);
                for(int k=1; k<=reverse.length(); k++){
                    String rv = reverse.substring(0,k);
                    if(realOg.equals(rv)){
                        same = Math.max(same, rv.length());
                    }
                }
            }
        }
        int answer = (origin.length() * 2) - same;
        System.out.print(answer);
    }
}
