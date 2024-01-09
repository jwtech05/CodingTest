package 백준.TestPrepare;

import java.util.Arrays;

public class 좌석번호_인프런_구현 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        int[][] check = new int[c+1][r+1];

        int x = 1;
        int y = 1;
        int cnt = 1;
        int dis = 0;
        while(k > cnt){

            int cx = x + dx[dis];
            int cy = y + dy[dis];
            if(cx < 1 || cx >= c+1 || cy <1 || cy >= r+1 || check[cx][cy] == 1){
                dis = (dis + 1) % 4;
            }else {
                check[cx][cy] = 1;
                x = cx;
                y = cy;
            }
            cnt++;
        }
        answer[0]=x;
        answer[1]=y;
        return answer;
    }

    public static void main(String[] args) {
        좌석번호_인프런_구현 T = new 좌석번호_인프런_구현();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));

    }
}