import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp = n+1;
        double sum = 0.0;
        while(tmp-->1){
            sum += (double)n/tmp;
        }
        System.out.println(sum);




    }
}
