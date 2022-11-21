import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] white = new int[2];
        st = new StringTokenizer(br.readLine());
        white[0] = Integer.parseInt(st.nextToken()) -1;
        white[1] = Integer.parseInt(st.nextToken()) -1;


        int[][] black = new int[k][2];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            black[i][0] = Integer.parseInt(st.nextToken()) -1;
            black[i][1] = Integer.parseInt(st.nextToken()) -1;
        }

//        Arrays.sort(black, ((o1, o2) -> {
//            if(o1[0]==o2[0]){
//                return Integer.compare(o1[1], o2[1]);
//            }
//            else return Integer.compare(o1[0], o2[0]);
//        }));

//        for(int i=0; i<k; i++){
//            System.out.println(Arrays.toString(black[i]));
//        }

        boolean isWhiteAttacked = false;
        // -1 : default, 0 : 공격X , 1 : 공격 O
        int[] isAttacked = new int[8];
        Arrays.fill(isAttacked, -1);

        for(int i=0; i<k; i++){
            if(white[0]==black[i][0] || white[1]==black[i][1]){
                isWhiteAttacked = true;
                break;
            }
            int tmp = white[0] - black[i][0];
            if(tmp+black[i][1]==white[1] || black[i][1] - tmp==white[1]){
                isWhiteAttacked = true;
                break;
            }
        }

//        System.out.println(isWhiteAttacked);

        for(int i=0; i<8; i++){
            int newI = white[0]+dx[i];
            int newJ = white[1]+dy[i];
            if(newI>=0 && newI<n && newJ>=0 && newJ<n){
                isAttacked[i] = 0;
                for(int j=0; j<k; j++) {
                    if (newI == black[j][0] || newJ == black[j][1]) {
                        isAttacked[i] = 1;
                        break;
                    }
                    int tmp = newI - black[j][0];
                    if(tmp+black[j][1]==newJ || black[j][1]-tmp==newJ){
                        isAttacked[i] = 1;
                        break;
                    }
                }
            }
        }

        boolean tf = true;
        for(int i=0; i<8; i++){
            if(isAttacked[i]==0){
                tf = false;
                break;
            }
        }
//        System.out.println("tf = "+tf);

        if(isWhiteAttacked && tf) System.out.println("CHECKMATE");
        else if(!isWhiteAttacked && tf) System.out.println("STALEMATE");
        else if(isWhiteAttacked && !tf) System.out.println("CHECK");
        else if(!isWhiteAttacked && !tf) System.out.println("NONE");






    }
}
