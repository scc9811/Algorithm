import java.util.*;
import java.io.*;


public class Main {
    static int n, m, arr[][], res[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }


        int areaNumber = 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    map.put(areaNumber, areaSize(areaNumber++, new Point(i, j)));
                }
            }
        }


        res = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==1){
                    res[i][j] = 1;
                    Set<Integer> areaNumberSet = new LinkedHashSet<>();
                    for(int k=0; k<4; k++){
                        int newI = i + dx[k];
                        int newJ = j + dy[k];
                        if(newI>=0 && newI<n && newJ>=0 && newJ<m && !areaNumberSet.contains(arr[newI][newJ])){
                            res[i][j] += map.get(arr[newI][newJ]);
                            areaNumberSet.add(arr[newI][newJ]);
                        }
                    }
                    res[i][j] %= 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(res[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);







    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int areaSize(int areaNumber, Point startP){
        Queue<Point> queue = new LinkedList<>();
        arr[startP.i][startP.j] = areaNumber;
        queue.add(startP);
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Point curP = queue.poll();
            for(int i=0; i<4; i++){
                int newI = curP.i + dx[i];
                int newJ = curP.j + dy[i];
                if(newI>=0 && newI<n && newJ>=0 && newJ<m && arr[newI][newJ]==0){
                    arr[newI][newJ] = areaNumber;
                    queue.add(new Point(newI, newJ));
                }
            }
        }


        return count;
    }
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}


