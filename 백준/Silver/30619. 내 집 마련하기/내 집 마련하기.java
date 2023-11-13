import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[Integer.parseInt(st.nextToken())] = i;
        }

        

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int[] tmpA = Arrays.copyOf(arr, n+1);
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j=l; j<=r; j++){
                list.add(arr[j]);
            }
            Collections.sort(list);
            for(int j=l; j<=r; j++){
                tmpA[j] = list.get(j-l);
            }
            int[] tmpB = new int[n+1];
            for(int j=1; j<=n; j++){
                tmpB[tmpA[j]] = j;
            }

            for(int j=1; j<=n; j++){
                sb.append(tmpB[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}