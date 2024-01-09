package 백준.TestPrepare;

public class 비밀번호_인프런_구현 {
        static int x = 0;
        static int y = 0;

        public int solution(int[] keypad, String password){
            int answer = 0;
            int[] dx = {0,1,0,-1,1,-1,1,-1};
            int[] dy = {1,0,-1,0,1,-1,-1,1};
            char[] pass = password.toCharArray();


            return answer;
        }

        public static void main(String[] args){
            비밀번호_인프런_구현 T = new 비밀번호_인프런_구현();
            System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
            System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
            System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
            System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
        }
    }