import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n *= n;
        if(n==1) System.out.println(0);
        else if(n%2==0) System.out.println(n/2);
        else System.out.println(n/2+1);







    }
}
