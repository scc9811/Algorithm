import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] charges = new int[n+1];
        int[] weight = new int[m+1];
        for(int i=1; i<=n; i++){
            charges[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=m; i++){
            weight[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> queue = new LinkedList<>();

        // 현재 주차장 상태.
        int[] current = new int[n+1];
        int size = 0;
        int total = 0;
        for(int i=0; i<2*m; i++){
            int k = Integer.parseInt(br.readLine());
            if(k>0){
                if(size==n){
                    queue.add(k);
                }
                else{
                    for(int j=1; j<=n; j++){
                        if(current[j]==0){
                            current[j]=k;
                            size++;
                            total += weight[k]*charges[j];
                            break;
                        }
                    }
                }

            }
            else{
                k = Math.abs(k);
                if(size==n && !queue.isEmpty()) {
                    for (int j = 1; j <= n; j++) {
                        if (current[j] == k) {
                            int tmp = queue.poll();
                            current[j] = tmp;
                            total += weight[tmp]*charges[j];
                            break;
                        }
                    }
                }

                else{
                    for(int j=1; j<=n; j++){
                        if(current[j]==k){
                            current[j] = 0;
                            size--;
                            break;
                        }
                    }

                }

            }

        }
        System.out.println(total);



    }
}
