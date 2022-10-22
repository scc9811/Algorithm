import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int size;
    static char[][] array;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        array = new char[size][size];
        boolean[][] tfArray = new boolean[size][size];
        for (int i = 0; i < size; i++) 
            array[i] = br.readLine().toCharArray();
        

        System.out.println(ordinary_person(tfArray));
        
        for(int i=0; i<size; i++)
            Arrays.fill(tfArray[i],false);
        
        System.out.println(red_green_person(tfArray));



    }

    public static int ordinary_person(boolean[][] tfArray) {
        int count = 0;
        while (true) {
            boolean tf = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!tfArray[i][j]) {
                        queue.add(i);
                        queue.add(j);
                        tfArray[i][j] = true;
                        tf = true;
                        break;
                    }
                }
                if (tf) break;
            }
            if (!tf) return count;
            count++;
            while (!queue.isEmpty()) {
                int startI = queue.poll();
                int startJ = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if (newI < size && newI >= 0 && newJ < size && newJ >= 0 && !tfArray[newI][newJ]) {
                        if (array[startI][startJ] == array[newI][newJ]) {
                            queue.add(newI);
                            queue.add(newJ);
                            tfArray[newI][newJ] = true;
                        }
                    }
                }


            }

        }

    }

    public static int red_green_person(boolean[][] tfArray) {
        int count = 0;
        while (true) {
            boolean tf = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!tfArray[i][j]) {
                        queue.add(i);
                        queue.add(j);
                        tfArray[i][j] = true;
                        tf = true;
                        break;
                    }
                }
                if (tf) break;
            }
            if (!tf) return count;
            count++;
            while (!queue.isEmpty()) {
                int startI = queue.poll();
                int startJ = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if (newI < size && newI >= 0 && newJ < size && newJ >= 0 && !tfArray[newI][newJ]) {
                        int tmp = Math.abs(array[startI][startJ]-array[newI][newJ]);
                        if(tmp==11 || tmp==0){
                            queue.add(newI);
                            queue.add(newJ);
                            tfArray[newI][newJ]=true;
                        }
                    }


                }

            }
        }
    }
}