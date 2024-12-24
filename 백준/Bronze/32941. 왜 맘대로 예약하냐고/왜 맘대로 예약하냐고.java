import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        loop:
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == x) {
                    continue loop;
                }
            }
            System.out.println("NO");
            System.exit(0);
        }
        System.out.println("YES");









    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }
}