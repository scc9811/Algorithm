import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = s.charAt(0);
        int count =0;
        for (int i=1; i<s.length(); i++){
            if (c != s.charAt(i)){
                count++;
                c = s.charAt(i);
            }
        }
        System.out.println((count+1)/2);


    }
}
