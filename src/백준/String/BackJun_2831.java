package 백준.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BackJun_2831 {
    static int N, pairs = 0;
    static ArrayList<Integer>[] men = new ArrayList[2];
    static ArrayList<Integer>[] women = new ArrayList[2];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 2; i++) {
            men[i] = new ArrayList<Integer>();
            women[i] = new ArrayList<Integer>();
        }

        String[] menArr = br.readLine().split(" ");
        String[] womenArr = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int menHeight = Integer.parseInt(menArr[i]);
            int womenHeight = Integer.parseInt(womenArr[i]);

            if(menHeight < 0)
                men[0].add(menHeight*-1);
            else
                men[1].add(menHeight);

            if(womenHeight < 0)
                women[1].add(womenHeight*-1);
            else
                women[0].add(womenHeight);
        }

        for(int i = 0; i < 2; i++) {
            Collections.sort(men[i]);
            Collections.sort(women[i]);
        }

        findPair(0);
        findPair(1);

        System.out.println(pairs);
    }

    static void findPair(int type) {
        for(int i = 0, j = 0; i < men[type].size() && j < women[type].size();) {
            //0번 타입 : 남자가 크고 여자가 작은 커플
            //1번 타입 : 여자가 크고 남자가 작은 커플
            int tall = type == 0 ? men[type].get(i) : women[type].get(j);
            int small = type == 0 ? women[type].get(j) : men[type].get(i);

            //더 큰 쪽(남자 or 여자)의 index를 증가 시킴
            if(tall <= small) {
                if(type == 0)
                    i++;
                else
                    j++;
                continue;
            }

            pairs++;
            i++;
            j++;
        }
    }
}