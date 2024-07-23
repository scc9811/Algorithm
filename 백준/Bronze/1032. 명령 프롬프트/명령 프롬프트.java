import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for(int i=0; i<n; i++) {
            strings[i] = br.readLine();
        }
        int length = strings[0].length();
        char[] resultString = strings[0].toCharArray();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=0; k<length; k++) {
                    if(strings[i].charAt(k) != strings[j].charAt(k)) {
                        resultString[k] = '?';
                    }
                }
            }
        }

        System.out.println(resultString);





    }
}
