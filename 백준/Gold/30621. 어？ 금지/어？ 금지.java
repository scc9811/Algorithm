import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tA = new int[n+1];
        int[] bA = new int[n+1];
        int[] cA = new int[n+1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
             tA[i] = Integer.parseInt(st1.nextToken());
             bA[i] = Integer.parseInt(st2.nextToken());
             cA[i] = Integer.parseInt(st3.nextToken());
        }

        long[] score = new long[n+1];

        score[1] = cA[1];
        for(int i=2; i<=n; i++){
            int l = 0;
            int r = i-1;
            int mid = (l+r)/2;
            int idx = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(bA[i] < tA[i] - tA[mid]){
                    idx = Math.max(idx, mid);
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            
            if(bA[i] == tA[i]) score[i] = Math.max(score[i-1], cA[i]);
            else score[i] = Math.max(score[i-1], score[idx] + cA[i]);
        }

        System.out.println(score[n]);


















    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y){
        return x*y / gcd(x, y);
    }
}