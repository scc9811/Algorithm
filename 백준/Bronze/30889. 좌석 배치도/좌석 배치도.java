import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[10][20];
        for(int i=0; i<10; i++){
            Arrays.fill(arr[i], '.');
        }
        for(int i=0; i<n; i++){
            String s = br.readLine();
            int k1 = s.charAt(0) - 'A';
            int k = Integer.parseInt(s.substring(1, s.length())) - 1;
            arr[k1][k] = 'o';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            for(int j=0; j<20; j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

















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