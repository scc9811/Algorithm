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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = m*9;
        int base;
        if(tmp%10==0){
            base = tmp/10;
        }
        else{
            base = tmp/10 + 1;
        }


        // value count. ( m length )
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }


        int left = 0;
        int right = m;
        for(int i : map.values()){
            if(i>=base) {
                System.out.println("YES");
                System.exit(0);
            }
        }

        while(true){
            if(right==n) break;
            map.put(arr[left], map.get(arr[left])-1);
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
            if(map.get(arr[right])>=base) {
                System.out.println("YES");
                System.exit(0);
            }
            left++;
            right++;
        }
        System.out.println("NO");














    }
}
