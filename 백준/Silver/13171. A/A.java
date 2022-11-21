import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long x = Long.parseLong(br.readLine());
        long tmp = 1000000007;
        long ret = 1;

        a %= tmp;
        while(x>0){
            if(x%2==1){
                ret = (ret*a) % tmp;
            }
            a = (a*a) % tmp;
            x/=2;
        }

        System.out.println(ret);





    }
}