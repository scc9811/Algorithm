import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(BFS(new Board(arr)));




    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int BFS(Board startB){
        if(get_boardNumber(startB)==87654321) return 0;
        // 87654321
        Queue<Board> queue = new LinkedList<>();
        Set<Integer> set = new LinkedHashSet<>();
        set.add(get_boardNumber(startB));
        queue.add(startB);
        int tmp = 1;
        int count = 0;
        while(!queue.isEmpty()){
            tmp--;
            if(tmp==0){
                count++;
                tmp = queue.size();
            }
            int[][] b = queue.poll().arr;
//            for(int i=0; i<3; i++){
//                System.out.println(Arrays.toString(b[i]));
//            }
//            System.out.println();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(b[i][j]==0){
                        for(int k=0; k<4; k++){
                            int newI = i+dx[k];
                            int newJ = j+dy[k];
                            if(newI>=0 && newI<3 && newJ>=0 && newJ<3){
                                b[i][j] = b[newI][newJ];
                                b[newI][newJ] = 0;
                                int boardNumber = get_boardNumber(new Board(b));
                                if(boardNumber==87654321) return count;
                                else if(!set.contains(boardNumber)){
                                    set.add(boardNumber);
                                    queue.add(new Board(new int[][] {{b[0][0], b[0][1], b[0][2]},
                                            {b[1][0], b[1][1], b[1][2]},
                                            {b[2][0], b[2][1], b[2][2]}}));
                                }
                                b[newI][newJ] = b[i][j];
                                b[i][j] = 0;
                            }
                        }
                    }
                }
            }






        }
        return -1;
    }
    static int get_boardNumber(Board board){
        int ret = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                ret += board.arr[i][j] * Math.pow(10, i*3+j);
            }
        }
        return ret;
    }
    static class Board{
        int[][] arr;
        Board(int[][] arr){
            this.arr = arr;
        }
    }
}
