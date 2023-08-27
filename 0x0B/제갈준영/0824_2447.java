import java.io.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        star(0, 0, n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1)
                    bw.write('*');
                else bw.write(' ');
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        return;


    }
    static void star(int x, int y, int size){
        if(size == 3){
            arr[y][x] = 1;
            arr[y][x+1] = 1;
            arr[y][x+2] = 1;
            arr[y+1][x] = 1;
            arr[y+1][x+2] = 1;
            arr[y+2][x] = 1;
            arr[y+2][x+1] = 1;
            arr[y+2][x+2] = 1;
            return;
        }
        int scale = size/3;
        star(x, y, scale);
        star(x + scale, y, scale);
        star(x + 2*scale, y, scale);
        star(x, y + scale, scale);
        star(x + 2*scale, y + scale, scale);
        star(x, y + 2*scale, scale);
        star(x + scale, y + 2*scale, scale);
        star(x + 2*scale, y + 2*scale, scale);
        return;



    }

}
