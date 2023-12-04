import java.io.*;
import java.util.*;
public class Main{
    static int[] par;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        par = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
        }

        while(k-->0){
            int l = 0;
            int r = n-1;
            int mid;
            int maxIdx = -1;
            while(l<=r){
                mid = (l+r)/2;
                if(arr[mid] < t){
                    maxIdx = Math.max(maxIdx, mid);
                    l = mid+1;
                }
                else r = mid-1;
            }
            if(maxIdx == -1){
                break;
            }
            int p_i = find(maxIdx);
            if(p_i == -1) break;

            t += arr[p_i];
            union(p_i, p_i-1);
        }
        System.out.println(t);














    }
    static int find(int a){
        if(a==-1) return -1;
        if(par[a] == a) return a;
        else return par[a] = find(par[a]);
    }
    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a > p_b) par[p_a] = p_b;
        else par[p_b] = p_a;
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Node{
        int to;
        Node next;
        Node(int to, Node next){
            this.to = to;
            this.next = next;
        }
    }
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}