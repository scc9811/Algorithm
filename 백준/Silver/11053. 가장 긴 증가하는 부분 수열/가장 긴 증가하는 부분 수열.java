import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxLen = new int[n];
        maxLen[0] = 1;

        for(int i=1; i<n; i++) {
            int maxLength = 0;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) maxLength = Math.max(maxLength, maxLen[j]);
            }
            maxLen[i] = maxLength + 1;
        }

        int res = 0;
        for(int i=0; i<n; i++) {
            res = Math.max(res, maxLen[i]);
        }

        System.out.println(res);

















    }
}