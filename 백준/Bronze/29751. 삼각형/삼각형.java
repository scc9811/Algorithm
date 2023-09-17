import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        double res = (double)w * h / 2;
        System.out.printf("%.1f%n", res);

















    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}