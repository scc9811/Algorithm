import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] odd = new int[h+1];
        int[] even = new int[h+1];

        for(int i=0; i<n; i+=2){
            odd[Integer.parseInt(br.readLine())]++;
            even[Integer.parseInt(br.readLine())]++;
        }

        int[] sumOdd = new int[h+1];
        int[] sumEven = new int[h+1];
        for(int i=h-1; i>=1; i--){
            sumOdd[i] = sumOdd[i+1] + odd[i];
            sumEven[i] = sumEven[i+1] + even[i];
        }
//        System.out.println(Arrays.toString(odd));
//        System.out.println(Arrays.toString(even));
//        System.out.println(Arrays.toString(sumOdd));
//        System.out.println(Arrays.toString(sumEven));


        // result[i] == i개 부수는 경로의 개수
        int[] result = new int[n+1];

        for(int i=1; i<=h; i++){
           int k =sumOdd[i] + sumEven[h-i+1];
           result[k]++;
        }

        for(int i=0; i<=n; i++){
            if(result[i]!=0) {
                System.out.println(i+" "+result[i]);
                break;
            }
        }















    }
}
