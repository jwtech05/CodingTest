package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_1991 {
    static ArrayList<ArrayList<Character>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 'A';
            char left =  st.nextToken().charAt(0);
            char right =  st.nextToken().charAt(0);
            arr.get(root).add(left);
            arr.get(root).add(right);
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
    public static void preOrder(int now){
        if((char)(now +'A') == '.'){
            return;
        }
        System.out.print((char) (now+'A'));
        preOrder(arr.get(now).get(0)-'A');
        preOrder(arr.get(now).get(1)-'A');
    }

    public static void inOrder(int now){
        if((char)(now +'A') == '.'){
            return;
        }
        inOrder(arr.get(now).get(0)-'A');
        System.out.print((char) (now+'A'));
        inOrder(arr.get(now).get(1)-'A');
    }

    public static void postOrder(int now){
        if((char)(now +'A') == '.'){
            return;
        }
        postOrder(arr.get(now).get(0)-'A');
        postOrder(arr.get(now).get(1)-'A');
        System.out.print((char) (now+'A'));
    }
}
