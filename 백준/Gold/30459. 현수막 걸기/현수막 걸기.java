import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
            B[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);


        int res = -1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int left = 0;
                int right = m-1;
                int mid;
                while(left <= right){
                    mid = (left + right)/2;
                    if((A[j] - A[i]) * B[mid] <= r*2){
                        res = Math.max(res, (A[j] - A[i]) * B[mid]);
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
            }
        }

        if(res == -1) System.out.println(-1);
        else System.out.printf("%.1f\n", (double)res / 2);

















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}