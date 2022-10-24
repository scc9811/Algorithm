import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(br.readLine());
        int[][] array = new int[meetingCount][2];
        for (int i=0; i<meetingCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array, (o1, o2) -> {
            if (o1[1]==o2[1]){
                return Integer.compare(o1[0],o2[0]);
            }
            else{
                return Integer.compare(o1[1],o2[1]);
            }
        });

        int max = 1;
        int maxIndex = array[0][1];
        for (int i=1; i<meetingCount; i++){
            if (array[i][0] >= maxIndex) {
                if(array[i][0] == array[i][1]) maxIndex = array[i-1][1];
                else maxIndex = array[i][1];
                max++;
            }

        }
        System.out.println(max);
    }
}
