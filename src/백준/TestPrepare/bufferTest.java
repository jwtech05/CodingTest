package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bufferTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        System.out.println(a);
        System.out.println(b);
    }
}
