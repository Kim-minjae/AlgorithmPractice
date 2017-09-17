package baek1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-09.
 */
public class Main {

    static long[][] dp;

    public static void main(String argsp[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][31];
        int tc = Integer.parseInt(br.readLine());


        for(int t = 0; t<tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int  n = Integer.parseInt(st.nextToken());
            int  m = Integer.parseInt(st.nextToken());

            System.out.println(selectBridge(m,n));

        }

    }
    public static long selectBridge(int m , int n){

        if(n ==1) return m;
        if(n == m) return 1;
        if(dp[m][n] != 0) return dp[m][n];

        return dp[m][n] = selectBridge(m-1,n-1)+selectBridge(m-1,n);
    }
}
