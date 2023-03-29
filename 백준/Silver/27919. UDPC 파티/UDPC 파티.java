import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int uc = 0;
        int dp = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='U' || c=='C') uc++;
            else dp++;
        }

        StringBuilder res = new StringBuilder();
        if((uc-1)*2>=dp) res.append('U');
        if(dp!=0) res.append('D').append('P');
        System.out.println(res);
        




    }
}