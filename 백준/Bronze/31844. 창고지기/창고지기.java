import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int robotIdx = -1;
        int boxIdx = -1;
        int exit = -1;
        for(int i=0; i<10; i++) {
            if(s.charAt(i) == '@') robotIdx = i;
            else if(s.charAt(i) == '#') boxIdx = i;
            else if(s.charAt(i) == '!') exit = i;
        }

        if(robotIdx < boxIdx && boxIdx < exit) {
            System.out.println(exit - boxIdx + boxIdx - robotIdx - 1);
        }
        else if(exit < boxIdx && boxIdx < robotIdx) {
            System.out.println(robotIdx - boxIdx + boxIdx - exit - 1);
        }
        else {
            System.out.println(-1);
        }
















    }
}