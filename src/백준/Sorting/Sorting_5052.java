package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/*
 * 6차 시도 : 실패
 * 소요 시간 : 3시간 22분
 * 실패 원인 :
 *
 * */
public class Sorting_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            String answer = "YES";
            HashMap<String, Boolean> HM = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            String[] pNumArr = new String[num];
            for(int j=0; j<num; j++){
                String pNum = br.readLine();
                pNumArr[j] = pNum;
                HM.put(pNum, false);
            }
            for(String pNum : pNumArr){
                if(answer.equals("YES")) {
                    String part = "";
                    for (int j = 1; j <= pNum.length(); j++) {
                        part = pNum.substring(0, j);
                        if (HM.containsKey(part)) {
                            if(HM.get(part)){
                                answer = "NO";
                                break;
                            }else{
                                HM.put(part,true);
                            }
                        }
                    }
                }else{
                    break;
                }
            }
            System.out.println(answer);
        }
    }
 }
