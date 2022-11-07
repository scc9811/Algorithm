import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger bigInteger = new BigInteger("1");
        for(int i=n; i>n-m; i--){
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }



        for(int i=1; i<=m; i++){
            bigInteger = bigInteger.divide(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInteger);



    }
}