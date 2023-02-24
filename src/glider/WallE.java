package glider;


//You created WALL E, a small waste collecting robot equipped with a radar. Now you want to use it for recycling based on the following information:
//        blocks of garbage are located in a straight line. Pis the position of WALL-E. Now, WALL-E can detect whether there is a garbage block Klength units away from it or not. However, if it cannot determine the exact position of a garbage block, it will not take chances to check both positions to save energy.
//        1 represents that there is a garbage block on the ith position, and o indicates that there is no garbage block on the ith position. WALL-E will only go to the positions where it is sure that a garbage block is located and will recycle it.
//        Your task is to calculate the number of garbage blocks WALL-E will recycle.
//        Note: Every position is 1-based.

//first line is WALLE initial position P
// second line contains N, that is number of poisitions wher garbage bocks can be located
//third line of input contains N integers containing 0 and 1 which descirbe the posiiton ofo garbage blocks

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WallE {


    public static void main(String[] args) {

        //input
        //3
        //5
        //1 0 1 1 1

        //output should be 3
        //walle is located in third position walle-E is sure that there is one garbage block at distance 0 from it.

        int P =3;
        List<Integer> a = Arrays.asList(1,0,1,1,1);
        Set<Integer> blocks = new HashSet<>();
        int k=1;
        for (int i=0; i<a.size(); i++){
            if(a.get(i) ==1){
                int distance = Math.abs(i-P);
                if(distance <= k){
                    blocks.add(i);
                }
            }
        }

        System.out.println(blocks.size());


    }


}
