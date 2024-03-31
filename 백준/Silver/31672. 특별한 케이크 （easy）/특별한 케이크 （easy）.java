import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int n = Integer.parseInt(br.readLine());
        boolean[] isExist = new boolean[n+1];
        List<Integer>[] lists = new List[n+1];
        for(int i=1; i<=n; i++){
            lists[i] = new ArrayList<>();
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                lists[i].add(Integer.parseInt(st.nextToken()));
            }
            int flag = Integer.parseInt(br.readLine());
            isExist[i] = flag == 1;
        }

        List<Integer> resList = new ArrayList<>();
        loop:
        for(int lier=1; lier<=n; lier++){
            if(isExist[lier]){
                if(lists[lier].contains(lier)) continue loop;
            }
            else{
                if(!lists[lier].contains(lier)) continue loop;
            }

            for(int i=1; i<=n; i++){
                if(i==lier) continue;
                if(isExist[i] && !lists[i].contains(lier)) continue loop;
                if(!isExist[i] && lists[i].contains(lier)) continue loop;
            }
            resList.add(lier);
        }

        if(resList.size()==0){
            System.out.println("swi");
        }
        else{
            for(int i=0; i<resList.size(); i++){
                System.out.printf("%d ", resList.get(i));
            }
        }















    }
}
