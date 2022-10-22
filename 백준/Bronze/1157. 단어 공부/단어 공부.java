import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[26];
        String s = br.readLine();
        s = s.toUpperCase();

        for(int i=0; i<s.length(); i++){
            array[s.charAt(i)-65]++;
        }

        int max=0;
        int max_count=0;
        int maxIndex=-1;
        for(int i=0; i<26; i++){
            if(max<array[i]) max=array[i];
        }

        for(int i=0; i<26; i++){
            if(max==array[i]){
                maxIndex=i;
                max_count++;
            }
        }
        if(max_count!=1) System.out.println('?');
        else System.out.println((char)(65+maxIndex));














    }
}