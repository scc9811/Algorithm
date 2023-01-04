import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] edge = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0; j<m; j++){
                int k = Integer.parseInt(st.nextToken());
                edge[i][k] = -1;
                edge[k][i] = -1;
            }
        }

        // -1 , 1
        int[] team = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        team[1] = -1;
        queue.add(1);
        while(true){
            if(queue.isEmpty()){
                for(int i=1; i<=n; i++){
                    if(team[i]==0){
                        team[i] = -1;
                        queue.add(i);
                        break;
                    }
                }
                if(queue.isEmpty()) break;
            }
            int start = queue.poll();
            int teamS = team[start];
            for(int i=1; i<=n; i++){
                if(edge[start][i]==-1 && team[i]==0){
                    team[i] = -teamS;
                    queue.add(i);
                }
            }
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(team[i]==-1) listA.add(i);
            else listB.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(listA.size()).append('\n');
        for (Integer value : listA) {
            sb.append(value).append(' ');
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append('\n').append(listB.size()).append('\n');
        for (Integer integer : listB) {
            sb.append(integer).append(' ');
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);








    }
}
