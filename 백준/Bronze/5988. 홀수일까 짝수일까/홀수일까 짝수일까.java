import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            String s = br.readLine();
            if((s.charAt(s.length()-1)-'0')%2==0) sb.append("even");
            else sb.append("odd");


            sb.append('\n');
        }
        System.out.println(sb);



    }
}