    package baek1520;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    /**
     * Created by pose2 on 2017-09-07.
     */
    public class Main {
        static int M;
        static int N;
        static int[][]map;
        static int[][]dp;
        static int[] dx = {0,1,0,-1};
        static int[] dy = {-1,0,1,0};
        public static void main(String args[])throws IOException{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

             M = Integer.parseInt(st.nextToken());
             N = Integer.parseInt(st.nextToken());

            dp = new int[M+2][N+2];

            for(int i = 0 ; i<M+2;i++){
                Arrays.fill(dp[i],-1);
            }

            //도착지점을 M,N으로 잡음
            map = new int[M+2][N+2];

            Arrays.fill(map[0],Integer.MIN_VALUE);
            Arrays.fill(map[M+1],Integer.MIN_VALUE);
            for(int i = 0; i<M+2; i++){
                map[i][N+1]= Integer.MIN_VALUE;
                map[i][0]=Integer.MIN_VALUE;
            }
            for(int i = 1; i<M+1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j<N+1; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = 1;

            System.out.println(dfs(M,N));

        }
        public static int dfs(int i, int j){

            if(i == 1 && j==1) return 1;
            if(dp[i][j] != -1) return dp[i][j];
            int sum = 0;
            for(int k = 0; k<4;k++){
                if(map[i][j] < map[i+dx[k]][j+dy[k]]){
                    sum += dfs(i+dx[k],j+dy[k]);
                }
            }
            return dp[i][j] = sum;
        }
    }