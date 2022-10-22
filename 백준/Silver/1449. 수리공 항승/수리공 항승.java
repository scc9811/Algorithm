import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];


        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            array[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(array);
        int start;
        int end=0;
        int count=0;
        for (int i=0; i<N; i++){
            if(array[i] <= end) continue;
            else {
                end = array[i]+M-1;
                count++;
            }


        }
        System.out.println(count);






    }
}
