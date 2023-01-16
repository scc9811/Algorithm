import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 4000]++;
        }
        long sum = 0;
        int max = -5000;
        int min = -5000;
        // 최빈값
        int maxCount = 0;
        int mC = -5000;

        int count = 0;
        int middle = -5000;
        for (int i = 0; i < 8001; i++) {
            if (arr[i] == 0) continue;

            if (min == -5000) min = i - 4000;
            count += arr[i];
            max = i - 4000;
            sum += (long) (i - 4000) * arr[i];

            if (arr[i] > maxCount) {
                maxCount = arr[i];
            }
            if (middle == -5000 && count > n / 2) {
                middle = i - 4000;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<8001; i++){
            if(arr[i]==maxCount) list.add(i-4000);
        }
        Collections.sort(list);
        if(list.size()==1) mC = list.get(0);
        else mC = list.get(1);

        

        System.out.println(Math.round(sum / (double) n));
        System.out.println(middle);
        System.out.println(mC);
        System.out.println(max - min);


    }
}