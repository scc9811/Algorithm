import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());


        long start = 1;
        while(b>0){
            if(b%2==1){
                start *= a;
                start %= c;
            }
            a *= a;
            a %= c;
            b /= 2;
//            System.out.println("start = "+start);
//            System.out.println("a = "+a);
//            System.out.println("b = "+b);
        }
        System.out.println(start);






    }
}