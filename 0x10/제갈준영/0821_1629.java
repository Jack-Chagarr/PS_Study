import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Mainb {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(mul(A, B, C));
        return ;


    }
    static long mul(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }
        long temp = mul(A, B / 2, C);
        long tempModC = ((temp % C) * (temp % C)) % C;
        if (B % 2 == 0) {
            return tempModC;
        } else {
            return (tempModC * (A % C)) % C;
        }
    }
}
