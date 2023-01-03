import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int nameCount = 0;
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                if(map.containsKey(s)){
                    arr[map.get(s)]++;
                }
                else{
                    map.put(s, nameCount);
                    arr[nameCount++]++;
                }
            }
            int mul = 1;
            for(int i=0; i<nameCount; i++){
                mul *= arr[i]+1;
            }
            sb.append(mul-1).append('\n');
        }
        System.out.println(sb);


    }
}