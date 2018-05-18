package wooABros;

import java.io.IOException;

public class Solution01 {

    static final String hierarchy = "AKQJT98765432";

    public static void main(String args[]) throws IOException {

        Solution01 a = new Solution01();

        System.out.println(a.solution("A586QK" , "JJ653K"));

    }
    public int solution (String A, String B) {

        int AlecWin = 0;

        for(int i = 0; i<A.length(); i++){
            if(hierarchy.indexOf(A.charAt(i)) <  hierarchy.indexOf(B.charAt(i))) AlecWin++;
        }

        return AlecWin;
    }
}
