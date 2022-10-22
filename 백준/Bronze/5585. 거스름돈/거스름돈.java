import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int charge = 1000 - Integer.parseInt(br.readLine());
        int count =0;
        count += charge/500; charge %= 500;
        count += charge/100; charge %= 100;
        count += charge/50; charge %= 50;
        count += charge/10; charge %= 10;
        count += charge/5; charge %= 5;
        count += charge;

        System.out.println(count);



    }
}
