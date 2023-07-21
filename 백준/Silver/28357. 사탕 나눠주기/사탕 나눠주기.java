import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static long k,  arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long left = 0;
        long right = (long)1e12;

        long res = (long)1e13;
        while(left <= right){
            long mid = (left + right)/2;
            if (bin(mid)) {
                res = Math.min(res, mid);
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(res);






    }
    static boolean bin(long x){
        long sum = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > x){
                sum += arr[i] - x;
            }
        }
        if(sum <= k) return true;
        return false;
    }
}