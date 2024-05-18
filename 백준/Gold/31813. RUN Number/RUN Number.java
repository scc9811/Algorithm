import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            int resCount = 0;
            StringBuilder resTmpSb = new StringBuilder();
            while(k > 0) {
                int len = String.valueOf(k).length();
                boolean breakFlag = false;
                for(int i=9; i>=1; i--) {
                    StringBuilder tmpSb = new StringBuilder();
                    for(int j=0; j<len; j++){
                        tmpSb.append(i);
                    }
                    long base = Long.parseLong(tmpSb.toString());
                    if(k >= base) {
                        k -= base;
                        resTmpSb.append(base).append(' ');
                        breakFlag = true;
                        resCount++;
                        break;
                    }
                }
                if(!breakFlag) {
                    StringBuilder tmpSb = new StringBuilder();
                    for(int j=0; j<len-1; j++) {
                        tmpSb.append(9);
                    }
                    long base = Long.parseLong(tmpSb.toString());
                    k -= base;
                    resTmpSb.append(base).append(' ');
                    resCount++;
                }


            }
            sb.append(resCount).append('\n');
            sb.append(resTmpSb).append('\n');

        }
        System.out.println(sb);









    }
}