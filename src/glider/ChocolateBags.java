package glider;
/* Your mother has N bags containing Chocolates (the ith bag contains ar[i] chocolates). she wants to ditribute
* these bags between you and your sister in a way that there is absolute minimum difference between the total number
*  of chocolates each of you gets.
* */


import java.util.ArrayList;
import java.util.List;

public class ChocolateBags {

    public static int solve(List<Integer> ar){
        int sum = ar.stream().reduce(Integer::sum).get();
        System.out.println("sum  is "+sum );

        int n = ar.size();
        //create an array to store the sum of subsets
        //creates 2d array for dynamic problem with size 6 * 27
        boolean dp[][]=new boolean[n+1][sum+1];

        for(int i=0; i<= n ; i++){
            dp[i][0]=true;
        }

        //[0][0] is alreay true
        for(int i=1; i<=sum; i++){
            dp[0][i] =false;
        }

       // print2D(dp);

        for(int i=1; i <=n ; i++){
            for(int j=1; j<=sum ; j++){
                dp[i][j]  = dp[i-1][j];

                if (ar.get(i - 1) <= j)
                    dp[i][j] |= dp[i - 1][j - ar.get(i-1)];
            }
        }



    int diff = Integer.MAX_VALUE;
        for(int j =sum/2; j>=0 ; j--){
            if(dp[n][j] == true){
                diff = sum-2*j;
                break;
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

        //output should be 1 for this list
        //there are five elements . you can divide by (12,2) =14 and (3+6+4)=13
        //so the difference is 1 minimum

        System.out.println(solve(ar));
//        System.out.println(solve(ar));
    }


    public static void print2D(boolean mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(i+" "+j +" " + mat[i][j] +" ");
    }

}
