import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        Point[] arr = new Point[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int resX = -1;
        int resY = -1;
        int max = -1;
        for(int x=-100; x<=100; x++){
            for(int y=-100; y<=100; y++){
                int count = 0;
                for(int i=0; i<n; i++){
                    if(Math.pow(arr[i].x - x, 2) + Math.pow(arr[i].y - y, 2) <= r*r) count++;
                }
                if(max < count){
                    max = count;
                    resX = x;
                    resY = y;
                }
            }
        }

        System.out.printf("%d %d",resX, resY);















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