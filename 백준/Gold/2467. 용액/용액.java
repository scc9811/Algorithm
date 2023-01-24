import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int le = 0;
        int ri = n-1;
        int minRes = Math.abs(arr[0]+arr[n-1]);
        int minN1 = arr[0];
        int minN2 = arr[n-1];
        while(le<ri){
            int mix = arr[le] + arr[ri];
            if(Math.abs(mix)<minRes){
                minRes = Math.abs(mix);
                minN1 = arr[le];
                minN2 = arr[ri];
            }
            if(mix==0) break;
            if(mix>0) ri--;
            else le++;
        }
        System.out.printf("%d %d\n",minN1,minN2);



    }
}