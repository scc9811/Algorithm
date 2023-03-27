import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Element[] xElement = new Element[n];
        Element[] yElement = new Element[n];
        Element[] zElement = new Element[n];



        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            xElement[i] = new Element(Integer.parseInt(st.nextToken()), i);
            yElement[i] = new Element(Integer.parseInt(st.nextToken()), i);
            zElement[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(xElement);
        Arrays.sort(yElement);
        Arrays.sort(zElement);


        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        for(int i=1; i<n; i++){
            priorityQueue.add(new Edge(xElement[i-1].nodeNumber, xElement[i].nodeNumber, xElement[i].k - xElement[i-1].k));
            priorityQueue.add(new Edge(yElement[i-1].nodeNumber, yElement[i].nodeNumber, yElement[i].k - yElement[i-1].k));
            priorityQueue.add(new Edge(zElement[i-1].nodeNumber, zElement[i].nodeNumber, zElement[i].k - zElement[i-1].k));
        }



        int res = 0;
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(find(parent, e.from)==find(parent, e.to)) continue;
            res += e.weight;
            union(parent, e.from, e.to);
        }
        System.out.println(res);







    }
    static int find(int[] parent, int a){
        if(parent[a]!=a) return parent[a] = find(parent, parent[a]);
        return a;
    }
    static void union(int[] parent, int a, int b){
        int p_a = find(parent, a);
        int p_b = find(parent, b);
        if(p_a != p_b){
            parent[p_a] = p_b;
        }
    }
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }
    }
    static class Element implements Comparable<Element>{
        int k, nodeNumber;
        Element(int k, int nodeNumber){
            this.k = k;
            this.nodeNumber = nodeNumber;
        }
        public int compareTo(Element e){
            return Integer.compare(this.k, e.k);
        }
    }
}
