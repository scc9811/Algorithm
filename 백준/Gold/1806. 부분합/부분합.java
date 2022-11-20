import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int startI = 0;
        int endI = 0;
        int sum = 0;

        int length = (int)1e9;

        while(endI<n){
            if(startI==endI){
                sum += arr[endI++];
                continue;
            }
            if(sum<=s){
                if(sum==s) length = Math.min(length, endI-startI);
                sum += arr[endI++];
            }
            else{
                length = Math.min(length, endI-startI);
                sum -= arr[startI++];
            }
        }
        if(sum>=s){
            while(sum>=s && startI<n){
                length = Math.min(length, n-startI);
                sum -= arr[startI++];
            }
        }
        if(length==(int)1e9) System.out.println(0);
        else System.out.println(length);





    }
}