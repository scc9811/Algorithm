import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] dp = new int[n+1];
        for (int i=2; i<dp.length; i++){
            if(i%6==0){
                dp[i] = Math.min(dp[i/2],dp[i/3])+1;
            }
            else if(i%3==0){
                dp[i] = Math.min(dp[i/3],dp[i-1])+1;
            }
            else if(i%2==0){
                dp[i] = Math.min(dp[i/2],dp[i-1])+1;
            }
            else dp[i]=dp[i-1]+1;

        }
        System.out.println(dp[n]);
    }
}
