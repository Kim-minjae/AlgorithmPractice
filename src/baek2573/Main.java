package baek2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-31.
 */
public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] backup;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        backup = new int[n][m];

        int max = 0;

        for(int i =0; i<n; i++){

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<m; j++){
                int tmpInt = Integer.parseInt(st.nextToken());
                map[i][j] = tmpInt;
                backup[i][j] = tmpInt;
                max = Math.max(max,tmpInt);
            }
        }

        int year = 0;
        int blockCount = 1;
        while (true){

            for(int x = 0; x<map.length; x++) {
                map[x] = backup[x].clone();
            }
            blockCount = blockCounter();
            if(blockCount == 0){
                System.out.println(0);
                return;
            }
            if(blockCount>1){
                break;
            }

            backup = water(backup);
            year++;
        }

        System.out.println(year);
    }
    public static int[][] water(int[][] map){

        int[][] map2 = new int[map.length][map[0].length];

        for(int i = 1; i<map.length-1;i++){
            for(int j = 1; j<map[0].length; j++){
                if(map[i][j] != 0) {
                    int tmp = map[i][j];
                    for (int k = 0; k < 4; k++) {

                        if(map[i+dx[k]][j+dy[k]] == 0){
                            tmp--;
                        }
                    }
                    if(tmp<0){
                        tmp = 0;
                    }

                    map2[i][j] = tmp;
                }
            }
        }
        return map2;
    }
    public static int blockCounter(){

        int tmpMap[][] = new int[map.length][map[0].length];

        for(int i = 0; i<map.length; i++){
            tmpMap[i] = map[i].clone();
        }

        int count  =0;
        for(int i =1; i<tmpMap.length-1; i++){
            for(int j =1; j<tmpMap[0].length; j++){
                if(tmpMap[i][j] != 0){
                    makeZero(tmpMap,i,j);
                    count++;
                    if(count>1){
                        return 2;
                    }
                }
            }
        }
        return count;
    }
    public static void makeZero(int[][] tmpmap, int x,int y){
        tmpmap[x][y] = 0;

        for(int i = 0; i<4; i++){
            if(tmpmap[x+dx[i]][y+dy[i]] > 0){
                makeZero(tmpmap,x+dx[i],y+dy[i]);
            }
        }
    }
}

