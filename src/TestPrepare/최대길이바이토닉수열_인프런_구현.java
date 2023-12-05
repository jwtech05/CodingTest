package TestPrepare;

public class 최대길이바이토닉수열_인프런_구현 {
    public int solution(int[] nums){
        int answer = 0;
        boolean checker = false;
        int cnt = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] != nums[i+1]) {
                cnt++;
            }
            if(nums[i] < nums[i+1] && !checker){
                checker = true;
                cnt -=1;
                answer = Math.max(answer,cnt);
                cnt = 1;
            }
           if(nums[i] > nums[i+1]){
               checker = false;
           }
        }
        answer = Math.max(answer,cnt)+1;
        return answer;
    }

    public static void main(String[] args){
        최대길이바이토닉수열_인프런_구현 T = new 최대길이바이토닉수열_인프런_구현();

        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 4,5,6, 2, 1,3}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));

    }
}
