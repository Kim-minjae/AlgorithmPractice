package baek11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] karray;
    private static int[][][] dp;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 0 ; t<tc; t++){

            int knum = Integer.parseInt(br.readLine());
            dp = new int[knum][knum][2];
            karray = new int[knum];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<knum; i++){
                karray[i] = Integer.parseInt(st.nextToken());
            }

            int result = function(0,knum-1);

            System.out.println(result);

        }

    }

    public static int function(int from, int to){

        if(from == to){
            dp[from][to][0] = karray[from];
            return 0;
        }
        if(dp[from][to][1] != 0) return dp[from][to][1];

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for(int i = from; i<to; i++){

            a = function(from,i);
            b = function(i+1,to);
            dp[from][to][0] = dp[from][i][0] + dp[i+1][to][0];
            min = Math.min(min, a + b + dp[from][i][0] + dp[i+1][to][0]);
        }

        return dp[from][to][1] = min;
    }
}
