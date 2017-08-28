package baek1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by pose2 on 2017-08-26.
 */
public class Main {

    static BigInteger[] dp;

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new BigInteger[252];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for(int i =2; i<251; i++){
            dp[i] = (dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2))));
        }

        while (true){
            String s;
            s= br.readLine();

            if(s == null) break;

            int n = Integer.parseInt(s);

            System.out.println(dp[n]);
        }

    }

}
