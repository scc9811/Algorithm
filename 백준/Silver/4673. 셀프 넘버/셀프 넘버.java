public class Main {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        boolean[] array = new boolean[10001];
        for (int i=1; i<10000; i++){
            int n=i;
            while(true){
                n = d(n);
                if(n>10000 || array[n]) break;
                array[n]=true;
            }
        }

        for (int i=1; i<10001; i++){
            if(!array[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);



    }
    static int d(int n){
        int sum=n;
        for (int i=0; i<5; i++){
            sum += n%10;
            n /=10;
        }

        return sum;
    }
}

