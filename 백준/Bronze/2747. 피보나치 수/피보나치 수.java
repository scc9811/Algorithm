import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        System.out.println(memo[n]);


    }
}