import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st1.nextToken());
        }
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int[] idx = new int[m];
        for(int i=0; i<m; i++){
            idx[i] = i;
        }
        for(int i=m-2; i>=0; i--){
            if(b[i] == b[i+1]) idx[i] = idx[i+1];
        }

        long win = 0;
        long lose = 0;
        long draw = 0;
        for(int i=0; i<n; i++){
            int l = 0;
            int r = m-1;
            int mid = (l+r)/2;
            while(l<=r){
                mid = (l+r)/2;
                if(a[i] <= b[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }

            if(mid != m-1 && b[mid]!=a[i] && b[mid+1]==a[i]) mid++;
            int midL = mid;
            int midR = idx[mid];
            



            if(a[i] == b[mid]){
                draw += midR-midL+1;
                win += midL;
                lose += m-(midR+1);
            }
            else if(a[i] < b[mid]){
                win += mid;
                lose += m - mid;
            }
            else{
                win += mid+1;
                lose += m - (mid + 1);
            }
//            System.out.printf("%d %d %d\n", win, lose, draw);
        }

        System.out.printf("%d %d %d\n", win, lose, draw);





    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}