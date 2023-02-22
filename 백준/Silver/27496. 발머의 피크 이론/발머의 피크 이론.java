import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        arr[0] = Integer.parseInt(st.nextToken());
        if(arr[0]>=129 && arr[0]<=138) count++;
        for(int i=1; i<n; i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());

            if(i-l>=0) {
                int v = arr[i] - arr[i - l];
                if (v >= 129 && v <= 138) count++;
            }
            else{
                if(arr[i]>=129 && arr[i]<=138) count++;
            }
        }


        System.out.println(count);



    }
}
