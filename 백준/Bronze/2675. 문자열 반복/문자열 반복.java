import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                for(int j=0; j<n; j++) {
                    sb.append(c);
                }
            }
            sb.append('\n');


        }
        System.out.println(sb);












    }
}