import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            if (map.get(name) == null) {
                map.put(name, c);
            } else {
                map.put(name, c + map.get(name));
            }
        }

        boolean tf = false;
        Object[] arr = map.keySet().toArray();
        for (int j = 0; j < arr.length; j++) {
            int tmp = (int) (map.get(arr[j]) * 1.618);
            for (int k = 0; k < arr.length; k++) {
                if(j==k) continue;
                if (tmp == (int) map.get(arr[k])) {
                    tf = true;
                    break;
                }
            }
            if (tf) break;
        }

        if (tf) System.out.println("Delicious!");
        else System.out.println("Not Delicious...");


    }
}

