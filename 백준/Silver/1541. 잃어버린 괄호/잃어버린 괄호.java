import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        boolean tf = false;
        int n=0;
        while (s.length() > n){
            if (s.charAt(n)=='+' || s.charAt(n)=='-'){
                if(tf==false) sum += Integer.parseInt(s.substring(0,n));
                else sum -= Integer.parseInt(s.substring(0,n));
                if (s.charAt(n)=='-') tf = true;

                s = s.substring(n+1);
                n=0;
            }
            n++;
        }
        if (tf==true) sum -= Integer.parseInt(s);
        else sum += Integer.parseInt(s);
        System.out.println(sum);


    }
}
