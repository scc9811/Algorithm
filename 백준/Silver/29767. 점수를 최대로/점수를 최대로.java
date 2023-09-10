import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken());
        for(int i=1; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken()) + arr[i-1];
        }


        Arrays.sort(arr);
        long res = 0;
        for(int i=n-1; i>n-k-1; i--){
            res += arr[i];
        }
        System.out.println(res);













    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}