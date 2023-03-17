import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] weights = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(weights[i], (int)1e9);
        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            weights[from][to] = Math.min(weights[from][to], weight);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    weights[j][k] = Math.min(weights[j][k], weights[j][i] + weights[i][k]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            weights[i][i] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(weights[i][j]==1e9) sb.append(0);
                else sb.append(weights[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);







    }
}