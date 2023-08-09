import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] arr1 = new long[n];
        long[] arr2 = new long[m];
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());
            if(flag==1){
                arr1[a] += b;
            }
            else{
                arr2[a] += b;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(arr1[i] + arr2[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);









    }
}