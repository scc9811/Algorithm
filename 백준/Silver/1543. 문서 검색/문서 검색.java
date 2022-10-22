import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (s2.length() > s1.length()) System.out.println(0);
        else{
            int count = 0;
            for (int i=0; i<s1.length(); i++){
                if (s2.charAt(0)==s1.charAt(i) && i+s2.length()<=s1.length())
                    if (s1.substring(i, i + s2.length()).equals(s2)) {
                        i = i+s2.length()-1;
                        count++;
                    }

            }
            System.out.println(count);


        }







    }

}
