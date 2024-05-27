import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int count = 0;
            while(a != b && count < 10000) {
                count++;
                a += p;
                b += q;
            }
            if(a == b) {
                sb.append(count).append(' ');
            }
            else {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        System.out.println(sb);








    }
}