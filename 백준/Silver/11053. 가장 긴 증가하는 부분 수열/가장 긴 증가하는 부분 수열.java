import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = array[0];
        int count =1;
        for (int i=1; i<N; i++) {
            // 다음으로 오는 수가  최대값보다 큰 경우
            if (dp[count] < array[i]){
                dp[++count] = array[i];
            }
            // 최댓값보다 작은 경우 >> 배열이 정렬되어있으므로 맞는위치에 삽입.
            else if (dp[count] > array[i]){
                for (int j=1; j<=count; j++){
                    if(dp[j] >= array[i]){
                        dp[j] = array[i];
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(count);



    }
}
