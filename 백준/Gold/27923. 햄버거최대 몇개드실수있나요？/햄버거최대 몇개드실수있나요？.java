import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 햄버거 개수
        int n = Integer.parseInt(st.nextToken());
        // 콜라 개수
        int k = Integer.parseInt(st.nextToken());
        // 콜라 지속시간
        int l = Integer.parseInt(st.nextToken());

        int[] bugger = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            bugger[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bugger);


        long[] prefixSum = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int index = Integer.parseInt(st.nextToken())-1;
            prefixSum[index]++;
            if(index+l>=n) prefixSum[n]--;
            else prefixSum[index + l]--;
        }
        for(int i=1; i<n; i++){
            prefixSum[i] += prefixSum[i-1];
        }
        Arrays.sort(prefixSum, 0, n);

        long res = 0;
        for(int i=0; i<n; i++){
            res += bugger[i]/Math.pow(2, prefixSum[i]);
        }
        System.out.println(res);



    }
}