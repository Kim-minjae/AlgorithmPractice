package wooABros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pose2 on 2017-10-27.
 */
public class Main2 {
    public static void main(String args[])throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(Integer.toString(n,16));
    }
}
