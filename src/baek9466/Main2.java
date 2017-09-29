package baek9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-09-29.
 */
public class Main2 {

    private static int[] students;
    private static int[] studentsDegree;
    private static boolean[] visit;

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {

            int n = Integer.parseInt(br.readLine());

            studentsDegree = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            students = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {

                students[i] = Integer.parseInt(st.nextToken());
                studentsDegree[students[i]]++;
            }



            int sum1 = 0;
            visit = new boolean[n+1];


                for (int i = 1; i < studentsDegree.length; i++) {
                    int sum = 0;
                    if (studentsDegree[i] == 0 && !visit[i]) {
                        sum1 += dfs(i,sum);
                    }
                }
            System.out.println(sum1);
        }
    }
    public static int dfs(int i, int sum){
        studentsDegree[i]--;
        studentsDegree[students[i]]--;
        sum += 1;
        visit[i] = true;
        if(studentsDegree[students[i]] == 0 && !visit[students[i]]){
            sum+=dfs(students[i],sum);
        }
        if(students[i] == students[students[i]]) return 1;

        return sum;
    }
}
