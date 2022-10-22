import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder n1 = new StringBuilder(st.nextToken());
        StringBuilder n2 = new StringBuilder(st.nextToken());
        n1.reverse();
        n2.reverse();
        StringBuilder sb = new StringBuilder();


        int length = n1.length()-n2.length();


        boolean up = false;
        if(length>0){
            for(int i=0; i<n2.length(); i++){
                int tmp=n1.charAt(i)-'0'+n2.charAt(i)-'0';
                if(up){
                    if(tmp+1<10){
                        up=false;
                        sb.append(tmp+1);
                    }
                    else{
                        sb.append((tmp+1)%10);
                    }
                }
                else{
                    if(tmp<10){
                        sb.append(tmp);
                    }
                    else{
                        up=true;
                        sb.append(tmp%10);
                    }
                }
            }

            for(int i=n2.length(); i<n1.length(); i++){
                if(up){
                    if(n1.charAt(i)=='9') sb.append(0);
                    else{
                        sb.append(n1.charAt(i)-'0'+1);
                        up=false;
                    }
                }
                else{
                    sb.append(n1.charAt(i));
                }
            }
            if(up) sb.append(1);

        }

        if(length<0){
            for(int i=0; i<n1.length(); i++){
                int tmp=n1.charAt(i)-'0'+n2.charAt(i)-'0';
                if(up){
                    if(tmp+1<10){
                        up=false;
                        sb.append(tmp+1);
                    }
                    else{
                        sb.append((tmp+1)%10);
                    }
                }
                else{
                    if(tmp<10){
                        sb.append(tmp);
                    }
                    else{
                        up=true;
                        sb.append(tmp%10);
                    }
                }
            }

            for(int i=n1.length(); i<n2.length(); i++){
                if(up){
                    if(n2.charAt(i)=='9') sb.append(0);
                    else{
                        sb.append(n2.charAt(i)-'0'+1);
                        up=false;
                    }
                }
                else{
                    sb.append(n2.charAt(i));
                }
            }
            if(up) sb.append(1);




        }
        if(length==0) {
            for (int i = 0; i < n1.length(); i++) {
                int tmp = n1.charAt(i) - '0' + n2.charAt(i) - '0';
                if (up) {
                    if (tmp + 1 < 10) {
                        up = false;
                        sb.append(tmp + 1);
                    } else {
                        sb.append((tmp + 1) % 10);
                    }
                } else {
                    if (tmp < 10) {
                        sb.append(tmp);
                    } else {
                        up = true;
                        sb.append(tmp % 10);
                    }
                }
            }
            if (up) sb.append(1);

        }
        System.out.println(sb.reverse());



    }
}