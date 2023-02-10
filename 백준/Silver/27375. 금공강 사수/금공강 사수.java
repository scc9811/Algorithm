import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, k, arr[][], resCount;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        resCount = 0;
        // day, startT, endT
        arr = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[0]==o2[0]){
                if(o1[1]==o2[1]) return Integer.compare(o1[2], o2[2]);
                else return Integer.compare(o1[1], o2[1]);
            }
            else return Integer.compare(o1[0], o2[0]);
        }));
        back(0, 1, 0, 0);
        System.out.println(resCount);






    }
    public static void back(int startId, int startDay, int startTime, int score){
        if(score==k){
            resCount++;
            return;
        }
        else if(score>k || startDay==5) return;
        for(int i=startId; i<n; i++){
            if(arr[i][0]==5) continue;
            if(startDay<arr[i][0] || (startDay==arr[i][0] && startTime<arr[i][1])){
                score += arr[i][2]-arr[i][1]+1;
                if(arr[i][2]==10) back(i+1, arr[i][0]+1, 0, score);
                else back(i+1, arr[i][0], arr[i][2], score);
                score -= arr[i][2]-arr[i][1]+1;
            }

        }


    }
}
