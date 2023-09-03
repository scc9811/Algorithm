import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x1 = 0;
        long y1 = 0;
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 += Integer.parseInt(st.nextToken());
            y1 += Integer.parseInt(st.nextToken());
        }

        long x2 = 0;
        long y2 = 0;
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x2 += Integer.parseInt(st.nextToken());
            y2 += Integer.parseInt(st.nextToken());
        }

        x1 /= 2;
        x2 /= 2;
        y1 /= 2;
        y2 /= 2;



        long res1A = y2-y1;
        long res1B = x2-x1;

        long res2A = x1*(y1-y2) +y1*(x2-x1);
        long res2B = (x2-x1)*2;

        StringBuilder res = new StringBuilder();
        if((res1A<0 && res1B>0) || (res1A>0 && res1B<0)){
            res.append('-');
        }
        res1A = Math.abs(res1A);
        res1B = Math.abs(res1B);



        if(res1A%res1B == 0){
            res.append(res1A/res1B).append(' ');
        }
        else {
            while(gcd(res1A, res1B)!=1){
                long gcd = gcd(res1A, res1B);
                res1A /= gcd;
                res1B /= gcd;
            }
            res.append(res1A).append('/').append(res1B).append(' ');
        }



        if((res2A<0 && res2B>0) || (res2A>0 && res2B<0)){
            res.append('-');
        }
        res2A = Math.abs(res2A);
        res2B = Math.abs(res2B);


        if(res2A%res2B == 0){
            res.append(res2A/res2B);
        }
        else {
            while(gcd(res2A, res2B)!=1){
                long gcd = gcd(res2A, res2B);
                res2A /= gcd;
                res2B /= gcd;
            }
            res.append(res2A).append('/').append(res2B);
        }



        System.out.println(res);



















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}