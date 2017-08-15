package BOGGLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 6/15/2017.
 */
public class Main {

    static StringTokenizer st;
    static char map[][] = new char[7][7];
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());

        for (int ts = 0; ts < C; ts++) {
            for (int i = 1; i < 6; i++) {
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                for (int j = 1; j < 6; j++) {
                    map[j][i] = tmp.charAt(j - 1);
                }
            }

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            for (int i2 = 0; i2 < N; i2++) {
                st = new StringTokenizer(br.readLine());
                String tmp1 = st.nextToken();

                Queue<Integer> queue = new LinkedList<Integer>(); // fail 체크용 queue

                System.out.print(tmp1 + " ");

                char starter = tmp1.charAt(0);

                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (map[j][i] == starter) {
                            queue.offer(10 * j + i);
                        }
                    }
                }

                int[][] dp = new int[7][7];
                if (queue.isEmpty()) {
                    System.out.println("NO");
                } else {
                    if (findWord(tmp1, 1, dpInit(dp), queue)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }

    }

    public static boolean findWord(String word, int order, int[][] dp, Queue q) {

        if (order == word.length()) {
            return true;
        }

        //q 안에있는 좌표들을 dp에 반영해서 0으로 만들어준다.

        while (!q.isEmpty()) {
            int tmp = (int) q.poll();
            dp[tmp / 10][tmp % 10] = 0;
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (dp[j][i] == 0) {
                    for (int k = 0; k < 8; k++) {
                        if (word.charAt(order) == map[j + dx[k]][i + dy[k]]) {
                            q.offer((j + dx[k]) * 10 + (i + dy[k]));
                        }
                    }
                }
            }
        }

        dp = dpInit(dp);


        if (q.isEmpty()) {
            return false;
        }

        return findWord(word, order + 1, dp, q);

    }

    public static int[][] dpInit(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[j][i] = -1;
            }
        }

        return dp;
    }


}