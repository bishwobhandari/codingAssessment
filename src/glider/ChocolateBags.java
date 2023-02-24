package glider;
/* Your mother has N bags containing Chocolates (the ith bag contains ar[i] chocolates). she wants to ditribute
* these bags between you and your sister in a way that there is absolute minimum difference between the total number
*  of chocolates each of you gets.
* */


import java.util.ArrayList;
import java.util.List;

public class ChocolateBags {

    public static int solve(List<Integer> ar){
        int sum = ar.stream().mapToInt(Integer::intValue).sum();
        int n = ar.size();
        boolean dp[][]=new boolean[n+1][sum+1];
        dp[0][0] =true;
        for(int i=1; i<= n ; i++){
            int value = ar.get(i-1);
            for(int j=0; j<=sum ; j++){
                dp[i][j]  = dp[i-1][j] || (j>= value && dp[i-1][j-value]);
            }
        }

    int diff = Integer.MAX_VALUE;
        for(int j=0; j<=sum/2; j++){
            if(dp[ar.size()][j]){
                diff = Math.min(diff, sum-2*j);
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        ar.add(12);
        ar.add(3);
        ar.add(6);
        ar.add(4);
        ar.add(2);

//        ar.add(7);
//        ar.add(3);
//        ar.add(1);
//        ar.add(8);
//        ar.add(4);
//        ar.add(5);

        System.out.println(solve(ar));
    }

}
