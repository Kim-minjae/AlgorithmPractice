/*
package LGNO2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

*/
/**
 * Created by pose2 on 2017-09-29.
 *//*

public class Main2 {

    private static char[][] map;
    private static int[][][] dpMap;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fileOutputStream);
        System.setOut(ps);


        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {

            int n = Integer.parseInt(br.readLine());

            map = new char[n + 2][n + 2];
            dpMap = new int[n + 2][n + 2][2];

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        dpMap[i][j][k] = -1;
                    }
                }
            }

            for (int i = 0; i < n + 2; i++) {
                dpMap[i][0][0] = dpMap[i][0][1] = -2;
                dpMap[i][n + 1][0] = dpMap[i][n + 1][1] = -2;
            }

            for (int j = 0; j < n + 2; j++) {
                dpMap[0][j][0] = dpMap[0][j][1] = -2;
                dpMap[n + 1][j][0] = dpMap[n + 1][j][1] = -2;
            }


            for (int i = 1; i < n + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j < n + 1; j++) {

                    map[i][j] = st.nextToken().charAt(0);

                }
            }

            Queue<Bird> queue = new LinkedList<>();

            if(map[n][1])

            Bird upBird = new Bird(n,1,)

        }
    }
    static class Bird{

        int x;
        int y;
        int bCount;
        int direction;

        public Bird(int x, int y, int bCount, int direction) {
            this.x = x;
            this.y = y;
            this.bCount = bCount;
            this.direction = direction;
        }

    }
}
*/
