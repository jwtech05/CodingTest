package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬라이딩윈도우_백준_12891 {
    static int[] checker;
    static boolean[] must;
    public static void minus(char alpha){
        if(alpha == 'A'){
                checker[0]--;
        }else if(alpha == 'C'){
                checker[1]--;
        }else if(alpha == 'G'){
                checker[2]--;
        }else if(alpha == 'T'){
                checker[3]--;
        }
    }

    public static void plus(char alpha){
        if(alpha == 'A' && must[0]){
            checker[0]++;
        }else if(alpha == 'C'&& must[1]){
            checker[1]++;
        }else if(alpha == 'G'&& must[2]){
            checker[2]++;
        }else if(alpha == 'T'&& must[3]){
            checker[3]++;
        }
    }
    public static boolean checking(int[] checker){
        for(int i=0; i<4; i++){
            if(checker[i] > 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int answer = 0;
        must = new boolean[4];
        st = new StringTokenizer(br.readLine());
        checker = new int[4];
        for(int i=0; i<4; i++){
            checker[i] = Integer.parseInt(st.nextToken());
            if(checker[i] != 0){
                must[i] = true;
            }
        }
        for(int i = 0; i<S; i++){
            char alpha = dna.charAt(i);
            minus(alpha);
        }
        if(checking(checker)) answer++;
        for(int i=S; i<N; i++){
            int j = i-S;
            minus(dna.charAt(i));
            plus(dna.charAt(j));
            if(checking(checker)) answer++;
        }
        System.out.println(answer);
    }



}
