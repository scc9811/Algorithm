import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int evenCount = 0;
        int oddCount = 0;
        String s = br.readLine();
        for(int i=0; i<n; i++) {
            if((s.charAt(i)-'0') % 2 == 0) evenCount++;
            else oddCount++;
        }
        int res;
        if(evenCount > oddCount) res = 0;
        else if(evenCount < oddCount) res = 1;
        else res = -1;
        System.out.println(res);



    }
}
