import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<m+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                arr[i][j] += arr[i][j-1];
            }
        }


        for(int j=1; j<m+1; j++) {
            for (int i = 1; i < n + 1; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
        

        int result = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                for(int k=i; k<n+1; k++){
                    for(int l=j; l<m+1; l++){
                        result = Math.max(result, sum(i,j,k,l));
                    }
                }
            }
        }
        System.out.println(result);









    }
    public static int sum(int x1, int y1, int x2, int y2){
        x1--;
        y1--;
        return (arr[x2][y2] - arr[x1][y2] - arr[x2][y1] + arr[x1][y1]);
    }
}