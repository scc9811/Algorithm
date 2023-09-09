import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int res1 = 1;
        int last = arr1[0];
        for(int i=1; i<n; i++){
            if(last + 100 <= arr1[i]) {
                res1++;
                last = arr1[i];
            }
        }
        int res2 = 1;
        last = arr2[0];
        for(int i=1; i<m; i++){
            if(last + 360 <= arr2[i]) {
                res2++;
                last = arr2[i];
            }
        }

        System.out.printf("%d %d\n", res1, res2);











    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}