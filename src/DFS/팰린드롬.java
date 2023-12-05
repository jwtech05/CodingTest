package DFS;
import java.lang.reflect.Array;
import java.util.*;
class Solution {
    static HashMap<Character, Integer> HM;
    static boolean[] check;
    static ArrayList<String> words;
    public void DFS(char key ,Deque<Character> dq, int len){
        if(dq.size() == len){
            StringBuilder word = new StringBuilder();
            while(!dq.isEmpty()){
                word.append(dq.pop());
            }
            String a = String.valueOf(word);
            words.add(a);
            return;
        }
        dq.addFirst(key);
        dq.addLast(key);
        for(Character x: HM.keySet()){
            if(HM.get(x) != 0){
                HM.put(x,HM.get(x)-2);
                DFS(x,dq,len+2);
                HM.put(x,HM.get(x)+2);
                dq.removeFirst();
                dq.removeLast();
            }
        }
    }
    public String[] solution(String s){
        HM = new LinkedHashMap<>();
        Deque<Character> dq = new LinkedList<>();
        char[] arr = s.toCharArray();
        words = new ArrayList<>();
        int len = arr.length;
        for(int i=0; i<len; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i],0)+1);
        }
        for(Character x: HM.keySet()){
            HM.put(x,HM.get(x)-2);
            dq.addFirst(x);
            dq.addLast(x);
            DFS(x,dq,2);
            HM.put(x,HM.get(x)+2);
        }
        String[] answer = new String[words.size()];
        for(int i=0; i<words.size(); i++){
            answer[i] = words.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}