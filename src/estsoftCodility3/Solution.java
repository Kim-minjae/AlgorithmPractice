package estsoftCodility3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by pose2 on 2018-01-10.
 */
public class Solution {

    public static void main(String args[]) throws IOException{

        Solution a = new Solution();

        System.out.println(a.solution(26));

    }

    public int solution(int N){

        if(( (N > 0) && ((N & (N - 1))==0) )) return -1;

        String a = Integer.toBinaryString(N);

        StringBuffer x = new StringBuffer("");
        StringBuffer y = new StringBuffer("");


        for(int i = 0; i<a.length(); i++){
            if(a.length() - i >= 2 ){

                if((a.charAt(i) == '1') && (a.charAt(i+1) =='1')){
                    x.append("10");
                    y.append("01");
                    i++;
                }else {
                    if(a.charAt(i) == '0'){
                        x.append("0");
                        y.append("0");
                    }else {
                        x.append("0");
                        y.append("1");
                    }
                }


            }else {
                if(a.charAt(i) == '0'){
                    x.append("0");
                    y.append("0");
                }else {
                    x.append("0");
                    y.append("1");
                }
            }


        }


        return Integer.parseInt(x.toString(),2);
    }
}
