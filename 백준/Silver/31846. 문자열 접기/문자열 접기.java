import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            int maxCount = 0;
            for(int len=1; len<=r-l; len++) {
                String a = s.substring(l, l+len);
                String b = s.substring(l+len, r+1);
                int count = 0;
                for(int j=0; j<Math.min(a.length(), b.length()); j++) {
                    if(a.charAt(a.length()-1-j) == b.charAt(j)) count++;
                }
                maxCount = Math.max(maxCount, count);
            }
            System.out.println(maxCount);
        }















    }
}