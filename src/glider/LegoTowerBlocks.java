package glider;


import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

//imagine you have N bloks numbered from 1 to N and they do not have uniform height
//build a toer using all the blocks . for stacking together you will get A* B points and new height will be A+B
// fine maximum possible points
//input 1 2 3 output will be 11 (1*3) points new height is 4 and (4*2) 8 points but total *+3
public class LegoTowerBlocks {

    public static int solve(List<Integer> h){
        int points=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //priority que will return the largest number
        for(int height: h) { //adding elements into priority queu
            pq.offer(height);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            points += first* second;
            pq.offer(first+second);
        }





        return points;
    }

    public static void main(String[] args) {
        List<Integer> h  = new ArrayList<>();
        h.add(1);
        h.add(2);
        h.add(3);
        int max = solve(h);
        System.out.println(max);
    }

}
