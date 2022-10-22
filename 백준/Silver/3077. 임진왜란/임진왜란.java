import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map.put(st.nextToken(),i);
        }
        String[] array = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = st.nextToken();
        }

        int count=0;
        for(int i=0; i<n; i++){
            int k1 = map.get(array[i]);
            for(int j=i+1; j<n; j++){
                int k2 = map.get(array[j]);
                if(k1<k2) count++;

            }
        }
        System.out.printf("%d/%d",count,n*(n-1)/2);








    }
}
