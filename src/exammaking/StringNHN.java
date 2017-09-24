package exammaking;


import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by pose2 on 2017-09-20.
 */
public class StringNHN {
    public static void main(String args[]){

        PriorityQueue<Element> pq = new PriorityQueue<>();

        String[] strings = {"2","9","10","21","24"};
        StringBuffer max = new StringBuffer("");
        StringBuffer min = new StringBuffer("");

        for(String s : strings){
            pq.offer(new Element(s));
        }

        Stack<String> elementStack = new Stack<>();

        while (!pq.isEmpty()){
            Element tmp = pq.poll();
            elementStack.push(tmp.getIndex());
            min.append(tmp.getIndex());
        }

        while (!elementStack.isEmpty()){
            max.append(elementStack.pop());
        }

        System.out.println(min.toString()+ " " + max.toString());

        System.out.print(calculString(min.toString(),max.toString(),0));

    }

    public static int calculString(String min, String max, int index){
        if(index == min.length()) return 0;
        int result = min.charAt(index)-'0' + max.charAt(index)-'0'  + calculString(min,max,index+1);
        System.out.print(result%10);

        return result/10;
    }
}
class Element implements Comparable<Element>{
    String index;

    public Element(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public int compareTo(Element o) {
        if(this.index.charAt(0) == o.index.charAt(0)){
            return this.index.charAt(this.index.length()-1) - o.index.charAt(o.index.length()-1);
        }
        return this.index.charAt(0) - o.index.charAt(0);
    }
}
