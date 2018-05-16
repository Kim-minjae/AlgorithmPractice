package codilityPractice_BuildWall;

import java.io.IOException;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) throws IOException {

        Solution a = new Solution();
        int[] H = {8,8,5,7,9,8,7,4,8};


        System.out.println(a.solution(H));
    }
    public int solution(int[] H) {

        Stack<BlockHeight> block = new Stack<>();

        block.push(new BlockHeight(0,0));

        int counter = 0;

        for(int x : H) {

            if(x == block.peek().totalHeight) continue;
            if(x > block.peek().totalHeight){

                int totalHeight = block.peek().totalHeight;

                block.push(new BlockHeight(x,x-totalHeight));
                counter++;

            } else {

                //k 는 현재 블럭의 총 높이
                int k = block.peek().totalHeight;

                //블럭을 우리가 원하는 높이보다 k가 작거나 같아질때까지 뺀다.
                while (x<k){
                   k -= block.pop().blockHeight;
                }

                //k가 더 작아졌으면 블럭을 원하는 높이를 보충할만한 블럭만큼 더해준다.
                if(x > k){
                    block.push(new BlockHeight(x,x-k));
                    counter++;
                    continue;
                }
                if(x == k){
                    continue;
                }

            }

        }


        return counter;
    }
}
class BlockHeight {

    int totalHeight;
    int blockHeight;

    public BlockHeight(int totalHeight, int blockHeight) {
        this.totalHeight = totalHeight;
        this.blockHeight = blockHeight;
    }
}
