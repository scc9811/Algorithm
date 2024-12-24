import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int max = n;
        for(int i=0; i<n; i++) {
            max = Math.min(max, i + arr[i]);
        }
        System.out.println(max);








    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }
}