import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][n];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean tf = true;
        int current = -1;
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=0; j<3; j++){
                min = Math.min(min, arr[j][i]);
                max = Math.max(max, arr[j][i]);
            }
            if(current+1>max){
                tf = false;
                break;
            }
            else{
                if(current+1<min){
                    current = min;
                }
                else{
                    current++;
                }
            }
        }
        if(tf) System.out.println("YES");
        else System.out.println("NO");






    }
}