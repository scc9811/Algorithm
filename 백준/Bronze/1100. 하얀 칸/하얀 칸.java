import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for(int i=0; i<8; i++) {
            char[] arr = br.readLine().toCharArray();
            int j = i % 2 == 0 ? 0 : 1;
            for( ; j<8; j+=2) {
                if(arr[j] == 'F') count++;
            }
        }
        System.out.println(count);







    }
}
