import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MNH = br.readLine().split(" ");
        int N = Integer.parseInt(MNH[0]);
        int M = Integer.parseInt(MNH[1]);
        int H = Integer.parseInt(MNH[2]);

        int[][][] box = new int[H][M][N];
        int[][][] visited = new int[H][M][N];
        int unripe = 0;
        int dayCount = -1;
        LinkedList<pair3> queue = new LinkedList<>();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < M; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) {
                        queue.offerFirst(new pair3(i,j,k));
                        visited[i][j][k] = 1;
                    }
                    if(box[i][j][k] == 0) unripe++;
                }
            }
        }
        if(unripe == 0){
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            int len = queue.size();
            //System.out.println(len);
            for(int i = 0; i < len; i++){
                    pair3 grid = queue.pollLast();
                    if(grid.h+1 >= 0 && grid.h+1 < H && box[grid.h+1][grid.m][grid.n] == 0 && visited[grid.h+1][grid.m][grid.n] == 0){
                        box[grid.h+1][grid.m][grid.n] = 1;
                        visited[grid.h+1][grid.m][grid.n] = 1;
                        queue.offerFirst(new pair3(grid.h+1, grid.m, grid.n));
                        unripe--;
                    }
                    if(grid.h-1 >= 0 && grid.h-1 < H && box[grid.h-1][grid.m][grid.n] == 0 && visited[grid.h-1][grid.m][grid.n] == 0){
                        box[grid.h-1][grid.m][grid.n] = 1;
                        visited[grid.h-1][grid.m][grid.n] = 1;
                        queue.offerFirst(new pair3(grid.h-1, grid.m, grid.n));
                        unripe--;
                    }
                    if(grid.m+1 >= 0 && grid.m+1 < M && box[grid.h][grid.m+1][grid.n] == 0 && visited[grid.h][grid.m+1][grid.n] == 0){
                        box[grid.h][grid.m+1][grid.n] = 1;
                        visited[grid.h][grid.m+1][grid.n] = 1;
                        queue.offerFirst(new pair3(grid.h, grid.m+1, grid.n));
                        unripe--;
                    }
                    if(grid.m-1 >= 0 && grid.m-1 < M && box[grid.h][grid.m-1][grid.n] == 0 && visited[grid.h][grid.m-1][grid.n] == 0){
                        box[grid.h][grid.m-1][grid.n] = 1;
                        visited[grid.h][grid.m-1][grid.n] = 1;
                        queue.offerFirst(new pair3(grid.h, grid.m-1, grid.n));
                        unripe--;
                    }
                    if(grid.n+1 >= 0 && grid.n+1 < N && box[grid.h][grid.m][grid.n+1] == 0 && visited[grid.h][grid.m][grid.n+1] == 0){
                        box[grid.h][grid.m][grid.n+1] = 1;
                        visited[grid.h][grid.m][grid.n+1] = 1;
                        queue.offerFirst(new pair3(grid.h, grid.m, grid.n+1));
                        unripe--;
                    }
                    if(grid.n-1 >= 0 && grid.n-1 < N && box[grid.h][grid.m][grid.n-1] == 0 && visited[grid.h][grid.m][grid.n-1] == 0){
                        box[grid.h][grid.m][grid.n-1] = 1;
                        visited[grid.h][grid.m][grid.n-1] = 1;
                        queue.offerFirst(new pair3(grid.h, grid.m, grid.n-1));
                        unripe--;
                    }
            }
            dayCount++;
        }
        if(unripe != 0) System.out.println(-1);
        else System.out.println(dayCount);
        return;
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
