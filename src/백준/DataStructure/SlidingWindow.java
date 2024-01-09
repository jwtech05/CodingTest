package 백준.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {

    static int s;
    static int e;
    static int[] checkArr = new int[4];
    static int[] myArr = new int[4];
    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] A;
        String a = br.readLine();
        A = a.toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
        }
        s = 0;
        e = M;
        for(int i=s; i<e; i++){
            if (A[i]=='A') myArr[0]++;
            if (A[i]=='C') myArr[1]++;
            if (A[i]=='G') myArr[2]++;
            if (A[i]=='T') myArr[3]++;
        }

        if(check()){
            answer++;
        }

        for(int j=e; j<N; j++){
            int i = s;

            if (A[i]=='A') myArr[0]--;
            if (A[i]=='C') myArr[1]--;
            if (A[i]=='G') myArr[2]--;
            if (A[i]=='T') myArr[3]--;

            if (A[j]=='A') myArr[0]++;
            if (A[j]=='C') myArr[1]++;
            if (A[j]=='G') myArr[2]++;
            if (A[j]=='T') myArr[3]++;

            if(check()){
                answer++;
            }
            s++;
        }
        System.out.print(answer);
    }

    public static boolean check(){
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i])
                return false;
        }
        return true;
    }
}
