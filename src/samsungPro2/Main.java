package samsungPro2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by pose2 on 2017-09-09.
 */
public class Main {

    static final long mod = 100000123;
    static long[][] dp;

    public static void main(String args[]) throws IOException{

        dp = new long[4096][4096];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(func(n));
        }

    }
    public static BigInteger func(int n){
        if(n == 0) return BigInteger.ZERO;
        if(n == 1) return BigInteger.valueOf(2);

        BigInteger tmpFunc = func(n-1).pow(2);

        return (BigInteger.valueOf(func_aCb((int)Math.pow(2,n+1)-2,(int)Math.pow(2,n)-1)).multiply(tmpFunc)).mod(BigInteger.valueOf(mod));
    }
    public static long func_aCb(int a, int b){
        if(b == 0) return  1;
        if(a == b) return  1;
        if(dp[a][b] != 0) return dp[a][b];

        return dp[a][b] = (func_aCb(a-1,b-1) + func_aCb(a-1,b))%mod;
    }
}
