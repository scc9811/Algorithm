import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count=0;
        int length = s.length();
        for(int i=0; i<length; i++){
            if(count==0 && s.charAt(i)!=' ') count++;
            if(s.charAt(i)==' ' && i!=0 && i!=length-1){
                count++;
            }
        }
        System.out.println(count);











    }
}