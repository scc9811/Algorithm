import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static int[] opArray = new int[4];
    static int min,max,n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[n];
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++){
            opArray[i] = Integer.parseInt(st.nextToken());
        }


        min = 1000000000;
        max = -1000000000;
        function(array[0],0);
        System.out.println(max);
        System.out.println(min);




    }
    public static void function(int k, int depth){
        if(depth==n-1) {
            max = Math.max(max,k);
            min = Math.min(min,k);
            return;
        }
        for (int i=0; i<n; i++) {
            // i=0이면 첫번째, i=1이면 두번째 operators 로 계산.
            int tmp=i;
            for(int j=0; j<4; j++){
                tmp -= opArray[j];
                if(tmp<0) {
                    if(j==0) {
                        opArray[0]--;
                        function(k+array[depth+1],depth+1);
                        opArray[0]++;
                    }
                    else if(j==1){
                        opArray[1]--;
                        function(k-array[depth+1],depth+1);
                        opArray[1]++;
                    }
                    else if(j==2){
                        opArray[2]--;
                        function(k*array[depth+1],depth+1);
                        opArray[2]++;
                    }
                    else if(j==3){
                        opArray[3]--;
                        function(k/array[depth+1],depth+1);
                        opArray[3]++;
                    }
                    break;
                }
            }

        }


    }
}
