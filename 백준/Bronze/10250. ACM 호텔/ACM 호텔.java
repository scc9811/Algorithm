import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(n%h==0) {
                sb.append(h);
            }
            else sb.append(n%h);
            if(n%h==0){
                if(n/h<10) sb.append(0);
                sb.append(n/h);
            }
            else{
                if((n/h+1)<10) sb.append(0);
                sb.append(n/h+1);
            }
            sb.append('\n');


        }
        System.out.println(sb);





    }
}