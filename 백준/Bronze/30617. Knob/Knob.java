import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b  =Integer.parseInt(st.nextToken());
        int res = 0;
        if(a == b && a!=0) res++;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int tmpA = Integer.parseInt(st.nextToken());
            int tmpB = Integer.parseInt(st.nextToken());
            if(tmpA == a && tmpA!=0) res++;
            if(tmpB == b && tmpB!=0) res++;
            if(tmpA == tmpB && tmpA!=0) res++;
            a = tmpA;
            b = tmpB;

        }
        System.out.println(res);

















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}