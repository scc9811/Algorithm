import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        int sum = 0;
        while(endIndex<n){
            if(sum<=m){
                result = Math.max(result, sum);
                sum += arr[endIndex++];
            }
            else{
                sum -= arr[startIndex++];
            }
//            System.out.println("startI = "+startIndex);
//            System.out.println("endI = "+endIndex);
//            System.out.println("sum = "+sum);
        }
        if(sum <= m) result = Math.max(result, sum);
        System.out.println(result);

    }
}