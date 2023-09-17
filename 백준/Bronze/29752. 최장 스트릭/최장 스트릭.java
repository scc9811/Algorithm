import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            if(Integer.parseInt(st.nextToken())!=0) count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);
        System.out.println(max);















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}