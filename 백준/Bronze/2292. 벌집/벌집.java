import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = 1;
        int step = 0;
        int count = 1;
        while (k < n) {
            step += 6;
            k += step;
            count++;
        }
        System.out.println(count);


    }
}