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
        int k = Integer.parseInt(st.nextToken());
        int[] sumArray = new int[n+2];
        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sumArray[start]++;
            sumArray[end+1]--;
        }
        for(int i=1; i<=n; i++){
            sumArray[i] += sumArray[i-1];
        }



//        System.out.println(Arrays.toString(sumArray));
//        System.out.println(Arrays.toString(resultArray));
        Arrays.sort(sumArray);
        System.out.println(sumArray[(n+1)/2+1]);












    }
}
