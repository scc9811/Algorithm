import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[k];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[c+1];
        int[] sitNumbers = new int[x+1];
        for(int i=0; i<k; i++) {
            Node curNode = arr[i];
            if(!visited[curNode.s]) {
                if(sitNumbers[curNode.n] != 0) {
                    visited[sitNumbers[curNode.n]] = false;
                }
                visited[curNode.s] = true;
                sitNumbers[curNode.n] = curNode.s;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=x; i++) {
            if(sitNumbers[i] != 0) {
                sb.append(i).append(' ').append(sitNumbers[i]).append('\n');
            }
        }
        System.out.println(sb);









    }
    static class Node implements Comparable<Node>{
        int t, s, n;
        Node(int t, int s, int n) {
            this.t = t;
            this.s = s;
            this.n = n;
        }
        public int compareTo(Node n) {
            return Integer.compare(this.t, n.t);
        }
    }
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int x, int y) {
        return (x*y) / gcd(x,y);
    }
}