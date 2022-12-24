import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n,  maxBlock;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxBlock = 0;
        for(int i=0; i<4; i++){
            int[][] tmp = new int[n][n];
            for(int j=0; j<n; j++){
                tmp[j] = Arrays.copyOf(arr[j], n);
            }
            back(0,i, tmp);
        }
        System.out.println(maxBlock);










    }
    public static void back(int depth, int direction, int[][] array){
        if(depth==5){
            for(int i=0; i<n; i++){
//                System.out.println(Arrays.toString(array[i]));
                for(int j=0; j<n; j++){
                    maxBlock = Math.max(array[i][j], maxBlock);
                }
            }
//            System.out.println();
            return;
        }
        move(direction, array);

        for(int i=0; i<4; i++){
            int[][] tmp = new int[n][n];
            for(int j=0; j<n; j++){
                tmp[j] = Arrays.copyOf(array[j], n);
            }
            back(depth+1, i, tmp);
        }










    }
    public static void move(int direction, int[][] arr){
//        int zeroCount = 0;
//        int lastNum = 0;
        //up
        if(direction==0){
            for(int j=0; j<n; j++){
                List<Integer> list = new ArrayList<>();
                int lastNum = 0;
                for(int i=0; i<n; i++){
                    if(arr[i][j]!=0){
                        if(lastNum==0){
                            lastNum = arr[i][j];
                        }
                        else if(arr[i][j]==lastNum){
                            list.add(lastNum*2);
                            lastNum = 0;
                        }
                        else{
                            list.add(lastNum);
                            lastNum = arr[i][j];
                        }
                    }
                    arr[i][j] = 0;
                }
                for(int i=0; i<list.size(); i++){
                    arr[i][j] = list.get(i);
                }
                arr[list.size()][j] = lastNum;
            }


        }
        //down
        else if(direction==1){
                for(int j=0; j<n; j++){
                List<Integer> list = new ArrayList<>();
                int lastNum = 0;
                for(int i=n-1; i>=0; i--){
                    if(arr[i][j]!=0){
                        if(lastNum==0){
                            lastNum = arr[i][j];
                        }
                        else if(arr[i][j]==lastNum){
                            list.add(lastNum*2);
                            lastNum = 0;
                        }
                        else{
                            list.add(lastNum);
                            lastNum = arr[i][j];
                        }
                    }
                    arr[i][j] = 0;
                }
                for(int i=0; i<list.size(); i++){
                    arr[n-1-i][j] = list.get(i);
                }
                arr[n-1-list.size()][j] = lastNum;
            }
        }
        //left
        else if(direction==2){
            for(int i=0; i<n; i++){
                List<Integer> list = new ArrayList<>();
                int lastNum = 0;
                for(int j=0; j<n; j++){
                    if(arr[i][j]!=0){
                        if(lastNum==0){
                            lastNum = arr[i][j];
                        }
                        else if(arr[i][j]==lastNum){
                            list.add(lastNum*2);
                            lastNum = 0;
                        }
                        else{
                            list.add(lastNum);
                            lastNum = arr[i][j];
                        }
                    }
                    arr[i][j] = 0;
                }
                for(int j=0; j<list.size(); j++){
                    arr[i][j] = list.get(j);
                }
                arr[i][list.size()] = lastNum;
            }





        }
        //right
        else if(direction==3){
            for(int i=0; i<n; i++){
                List<Integer> list = new ArrayList<>();
                int lastNum = 0;
                for(int j=n-1; j>=0; j--){
                    if(arr[i][j]!=0){
                        if(lastNum==0){
                            lastNum = arr[i][j];
                        }
                        else if(arr[i][j]==lastNum){
                            list.add(lastNum*2);
                            lastNum = 0;
                        }
                        else{
                            list.add(lastNum);
                            lastNum = arr[i][j];
                        }
                    }
                    arr[i][j] = 0;
                }
                for(int j=0; j<list.size(); j++){
                    arr[i][n-1-j] = list.get(j);
                }
                arr[i][n-1-list.size()] = lastNum;
            }





        }



    }
}
