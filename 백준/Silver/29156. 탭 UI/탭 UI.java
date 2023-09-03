import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lengths = new int[n+1];

        // right
        long[] sum = new long[n+1];
        for(int i=1; i<=n; i++){
            lengths[i] = Integer.parseInt(br.readLine());
            sum[i] = lengths[i] + sum[i-1];
        }

        // base :  center <-> edge length

        int total = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        double cur = 0.0;
        StringBuilder sb = new StringBuilder();
        if(total > sum[n]){
            for(int i=0; i<q; i++){
                sb.append("0.00").append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        for(int i=0; i<q; i++){
            int num = Integer.parseInt(br.readLine());
            cur = sum[num] - (double)lengths[num]/2 - (double)total/2;
            if(cur<0) cur = 0;
            if(cur>sum[n]-total) cur = sum[n]-total;
//            cur = Math.floor(cur*100)/100.0;
//            sb.append(cur).append('\n');

            sb.append(new DecimalFormat("0.00").format(cur)).append('\n');

        }
        System.out.println(sb);



















    }
}