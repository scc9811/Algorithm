import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));


        double sum = 0.0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        if(n==1) System.out.println(arr[0]);
        else {
            double res = Math.max(arr[n - 2], sum / n);
            System.out.println(res);
        }





    }
}