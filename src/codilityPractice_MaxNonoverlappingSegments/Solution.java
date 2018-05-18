package codilityPractice_MaxNonoverlappingSegments;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String args[]) throws IOException {

        Solution s = new Solution();

        int[] A = {1,3,7,9,9};
        int[] B = {5,6,8,9,10};

        System.out.println(s.solution(A,B));

    }
    public int solution(int[] A, int[] B) {

        int section = 0;
        int endpoint = B[B.length-1]+1;

        int[] cache = new int[endpoint+1];

        Queue<Line> lines = new LinkedList<>();

        for(int i = 0; i<A.length; i++){

            lines.offer(new Line(A[i]+1,B[i]+1));

        }

        while (!lines.isEmpty()){

            Line tmpLine = lines.poll();

            int from = tmpLine.from;
            int to = tmpLine.to;

            for(int i = section; i<to; i++){
                if(cache[i] < cache[section]) cache[i] = cache[section];
            }

            section = tmpLine.to;

            if(cache[to] < cache[from-1] + 1) cache[to] = cache[from-1] + 1;

        }

        return  cache[B[B.length-1]];
    }
}
class Line {
    int from;
    int to;

    public Line(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
