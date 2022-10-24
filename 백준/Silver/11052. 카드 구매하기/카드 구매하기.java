import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());
        int[] array = new int[cardCount+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<cardCount+1; i++) {
            int n = Integer.parseInt(st.nextToken());
            int max = n;
            for (int j = i-1; j>=i/2; j--){
                if (array[j]+array[i-j] > max) max = array[j]+array[i-j];
            }
            array[i] = max;
        }
        System.out.println(array[cardCount]);
    }
}
