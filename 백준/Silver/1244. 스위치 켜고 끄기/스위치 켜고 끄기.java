import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(flag==1){
                for(int j=k; j<=n; j+=k){
                    arr[j] = (arr[j]+1)%2;
                }
            }
            else{
                int left = k-1;
                int right = k+1;
                arr[k] = (arr[k]+1)%2;
                while(left>0 && right<=n && arr[left]==arr[right]){
                    arr[left] = (arr[left]+1)%2;
                    arr[right] = (arr[right]+1)%2;
                    left--;
                    right++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(arr[i]).append(' ');
            if(i%20==0) sb.append('\n');
        }
        System.out.println(sb);










    }
   
}


