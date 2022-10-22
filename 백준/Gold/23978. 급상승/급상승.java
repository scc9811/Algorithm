import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static long k;
    static long[] days;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        days = new long[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            days[i] = Long.parseLong(st.nextToken());
        }

        long min_x = k;

        long lo = 1;
        long hi = (long) Math.pow(10,9)*2;
        long mid;

        while(lo <= hi){
            mid = (lo + hi)/2;
            long tmp = total(mid);
//            System.out.println(mid);
//            System.out.println(tmp);
            if(tmp==k){
                min_x = mid;
                break;
            }
            else if(tmp>k){
                min_x = Math.min(min_x, mid);
                hi = mid -1;
            }
            else{
                lo = mid +1;
            }
        }
        System.out.println(min_x);















    }
    public static long total(long x){
        long total = 0;
        for(int i=0; i<n-1; i++){
            long step = days[i+1]-days[i];
            if(step>=x){
                total += sum(x);
            }

            else {
                total += sum(x,step);
            }

            if(total > k || total<0) return k+1;
        }

        total += sum(x);
        if(total > k || total<0) return k+1;
        else return total;
    }


    public static long sum(long x){
        return x*(x+1)/2;
    }

    public static long sum(long x, long n){
        return n*(2*x-n+1)/2;
    }
}
