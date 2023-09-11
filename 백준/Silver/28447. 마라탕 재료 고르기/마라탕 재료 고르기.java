import java.io.*;
import java.util.*;

public class Main{
    static int n, k, arr[][], visited[] , max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new int[k];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = - (int) 1e9;
        back(0, 0);
        System.out.println(max);







    }
    static void back(int depth, int idx){
        if(depth == k){
            int sum = 0;
            for(int i=0; i<k; i++){
                for(int j=i+1; j<k; j++){
                    sum += arr[visited[i]][visited[j]];
                }
            }
            max = Math.max(max, sum);
            return;
        }
        if(idx == n) return;

        back(depth, idx+1);
        visited[depth] = idx;
        back(depth+1, idx+1);

    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}