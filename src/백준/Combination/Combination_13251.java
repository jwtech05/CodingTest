package 백준.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int colorN = Integer.parseInt(st.nextToken());
        int[] colorArr = new int[colorN];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<colorN; i++){
            int rockN = Integer.parseInt(st.nextToken());
            colorArr[i] = rockN;
            sum += rockN;
        }
        st = new StringTokenizer(br.readLine());
        int drawN = Integer.parseInt(st.nextToken());

        double per = 0;
        for(int i=0; i<colorArr.length; i++){
            double subPer = 0;
            if(colorArr[i] >= drawN) {
                subPer = 1;
                for(int j=0; j<drawN; j++){
                    subPer *= (double) (colorArr[i] - j) / (sum -j);
                }
            }
            per += subPer;
        }

        System.out.println(per);
    }
}
