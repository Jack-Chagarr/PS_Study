import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] screen = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            screen[i] = s.toCharArray();
        }
        String s = compress(screen, 0, 0, n);
        System.out.println(s);
        return;

    }
    static String compress(char[][] screen, int x, int y, int size){
        String s = "";
        s += "(";
        if(size == 1){
            if(screen[y][x] == '0') return "0";
            else return "1";
        }
        int same = 1;

        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(screen[i][j] != screen[y][x]){
                    same = 0;
                    break;
                }
            }
        }
        if(same == 1){
            if(screen[y][x] == '0') return "0";
            else return "1";
        }
        s += compress(screen, x, y, size/2) + compress(screen, x + size/2, y, size/2) +compress(screen, x, y + size/2, size/2) +compress(screen, x + size/2, y + size/2, size/2) + ")";
        return s;



    }
}
