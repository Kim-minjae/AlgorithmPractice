package baek10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by pose2 on 2017-09-04.
 */
public class Main {
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받는 스트림을 1바이트에서 2바이트로 바꿔주는 역할을 한다.
        //BufferedReader는 리더밖에 못 읽어서 바로 스트림으로 읽는게 아니라 리더로 먼저읽고
        //그다음 리더를 버퍼로 바꿔준다.

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int tmp = 0;

        for(int i = 0; i<N; i++){
            tmp = Integer.parseInt(st.nextToken());
            if(tmp<X){
                System.out.print(tmp + " ");
            }
        }

    }
}