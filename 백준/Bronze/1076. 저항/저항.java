import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 2; i++) {
            String s = br.readLine();
            for(int value = 0; value < 10; value++) {
                if(colors[value].equals(s)) {
                    sb.append(value);
                    break;
                }
            }
        }

        String s = br.readLine();
        for(int value = 0; value < 10; value++) {
            if(colors[value].equals(s)) {
                for(int i = 0; i < value; i++) {
                    sb.append(0);
                }
            }
        }

        System.out.println(Long.parseLong(sb.toString()));





    }
}
