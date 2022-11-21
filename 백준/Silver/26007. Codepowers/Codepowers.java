import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
//        arr[0] = x;
        for(int i=1; i<=n; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        k -= x;

        int[] countArr = new int[n+1];
        for(int i=1; i<=n; i++){
            if(arr[i]<k) countArr[i] = countArr[i-1]+1;
            else countArr[i] = countArr[i-1];
        }
//        System.out.println(Arrays.toString(countArr));
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(countArr[r-1] - countArr[l-1]).append('\n');
//            int count = 0;
//            for(int i=l; i<r; i++){
//                if(arr[i] < k) count++;
//            }
//            sb.append(count).append('\n');

        }
        System.out.println(sb);





    }
}
