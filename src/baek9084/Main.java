package baek9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-06-17.
 */
public class Main {

    static int[] dp;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int ts = 0; ts<T; ts++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int coin[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            dp = new int[M+coin[N-1]+1];
            dp[0] = 1;
            for(int j = 0; j<N; j++){
                for(int i = 0; i<M+1; i++) {

                    if(i-coin[j]<0){
                        continue;
                    }

                    dp[i] += dp[i-coin[j]];

                }
            }

            System.out.println(dp[M]);

        }

    }

}
