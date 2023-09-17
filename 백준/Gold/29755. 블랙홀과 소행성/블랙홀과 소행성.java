import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bj = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            bj[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bj);

        long res = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int aj = Integer.parseInt(st.nextToken());
            int wj = Integer.parseInt(st.nextToken());
            int min = (int)1e9;
            int l = 0;
            int r = n-1;
            int mid = (l+r)/2;
            while(l<=r){
                mid = (l+r)/2;
                if(bj[mid] - aj < 0){
                    min = Math.min(min, Math.abs(bj[mid] - aj));
                    l = mid + 1;
                }
                else{
                    min = Math.min(min, Math.abs(bj[mid] - aj));
                    r = mid - 1;
                }
            }
//            System.out.println(min);
            res = Math.max(res, (long)min*wj);
        }
        System.out.println(res);

















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}