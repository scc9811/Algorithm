import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("? "+1);
        System.out.flush();
        int left = Integer.parseInt(br.readLine());
        System.out.println("? "+n);
        System.out.flush();
        int right = Integer.parseInt(br.readLine());
        
        if(left==1 && right==0){
            System.out.println("! -1");
            System.out.flush();
        }
        else if(left==0 && right==1){
            System.out.println("! 1");
            System.out.flush();
        }
        else{
            System.out.println("! 0");
            System.out.flush();
        }
        

















    }
}