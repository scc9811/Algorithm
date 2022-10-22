import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0){
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                array[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }
            int count =1;
            int min = array[0];
            for (int i=1; i<N; i++){
                if (min > array[i]){
                    count++;
                    min = array[i];
                }
            }
            System.out.println(count);

        }
    }
}
