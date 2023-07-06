import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        par = new int[g+1];
        for(int i=1; i<=g; i++){
            par[i] = i;
        }
        int count = 0;
        for(int i=0; i<p; i++){
            int k = Integer.parseInt(br.readLine());
            if(find(k)==0) break;
            if(k==par[k]) union(k, k-1);
            else union(par[k], par[k]-1);
            count++;

//            System.out.println(Arrays.toString(par));
        }


        System.out.println(count);















    }
    static int[] par;
    static int find(int a){
        if(a==par[a]) return a;
        return par[a] = find(par[a]);
    }
    static boolean union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a!=p_b) {
            par[p_a] = p_b;
            return true;
        }
        return false;
    }
}
