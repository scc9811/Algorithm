import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=2; i<n; i++) {
            sum = (sum+(n/i)*i-i)%1000000;
        }
        System.out.println(sum);


    }
}