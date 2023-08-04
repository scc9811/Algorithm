import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }


        // 0 ~ n-2
        long[] cost1 = new long[n];
        cost1[n-2] = arr[n-1] + (long) k *(n-1);
        for(int i=n-3; i>=0; i--){
            cost1[i] = Math.min(cost1[i+1], arr[i+1]+ (long) k *(i+1));
        }



        long res = (int)-1e11;
        for(int i=0; i<=n-2; i++){
            res = Math.max(res, arr[i]-cost1[i]+ (long) i *k);
        }



        // 1 ~ n-1
        long[] cost2 = new long[n];
        cost2[1] = arr[0]+(long)k*(n-1);
        for(int i=2; i<n; i++){
            cost2[i] = Math.min(cost2[i-1], arr[i-1]+(long) k*(n-i));
        }


        for(int i=n-1; i>=1; i--){
            res = Math.max(res, arr[i]-cost2[i] +(long) k*(n-1-i));
        }
        System.out.println(res);




    }
}
