import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long l = 0;
        long r = 2000000000;
        long mid;
        long maxHeight = 0;
        while(l <= r) {
            mid = (l + r) / 2;
            long sum = 0;
            for(int i=0; i<n; i++) {
                if(arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if(sum >= m) {
                maxHeight = Math.max(maxHeight, mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(maxHeight);






    }
}