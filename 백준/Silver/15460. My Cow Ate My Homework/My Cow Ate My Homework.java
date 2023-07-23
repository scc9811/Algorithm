import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int[] min = new int[n];
        min[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            min[i] = Math.min(min[i+1], arr[i]);
        }
        



        double maxAv = -1;
        List<Integer> k = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            sum -= arr[i];
            double av = (double) (sum - min[i+1]) / (n-i-2);
            if(av==maxAv){
                k.add(i+1);
            }
            else if(av > maxAv){
                k.clear();
                k.add(i+1);
                maxAv = av;
            }
        }
        Collections.sort(k);
        StringBuilder sb = new StringBuilder();
        for(int i : k){
            sb.append(i).append(' ');
        }
        System.out.println(sb);







    }
}