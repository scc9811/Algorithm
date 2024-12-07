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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // ->
        long max = (long)arr[0] * k;
        long sum = arr[0];
        for(int i=1; i<n; i++) {
            if(i == k) break;
            max = Math.max(max, sum + (long)arr[i]*(k-i));
            sum += arr[i];
        }


        // <-
        long max2 = (long)arr[n-1] * k;
        long sum2 = arr[n-1];
        for(int i=1; i<n; i++) {
            if(i == k) break;
            max2 = Math.max(max2, sum2 + (long)arr[n-i-1]*(k-i));
            sum2 += arr[n-i-1];
        }
        System.out.println(Math.max(max, max2));





    }
}