import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] start = new int[n][n];
        for(int i=0; i<n; i++){
            start[i][i] = 1;
        }

        while(b>0){
            if(b%2==1){
                start = mul(start, arr);
            }

            arr = mul(arr, arr);
            b /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j : start[i]){
                sb.append(j).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);








//        int[][] temp = mul(arr, arr);
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(temp[i]));
//        }





    }
    public static int[][] mul(int[][] arr1, int[][] arr2){
        int[][] ret = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    ret[i][j] += arr1[i][k]*arr2[k][j];
                }
                ret[i][j] %= 1000;
            }
        }

        return ret;
    }
}
