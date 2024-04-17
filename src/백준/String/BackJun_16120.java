package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 시도 : 8회
 * 시간 : 4시간
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
        Stack<Character> st = new Stack<>();
        sb = new StringBuilder();
        for(int i=0; i< standard.length(); i++) {
            char alpha = standard.charAt(i);
            st.push(alpha);
            if (st.size() >= 4) {
                sb.setLength(0);

                for (int j = 0; j < 4; j++) {
                    sb.append(st.pop());
                }

                String letter = sb.toString();
                if (letter.equals("PAPP")) {
                    st.push('P');
                } else {
                    for (int j = 0; j < 4; j++) {
                        st.push(letter.charAt(3 - j));
                    }
                }
            }
        }

        if(st.size() == 1 && st.peek() == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}
