import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] ab = new int[n];
        int[] bc = new int[n];
        int[] ac = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ab[i] = a+b;
            bc[i] = b+c;
            ac[i] = a+c;
        }

        Arrays.sort(ab);
        Arrays.sort(bc);
        Arrays.sort(ac);


        long a = 0;
        long b = 0;
        long c = 0;
        for(int i=n-1; i>=n-k; i--){
            a += ab[i];
            b += bc[i];
            c += ac[i];
        }
        System.out.println(Math.max(a,Math.max(b,c)));


    }
}