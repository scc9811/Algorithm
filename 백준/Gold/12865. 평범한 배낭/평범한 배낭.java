import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int objectCount = Integer.parseInt(st.nextToken());
        int fullWeight = Integer.parseInt(st.nextToken());
        // index 0은 쓰지 않음.
        int[] dp = new int[fullWeight+1];
        for (int i=0; i<objectCount; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st2.nextToken());
            int value = Integer.parseInt(st2.nextToken());
            if (weight <=fullWeight){
                for (int j=fullWeight; j>=weight; j--){
                    dp[j] = Math.max(dp[j],dp[j-weight]+value);
                }
            }
        }
        System.out.println(dp[fullWeight]);

    }
}
