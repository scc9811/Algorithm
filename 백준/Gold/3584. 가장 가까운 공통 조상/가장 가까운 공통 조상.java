import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase-->0){
            int n = Integer.parseInt(br.readLine());
            int[] par = new int[n+1];
            for(int i=0; i<n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                par[c] = p;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            for(int i=v1; i!=0; i=par[i]){
                set.add(i);
            }
            for(int i=v2; i!=0; i=par[i]){
                if(set.contains(i)){
                    sb.append(i).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

