import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i=0; i<N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        int sum =0;
        int size = N;
        while(size >1 ){
            int index = 0;
            int k = array[0]+array[1];
            sum += k;
            for (int i=2; i<N; i++){
                if(array[i]>=k){
                    array[i-2] = k;
                    index = i;
                    break;
                }
                array[i-2] = array[i];
            }
            if (index==0) array[size-2] = k;
            else {
                for (int i=index; i<N; i++){
                    array[i-1] = array[i];
                }
            }
            size--;

//            for (int i=1; i<size-1; i++){
//                array[i] = array[i+1];
//            }
//            size--;
//            Arrays.sort(array,0,size);
        }
        System.out.println(sum);



    }
}
