import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>i; j--){
                if(arr[i] + arr[j] <= k && !visited[j] && !visited[i]){
                    count++;
                    visited[j] = true;
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(count);




    }
}