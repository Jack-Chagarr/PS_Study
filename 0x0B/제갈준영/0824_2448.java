import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int side = n + n;
        arr = new int[side][side];
        star11(0, 0, n);
        for (int i = 0; i < side; i= i + 2) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] == 1)
                    s.append('*');
                else s.append(' ');
            }
            for(int k = 0; k < (side - 2 - i)/ 2; k++){
                bw.write(' ');
            }
            bw.write(s.toString());
            for(int k = 0; k < (side - 2 - i)/ 2; k++){
                bw.write(' ');
            }
            bw.write( "\n");
        }
        bw.flush();
        bw.close();
        return;


    }
    static void star11(int x, int y, int size){
        if(size == 3){
            arr[y][x] = 1;
            arr[y + 2][x] = 1;
            arr[y + 2][x + 2] = 1;
            arr[y + 4][x] = 1;
            arr[y + 4][x + 1] = 1;
            arr[y + 4][x + 2] = 1;
            arr[y + 4][x + 3] = 1;
            arr[y + 4][x + 4] = 1;
            return;
        }
        int scale = (size + size)/2;
        star11(x, y, size/2);
        star11(x, y + scale, size/2);
        star11(x + scale, y + scale, size/2);
        return;



    }
}