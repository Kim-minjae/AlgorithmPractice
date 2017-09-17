package baek14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-12.
 */
public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static int[][] map;
    static boolean[][] visit;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+6][m+6];
        visit = new boolean[n+6][m+6];

        for(int i = 3; i<n+3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 3; j<m+3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for(int i = 3; i<n+3; i++){
            for(int j = 3; j<m+3; j++){
                visit[i][j] = true;
                max = Math.max(Math.max(dfs_1(i,j,1),dfs_2(i,j)),max);
                visit[i][j] = false;

            }
        }

        System.out.println(max);

    }
    public static int dfs_1(int x, int y, int count){

        if(count == 4) return map[x][y];

        int sum = map[x][y];
        int tmp = 0;
        for(int i = 0; i<4; i++){
            if(!visit[x+dx[i]][y+dy[i]]){
                visit[x+dx[i]][y+dy[i]] = true;
                tmp = Math.max(tmp, dfs_1(x + dx[i], y + dy[i], count+1));
                visit[x+dx[i]][y+dy[i]] = false;
            }
        }

        return sum+tmp;
    }

    public static int dfs_2(int x,int y){

        int sum = map[x][y];
        for(int i = 0; i<4; i++){
            sum += map[x+dx[i]][y+dy[i]];
        }
        int tmp = Integer.MAX_VALUE;
        for(int i = 0; i<4; i++){
            tmp = Math.min(tmp,map[x+dx[i]][y+dy[i]]);
        }
        return sum-tmp;
    }
}
