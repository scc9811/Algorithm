import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] isFriend = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(s.charAt(j)=='Y') isFriend[i][j] = true;
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            boolean[] visited = new boolean[n];
            int count = 0;
            visited[i] = true;
            for(int j=0; j<n; j++){
                if(isFriend[i][j]){
                    if(!visited[j]) {
                        count++;
                        visited[j] = true;
                    }
                    for(int k=0; k<n; k++){
                        if(isFriend[j][k] && !visited[k]){
                            count++;
                            visited[k] = true;
                        }
                    }

                }
            }


            max = Math.max(max, count);
        }

        System.out.println(max);






    }

}