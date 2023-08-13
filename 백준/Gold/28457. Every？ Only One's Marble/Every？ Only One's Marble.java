import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        Node[] goldCards = new Node[g];
        int goldCardPointer = 0;
        for(int i=0; i<g; i++){
            st = new StringTokenizer(br.readLine());
            goldCards[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 0 : 특수, -1  : 황금열쇠, else : 땅 가격
        int[] board = new int[4*n - 4];
        for(int i=0; i<4*n-4; i++){
            if(i==0 || i==n-1 || i==2*(n-1) || i==3*(n-1)) i++;
            st = new StringTokenizer(br.readLine());
            char flag = st.nextToken().charAt(0);
            if(flag == 'G') board[i] = -1;
            else{
                board[i] = Integer.parseInt(st.nextToken());
            }
        }

        int I = Integer.parseInt(br.readLine());
        int bind = 0;

        int bank = 0;
        int curLoc = 0;




        // 0 : 시작지점, n-1 : 무인도, 2*(n-1) : 사회복지기금, 3*(n-1) : 우주여행
        for(int i=0; i<I; i++){
//            System.out.println(Arrays.toString(board));
//            System.out.println("bank = "+bank);
//            System.out.println("curLoc = "+curLoc);
//            System.out.println("Money = "+s);
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int scd = Integer.parseInt(st.nextToken());
            if(bind != 0){
                if(fst == scd) {
                    bind = 0;
                    continue;
                }
                bind--;
                continue;
            }
            curLoc += fst + scd;
            if(curLoc >= 4*n-4){
                s += w*(curLoc/(4*n-4));
                curLoc = curLoc%(4*n-4);
            }

            // 특수지점
            if(board[curLoc]==0){
                if(curLoc==0) continue;
                else if(curLoc==n-1){
                    bind = 3;
                }
                else if(curLoc==2*(n-1)){
                    s += bank;
                    bank = 0;
                }
                else if(curLoc==3*(n-1)){
                    curLoc = 0;
                    s += w;
                }
                else{
                    System.out.println("error");
                }
            }
            // 황금열쇠
            else if(board[curLoc] == -1){
                Node node = goldCards[goldCardPointer];
                if(node.flag==1){
                    s += node.x;
                }
                else if(node.flag==2){
                    s -= node.x;
                    if(s < 0){
                        System.out.println("LOSE");
                        System.exit(0);
                    }
                }
                else if(node.flag==3){
                    s -= node.x;
                    if(s < 0){
                        System.out.println("LOSE");
                        System.exit(0);
                    }
                    bank += node.x;
                }
                else if(node.flag==4){
                    curLoc += node.x;
                    if(curLoc >= 4*n-4){
                        s += w*(curLoc/(4*n-4));
                        curLoc = curLoc%(4*n-4);
                    }

                    // 특수지점
                    if(board[curLoc]==0){
                        if(curLoc==0) continue;
                        else if(curLoc==n-1){
                            bind = 3;
                        }
                        else if(curLoc==2*(n-1)){
                            s += bank;
                            bank = 0;
                        }
                        else if(curLoc==3*(n-1)){
                            curLoc = 0;
                            s += w;
                        }
                        else{
                            System.out.println("error");
                        }
                    }
                    else if(board[curLoc] != -2){
                        if(s >= board[curLoc]){
                            s -= board[curLoc];
                            board[curLoc] = -2;
                        }
                    }
                }
                else{
                    System.out.println("error");
                }
                goldCardPointer = (goldCardPointer+1)%g;
            }

            // 일반 지역
            else if(board[curLoc] != -2){
                if(s >= board[curLoc]){
                    s -= board[curLoc];
                    board[curLoc] = -2;
                }
            }
        }
//        System.out.println(Arrays.toString(board));
        for(int i=0; i<4*n-4; i++){
            if(board[i] > 0){
                System.out.println("LOSE");
                System.exit(0);
            }
        }

        System.out.println("WIN");






    }
    static class Node{
        int flag, x;
        Node(int flag, int x){
            this.flag = flag;
            this.x = x;
        }
    }
}
