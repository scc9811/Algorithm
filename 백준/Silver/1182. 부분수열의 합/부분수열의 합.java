import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] array;
    static int n,s,count,sum;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        sum=Integer.MAX_VALUE;
        count=0;
        backTracking(0);
        System.out.println(count);



    }
    public static void backTracking(int startIndex){
        if(sum==s) {
            count++;
        }



        for(int i=startIndex; i<n; i++){
            if(i==0) sum=array[0];
            else sum+=array[i];
            backTracking(i+1);
            sum-=array[i];
        }
    }
}