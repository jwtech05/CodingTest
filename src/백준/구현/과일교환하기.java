package 백준.구현;

class Solution {

    public boolean fruitKind(int[] box){
        if(box[0] == box[1] ) return false;
        if(box[0] == box[2]) return false;
        if(box[1] == box[2]) return false;
        return true;
    }

    public int fruitLeast(int[] box){
        int min = 50;
        int num = 0;
        for(int i=0; i<box.length; i++){
            if(min > box[i]) {
                min = Math.min(min, box[i]);
                num = i;
            }
        }
        return num;
    }
    public int solution(int[][] fruit){
        boolean[] check = new boolean[fruit.length];
        for(int i=0; i<fruit.length; i++){
            int leastPick = 0;
            int leastPick2 = 0;
            if(!fruitKind(fruit[i]) || check[i]){
                continue;
            }
            for(int j=i+1; j<fruit.length; j++) {
                if (!fruitKind(fruit[j]) || check[j]) {
                    continue;
                }
                leastPick = fruitLeast(fruit[i]);
                leastPick2 = fruitLeast(fruit[j]);

                if (leastPick != leastPick2&& fruit[i][leastPick2] > 0 && fruit[j][leastPick] > 0) {
                    if (fruit[i][leastPick] + 1 <= fruit[i][leastPick2] - 1 && fruit[j][leastPick2] + 1 <= fruit[j][leastPick] - 1) {
                        fruit[i][leastPick]++;
                        fruit[j][leastPick2]++;
                        fruit[i][leastPick2]--;
                        fruit[j][leastPick]--;
                        check[i] = true;
                        check[j] = true;
                        break;
                    }
                    }
                }
            }
        int answer = 0;
        for(int x=0; x<fruit.length; x++){
            int num = fruit[x][0];
            for(int y=1; y<fruit[x].length; y++){
                if (fruit[x][y] < num) {
                    num = fruit[x][y];
                }
            }
            answer += num;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}