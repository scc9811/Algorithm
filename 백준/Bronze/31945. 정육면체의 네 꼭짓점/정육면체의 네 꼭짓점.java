import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        Set<String> set = new LinkedHashSet<>();
        set.add("0123");
        set.add("4567");
        set.add("0145");
        set.add("2367");
        set.add("0246");
        set.add("1357");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();

        while(testCase-- > 0) {
            char[] arr = br.readLine().replace(" ", "").toCharArray();
            Arrays.sort(arr);
            if(set.contains(new String(arr))) {
                res.append("YES");
            }
            else res.append("NO");
            res.append('\n');
        }
        System.out.println(res);






    }
}