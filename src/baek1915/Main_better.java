package baek1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-15.
 */
public class Main_better {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //입력을 받으면서 할 수  있다.

        int dp[][] = new int[m+1][n+1];
        int max = 0;

        for(int i = 1; i<n+1; i++){
            String tmp = br.readLine();
            for(int j = 1; j<m+1; j++){
                dp[j][i] = tmp.charAt(j-1) - 48;

                if(dp[j][i] == 1){
                    dp[j][i] = Math.min(dp[j-1][i],Math.min(dp[j-1][i-1],dp[j][i-1]))+1;
                    max = Math.max(dp[j][i], max);
                }

            }
        }

        System.out.println(max*max);

    }
}
