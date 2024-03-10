import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long[] sum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        sum[0] = arr[0];
        for(int i=1; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

//        System.out.println(Arrays.toString(sum));
        long frontIdx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag==1){
                int k = Integer.parseInt(st.nextToken());
                frontIdx -= k;
            }
            else if(flag==2){
                int k = Integer.parseInt(st.nextToken());
                frontIdx += k;
            }
            else{
                frontIdx %= n;
                if(frontIdx<0){
                    frontIdx += n;
                }
                long a = (Integer.parseInt(st.nextToken())-1 + frontIdx)%n;
                long b = (Integer.parseInt(st.nextToken())-1 + frontIdx)%n;
//                System.out.printf("(%d, %d)\n", a, b);
                if(b < a){
                    sb.append(sum[n-1]-sum[(int)a]+arr[(int)a] + sum[(int)b]).append('\n');
                }
                else sb.append(sum[(int)b]-sum[(int)a] + arr[(int)a]).append('\n');
            }
        }
        System.out.println(sb);













    }
}