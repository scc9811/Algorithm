import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            if(s.equals("STRAWBERRY")){
                arr[0] += k;
            }
            else if(s.equals("BANANA")){
                arr[1] += k;
            }
            else if(s.equals("LIME")){
                arr[2] += k;
            }
            else if(s.equals("PLUM")){
                arr[3] += k;
            }
        }
        boolean tf = false;
        for(int i=0; i<4; i++){
            if(arr[i]==5) tf = true;
        }
        if(tf) System.out.println("YES");
        else System.out.println("NO");











    }
}

