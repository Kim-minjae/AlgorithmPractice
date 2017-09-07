package samsungMulticampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-05.
 */
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            int[][] result = new int[n][m+1];
            for(int i = 0; i<result.length; i++){
                result[i][0] = -1;
            }


            String tmp;
            for(int i = 0; i<n; i++){

                tmp = br.readLine();
                for(int j = 1; j <m+1;j++){
                    char tmp2 = tmp.charAt(j-1);
                    if(tmp2 == '.'){
                        if(result[i][j-1] ==-1){

                            System.out.print(-1);
                            result[i][j] = -1;

                        }else {
                            System.out.print(result[i][j-1] +1);
                            result[i][j] = result[i][j-1] +1;
                        }

                    }else {

                        System.out.print(0);
                        result[i][j] = 0;

                    }

                }
                System.out.println();
            }

        }

    }
}
