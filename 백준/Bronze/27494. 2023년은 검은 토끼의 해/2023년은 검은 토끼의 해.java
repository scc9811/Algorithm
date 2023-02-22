import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=0;
        for(int k = 2023; k<=n; k++) {
            String s = String.valueOf(k);
            boolean tf1 = false;
            boolean tf2 = false;
            boolean tf3 = false;
            boolean tf4 = false;
            for (int i = 0; i < s.length(); i++) {
                if (!tf1) {
                    if (s.charAt(i) - '0' == 2) {
                        tf1 = true;
                    }
                } else if (!tf2) {
                    if (s.charAt(i) - '0' == 0) {
                        tf2 = true;
                    }
                } else if (!tf3) {
                    if (s.charAt(i) - '0' == 2) {
                        tf3 = true;
                    }
                } else if (!tf4) {
                    if (s.charAt(i) - '0' == 3) {
                        tf4 = true;
                    }
                }
            }
            if(tf1 && tf2 && tf3 && tf4) count++;
        }
        System.out.println(count);





    }
}
