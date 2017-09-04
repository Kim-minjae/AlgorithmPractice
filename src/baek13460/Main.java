package baek13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-04.
 */
public class Main {

    static char[][] map;
    static Queue<Balls> queue;

    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int[] R = new int[3]; // x,y 의 좌표를 말해주고 만약 구멍에 들어가면 -1로 바꿔준다.
        int[] B = new int[3];

        for(int i = 0; i<N; i++){
            String tmp  = br.readLine();
            // '.', '#', 'O', 'R', 'B'
            for(int j = 0; j<M; j++){

                map[i][j] = tmp.charAt(j);

                if(map[i][j] == 'R'){
                    R[0] = i;
                    R[1] = j;
                    map[i][j] = '.';

                }else if(map[i][j] == 'B'){
                    B[0] = i;
                    B[1] = j;
                    map[i][j] = '.';
                }
            }
        }

        queue = new LinkedList<>();

        queue.offer(new Balls(B,R,0));

        Balls tmpballs = new Balls(B,R,0);

       do {
            tmpballs = queue.poll();
        } while ((!queue.isEmpty() || tmpballs.getCount() < 10) && (!up(new Balls(tmpballs.blueball.clone(),tmpballs.readball.clone(),tmpballs.getCount()))
               && !left(new Balls(tmpballs.blueball.clone(),tmpballs.readball.clone(),tmpballs.getCount()))
               && !right(new Balls(tmpballs.blueball.clone(),tmpballs.readball.clone(),tmpballs.getCount()))
               && !down(new Balls(tmpballs.blueball.clone(),tmpballs.readball.clone(),tmpballs.getCount()))));

        if(tmpballs.getCount() >=10){
            System.out.println(-1);
        }


    }
    public static boolean down(Balls balls){
        Balls tmpBalls2 = new Balls(null,null,0);

        int[] B = balls.getBlueball().clone();
        int[] R = balls.getReadball().clone();

        int Bx = B[0];
        int By = B[1];
        int Rx = R[0];
        int Ry = R[1];

        //움직이는 로직
        if(B[0] < R[0]){

            while (map[B[0]+1][B[1]] == '.' && (B[0]+1 != R[0] || B[1] !=R[1])){
                B[0]++;
            }

            if(map[B[0]+1][B[1]] == 'O'){
                B[2] = -1;
            }

            while (map[R[0]+1][R[1]] == '.'&& (B[0] != R[0]+1 || B[1] !=R[1])){
                R[0]++;
            }
            if(map[R[0]+1][R[1]] == 'O'){
                R[2] = -1;
            }


        }else {

            while (map[R[0]+1][R[1]] == '.'&& (B[0] != R[0]+1 || B[1] !=R[1])){
                R[0]++;
            }
            if(map[R[0]+1][R[1]] == 'O'){
                R[2] = -1;
            }
            while (map[B[0]+1][B[1]] == '.'&& (B[0]+1 != R[0] || B[1] !=R[1])){
                B[0]++;
            }

            if(map[B[0]+1][B[1]] == 'O'){
                B[2] = -1;
            }

        }
        //움직이는 로직 끝

        tmpBalls2.setBlueball(B.clone());
        tmpBalls2.setReadball(R.clone());
        tmpBalls2.setCount(balls.getCount()+1);

        if(R[2] == -1 && B[2] ==0){
            System.out.println(tmpBalls2.getCount());
            return true;
        }else if(B[2] == -1){
            return false;
        }

        if(!(B[0] == Bx && B[1] == By && R[0] == Rx && R[1] == Ry)) {
            queue.offer(tmpBalls2);
        }

        return false;
    }

    public static boolean left(Balls balls){
        Balls tmpBalls2 = new Balls(null,null,0);

        int[] B = balls.getBlueball().clone();
        int[] R = balls.getReadball().clone();

        int Bx = B[0];
        int By = B[1];
        int Rx = R[0];
        int Ry = R[1];

        //움직이는 로직
        if(B[1] < R[1]){

            while (map[B[0]][B[1]-1] == '.' && (B[0] != R[0] || B[1]-1 !=R[1])){
                B[1]--;
            }


            if(map[B[0]][B[1]-1] == 'O'){
                B[2] = -1;
            }

            while (map[R[0]][R[1]-1] == '.' && (B[0] != R[0] || B[1] !=R[1]-1)){
                R[1]--;
            }
            if(map[R[0]][R[1]-1] == 'O'){
                R[2] = -1;
            }


        }else {

            while (map[R[0]][R[1]-1] == '.'&& (B[0] != R[0] || B[1] !=R[1]-1)){
                R[1]--;
            }
            if(map[R[0]][R[1]-1] == 'O'){
                R[2] = -1;
            }
            while (map[B[0]][B[1]-1] == '.'&& (B[0] != R[0] || B[1]-1 !=R[1])){
                B[1]--;
            }

            if(map[B[0]][B[1]-1] == 'O'){
                B[2] = -1;
            }

        }
        //움직이는 로직 끝

        tmpBalls2.setBlueball(B.clone());
        tmpBalls2.setReadball(R.clone());
        tmpBalls2.setCount(balls.getCount()+1);

        if(R[2] == -1 && B[2] ==0){
            System.out.println(tmpBalls2.getCount());
            return true;
        }else if(B[2] == -1){
            return false;
        }

        if(!(B[0] == Bx && B[1] == By && R[0] == Rx && R[1] == Ry)) {
            queue.offer(tmpBalls2);
        }
        return false;
    }

    public static boolean right(Balls balls){
        Balls tmpBalls2 = new Balls(null,null,0);

        int[] B = balls.getBlueball().clone();
        int[] R = balls.getReadball().clone();

        int Bx = B[0];
        int By = B[1];
        int Rx = R[0];
        int Ry = R[1];

        //움직이는 로직
        if(B[1] > R[1]){

            while (map[B[0]][B[1]+1] == '.' && (B[0] != R[0] || B[1]+1 !=R[1])){
                B[1]++;
            }

            if(map[B[0]][B[1]+1] == 'O'){
                B[2] = -1;
            }

            while (map[R[0]][R[1]+1] == '.'&& (B[0] != R[0] || B[1] !=R[1]+1)){
                R[1]++;
            }
            if(map[R[0]][R[1]+1] == 'O'){
                R[2] = -1;
            }


        }else {

            while (map[R[0]][R[1]+1] == '.' && (B[0] != R[0] || B[1] !=R[1]+1)){
                R[0]++;
            }
            if(map[R[0]][R[1]+1] == 'O'){
                R[2] = -1;
            }
            while (map[B[0]][B[1]+1] == '.'&& (B[0] != R[0] || B[1]+1 !=R[1])){
                B[0]++;
            }

            if(map[B[0]][B[1]+1] == 'O'){
                B[2] = -1;
            }

        }
        //움직이는 로직 끝

        tmpBalls2.setBlueball(B.clone());
        tmpBalls2.setReadball(R.clone());
        tmpBalls2.setCount(balls.getCount()+1);

        if(R[2] == -1 && B[2] ==0){
            System.out.println(tmpBalls2.getCount());
            return true;
        }else if(B[2] == -1){
            return false;
        }

        if(!(B[0] == Bx && B[1] == By && R[0] == Rx && R[1] == Ry)) {
            queue.offer(tmpBalls2);
        }

        return false;
    }

    public static boolean up(Balls balls){
        Balls tmpBalls2 = new Balls(null,null,0);

        int[] B = balls.getBlueball().clone();
        int[] R = balls.getReadball().clone();

        int Bx = B[0];
        int By = B[1];
        int Rx = R[0];
        int Ry = R[1];


        //움직이는 로직
        if(B[0] > R[0]){

            while (map[B[0]-1][B[1]] == '.' && (B[0]-1 != R[0] || B[1] !=R[1])){
                B[0]--;
            }

            if(map[B[0]-1][B[1]] == 'O'){
                B[2] = -1;
            }

            while (map[R[0]-1][R[1]] == '.'&& (B[0] != R[0]-1 || B[1] !=R[1])){
                R[0]--;
            }
            if(map[R[0]-1][R[1]] == 'O'){
                R[2] = -1;
            }


        }else {

            while (map[R[0]-1][R[1]] == '.'){
                R[0]--;
            }
            if(map[R[0]-1][R[1]] == 'O'){
                R[2] = -1;
            }
            while (map[B[0]-1][B[1]] == '.' && ((B[0]-1 != R[0]) || (B[1] !=R[1]))){
                B[0]--;
            }

            if(map[B[0]-1][B[1]] == 'O'){
                B[2] = -1;
            }

        }
        //움직이는 로직 끝

        tmpBalls2.setBlueball(B.clone());
        tmpBalls2.setReadball(R.clone());
        tmpBalls2.setCount(balls.getCount()+1);

        if(R[2] == -1 && B[2] ==0){
            System.out.println(tmpBalls2.getCount());
            return true;
        }else if(B[2] == -1){
            return false;
        }



        if(!(B[0] == Bx && B[1] == By && R[0] == Rx && R[1] == Ry)) {
            queue.offer(tmpBalls2);
        }
        return false;
    }

}
class Balls{
    int[] blueball;
    int[] readball;
    int count;

    public Balls(int[] blueball, int[] readball, int count) {
        this.blueball = blueball;
        this.readball = readball;
        this.count = count;
    }

    public int[] getBlueball() {
        return blueball;
    }

    public void setBlueball(int[] blueball) {
        this.blueball = blueball;
    }

    public int[] getReadball() {
        return readball;
    }

    public void setReadball(int[] readball) {
        this.readball = readball;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
