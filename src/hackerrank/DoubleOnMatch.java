package hackerrank;

import java.util.ArrayList;
import java.util.List;

//given array of long integers arr ana number num,
//iterate and double the value of num whenever an element equals num;
//find max posible value of num
public class DoubleOnMatch {

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        for(int i=0; i<50; i++){
            arr.add(Long.valueOf(i));
        }
        long num=2;
        boolean exist = true;
        long max = num;
        while(exist){
            exist = false;
            for(long a :arr){
                if(a==num){
                    num *=2;
                    exist = true;
                }
                max = Math.max(max, num);
            }
        }


//this is also correct
//        for(int i=0; i<arr.size(); i++){
//            if(num == arr.get(i)){
//                num *= 2;
//            }
//        }

        System.out.println(max);
    }
}
