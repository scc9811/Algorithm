import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double res;
        if(n > 30){
            res = 15.0 + (double)(n-30)*3/2;
        }
        else{
            res = (double) n/2;
        }
        System.out.printf("%.1f\n", res);










    }
}