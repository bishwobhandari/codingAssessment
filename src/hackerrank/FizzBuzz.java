package hackerrank;

//Given a number n, for each integer i in the rage from 1 to n inclusive, print one value per line as
//if i is multiple of both 3 and 5 print fizzbuzz
//if 3  but not 5, print FIzz
// if 5 but not 3 print buzz
//if i not 3 or 5 print value

public class FizzBuzz {

    public static void main(String[] args) {
        int n = 20;

        for(int i=1; i<=n ; i++){
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz"+i);
            }
            else if(i%3==0){
                System.out.println("Fizz");
            }
            else if(i%5==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }
}
