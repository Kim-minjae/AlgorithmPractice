package softwareExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3319 {

    static int[][] combinationCache;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

//            combinationCache = new int[][];
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            Queue<MyungWoo> myungWooQueue = new LinkedList<>();

            MyungWoo start = new MyungWoo(0,0,x);
            myungWooQueue.offer(start);

            int result = 0;

            while (!myungWooQueue.isEmpty()){

                MyungWoo tmpMyungWoo = myungWooQueue.poll();

                if(tmpMyungWoo.d > d) continue;
                if(tmpMyungWoo.n == n){
                    result += combination(d,tmpMyungWoo.d);
                }


            }

        }

    }
    static class MyungWoo{

        private int n;
        private int d;
        private int x;

        public MyungWoo(int n, int d, int x) {
            this.n = n;
            this.d = d;
            this.x = x;
        }

    }
    public static int combination(int n, int r){
        if(r == 0 || r == n) return 1;



        int result = combination(n-1,r-1)%1000000007 + + combination(n,r-1)%1000000007;

        return  result;
    }
}
