import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-06-16.
 */
public class Main {

    static int[] dp;
    static int[] array;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        for(int i = 0; i<N+1; i++){
            dp[i] = -1;
        }


        array = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i<N+1; i++){
            for(int j = 0; j<i; j++){
                int tmp = 0;
               tmp  = Max(i-j)+Max(j);
               dp[i] = (dp[i]>tmp)?dp[i]:tmp;
            }
        }

        System.out.println(dp[N]);


    }
    public static int Max(int k){
        if(k == 0){
            return 0;
        }
        if(dp[k] != -1){
            return dp[k];
        }
        if( k == 1){
            return dp[1] = array[1];
        }

        return array[k];
    }
}
