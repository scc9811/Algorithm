import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] damages;
    static Point[] points;
    static long totalDamage, maxC, curD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        damages = new long[n];
        for(int i=0; i<n; i++){
            damages[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(damages);
        points = new Point[k];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        long res = 0;
        for(int i=n-1; i>=n-m; i--){
            totalDamage = damages[i]*900;
            curD = damages[i];
            maxC = -1;
            back(0, 0, 0, 0);
            res += maxC;
//            System.out.println("totalD = "+totalDamage);
//            System.out.println("maxC = "+maxC);
        }
        System.out.println(res);

















    }
    static void back(int depth, long damage, long coins, int idx){
        if(idx == k){
            maxC = Math.max(maxC, coins);
            return;
        }
        if(points[idx].p + damage <= totalDamage){
            if((points[idx].p + damage)%curD==0) back(depth+1, points[idx].p+damage, coins + points[idx].q, idx+1);
            else back(depth+1, points[idx].p+damage + curD - (points[idx].p + damage)%curD, coins + points[idx].q, idx+1);
        }
        back(depth, damage, coins, idx+1);
    }
    static class Point{
        long p, q;
        Point(long p, long q){
            this.p = p;
            this.q = q;
        }
    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}