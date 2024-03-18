import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] par = new int[n+1];
        par[1] = -1;
        int curNode = 1;
        int visitedCount = 1;
        boolean[] flag = new boolean[n+1];

        while(true){
//            System.out.println(Arrays.toString(par));
//            System.out.println(Arrays.toString(flag));
            if(flag[curNode]){
//                System.out.println("case 0 ");
                System.out.println("gaji " + par[curNode]);
                System.out.flush();
                br.readLine();
                curNode = par[curNode];
                continue;
            }
            int lastNode = curNode;
            System.out.println("maze");
            System.out.flush();
            curNode = Integer.parseInt(br.readLine());
//            System.out.println("curNode = "+curNode);
//            System.out.println("lastNode = "+lastNode);

            // no visited, 아래로 내려감
            if(par[curNode] == 0){
//                System.out.println("case 1 ");
                par[curNode] = lastNode;
                visitedCount++;
                if(visitedCount==n) break;
            }
            // visited, 위로 올라감
            else if(par[lastNode] == curNode){
//                System.out.println("case 2 ");
                flag[lastNode] = true;
//                curNode = lastNode;
                continue;
            }
            // visited, 아래로 내려감
            else{
//                System.out.println("case 3 ");
                flag[lastNode] = true;
                System.out.println("gaji " + lastNode);
                System.out.flush();
                br.readLine();
                curNode = lastNode;
            }
        }
        System.out.println("answer");
        for(int parIdx=1; parIdx<=n; parIdx++){
            for(int node=1; node<=n; node++){
                if(par[node] == parIdx) System.out.printf("%d %d\n",parIdx, node);
            }
        }
        System.out.flush();


















    }
}