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
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        int[][] table = new int[n][n];
//        for(int i=0; i<n; i++){
//            int len = arr[i];
//            for(int j=i+1; j<n; j++){
//                len += arr[j];
//                table[i][j] = len*len + (int)Math.pow(Math.abs(arr[i]-arr[j]),2);
//                table[j][i] = table[i][j];
//            }
//        }
//
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(table[i]));
//        }
        int res = 0;
        for(int i=0; i<n-1; i++){
            int len = arr[i]+arr[i+1];
            res += len*len + (int)Math.pow(Math.abs(arr[i]-arr[i+1]),2);
        }
        System.out.println(res);


    }
}