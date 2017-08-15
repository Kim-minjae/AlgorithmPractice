import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by pose2 on 2017-06-23.
 */
public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        int Pi[] = new int[P.length()];
        Pi = makePiFunction(P);

        LinkedList<Integer> result = new LinkedList<>();

        result = KMP(T,P,Pi);

        System.out.println(result.size());

        while(!result.isEmpty()){
            System.out.print(result.remove()+1 + " ");
        }

    }
    public static int[] makePiFunction(String P_){
        int[] Pi = new int[P_.length()];
        int begin = 1;
        int matched = 0;

        while (begin+matched<Pi.length){
            if(P_.charAt(begin+matched) == P_.charAt(matched)){
                matched++;
                Pi[begin+matched-1] = matched;
            }
            else {
                if(matched == 0){
                    begin++;
                }
                else {
                    begin += matched - Pi[matched-1];
                    matched = Pi[matched-1];
                }
            }
        }
        return Pi;
    }

    public static LinkedList<Integer> KMP(String T_, String P_, int[] Pi_){

        LinkedList<Integer> result = new LinkedList<>();
        int begin=0, matched =0;
        int N = T_.length(); int M = P_.length();

        while(begin <= N-M){

            if(matched == P_.length()){
                result.add(begin);
                begin += matched - Pi_[matched-1];
                matched = Pi_[matched-1];
                continue;
            }
            if(T_.charAt(begin+matched) == P_.charAt(matched)){
                    matched++;
            }
            else{
                if(matched == 0){
                    begin++;
                }
                else{
                    begin += matched - Pi_[matched-1];
                    matched = Pi_[matched-1];
                }
            }
        }

        return result;
    }
}
