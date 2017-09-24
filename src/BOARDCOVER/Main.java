package BOARDCOVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-21.
 */
public class Main {

    static char[][] map;


    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            map = new char[H+2][W+2];

            for(int i = 1; i<H+1; i++){
                String tmp = br.readLine();
                for(int j = 1; j<W+1; j++){
                    map[i][j] = tmp.charAt(j-1);
                }
            }
            System.out.println(dfs(0,0));

        }

    }
    public static int dfs(int x, int y){
        if(map[x][y] != '.'){
            while (map[x][y] != '.'){
                if(x == map.length-1 && y == map[0].length-1) return 1;

                if(y<map[0].length-1){
                    y++;
                }else {
                    y = 0;
                    x++;
                }
            }
        }
        int sum = 0;

        if(map[x+1][y+1] == '.' && map[x][y+1] == '.'){
            map[x][y] = map[x+1][y+1] = map[x][y+1] = '#';
            sum += dfs(x,y+1);
            map[x][y] = map[x+1][y+1] = map[x][y+1] = '.';
        }
        if(map[x+1][y] == '.' && map[x+1][y+1] == '.'){
            map[x][y] = map[x+1][y] = map[x+1][y+1] = '#';
            sum += dfs(x,y+1);
            map[x][y] = map[x+1][y] = map[x+1][y+1] = '.';
        }
        if(map[x+1][y] == '.' && map[x][y+1] == '.'){
            map[x][y] = map[x+1][y] = map[x][y+1] = '#';
            sum += dfs(x,y+1);
            map[x][y] = map[x+1][y] = map[x][y+1] = '.';
        }
        if(map[x+1][y] == '.' && map[x+1][y-1] == '.'){
            map[x][y] = map[x+1][y] = map[x+1][y-1] = '#';
            sum += dfs(x,y+1);
            map[x][y] = map[x+1][y] = map[x+1][y-1] = '.';
        }
        return sum;
    }
}