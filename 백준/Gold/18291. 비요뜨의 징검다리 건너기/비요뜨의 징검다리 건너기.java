import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){

            bw.write(String.valueOf(pow(Integer.parseInt(br.readLine())-2)));
            bw.write('\n');
        }
        bw.close();




    }
    public static long pow(long depth){
        if(depth<=0) return 1;

        long tmp = pow(depth/2);
        if(depth%2 == 0) return (tmp * tmp)%1000000007;
        else return (tmp*tmp*2)%1000000007;
    }

}