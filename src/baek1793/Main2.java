/*
package baek1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger("1");
        BigInteger[] b = new BigInteger[250 + 1];

        for (int i = 0; i <= 250; i++) {
            if (i == 0 || i == 1)
                b[i] = a;
            else
                b[i] = b[i - 1].add(b[i - 2]).add(b[i - 2]);

        while (true) {

            String str = br.readLine();
            if("".equals(str)) return;
            int n = Integer.parseInt(str);

            BigInteger a = new BigInteger("1");
            BigInteger[] b = new BigInteger[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i == 0 || i == 1)
                    b[i] = a;
                else
                    b[i] = b[i - 1].add(b[i - 2]).add(b[i - 2]);
            }

            System.out.println(b[n]);

        }
    }

}*/
