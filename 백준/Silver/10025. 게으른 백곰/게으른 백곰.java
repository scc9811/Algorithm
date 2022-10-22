import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[1000001];

        int maxIndex = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            array[x] = g;
            maxIndex = Math.max(maxIndex,x);
        }

        // 처음 sum 값.

        int sum=0;

        for(int i=0; i<=2*K; i++){
            try {
                sum += array[i];
            }
            catch(ArrayIndexOutOfBoundsException ignore){
                break;
            }
        }





        int maxValue = sum;

        for(int i=K+1; i<=maxIndex-K; i++){

            // i-K-1 에서 0보다 작아짐.
            // -array[i-K-1] , +array[i+K] 부분 나눠서 처리.

            try{
                sum -= array[i-K-1];
            }
            catch(ArrayIndexOutOfBoundsException ignore){}


            try{
                sum += array[i+K];
                maxValue = Math.max(maxValue,sum);
            }
            catch(ArrayIndexOutOfBoundsException ignore){
                break;
            }

//            try {
//                sum = sum - array[i - K - 1] + array[i + K];
//                maxValue = Math.max(maxValue, sum);
//            }
//
//            catch (ArrayIndexOutOfBoundsException ignore){
//                break;
//            }
        }
        System.out.println(maxValue);





    }
}