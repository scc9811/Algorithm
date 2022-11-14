import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=testCase; i++){
            String s = br.readLine();
            StringBuilder tmp = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='Z') tmp.append('A');
                else tmp.append((char)(s.charAt(j)+1));
            }
            sb.append("String #").append(i).append('\n').append(tmp).append("\n\n");
        }
        System.out.println(sb);







    }
}
