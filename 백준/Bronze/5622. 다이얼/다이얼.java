import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)<68) sum+=3;
            else if(s.charAt(i)<71) sum+=4;
            else if(s.charAt(i)<74) sum+=5;
            else if(s.charAt(i)<77) sum+=6;
            else if(s.charAt(i)<80) sum+=7;
            else if(s.charAt(i)<84) sum+=8;
            else if(s.charAt(i)<87) sum+=9;
            else sum+=10;
        }

        System.out.println(sum);













    }
}