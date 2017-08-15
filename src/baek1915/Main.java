package baek1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-15.
 */
public class Main {

    static int[][] map;
    static int[][] dp;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        map = new int[m][n];
        dp = new int[m][n];

        for(int j = 0; j<n; j++){
            String stringTmp = br.readLine();
            for(int i = 0; i<m; i++){
                map[i][j] = stringTmp.charAt(i)-48;
            }
        }

        int go = 0;
        int size = 0;

        while (go<m*n){

            if(map[go%m][go/m] == 1) {
                if (findSq(go % m, go / m, size)) {
                    go += m+ 1;
                    size++;
                    continue;
                }
            }

            go++;

        }

        System.out.println((size)*(size));

    }

    /*
    기본설명 :
    x,y에서 왼쪽과 위쪽에 size의 길이를 더한만큼의 선분이 모두 1인지 체크하고,
    맞으면 x,y의 좌표에서 각각 1 뺀값만큼의 위치에서 다시 findSq를 호출한것이 true인지 확인한다.

    예외체크 :
    x -size값 또는 y - size값이 map을 벗어나는 범위라면 false를 리턴해준다.
    만약 size가 0이라면 1인지만 확인하고 dp에 매핑해준후 boolean 값을 반환한다.
    만약 dp값이 사이즈보다 큰 값이라면 true를 리턴해준다.
    만약 x,y의 값이 0 이라면 리턴해준다. */
    public static boolean findSq(int x, int y, int size){
        boolean result = false;

        if(map[x][y] == 0)return false;
        if(x-size<0 || y-size<0) return false;

        if(size == 0){
            if(map[x][y] == 1){
                dp[x][y] = 1;
                return true;
            }else {
                return false;
            }
        }

        if(dp[x][y] > size) return true;

        if(findSq(x-1,y-1,size-1) &&findInverted_L(x,y,size)){
            dp[x][y] = size+1;
            return true;
        }

        return result;
    }

    public static boolean findInverted_L(int x, int y , int size){
        boolean result = false;

        if(x-size<0 || y-size<0) return result;

        for(int i = 1; i<=size; i++){
            if(map[x-i][y] == 0 || map[x][y-i] == 0) return result;
        }

        return result = true;
    }
}
