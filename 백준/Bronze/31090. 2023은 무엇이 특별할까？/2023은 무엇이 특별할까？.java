import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append((n+1)%(n%100)==0 ? "Good" : "Bye").append('\n');
        }
        System.out.println(sb);


    }
}