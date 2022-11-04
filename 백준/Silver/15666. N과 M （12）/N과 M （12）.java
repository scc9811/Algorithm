import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main{
    static int n, m, store[];
    static Object[] arr;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        store = new int[m];
        st = new StringTokenizer(br.readLine());
        Set<Integer> intSet = new HashSet<>();
        for(int i=0; i<n; i++){
            intSet.add(Integer.parseInt(st.nextToken()));
        }

        arr = intSet.toArray();
        Arrays.sort(arr);

        backTracking(0,0);
        System.out.println(result);







    }
    public static void backTracking(int depth, int startI){
        if(depth==m){
            for(int i=0; i<m; i++){
                result.append(store[i]).append(' ');
            }
            result.append('\n');
            return;
        }

        for(int i=startI; i<arr.length; i++){
            store[depth] = (int) arr[i];
            backTracking(depth+1, i);
        }






    }
}