package exammaking;

import java.math.BigInteger;
import java.util.Scanner;

public class MakeSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while((sc.hasNext())) {
            Integer n = sc.nextInt();

            BigInteger a = new BigInteger("1");
            BigInteger[] b = new BigInteger[n+1];
            for(int i=0; i<=n;i++) {
                if(i==0 || i==1) b[i]=a;
                else b[i] = b[i-1].add(b[i-2]).add(b[i-2]);
            }
            System.out.println(b[n]);
            sc.nextLine();
        }
    }

}