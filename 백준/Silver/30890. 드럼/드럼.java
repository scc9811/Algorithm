import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int size = lcm(x, y);


        int[] arr = new int[size+1];
        int stepX = size/x;
        for(int i=stepX; i<=size; i+=stepX){
            arr[i] = 1;
        }
        int stepY = size/y;
        for(int i=stepY; i<=size; i+=stepY){
            if(arr[i] == 1) arr[i] = 3;
            else arr[i] = 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=size; i++){
            if(arr[i] != 0) sb.append(arr[i]);
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