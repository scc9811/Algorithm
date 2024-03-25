import java.util.*;
import java.io.*;
public class Main {
    static int n, m, par[], basePar[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        basePar = new int[n+1];
        for(int i=1; i<=n; i++){
            basePar[i] = i;
        }
        int q = Integer.parseInt(st.nextToken());
//        List<Edge> aEdgesList = new ArrayList<>();
//        List<Edge> bEdgesList = new ArrayList<>();
//        List<Edge> cEdgesList = new ArrayList<>();
//        List<Edge> dEdgesList = new ArrayList<>();
//        List<Edge> eEdgesList = new ArrayList<>();
        List<Edge>[] edgesLists = new List[5];
        for(int i=0; i<5; i++){
            edgesLists[i] = new ArrayList<>();
        }




        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int univNumber = st.nextToken().charAt(0) - 'A';
            edgesLists[univNumber].add(new Edge(from, to));
        }

        Map<String, EdgeCounts> map = new HashMap<>();
        for (int first=0; first<5; first++){
            for (int second=0; second<5; second++){
                if (second == first) continue;
                for (int third=0; third<5; third++){
                    if (third == first || third == second) continue;
                    for (int fourth=0; fourth<5; fourth++){
                        if (fourth == first || fourth == second || fourth == third) continue;
                        for(int fifth=0; fifth<5; fifth++){
                            if (fifth == first || fifth == second || fifth == third || fifth == fourth) continue;
                            StringBuilder sb = new StringBuilder();
                            sb.append(first).append(second).append(third).append(fourth).append(fifth);
                            List<Integer> univNumberSequenceList = new ArrayList<>();
                            univNumberSequenceList.add(first);
                            univNumberSequenceList.add(second);
                            univNumberSequenceList.add(third);
                            univNumberSequenceList.add(fourth);
                            univNumberSequenceList.add(fifth);

                            int unionCount = 0;
                            par = Arrays.copyOf(basePar, n+1);
                            EdgeCounts resultEdgeCounts = new EdgeCounts();
                            loop:
                            for(int i = 0; i < 5; i++){
                                int currentUnivNumber = univNumberSequenceList.get(i);
                                for(int j = 0; j < edgesLists[currentUnivNumber].size(); j++){
                                    if(union(edgesLists[currentUnivNumber].get(j).from, edgesLists[currentUnivNumber].get(j).to)){
                                        unionCount++;
                                        resultEdgeCounts.countArray[currentUnivNumber]++;
                                        if(unionCount == n-1) break loop;
                                    }
                                }
                            }
//                            System.out.println("sb = "+sb);
//                            System.out.println(resultEdgeCounts);
                            map.put(sb.toString(), resultEdgeCounts);

                        }
                    }
                }
            }
        }

        StringBuilder resultSb = new StringBuilder();
        for(int i=0; i<q; i++){
            Node[] nodes = new Node[5];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                nodes[j] = new Node(j, Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(nodes);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<5; j++){
                sb.append(nodes[j].univNumber);
            }
//            System.out.println(sb);
            EdgeCounts edgeCounts = map.get(sb.toString());
            long sum = 0;
            for(int j=0; j<5; j++){
//                System.out.println("weight = "+nodes[j].weight);
//                System.out.println("edgeCount = "+edgeCounts.countArray[nodes[j].univNumber]);
                sum += (long) nodes[j].weight * edgeCounts.countArray[nodes[j].univNumber];
            }
            resultSb.append(sum).append('\n');
        }

        System.out.println(resultSb);















    }
    static class Node implements Comparable<Node>{
        int univNumber, weight;
        Node(int univNumber, int weight){
            this.univNumber = univNumber;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
        }
    }
    static int find(int a){
        if(par[a] == a) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a == p_b) return false;
        else if(p_a <= p_b) {
            par[p_b] = p_a;
        }
        else{
            par[p_a] = p_b;
        }
        return true;
    }

    static class Edge{
        int from, to;
        Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
    static class EdgeCounts{
        // A, B, C, D, E
        int[] countArray;
        EdgeCounts(){
            this.countArray = new int[5];
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<5; i++){
                sb.append(this.countArray[i]).append(' ');
            }
            return sb.toString();
        }
//        int aEdgeCount, bEdgeCount, cEdgeCount, dEdgeCount, eEdgeCount;
//        EdgeCounts(int aEdgeCount, int bEdgeCount, int cEdgeCount, int dEdgeCount, int eEdgeCount){
//            this.aEdgeCount = aEdgeCount;
//            this.bEdgeCount = bEdgeCount;
//            this.cEdgeCount = cEdgeCount;
//            this.dEdgeCount = dEdgeCount;
//            this.eEdgeCount = eEdgeCount;
//        }
    }
}