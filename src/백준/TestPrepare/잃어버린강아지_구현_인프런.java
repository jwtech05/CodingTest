package 백준.TestPrepare;

public class 잃어버린강아지_구현_인프런 {

    static int[] 현수_dx = {-1, 0, 1, 0};
    static int[] 현수_dy = {0, 1, 0, -1};
    static int[] 강아지_dx = {-1, 0, 1, 0};
    static int[] 강아지_dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int answer = 0;
        int 현수_X = 0;
        int 현수_Y = 0;
        int 강아지_X = 0;
        int 강아지_Y = 0;
        int count = 0;
        int direction = 0;
        int direction2 = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    현수_X = i;
                    현수_Y = j;
                } else if (board[i][j] == 3) {
                    강아지_X = i;
                    강아지_Y = j;
                }
            }
        }

        while (count < 10000) {

            count++;

            int dx = 현수_X + 현수_dx[direction];
            int dy = 현수_Y + 현수_dy[direction];

            int dx2 = 강아지_X + 강아지_dx[direction2];
            int dy2 = 강아지_Y + 강아지_dy[direction2];

            if (dx < 0 || dx > board.length - 1 || dy < 0 || dy > board.length - 1 || board[dx][dy] == 1) {
                direction = (direction + 1) % 4;
            } else {
                현수_X = dx;
                현수_Y = dy;
            }

            if (dx2 < 0 || dx2 > board.length - 1 || dy2 < 0 || dy2 > board.length - 1 || board[dx2][dy2] == 1) {
                direction2 = (direction2 + 1) % 4;
            } else {
                강아지_X = dx2;
                강아지_Y = dy2;
            }

            if (현수_X == 강아지_X && 현수_Y == 강아지_Y) {
                answer = count;
                break;
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        잃어버린강아지_구현_인프런 T = new 잃어버린강아지_구현_인프런();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
