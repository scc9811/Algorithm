import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] array = new int[26];
        Arrays.fill(array,-1);

        for(int i=0; i<s.length(); i++){
            if(array[s.charAt(i)-97]==-1){
                array[s.charAt(i)-97]=i;
            }
        }
        for(int i=0; i<26; i++){
            sb.append(array[i]).append(' ');
        }
        System.out.println(sb);



    }


}
