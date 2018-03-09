package samsungPro6;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2018-01-07.
 */

public class Main {

    static int T, N, m, solution;
    static int D1[][][][];
    static int D2[][][], H[], C[][][];

    public static void main(String args[]) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            for (int test_case = 1; test_case <= T; test_case++) {

                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());

                D1 = new int[N][3][3][3];// i =row위치, r =(i-1,2) p = (i,1) q =(i,1)
                D2 = new int[N][3][3];
                C = new int[N+1][3][3];// 좌표의 개미혀길이
                H = new int[N]; // 높이

                for (int i = 1; i <= N; i++) {
                    st = new StringTokenizer(br.readLine());

                    int t1 = Integer.parseInt(st.nextToken());
                    int t2 = Integer.parseInt(st.nextToken());

                    C[i][1][1] = t1;
                    C[i][1][2] = t2;

                    int t3 = Integer.parseInt(st.nextToken());
                    int t4 = Integer.parseInt(st.nextToken());

                    C[i][2][1] = t3;
                    C[i][2][2] = t4;

                }

                for (int i = 1; i < N; i++) {
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    H[i] = s;
                } // 여기까지 입력

                for (int i = 1; i < N; i++) {
                    for (int j = 0; j < 3; j++) {// 상태 (오른쪽위)
                        for (int k = 0; k < 3; k++) {// 상태 (왼쪽위)
                            for (int uu = 0; uu <= 2; uu++) { // 혀를 위로내밀었을때
                                if (H[i - 1] >= C[i - 1][1][k] + C[i][1][uu]) {
                                    for (int rr = 0; rr <= 2; rr++) {// 오른
                                        if (rr != 0 && rr == uu)
                                            continue;
                                        if (m >= C[i][1][rr]) {
                                            for (int dd = 0; dd <= 2; dd++) {// 아래
                                                if ((dd != 0 && dd == rr || dd != 0
                                                        && dd == uu))
                                                    continue;
                                                if (H[i] >= C[i][1][dd])
                                                    D1[i][dd][rr][j] = Math.max(D1[i][dd][rr][j],D2[i - 1][k][j]+ C[i][1][uu]+ C[i][1][rr]+ C[i][1][dd]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (int j = 0; j < 3; j++) {// 상태 (왼쪽 아래)
                        for (int k = 0; k < 3; k++) {// 상태 (왼쪽)
                            for (int l = 0; l < 3; l++) { // 오른쪽 위
                                for (int uu = 0; uu <= 2; uu++) { // 위
                                    if (H[i - 1] >= C[i - 1][2][1] + C[i][2][uu]) {
                                        for (int rr = 0; rr <= 2; rr++) {// 오른
                                            if (rr != 0 && rr == uu)
                                                continue;
                                            if (m >= C[i][1][k] + C[i][2][rr]) {
                                                for (int dd = 0; dd <= 2; dd++) {// 아래
                                                    if (dd != 0
                                                            && (dd == rr || dd == uu))
                                                        continue;
                                                    if (H[i] >= C[i][2][dd])
                                                        D2[i][j][dd] = Math.max(D2[i][j][dd],D1[i][j][k][l]+ C[i][2][uu]+ C[i][2][rr]+ C[i][2][dd]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                bw.write("#" + test_case + " " + D2[N - 1][2][2] + "\n");

                bw.flush();
            }
    }
}
