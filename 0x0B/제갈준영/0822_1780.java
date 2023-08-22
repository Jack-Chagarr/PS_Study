import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pair3 pair = numPaper(arr, 0, 0, n);
        System.out.println(pair.h);
        System.out.println(pair.m);
        System.out.println(pair.n);







    }
    static pair3 numPaper(int[][] arr, int x, int y, int n){
        pair3 pair = new pair3(0, 0, 0);
        int firstOne = arr[x][y];
        int count = 0;
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(firstOne != arr[i][j]) break;
                count++;
            }
        }
        if(count == n*n){
            if(firstOne == -1){
                return new pair3(1, 0, 0);
            }else if(firstOne == 0){
                return new pair3(0, 1, 0);
            }else if(firstOne == 1){
                return new pair3(0, 0, 1);
            }
        }else{
            pair3 newPair1 = numPaper(arr, x, y, n/3);
            pair3 newPair2 = numPaper(arr, x + (n/3), y, n/3);
            pair3 newPair3 = numPaper(arr, x + 2 * (n/3), y, n/3);
            pair3 newPair4 = numPaper(arr, x, y + (n/3), n/3);
            pair3 newPair5 = numPaper(arr, x, y + 2*(n/3), n/3);
            pair3 newPair6 = numPaper(arr, x + (n/3), y + (n/3), n/3);
            pair3 newPair7 = numPaper(arr, x + 2 * (n/3), y + (n/3), n/3);
            pair3 newPair8 = numPaper(arr, x + (n/3), y + 2 * (n/3), n/3);
            pair3 newPair9 = numPaper(arr, x + 2 * (n/3), y + 2 * (n/3), n/3);

            pair.m = newPair1.m + newPair2.m + newPair3.m + newPair4.m + newPair5.m + newPair6.m + newPair7.m + newPair8.m + newPair9.m;
            pair.n = newPair1.n + newPair2.n + newPair3.n + newPair4.n + newPair5.n + newPair6.n + newPair7.n + newPair8.n + newPair9.n;
            pair.h = newPair1.h + newPair2.h + newPair3.h + newPair4.h + newPair5.h + newPair6.h + newPair7.h + newPair8.h + newPair9.h;
        }
        return  pair;
    }
}
class pair3{
    int h;
    int m;
    int n;
    pair3(int h, int m, int n){
        this.h = h;
        this.m = m;
        this.n = n;
    }
}