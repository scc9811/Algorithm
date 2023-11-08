import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes);

//        Arrays.sort(arr, Comparator.comparing(o1->o1[0]));
//        Arrays.sort(arr, (o1, o2) -> {
//            if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
//            else return Integer.compare(o1[0], o2[0]);
//        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(nodes[i].w).append(' ').append(nodes[i].v).append('\n');
        }
        System.out.println(sb);




    }
    static class Node implements Comparable<Node>{
        int w, v;
        Node(int w, int v){
            this.w = w;
            this.v = v;
        }
        public int compareTo(Node n){
            if(this.v == n.v) return Integer.compare(this.w, n.w);
            else return Integer.compare(this.v, n.v);
        }
    }
}