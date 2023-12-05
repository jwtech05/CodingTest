package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 그리디_백준_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String math = st.nextToken();
        String[] list = math.split("-");
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            String[] numbers = list[i].split("\\+");
            for (int j = 0; j < numbers.length; j++) {
                sum = sum + Integer.parseInt(numbers[j]);
            }
            arr.add(sum);
            sum = 0;
        }
        int answer = 0;
        for(int i=0; i<arr.size(); i++){
            if(i == 0){
                answer += arr.get(i);
            }else {
                answer -= arr.get(i);
            }
        }
        System.out.println(answer);
    }
}
