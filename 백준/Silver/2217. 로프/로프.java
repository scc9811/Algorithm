import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i=0; i<N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int count = N;
        int max =array[0]*count;
        count--;
        for (int i=1; i<N; i++){
            max = Math.max(max, array[i]*count);
            count--;
        }
        System.out.println(max);





    }
}
