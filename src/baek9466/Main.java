package baek9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] students;
    private static int[] stuCheck;
    private static boolean[] visit;
    private static int checkpoint;


    public static void main(String args[])throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            students = new int[n+1];

            for(int i = 1; i<n+1 ;i++){
                students[i] = Integer.parseInt(st.nextToken());
            }
            stuCheck = new int[n+1];

            int sum = 0;


            for(int i = 1; i<n+1; i++){


                if(stuCheck[i] == 1)continue;
                if(stuCheck[i] == 2){
                    sum++;
                    continue;
                }

                visit = new boolean[n+1];

                if(dfs(i,visit.clone()) == 2){
                    sum++;
                }
            }

            System.out.println(sum);
        }
    }
    public static int dfs(int starter,boolean[] visit){

        visit[starter] =true;
        if(starter == students[starter]){
            stuCheck[starter] = 1;
            return 1;
        }
        if(visit[students[starter]]){
            checkpoint = students[starter];
            stuCheck[starter] =1;
            return 3;
        }

        if(stuCheck[students[starter]] != 0) return stuCheck[starter] = 2;
        if(stuCheck[starter] != 0) return stuCheck[starter] = 2;

        int tmp = dfs(students[starter],visit.clone());

        if(tmp == 1 ){
            return stuCheck[starter] = 2;
        }
        if(tmp == 2){
            return stuCheck[starter] = 2;
        }
        if(tmp == 3){

            if(starter == checkpoint) {
                stuCheck[starter] = 1;
                checkpoint = 0;
                return 1;
            }

            stuCheck[starter] = 1;
            return 3;

        }

        return 2;

    }
}