import javax.swing.text.Segment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Star[] arr = new Star[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double d1 = Double.parseDouble(st.nextToken());
            double d2 = Double.parseDouble(st.nextToken());
            arr[i] = new Star(d1, d2);
        }


        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                priorityQueue.add(new Edge(i, j, dis(arr[i], arr[j])));
            }
        }
        par = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
        }

        double sum = 0.0;
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(!union(e.start, e.to)) continue;
            sum += e.dis;
        }

        System.out.println(sum);




    }
    static double dis(Star s1, Star s2){
        return Math.sqrt(Math.pow(s1.x-s2.x, 2) + Math.pow(s1.y-s2.y, 2));
    }
    static class Edge implements Comparable<Edge>{
        int start, to;
        double dis;
        Edge(int start, int to, double dis){
            this.start = start;
            this.to = to;
            this.dis = dis;
        }
        public int compareTo(Edge e){
            return Double.compare(this.dis, e.dis);
        }
    }
    static class Star{
        double x, y;
        Star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] par;
    static int find(int a){
        if(a==par[a]) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a!=p_b) {
            par[p_a] = p_b;
            return true;
        }
        return false;
    }
}
