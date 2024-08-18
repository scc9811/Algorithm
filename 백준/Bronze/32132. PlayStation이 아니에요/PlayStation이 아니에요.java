import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i=0; i<s.length()-2; i++) {
            if(s.substring(i, i+3).equals("PS4") || s.substring(i, i+3).equals("PS5")) {
                s = s.substring(0, i+2) + s.substring(i+3, s.length());
                i--;
            }
        }
        System.out.println(s);



    }
}