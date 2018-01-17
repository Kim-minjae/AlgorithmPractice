package wooABros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pose2 on 2017-10-27.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n%4 == 0){
            if(n%100 == 0) {
                if(n%400 == 0){
                    System.out.println("Leap Year");
                    return;
                }

                System.out.println("Not Leap Year");
            }else {
                System.out.println("Leap Year");
            }
        }else{
            System.out.println("Not Leap Year");
        }

    }
}
