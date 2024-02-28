package 테스트용;

public class DFS_TEST {
    static int num ;
    public static void main(String[] args) {
        num = 100;
        DFS(num, 0);
    }
    public static void DFS(int num, int cnt){
        if(cnt == 2){
            System.out.print(cnt +" ");
            return;
        }
        DFS(num,cnt+1);
        DFS(num+1, cnt+1);
    }

}
