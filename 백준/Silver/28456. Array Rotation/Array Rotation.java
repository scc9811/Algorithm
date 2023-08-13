import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag==1){
                int j = Integer.parseInt(st.nextToken());
                int tmp = arr[j-1][n-1];
                for(int k=n-1; k>0; k--){
                    arr[j-1][k] = arr[j-1][k-1];
                }
                arr[j-1][0] = tmp;

            }
            else{
                int[][] A = new int[n][n];
                for(int j=0; j<n; j++){
                    for(int k=0; k<n; k++){
                        A[k][n-j-1] = arr[j][k];
                    }
                }
                arr = A;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);






    }
}
