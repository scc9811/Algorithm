import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int score = s.length()+2;
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i)=='_') score += 5;
        }
        System.out.println(score);



    }
}
