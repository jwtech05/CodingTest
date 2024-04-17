package 백준.fiveJuCha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class fNode{
    int sMonth;
    int sDay;
    int eMonth;
    int eDay;
    public fNode(int sMonth, int sDay, int eMonth, int eDay){
        this.sMonth = sMonth;
        this.sDay = sDay;
        this.eMonth = eMonth;
        this.eDay = eDay;
    }
}
public class BackJun_2457 {
    static PriorityQueue<fNode> PQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<fNode> PQ = new PriorityQueue<>((f1, f2) -> {
            if (f1.sMonth == f2.sMonth) {
                if (f1.sDay == f2.sDay) {
                    if (f1.eMonth == f2.eMonth) {
                        return f2.eDay - f1.eDay;
                    }
                    return f2.eMonth - f1.eMonth;
                }
                return f1.sDay - f2.sDay;
            }
            return f1.sMonth - f2.sMonth;
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int sM = Integer.parseInt(st.nextToken());
            int sD = Integer.parseInt(st.nextToken());
            int eM = Integer.parseInt(st.nextToken());
            int eD = Integer.parseInt(st.nextToken());
            PQ.add(new fNode(sM,sD,eM,eD));
        }

        int endMonth = 3;
        int endDay = 1;
        int startMonth = 3;
        int startDay = 1;
        int cnt = 0;
        while(!PQ.isEmpty() && (endMonth < 12 || (endMonth == 12 && endDay < 1))){
            fNode x = PQ.poll();
            if(x.sMonth <= endMonth){
                if(x.sMonth == endMonth && x.sDay > endDay) continue;
                if(x.eMonth >= endMonth){
                    if(x.eMonth == endMonth && x.eDay <= endDay) continue;
                    if(x.sMonth >= startMonth && x.sDay >= startDay && endMonth >= x.sMonth && endDay >= x.sDay){
                        endMonth = x.eMonth;
                        endDay = x.eDay;
                        startMonth = x.sMonth;
                        startDay = x.sDay;
                        continue;
                    }
                    System.out.println(x.sMonth+" "+x.sDay+" "+x.eMonth+" "+x.eDay);
                    cnt++;
                    endMonth = x.eMonth;
                    endDay = x.eDay;
                    startMonth = x.sMonth;
                    startDay = x.sDay;
                    //System.out.println(endMonth+" "+endDay);
                }
            }
        }
/*        while(!PQ.isEmpty()){
            fNode check = PQ.poll();
            System.out.println(check.sMonth +" " +check.sDay + " "+ check.eMonth +" "+ check.eDay);
        }*/
        System.out.println(cnt);
    }
}
