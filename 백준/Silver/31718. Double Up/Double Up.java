import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(st.nextToken());
            while(k%2==0){
                k /= 2;
            }
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int max = 1;


        for(int i : map.values()){
            max = Math.max(max, i);
        }
        System.out.println(max);















    }
}
