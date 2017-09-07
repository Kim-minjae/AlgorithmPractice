package baek8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pose2 on 2017-09-05.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

            String tmp = br.readLine();

            int sum = 0;
            int sum2 = 0;

            for(int i =0; i<tmp.length(); i++){

                char tmpChar = tmp.charAt(i);

                if(tmpChar == 'O'){
                    sum2++;
                    sum+= sum2;
                }else {
                    sum2 = 0;
                }

            }

            System.out.println(sum);

        }

    }
}
