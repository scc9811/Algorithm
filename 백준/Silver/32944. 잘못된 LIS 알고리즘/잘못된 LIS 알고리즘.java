import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if ((m == n && m != k) || k > m) {
            System.out.println(-1);
            System.exit(0);
        }

        int l = 1;
        int r = n;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k-1; i++) {
            sb.append(l++).append(' ');
        }
        int requiredIncreaseCount = m - k;
        for(int i=0; i < n - l - requiredIncreaseCount; i++) {
            sb.append(r--).append(' ');
        }
        while(l <= r) {
            sb.append(l++).append(' ');
        }
        System.out.println(sb);











    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }
}