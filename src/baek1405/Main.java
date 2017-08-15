package baek1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-08-04.
 */
public class Main {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] direction = new int[4];


        int tmp1 = 0;
        for(int i = 0; i<4; i++){
            tmp1 += Integer.parseInt(st.nextToken());
            direction[i] = tmp1;

        }

        double simple = 0;
        int tmp2 = -1;


        for(int i =0; i< 1000000; i++){
            simple++;

            for(int j = 0; j<N; j++){
                int tmp = (int)(Math.random()*100);
                if(tmp>=0 && tmp<=direction[0]){
                    if(tmp2 == 0){
                        simple--;
                        break;
                    }else {
                        tmp2 = 0;
                    }
                }else if(tmp>direction[0] && tmp<=direction[1]){
                    if(tmp2 ==1){
                        simple --;
                        break;
                    }else {
                        tmp2 = 1;
                    }
                }else if(tmp>direction[1] && tmp<direction[2]){
                    if(tmp2 ==2){
                        simple--;
                        break;
                    }else{
                        tmp2 = 2;
                    }
                }else{
                    if(tmp2 == 3){
                        simple--;
                        break;
                    }else {
                        tmp2 =3;
                    }
                }


            }
            tmp2 = -1;

        }

        System.out.printf("%f" , (simple/1000000));

    }
}
