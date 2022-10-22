import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] array = new String[n+1];
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            array[i] = s;
            map.put(s,i);
        }

        while(m-->0){
            String s = br.readLine();
            try {
                int tmp = Integer.parseInt(s);
                sb.append(array[tmp]);
            }
            catch(NumberFormatException ignore){
                sb.append(map.get(s));
            }
            sb.append('\n');

        }
        System.out.println(sb);











    }
}
