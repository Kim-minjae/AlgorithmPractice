package baek2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-06-29.
 */
public class Main {

    static int date = 0;
    static int N;

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+2][N+2];
        int[][] tmpMap = new int[N+2][N+2];

        int MaxHeight = 0;
        int MinHeight = 101;

        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<N+1; j++){
                int tmpA = Integer.parseInt(st.nextToken());
                map[j][i] = tmpA;
                tmpMap[j][i] = tmpA;

                MaxHeight = MaxHeight>map[j][i]?MaxHeight:map[j][i];
                MinHeight = MinHeight<map[j][i]?MinHeight:map[j][i];
            }
        }

        int SafeZoneMaxCount;
        int result = 0;

        date = MinHeight-1;

        while (date<MaxHeight) {
            SafeZoneMaxCount = 0;
            mapRefresh(tmpMap,map);

            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    if(tmpMap[j][i]>date){
                        SafeZoneMaxCount += makeZero(tmpMap,j,i);
                    }
                }
            }
            date++;
            result = result>SafeZoneMaxCount?result:SafeZoneMaxCount;
        }


        System.out.println(result);


    }

    public static int makeZero(int[][] map, int x, int y){

        map[x][y] = 0;

        if(map[x+1][y]>date){
            makeZero(map,x+1,y);
        }
        if(map[x][y+1]>date){
            makeZero(map,x,y+1);
        }
        if(map[x-1][y]>date){
            makeZero(map,x-1,y);
        }
        if(map[x][y-1]>date){
            makeZero(map,x,y-1);
        }

        return 1;
    }
    public static void mapRefresh(int[][] map, int[][] map2){
        for(int i =0; i<map.length; i++){
            for(int j =0; j<map[i].length; j++){
                map[j][i] = map2[j][i];
            }
        }
    }

}
