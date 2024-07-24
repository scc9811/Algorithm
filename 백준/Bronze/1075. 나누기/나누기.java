import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        n = n / 100 * 100;
        for(int i=0; i<100; i++) {
            int cur = n + i;
            if(cur%f == 0) {
                System.out.printf("%02d", i);
                System.exit(0);
            }
        }





    }
}
