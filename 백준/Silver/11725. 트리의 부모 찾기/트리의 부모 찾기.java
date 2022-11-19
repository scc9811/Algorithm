import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
//        List[] lists = new List[n+1];
        List<Integer>[] lists = new List[n+1];



        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(lists[start]==null) lists[start] = new ArrayList();
            if(lists[end]==null) lists[end] = new ArrayList();
//            boolean tf1 = true;
//            boolean tf2 = true;
//            for(int j=0; j<3; j++){
//
//                if(arr[start][j]==0 && tf1) {
//                    arr[start][j] = end;
//                    tf1 = false;
//                }
//                if(arr[end][j]==0 && tf2){
//                    arr[end][j] = start;
//                    tf2 = false;
//                }
//            }
            lists[start].add(end);
            lists[end].add(start);
        }
        int[] parent = new int[n+1];
        parent[1] = -1;
        Queue<Integer> queue = new LinkedList<>(lists[1]);
        for(int i=0; i<lists[1].size(); i++){
            parent[lists[1].get(i)] = 1;
        }
//        for(int i=0; i<3; i++){
//            if(arr[1][i]!=0){
//                queue.add(arr[1][i]);
//                parent[arr[1][i]] = 1;
//            }
//        }

        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int i=0; i<lists[start].size(); i++){
                if(parent[lists[start].get(i)]!=0) continue;
                queue.add(lists[start].get(i));
                parent[lists[start].get(i)] = start;
            }
//            for(int i=0; i<3; i++) {
//                if (arr[start][i] != 0 && parent[arr[start][i]] == 0) {
//                    queue.add(arr[start][i]);
//                    parent[arr[start][i]] = start;
//                }
//            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);





//        for(int i=0; i<=n; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }







    }
}