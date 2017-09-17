package baek5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by pose2 on 2017-09-10.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t =0; t<tc; t++){
            String tmp = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(int  i = 0; i<tmp.length() ; i++){

                char command = tmp.charAt(i);

                switch (command){
                    case '<' :
                        if(!left.isEmpty()){
                            right.push(left.pop());
                        }
                        break;
                    case '>' :
                        if(!right.isEmpty()){
                            left.push(right.pop());
                        }
                        break;
                    case '-' :
                        if(!left.isEmpty()){
                            left.pop();
                        }
                        break;
                        default:left.push(command);
                        break;
                }
            }
            while (!left.isEmpty()){
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                System.out.print(right.pop());
            }
            System.out.println();
        }
    }
}
