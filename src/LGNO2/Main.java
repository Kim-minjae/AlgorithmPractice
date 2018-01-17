package LGNO2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-29.
 */
public class Main {

    private static char[][] map;
    private static int[][][] dpMap;

    public static void main(String args[])throws IOException{

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fileOutputStream);
        System.setOut(ps);


        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

            int n = Integer.parseInt(br.readLine());

            map = new char[n+2][n+2];
            dpMap = new int[n+2][n+2][3];
            for(int i = 1; i<n+1; i++){
                for(int j =1; j<n+1; j++){
                    for(int k = 0; k<3; k++) {
                        dpMap[i][j][k] = -1;
                    }
                }
            }


            for(int i = 0; i<n+2; i++){
                dpMap[i][0][0] =dpMap[i][0][1] = dpMap[i][0][2] = -2;
                dpMap[i][n+1][0] =dpMap[i][n+1][1] = dpMap[i][n+1][2] = -2;
            }

            for(int j = 0; j<n+2; j++){
                dpMap[0][j][0] = dpMap[0][j][1] = dpMap[0][j][2]= -2;
                dpMap[n+1][j][0] = dpMap[n+1][j][1] = dpMap[n+1][j][2]= -2;
            }


            for(int i = 1; i<n+1;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j =1; j<n+1; j++){

                    map[i][j] = st.nextToken().charAt(0);

                }
            }

            Queue<AngryBird> angryBirds = new LinkedList<>();

            int tmpBcount = 0;

            if(map[n][1] == 'B') tmpBcount = 1;

            //오른쪽이랑 위쪽 두개 추가
            AngryBird firstBird = new AngryBird(n,1,tmpBcount, true,0);
            AngryBird secondBird = new AngryBird(n,1,tmpBcount, true,1);


            angryBirds.offer(firstBird);
            angryBirds.offer(secondBird);

            while (!angryBirds.isEmpty()){

                AngryBird tmpBird = angryBirds.poll();



                int tmpDirection = tmpBird.direction;

                /*System.out.println("지금 위치는 -> x : " +tmpBird.getX() + " y : " + tmpBird.getY() + " Bcount = " + tmpBird.getBcount());
                System.out.println();*/

                switch (tmpDirection){
                    case 0 :

                        //나온놈이 오른쪽으로 가던경우
                        int tmpway = 0;
                        if(tmpBird.upDownToggle){
                            tmpway = 1;
                        }else {
                            tmpway = 2;
                        }

                        //dp값보다 bCount 가 클경우만 큐에 집어넣음 그리고 외곽만나면 죽임.

                        //오른쪽
                        if((dpMap[tmpBird.getX()][tmpBird.getY()+1][tmpway] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()][tmpBird.getY()+1][tmpway] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()][tmpBird.getY()+1] == 'B') tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()][tmpBird.getY()+1][tmpway] = tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX(),tmpBird.getY()+1,tmpBcount1,tmpBird.upDownToggle,0));
                        }

                        //위
                        if(tmpway != 2) {
                            if ((dpMap[tmpBird.getX() - 1][tmpBird.getY()][tmpway] < tmpBird.Bcount + 1) && dpMap[tmpBird.getX() - 1][tmpBird.getY()][tmpway] != -2) {

                                int tmpBcount1 = tmpBird.getBcount();

                                if (map[tmpBird.getX() - 1][tmpBird.getY()] == 'B') tmpBcount1++; //맞으면하나추가

                                dpMap[tmpBird.getX() - 1][tmpBird.getY()][tmpway] = tmpBcount1;

                                angryBirds.offer(new AngryBird(tmpBird.getX() - 1, tmpBird.getY(), tmpBcount1, tmpBird.upDownToggle, 1));
                            }
                        }
                        //아래

                        if((dpMap[tmpBird.getX()+1][tmpBird.getY()][2] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()+1][tmpBird.getY()][2] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()+1][tmpBird.getY()] == 'B')  tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()+1][tmpBird.getY()][2] =  tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX()+1,tmpBird.getY(), tmpBcount1,false,2));
                        }

                        break;
                    case 1 :
                        //나온놈이 위로가던경우

                        //오른쪽이랑 오른쪽 위 큐에 비교확인후 집어넣기

                        //오른쪽
                        if((dpMap[tmpBird.getX()][tmpBird.getY()+1][1] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()][tmpBird.getY()+1][1] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()][tmpBird.getY()+1] == 'B') tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()][tmpBird.getY()+1][1] = tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX(),tmpBird.getY()+1,tmpBcount1,true,0));
                        }

                        if((dpMap[tmpBird.getX()][tmpBird.getY()+1][2] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()][tmpBird.getY()+1][2] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()][tmpBird.getY()+1] == 'B') tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()][tmpBird.getY()+1][2] = tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX(),tmpBird.getY()+1,tmpBcount1,false,0));
                        }

                        //위
                        if((dpMap[tmpBird.getX()-1][tmpBird.getY()][1] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()-1][tmpBird.getY()][1] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()-1][tmpBird.getY()] == 'B') tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()-1][tmpBird.getY()][1] = tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX()-1,tmpBird.getY(),tmpBcount1,true,1));
                        }



                        break;
                    case 2 :
                        //나온놈이 아래로 가던경우

                        //오른쪽이랑 아래 큐에 비교확인후 집어넣기

                        //오른쪽
                        if((dpMap[tmpBird.getX()][tmpBird.getY()+1][2] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()][tmpBird.getY()+1][2] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()][tmpBird.getY()+1] == 'B') tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()][tmpBird.getY()+1][2] = tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX(),tmpBird.getY()+1,tmpBcount1,false,0));
                        }

                        //아래
                        if((dpMap[tmpBird.getX()+1][tmpBird.getY()][2] < tmpBird.Bcount+1) && dpMap[tmpBird.getX()+1][tmpBird.getY()][2] != -2){

                            int tmpBcount1 = tmpBird.getBcount();

                            if(map[tmpBird.getX()+1][tmpBird.getY()] == 'B')  tmpBcount1++; //맞으면하나추가

                            dpMap[tmpBird.getX()+1][tmpBird.getY()][2] =  tmpBcount1;

                            angryBirds.offer(new AngryBird(tmpBird.getX()+1,tmpBird.getY(), tmpBcount1,false,2));
                        }

                        break;


                        default:break;
                }

            }

            //while 문이 끝난후 dp비교만 하면됨 x좌표에서

            System.out.println(Math.max(dpMap[n][n][1],dpMap[n][n][2]));

        }

    }
    static class AngryBird{

        int x;
        int y;
        int Bcount;
        boolean upDownToggle;
        int direction;

        public AngryBird(int x, int y, int bcount, boolean upDownToggle, int direction) {
            this.x = x;
            this.y = y;
            Bcount = bcount;
            this.upDownToggle = upDownToggle;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getBcount() {
            return Bcount;
        }

        public void setBcount(int bcount) {
            Bcount = bcount;
        }

        public boolean isUpDownToggle() {
            return upDownToggle;
        }

        public void setUpDownToggle(boolean upDownToggle) {
            this.upDownToggle = upDownToggle;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }
}
