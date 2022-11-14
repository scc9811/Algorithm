import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        arr[0] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];
        int[] parent = new int[n];
        int[] dpParent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(dpParent, -1);
        dpParent[0] = 0;


        for(int i=1; i<n; i++){
            int key = Integer.parseInt(st.nextToken());
            arr[i] = key;
            if(key > dp[index-1]) {
                dp[index++] = key;
                dpParent[index-1] = i;
                parent[i] = dpParent[index-2];
            }
            else if(key < dp[index-1]){
                for(int j=0; j<index; j++){
                    if(key <= dp[j]) {
                        dp[j] = key;
                        if(j>0) parent[i] = dpParent[j-1];
                        dpParent[j] = i;
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
//            System.out.println(Arrays.toString(parent));
//            System.out.println(Arrays.toString(dpParent));
        }

        List<Integer> list = new ArrayList<>();
        int start = dpParent[index-1];
        for(int i=start; i!=-1; i=parent[i]){
            list.add(arr[i]);
        }
//        System.out.println(list.toString());



        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
//        System.out.println(Arrays.toString(dp));


//        StringBuilder sb = new StringBuilder();
//        sb.append(index).append('\n');
//        for(int i=0; i<index; i++){
//            sb.append(dp[i]).append(' ');
//        }
//        sb.delete(sb.length()-1, sb.length());
//        System.out.println(sb);





    }
}
