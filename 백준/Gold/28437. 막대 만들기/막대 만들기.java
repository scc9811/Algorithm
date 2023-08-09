import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[100001];
        dp = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            arr[k]++;
        }

        visited = new boolean[100001];
        visited[1] = true;
        visited[2] = true;
        if(arr[1]==1){
            Arrays.fill(dp, 1);
        }
        dp[2] += arr[2];
        for(int i=3; i<=100000; i++){
            dp[i] += arr[i];
        }



        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<q; i++){
            int cur = Integer.parseInt(st.nextToken());
            sb.append(f(cur)).append(' ');
//            System.out.println("q = "+cur);
//            for(int j=1; j<=10; j++){
//                System.out.printf("%d ",dp[j]);
//            }
//            System.out.println();
        }
        System.out.println(sb);






    }
    static int[] dp, arr;
    static boolean[] visited;
    static int f(int k){
        if(visited[k]) return dp[k];
        visited[k] = true;
        int sum = 0;
        for(int i=2; i<=Math.sqrt(k); i++){
            if(k%i==0){
                dp[i] = f(i);
                dp[k/i] = f(k/i);
                if(i==Math.sqrt(k)) sum += dp[i];
                else sum += dp[i] + dp[k/i];
            }
        }
        return dp[k] = sum + dp[k];
    }
}
