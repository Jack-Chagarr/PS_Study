import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        System.out.println(z(N,r,c,0));


    }
    static int z(int N, int r, int c, int count){
        int powN = (int) Math.pow(2,N);
        int powHalfN = (int) Math.pow(2,N - 1);
        if(N == 1){
            if(r % 2 == 0 && c % 2 == 0){
                count += 0;
            }else if(r % 2 == 0 && c % 2 == 1){
                count += 1;
            }else if(r % 2 == 1 && c % 2 == 0){
                count += 2;
            }else{
                count += 3;
            }
            return count;
        }
        else{
            int tempCount = powHalfN * powHalfN;
            //System.out.println("tempCount: " + tempCount);
            //System.out.println(powHalfN + " " + powN);
            if(r % powN < powHalfN && c % powN < powHalfN){
                //System.out.println(N + " 1번");
                count += z(N - 1, r, c, count);
            }else if(r % powN < powHalfN && c % powN >= powHalfN){
                //System.out.println(N + " 2번");
                count += z(N - 1, r, c - powHalfN, count) +  + tempCount;
            }else if(r % powN >= powHalfN && c % powN < powHalfN){
                //System.out.println(N + " 3번");
                count += z(N - 1, r - powHalfN, c, count)  + 2*tempCount;
            }else{
                //System.out.println(N + " 4번");
                count += z(N - 1, r - powHalfN, c - powHalfN, count) + 3*tempCount;
            }
        }
        return count;
    }
}
