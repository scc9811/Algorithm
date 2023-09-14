import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int maxPrice = 0;
        int maxMargin = 0;
        for(int i=0; i<m; i++){
            int margin = Math.min(n, m-i) * arr[i];
            if(maxMargin < margin){
                maxMargin = margin;
                maxPrice = arr[i];
            }
        }

        System.out.printf("%d %d\n", maxPrice, maxMargin);






    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}