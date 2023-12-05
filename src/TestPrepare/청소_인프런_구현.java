package TestPrepare;

import java.util.Arrays;

public class 청소_인프런_구현 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int cnt = 0;
        int pointer = 0;
        while (cnt < k) {
            if (x + dx[pointer] > board.length - 1 || x + dx[pointer] < 0  || y + dy[pointer] > board.length - 1
                    || y + dy[pointer] < 0 || board[x + dx[pointer]][y + dy[pointer]] == 1) {
                if (pointer == 3) {
                    pointer = 0;
                } else {
                    pointer++;
                }
            } else {
                x = x + dx[pointer];
                y = y + dy[pointer];
            }
            cnt++;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args) {
        청소_인프런_구현 T = new 청소_인프런_구현();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }

}
