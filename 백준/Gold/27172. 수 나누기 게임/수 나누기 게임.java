import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] index = new int[1000001];
        int[] count = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            index[arr[i]] = i;
        }

        for(int i=1; i<=n; i++){
            int cur = arr[i]+arr[i];
            while(cur<=1000000){
                if(index[cur]!=0) {
                    count[i]++;
                    count[index[cur]]--;
                }
                cur += arr[i];
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(count[i]).append(' ');
        }
        System.out.println(sb);











    }
}