package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 시도 : 6회
 * 시간 : 2시간
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
        flag = true;
        sb.append(standard);
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i<standard.length(); i++){
            arr.add(standard.charAt(i));
        }
        char[] alpha = standard.toCharArray();

        for(int i=0; i<standard.length(); i++){
            if(alpha[i] =='A') {
                if(standard.charAt(i-2) == 'P' && standard.charAt(i-1) == 'P' && standard.charAt(i+1) == 'P') sb.replace(i-2, i+1, "P");
                System.out.println(sb.toString());
            }
        }
        String newStandard = sb.toString();
        if(flag) System.out.println("PPAP");
        else System.out.println("NP");
    }

    public static void DFS(String str) {
        if(str.equals("P")){
            flag = true;
            return;
        }
        if(!str.contains("A") || str.length() < 4){
            return;
        }
        int aLoc = str.indexOf("A");
        if(aLoc < 2){
            return;
        }
        String front = str.substring(aLoc - 2, aLoc);
        String back = str.substring(aLoc + 1, aLoc + 2);
        if(front.equals("PP") && back.equals("P")){
            String fFront = str.substring(0, aLoc-2);
            String bBack = str.substring(aLoc+2);
            sb.append(fFront).append("P").append(bBack);
            String nStandard = sb.toString();
            sb.setLength(0);
            DFS(nStandard);
        }
    }
}
/*        Iterator<Character> itr = arr.iterator();
        while(itr.hasNext()){
            char a = itr.next();
            char b = itr.next();
            char c = itr.next();
            char d = itr.next();
            if(a == 'P' && b=='P' && c=='A' && d=='P') {
                itr.remove();
                itr.remove();
                itr.remove();
            }
            System.out.println(a+b+c+d);
        }*/