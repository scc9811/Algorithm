import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static char[] chars = {'O', 'B', 'I', 'S'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 'M') {
                    subLoop:
                    for(int dir=0; dir<8; dir++) {
                        int x = i;
                        int y = j;
                        for(int k=0; k<4; k++) {
                            x += dx[dir];
                            y += dy[dir];
                            if(x < 0 || x >= n || y < 0 || y >= n || arr[x][y] != chars[k]) continue subLoop;
                        }
                        count++;
                    }
                }
            }
        }
        System.out.println(count);











    }
}