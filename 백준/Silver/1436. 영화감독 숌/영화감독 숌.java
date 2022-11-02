import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int resultCount = 0;
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            String s = String.valueOf(i);
            if (s.contains("666")) resultCount++;
            if (resultCount == n) {
                System.out.println(i);
                break;
            }
        }


    }
}