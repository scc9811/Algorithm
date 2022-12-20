import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minX = (int) 1e9;
        int minY = (int) 1e9;
        int maxX = -1;
        int maxY = -1;
        int count = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(s.charAt(j)=='G'){
                    count++;
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int x1 = n-minX-1;
        int x2 = maxX;
        int y1 = n-minY-1;
        int y2 = maxY;


//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(y1);
//        System.out.println(y2);

        if(count==1) System.out.println(0);
//        else System.out.println(Math.min(x1, x2)+Math.min(y1, y2));

        else if(minX==maxX) System.out.println(Math.min(y1,y2));
        else if(minY==maxY) System.out.println(Math.min(x1,x2));
        else System.out.println(Math.min(x1, x2) + Math.min(y1, y2));






    }
}

