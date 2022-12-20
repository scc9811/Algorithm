import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n1 = st.nextToken();
            String n2 = st.nextToken();
            if(set.contains(n1) && set.contains(n2)) continue;
            else if(set.contains(n1) && !set.contains(n2)){
                set.add(n2);
            }
            else if(!set.contains(n1) && set.contains(n2)){
                set.add(n1);
            }





        }
        System.out.println(set.size());







    }
}