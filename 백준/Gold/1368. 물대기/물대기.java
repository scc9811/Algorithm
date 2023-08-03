import java.util.*;
import java.io.*;

class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            priorityQueue.add(new Edge(i, Integer.parseInt(br.readLine())));
        }
        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        boolean[] visited = new boolean[n+1];
        int res = 0;
        while(!priorityQueue.isEmpty()){
            Edge e = priorityQueue.poll();
            if(visited[e.to]) continue;
            visited[e.to] = true;
            res += e.weight;
            for(int j=1; j<=n; j++){
                if(!visited[j]) priorityQueue.add(new Edge(j, graph[e.to][j]));
            }
        }
        System.out.println(res);









    }
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }

    }
}