import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        LinkedList<pair> wallQueue = new LinkedList<>();


        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') wallQueue.offerFirst(new pair(i, j));
            }
        }
        int minCount = 987654321;
        if (wallQueue.isEmpty()) {
            System.out.println(m + n - 1);
            return;
        }

        int[][][] visited = new int[2][m][n];

        LinkedList<pair3> userQueue = new LinkedList<>();
        userQueue.offerFirst(new pair3(0,0, 0));
        visited[0][0][0] = 1;
        int tempCount = 0;
        int finished = 0;
        while (!userQueue.isEmpty() && finished == 0) {
            int queueSize = userQueue.size();
            tempCount++;
            for (int j = 0; j < queueSize; j++) {
                pair3 grid = userQueue.pollLast();

                //System.out.println(" userGrid: " + grid.m + " " + grid.n + " already broken: " + grid.h);
                if (grid.m + 1 >= 0 && grid.m + 1 < m && map[grid.m + 1][grid.n] == '0' && visited[grid.h][grid.m + 1][grid.n] == 0) {
                    userQueue.offerFirst(new pair3(grid.h,grid.m + 1, grid.n));
                    visited[grid.h][grid.m + 1][grid.n] = 1;
                }else if (grid.m + 1 >= 0 && grid.m + 1 < m && map[grid.m + 1][grid.n] == '1' && grid.h == 0) {
                    userQueue.offerFirst(new pair3(1, grid.m + 1, grid.n));
                    visited[1][grid.m + 1][grid.n] = 1;
                    //System.out.println("Broken Wall: " + (grid.m+1) + " " + grid.n + " userGrid: " + grid.m + " " + grid.n + " count: " + tempCount);

                }

                if (grid.n + 1 >= 0 && grid.n + 1 < n && map[grid.m][grid.n + 1] == '0' && visited[grid.h][grid.m][grid.n + 1] == 0) {
                    userQueue.offerFirst(new pair3(grid.h, grid.m, grid.n + 1));
                    visited[grid.h][grid.m][grid.n + 1] = 1;
                }else if (grid.n + 1 >= 0 && grid.n + 1 < n && map[grid.m][grid.n + 1] == '1' && grid.h == 0) {
                    userQueue.offerFirst(new pair3(1, grid.m, grid.n + 1));
                    visited[1][grid.m][grid.n + 1] = 1;
                    //System.out.println("Broken Wall: " + grid.m + " " + (grid.n+1) + " userGrid: " + grid.m + " " + grid.n + " count: " + tempCount);

                }

                if (grid.m - 1 >= 0 && grid.m - 1 < m && map[grid.m - 1][grid.n] == '0' && visited[grid.h][grid.m - 1][grid.n] == 0) {
                    userQueue.offerFirst(new pair3(grid.h, grid.m - 1, grid.n));
                    visited[grid.h][grid.m - 1][grid.n] = 1;
                }else if (grid.m - 1 >= 0 && grid.m - 1 < m && map[grid.m - 1][grid.n] == '1' && grid.h == 0) {
                    userQueue.offerFirst(new pair3(1, grid.m - 1, grid.n));
                    visited[1][grid.m - 1][grid.n] = 1;
                    //System.out.println("Broken Wall: " + (grid.m-1) + " " + grid.n + " userGrid: " + grid.m + " " + grid.n + " count: " + tempCount);

                }

                if (grid.n - 1 >= 0 && grid.n - 1 < n && map[grid.m][grid.n - 1] == '0' && visited[grid.h][grid.m][grid.n - 1] == 0) {
                    userQueue.offerFirst(new pair3(grid.h, grid.m, grid.n - 1));
                    visited[grid.h][grid.m][grid.n - 1] = 1;
                }else if (grid.n - 1 >= 0 && grid.n - 1 < n && map[grid.m][grid.n - 1] == '1' && grid.h == 0) {
                    userQueue.offerFirst(new pair3(1, grid.m, grid.n - 1));
                    visited[1][grid.m][grid.n - 1] = 1;
                    //System.out.println("Broken Wall: " + grid.m + " " + (grid.n-1) + " userGrid: " + grid.m + " " + grid.n + " count: " + tempCount);

                }

                if (visited[grid.h][m - 1][n - 1] == 1) {
                    tempCount++;
                    if (tempCount < minCount) {
                        minCount = tempCount;
                        //System.out.println(tempWall.m + " " + tempWall.n);
                    }
                    finished = 1;
                }
            }
        }
        if (minCount == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }
        return;


    }


}
class pair {
    int m;
    int n;
    pair(int m, int n){
        this.m = m;
        this.n = n;
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