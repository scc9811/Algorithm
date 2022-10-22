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
        int sum = 0;
        int index1=0;
        for (int i=0; i<N; i++){
            if(array[i]>=0){
                index1 = i;
                break;
            }
        }
        for (int i=0; i<index1-1; i +=2){
            sum += array[i]*array[i+1];
        }
        if (index1%2==1 && array[index1]!=0) sum+= array[index1-1];

        for (int i=index1; i<N; i++){
            if (array[i]==0 || array[i] ==1) sum += array[i];
            else{
                index1 = i;
                break;
            }
            index1 = N;
        }


        for (int i=N-1; i>index1; i -=2){
            sum += array[i]*array[i-1];
        }
        if ((N-index1)%2==1){
            sum += array[index1];
        }

        System.out.println(sum);







    }
}
