import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=1; j<=10; j++) {
                if (i * a + j * b == c) {
                    list.add(j);
                }
            }
            if (list.size() == 0) {
                sb.append(0);
            }
            else {
                for(int res : list) {
                    sb.append(res).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);









    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }
}