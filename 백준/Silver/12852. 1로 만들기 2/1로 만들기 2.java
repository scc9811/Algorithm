import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[3*n+1];
        Arrays.fill(dp, (int)1e9);
        int[] par = new int[3*n+1];
        dp[n] = 0;
        if(n%2==0) {
            dp[n/2] = 1;
            par[n/2] = n;
        }
        if(n%3==0) {
            dp[n/3] = 1;
            par[n/3] = n;
        }
        dp[n-1] = 1;
        par[n-1] = n;

        for(int i=n-2; i>=0; i--){
            if(dp[i]!=1e9) continue;
            dp[i] = Math.min(dp[i*2], Math.min(dp[i*3], dp[i+1]))+1;
            if(dp[i]==dp[i*2]+1) par[i] = i*2;
            else if(dp[i]==dp[i*3]+1) par[i] = i*3;
            else if(dp[i]==dp[i+1]+1) par[i] = i+1;
        }
        System.out.println(dp[1]);

        Stack<Integer> stack = new Stack<>();
        for(int i=1; i!=n; i=par[i]){
            stack.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(' ');
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);




    }
}