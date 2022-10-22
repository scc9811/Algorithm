import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        sb.reverse();
        String s = sb.toString();
        int n1 = Integer.parseInt(s.substring(0,3));
        int n2 = Integer.parseInt(s.substring(4,7));
        System.out.println(Math.max(n1,n2));





    }
}