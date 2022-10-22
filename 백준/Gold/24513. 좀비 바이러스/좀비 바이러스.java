import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// a,b 바이러스 모두 전파 초기에 표기.
// 동시간대 전파 여부를 위해 list에 저장.
public class Main {
    static List<Integer> list = new ArrayList<>();
    static int n,m,alphaCount,betaCount;
    static int[][] array;
    static Queue<Integer> alphaQueue = new LinkedList<>();
    static Queue<Integer> betaQueue = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j]==1){
                    alphaQueue.add(i);
                    alphaQueue.add(j);
                }
                else if(array[i][j]==2){
                    betaQueue.add(i);
                    betaQueue.add(j);
                }
            }
        }
        alphaCount=1;
        betaCount=1;

        virusTransmission();

        alphaCount=0;
        betaCount=0;
        int gammaCount=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]==1) alphaCount++;
                else if(array[i][j]==2) betaCount++;
                else if(array[i][j]==3) gammaCount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(alphaCount).append(' ').append(betaCount).append(' ').append(gammaCount).append(' ');
        System.out.println(sb);
    }
    
    
    
    public static void virusTransmission(){
        int startI, startJ;
        while(!alphaQueue.isEmpty() || !betaQueue.isEmpty()){
            while(alphaCount!=0 && !alphaQueue.isEmpty()) {
                startI = alphaQueue.poll();
                startJ = alphaQueue.poll();
                if(array[startI][startJ]==3){
                    alphaCount--;
                    continue;
                }
                alphaCount--;
                for (int i = 0; i < 4; i++) {
                    int newI = startI + dx[i];
                    int newJ = startJ + dy[i];
                    if (newI < n && newI >= 0 && newJ < m && newJ >= 0 && array[newI][newJ] == 0) {
                        alphaQueue.add(newI);
                        alphaQueue.add(newJ);
                        array[newI][newJ] = 1;
                        list.add(newI);
                        list.add(newJ);
                    }
                }
            }
            alphaCount = alphaQueue.size()/2;


            while(betaCount!=0 && !betaQueue.isEmpty()){
                startI = betaQueue.poll();
                startJ = betaQueue.poll();
                betaCount--;
                for(int i=0; i<4; i++){
                    int newI = startI+dx[i];
                    int newJ = startJ+dy[i];
                    if(newI<n && newI>=0 && newJ<m && newJ>=0){
                        if(array[newI][newJ]==-1) continue;
                        if(array[newI][newJ]==0){
                            betaQueue.add(newI);
                            betaQueue.add(newJ);
                            array[newI][newJ]=2;
                        }
                        // 3번 바이러스 판단
                        else if(array[newI][newJ]==1) {
                            for(int j=0; j<list.size(); j+=2){
                                if(list.get(j)==newI && list.get(j+1)==newJ){
                                    array[newI][newJ]=3;
                                    break;
                                }
                            }

                        }
                    }
                }


            }
            betaCount = betaQueue.size()/2;
            list.clear();



        }

    }
}
