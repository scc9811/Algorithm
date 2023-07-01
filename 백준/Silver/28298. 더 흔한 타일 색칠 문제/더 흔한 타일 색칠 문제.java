import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }


        int same = 0;
        char[][] res = new char[k][k];
        for(int k1=0; k1<k; k1++){
            for(int k2=0; k2<k; k2++){
                Map<Character, Integer> map = new HashMap<>();
                for(int i=0; i<n; i+=k) {
                    for (int j = 0; j < m; j += k) {
                        map.put(arr[i+k1][j+k2], map.getOrDefault(arr[i+k1][j+k2], 0)+1);
                    }
                }
                int maxCount = 0;
                char c = 'k';
                for(char key : map.keySet()){
                    if(maxCount<map.get(key)){
                        maxCount = map.get(key);
                        c = key;
                    }
                }
                res[k1][k2] = c;
                same += maxCount;
            }
        }

        char[][] res2 = new char[n][m];

        for(int i=0; i<n; i+=k){
            for(int j=0; j<m; j+=k){
                for(int k1=0; k1<k; k1++){
                    for(int k2=0; k2<k; k2++){
                        res2[i+k1][j+k2] = res[k1][k2];
                    }
                }
            }
        }


        System.out.println(n*m-same);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(res2[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);






    }
}
