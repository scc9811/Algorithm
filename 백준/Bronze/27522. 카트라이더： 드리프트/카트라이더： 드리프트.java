import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node[] arr = new Node[8];


        for(int i=0; i<8; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer time = new StringTokenizer(st.nextToken(), ":");
            char team = st.nextToken().charAt(0);
            arr[i] = new Node(Integer.parseInt(time.nextToken()), Integer.parseInt(time.nextToken()),
                    Integer.parseInt(time.nextToken()), team);
        }
        Arrays.sort(arr);
        


        int blue = 0;
        if(arr[0].team=='B') blue += 10;
        if(arr[1].team=='B') blue += 8;
        if(arr[2].team=='B') blue += 6;
        if(arr[3].team=='B') blue += 5;
        if(arr[4].team=='B') blue += 4;
        if(arr[5].team=='B') blue += 3;
        if(arr[6].team=='B') blue += 2;
        if(arr[7].team=='B') blue += 1;

        if(blue>=20) System.out.println("Blue");
        else System.out.println("Red");














    }
    public static class Node implements Comparable<Node>{
        int m, S, ss;
        char team;
        Node(int m, int S, int ss, char team){
            this.m = m;
            this.S = S;
            this.ss = ss;
            this.team = team;
        }
        public int compareTo(Node node){
            if(this.m==node.m){
                if(this.S==node.S){
                    return Integer.compare(this.ss, node.ss);
                }
                return Integer.compare(this.S, node.S);
            }
            return Integer.compare(this.m, node.m);
        }
    }
}
