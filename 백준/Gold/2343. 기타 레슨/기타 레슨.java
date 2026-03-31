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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = (int) 1e9;
        int min = r;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2; // size
            int count = 0;
            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    count = (int)1e5 + 1;
                    break;
                }
                if (currentSum + arr[i] > mid) {
                    count++;
                    currentSum = arr[i];
                }
                else {
                    currentSum += arr[i];
                }
            }
            if (count < m) {
                min = Math.min(min, mid);
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(min);


    }
}
