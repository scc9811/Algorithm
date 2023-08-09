import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int idx = -1;
        Set<String> set = new LinkedHashSet<>();
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
            set.add(arr[i]);
            if(arr[i].equals("?")){
                idx = i;
            }
        }

        int k = Integer.parseInt(br.readLine());
        String[] res = new String[k];
        for(int i=0; i<k; i++){
            res[i] = br.readLine();
        }
        if(n==1){
            System.out.println(res[0]);
            System.exit(0);
        }

        if(idx==0){
            char end = arr[1].charAt(0);
            for(int i=0; i<k; i++){
                if(res[i].charAt(res[i].length()-1) == end && !set.contains(res[i])){
                    System.out.println(res[i]);
                    System.exit(0);
                }
            }
        }
        else if(idx==n-1){
            char start = arr[n-2].charAt(arr[n-2].length()-1);
            for(int i=0; i<k; i++){
                if(res[i].charAt(0) == start && !set.contains(res[i])){
                    System.out.println(res[i]);
                    System.exit(0);
                }
            }
        }
        else{
            char start = arr[idx-1].charAt(arr[idx-1].length()-1);
            char end = arr[idx+1].charAt(0);
            for(int i=0; i<k; i++){
                if(res[i].charAt(0) == start && res[i].charAt(res[i].length()-1) == end && !set.contains(res[i])){
                    System.out.println(res[i]);
                    System.exit(0);
                }
            }
        }





    }
}