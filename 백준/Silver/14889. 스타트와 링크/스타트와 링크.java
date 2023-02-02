import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{
    static int n, arr[][], min;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = (int)1e9;
        visited = new boolean[n];
        back(0,0);
        System.out.println(min);



    }
    public static void back(int depth, int startI){
        if(depth==n/2){
            int sumA = 0;
            int sumB = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visited[i]&&visited[j]){
                        sumA += arr[i][j];
                    }
                    else if(!visited[i]&&!visited[j]){
                        sumB += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(sumA-sumB));
            return;
        }

        for(int i=startI; i<n; i++){
            visited[i] = true;
            back(depth+1, i+1);
            visited[i] = false;
        }




    }
}