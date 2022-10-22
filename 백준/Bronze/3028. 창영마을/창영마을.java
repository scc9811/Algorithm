import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ball = 1;
        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='A') {
                if(ball==1) ball=2;
                else if(ball==2) ball=1;
            }
            else if(s.charAt(i)=='B'){
                if(ball==2) ball=3;
                else if(ball==3) ball=2;
            }
            else{
                if(ball==1) ball=3;
                else if(ball==3) ball=1;
            }
        }
        System.out.println(ball);



    }
}