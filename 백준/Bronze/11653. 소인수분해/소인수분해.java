import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            if(n%i==0){
                while(n%i==0){
                    sb.append(i).append('\n');
                    n /= i;
                }
            }
            if(n==1) break;
        }
        System.out.println(sb);

















    }
}