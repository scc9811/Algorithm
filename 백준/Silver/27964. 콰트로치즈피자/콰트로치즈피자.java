import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Set<String> set = new LinkedHashSet<>();
        for(int i=0; i<n; i++){
            String s = st.nextToken();
            if(s.length()>=6 && s.substring(s.length()-6, s.length()).equals("Cheese")){
                set.add(s);
            }
        }
        if(set.size()>=4) System.out.println("yummy");
        else System.out.println("sad");





    }
}
