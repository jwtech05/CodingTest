package 백준.Sorting;

import java.io.*;

public class MergeSorting_2751 {
    public static int[] A, tmp;
    public static long result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        for(int i=1; i<=N; i++){
            //배열에 값을 집어 넣는다.
            A[i] = Integer.parseInt(br.readLine());
        }
        //병합정렬 메소드
        merge_sort(1, N);
        //System.out.println 대신 StringBuilder를 사용해서 시간 복잡도를 최소화한다.
        for(int i=1; i<=N; i++){
            sb.append(A[i]+"\n");
        }
        System.out.print(sb);
    }

    private static void merge_sort(int start, int end) {
        // 배열의 길이가 1보다 작을 경우 메소드를 종료한다.
        if(end - start < 1){
            return;
        }
        // 중간 값을 구한다. 시작점 + 배열의 길이를 2로 나눈 몫
        int mid = start + (end - start) / 2;
        //나눈 값을 기준으로 재귀 함수 실행
        merge_sort(start, mid);
        //나눈 값을 기준으로 재귀 함수 실행
        merge_sort(mid+1, end);
        // 임시 배열에 값 대입
        for (int i = start; i<=end; i++){
            tmp[i] = A[i];
        }
        //시작값
        int k = start;
        int index = start;
        //두번째 배열 시작값
        int index2 = mid + 1;
        //첫번째나 두번째가 끝에 도달할때까지 반복한다
        while(index <= mid && index2 <= end){
            if(tmp[index] > tmp[index2]){
                A[k] = tmp[index2];
                k++;
                index2++;
            }else {
                A[k] = tmp[index];
                k++;
                index++;
            }
        }
        //끝까지 도달했음에도 불구하고 탐색할 두번째 배열의 값이 남아있을 경우 남은 값을 반복한다.
        while (index <= mid) {
            A[k] = tmp[index];
            k++;
            index++;
        }
        //끝까지 도달했음에도 불구하고 탐샐할 첫번째 배열의 값이 남아있을 경우 남은 값을 반복한다.
        while(index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}

