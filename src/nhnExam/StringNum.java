package nhnExam;

/**
 * Created by pose2 on 2017-09-20.
 */
import java.io.IOException;
import java.util.PriorityQueue;

public class StringNum {
    public static void main(String args[]) throws IOException{


        String[] strs = {"2","9","10","21","24"};
        PriorityQueue<Elements> pq = new PriorityQueue<>();

        for(String s : strs){

            pq.offer(new Elements(s));
            pq.offer(new Elements(s));


        }

        StringBuffer highest = new StringBuffer();
        StringBuffer lowest = new StringBuffer();

        while(pq.isEmpty()){
            highest.append(pq.poll());
            lowest.insert(0, pq.poll());
        }

        System.out.println(highest);
        System.out.println(lowest);


    }
    static class Elements implements Comparable<Elements>{
        String index;

        public Elements(String index) {
            super();
            this.index = index;
        }

        @Override
        public int compareTo(Elements o) {
            // TODO Auto-generated method stub
            if(this.index.charAt(0) == o.index.charAt(0)){
                if(this.index.length() == 1){
                    return index.charAt(0) - o.index.charAt(1);
                }else{
                    return index.charAt(1) - o.index.charAt(1);
                }
            }
            return this.index.charAt(0) - o.index.charAt(0);
        }


    }
}
