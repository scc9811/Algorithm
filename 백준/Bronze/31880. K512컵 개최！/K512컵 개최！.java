import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur == 0) continue;
            sum *= cur;
        }
        System.out.println(sum);






    }
}
