package baek1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-07.
 */
public class Main {
    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();

        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();

        for(int i = 0; i<sentence.length(); i++){
            stackLeft.push(sentence.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        //n개의 커맨드가 들어올때마다 처리
        //맨왼쪽 맨오른쪽 예외처리 해줘야한다.
        StringTokenizer st;
        for(int i =0; i<n; i++){
            st =  new StringTokenizer(br.readLine());

            char commend2 = st.nextToken().charAt(0);
            char charTmp;

            switch (commend2){
                case 'L' :
                    if(!stackLeft.isEmpty()) {
                        stackRight.push(stackLeft.pop());
                    }
                    break;

                case 'D' :
                    if(!stackRight.isEmpty()) {
                        stackLeft.push(stackRight.pop());
                    }
                    break;
                case 'B' :
                    if(!stackLeft.isEmpty()) {
                        stackLeft.pop();
                    }
                    break;

                case 'P' :
                    charTmp = st.nextToken().charAt(0);
                    stackLeft.push(charTmp);
                    break;

                    default: break;
            }
        }
        //그다음 출력

        StringBuilder result = new StringBuilder();
        while (!stackRight.isEmpty()){
            result.append(stackRight.pop());
        }
        while (!stackLeft.isEmpty()) {
            result.insert(0,stackLeft.pop());
        }
        System.out.println(result.toString());
    }
}
