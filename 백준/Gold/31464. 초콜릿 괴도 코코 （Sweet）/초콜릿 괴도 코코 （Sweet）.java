import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

//        int[][] friends = new int[n][n];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(arr[i][j]=='#'){
//                    int count = 0;
//                    if(i<n-1 && arr[i+1][j]=='#') count++;
//                    if(j<n-1 && arr[i][j+1]=='#') count++;
//                    if(i>0 && arr[i-1][j]=='#') count++;
//                    if(j>0 && arr[i][j-1]=='#') count++;
//                    friends[i][j] = count;
//                }
//            }
//        }
        List<Point> list = new ArrayList<>();


        for(int i=0; i<n; i++){
            loop:
            for(int j=0; j<n; j++){


                if(arr[i][j]=='#'){
                    arr[i][j] = '.';
                    boolean[][] visited = new boolean[n][n];
                    boolean flag = false;
                    for(int k=0; k<n; k++){
                        for(int l=0; l<n; l++){
                            if(arr[k][l]=='#' && !visited[k][l]){
                                if(flag) {
                                    arr[i][j] = '#';
                                    continue loop;
                                }
                                Queue<Point> queue = new LinkedList<>();
                                queue.add(new Point(k, l, -1, -1));
                                visited[k][l] = true;
                                while(!queue.isEmpty()){
                                    Point curP = queue.poll();
                                    for(int d=0; d<4; d++){
                                        int newI = curP.x + dx[d];
                                        int newJ = curP.y + dy[d];
                                        if(newI>=0 && newI<n && newJ>=0 && newJ<n && arr[newI][newJ]=='#'){
                                            if(visited[newI][newJ] && (newI!=curP.lastX || newJ!=curP.lastY)){
                                                arr[i][j] = '#';
                                                continue loop;
                                            }
                                            if(!visited[newI][newJ]){
                                                queue.add(new Point(newI, newJ, curP.x, curP.y));
                                                visited[newI][newJ] = true;
                                            }
                                        }
                                    }
                                }



                                flag = true;
                            }

                        }
                    }


                    list.add(new Point(i, j, -1, -1));
                    arr[i][j] = '#';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).x+1).append(' ').append(list.get(i).y+1).append('\n');
        }
        System.out.println(sb);
















    }
    static class Point{
        int x, y, lastX, lastY;
        Point(int x, int y, int lastX, int lastY){
            this.x = x;
            this.y = y;
            this.lastX = lastX;
            this.lastY = lastY;
        }
    }
}